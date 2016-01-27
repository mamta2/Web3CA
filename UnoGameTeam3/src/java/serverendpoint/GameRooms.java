package serverendpoint;

import Main.Game;
import Model.AllGames;
import Model.Player;
import Model.Unocard;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.websocket.Session;

@ApplicationScoped
class GameRooms {

    private static int i = 0;
    private Map<String, List<Session>> rooms = new HashMap<>();
    private Lock lock = new ReentrantLock();

    @Inject
    private AllGames allgames;

    public void add(String roomName, Session session) {
        lock.lock();
        try {
            List<Session> sessions = rooms.get(roomName);
            if (null == sessions) {
                sessions = new LinkedList<>();
                rooms.put(roomName, sessions);

            }
            sessions.add(session);
        } finally {
            lock.unlock();
        }
    }

    void broadcast(String room, String playerid, String action) {
        lock.lock();
        Session playersession = null;
        switch (action) {
            case "logout":
                List<Session> ses = rooms.get(room);
                for (Session s : ses) {
                    try {
                        JsonObject obj = Json.createObjectBuilder().add("link", "xxxxx").add("cmd", "logmeout").build();
                        s.getBasicRemote().sendText(obj.toString());
                    } catch (IOException ex) {
                        Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "takebackcard":
                try {
                    List<Session> sessions = rooms.get(room);
                    Game g = allgames.getRunningGamesMap().get(room);
                    ArrayList<Player> plist = (ArrayList<Player>) g.getPlayers();
                    for (int i = 0; i < plist.size() - 1; i++) {
                        if (plist.get(i).getUserid().equals(playerid)) {
                            {
                                System.out.println(" PLAYER try takeback  playerid> " + playerid);
                                Player p = plist.get(i);
                                ArrayList<Unocard> pcard = p.getCardinhand();
                                for (Session s : sessions) {
                                    String sid = s.getId();
                                    String psid = p.getSessionid();
                                    if (psid.equals(sid)) {
                                        System.out.println(" PLAYER try takeback  psid> " + psid + "  sid >" + sid);
                                        System.out.println("Size of Discard Pile BEFORE takeback > " + g.getDiscard().size());

                                        if (g.getDiscard().size() > 1) {
                                            System.out.println(" Can takeback ");

                                            Unocard cardToTakeBackFromDiscard = g.getDiscard().get(g.getDiscard().size() - 1);
                                            System.out.println("card to take back from Discard & to add in player inhand > " + cardToTakeBackFromDiscard);

                                            if (!(cardToTakeBackFromDiscard.isIsFirstCardOnDiscard() && cardToTakeBackFromDiscard.getLink().equalsIgnoreCase(g.getFirstCardOnDiscardLink()))
                                                    && p.getUserid().equalsIgnoreCase(cardToTakeBackFromDiscard.getThrownByWhom())) {

                                                Unocard topCard = g.getDiscard().get(g.getDiscard().size() >= 2 ? g.getDiscard().size() - 2 : 0);
                                                System.out.println("topCardAfter take Back > " + topCard);

                                                System.out.println("BEFORE player gets card back, size inHandcards = " + pcard.size());
                                                pcard.add(cardToTakeBackFromDiscard);
                                                System.out.println("AFTER player gets card back, size inHandcards = " + pcard.size());

                                                System.out.println("card in discard BEFORE removing = " + g.getDiscard().size());
                                                g.getDiscard().remove(g.getDiscard().size() - 1);
                                                System.out.println("card in discard AFTER removing = " + g.getDiscard().size());

                                                try {
                                                    JsonObject obj = Json.createObjectBuilder().add("link", cardToTakeBackFromDiscard.getLink()).add("cmd", "takebackcard").build();
                                                    s.getBasicRemote().sendText(obj.toString());
                                                    broadcastTopCardAfterTakeBack(room, topCard.getLink(), playerid);

                                                } catch (IOException ex) {
                                                    Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        }
                                        System.out.println("Size of Discard Pile AFTER takeback > " + g.getDiscard().size());
                                    }
                                }
                            }
                        }
                    }

                } finally {
                    lock.unlock();
                }
                break;
            case "takeacard":

                try {
                    List<Session> sessions = rooms.get(room);
                    Game g = allgames.getRunningGamesMap().get(room);
                    ArrayList<Player> plist = (ArrayList<Player>) g.getPlayers();
                    for (int i = 0; i < plist.size() - 1; i++) {
                        if (plist.get(i).getUserid().equals(playerid)) {
                            {
                                Player p = plist.get(i);
                                ArrayList<Unocard> pcard = p.getCardinhand();
                                for (Session s : sessions) {
                                    String sid = s.getId();
                                    String psid = p.getSessionid();
                                    if (psid.equals(sid)) {
                                        Unocard newcardinhand = g.getDeck().get(0);
                                        pcard.add(g.getDeck().get(0));
                                        g.getDeck().remove(0);
                                        try {
                                            JsonObject obj = Json.createObjectBuilder().add("link", newcardinhand.getLink()).add("cmd", "takeacard").build();
                                            System.out.println(">> take a card: " + allgames.getTurn());

                                            s.getBasicRemote().sendText(obj.toString());
                                        } catch (IOException ex) {
                                            Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    }
                                }
                            }
                        }
                    }

                } finally {
                    lock.unlock();
                }
                break;

            case "sevenandtop":
                System.out.println("inside game rooms" + action);
                try {
                    List<Session> sessions = rooms.get(room);
                    Game g = allgames.getRunningGamesMap().get(room);
                    ArrayList<Player> plist = (ArrayList<Player>) g.getPlayers();
                    for (int i = 0; i < plist.size() - 1; i++) {
                        Player p = plist.get(i);
                        ArrayList<Unocard> pcard = p.getCardinhand();
                        for (Session s : sessions) {
                            String sid = s.getId();
                            String psid = p.getSessionid();
                            System.out.println("psid for players" + i + "=" + plist.get(i).getSessionid());
                            if (psid.equals(sid)) {
                                for (Unocard u : pcard) {
                                    try {
                                        JsonObject obj = Json.createObjectBuilder().add("link", u.getLink()).add("cmd", "sevencards").build();

                                        s.getBasicRemote().sendText(obj.toString());
                                    } catch (IOException ex) {
                                        Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                            }
                        }
                    }
                    Unocard u = plist.get(plist.size() - 1).getCardinhand().get(0);
                    g.getDiscard().add(u);
                    for (Session s : sessions) {
                        try {
                            JsonObject obj = Json.createObjectBuilder().add("link", u.getLink()).add("cmd", "topcard").build();
                            s.getBasicRemote().sendText(obj.toString());
                        } catch (IOException ex) {
                            Logger.getLogger(GameRooms.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } finally {
                    lock.unlock();
                }
                break;
        }
    }

    void BroadcastDiscard(String room, Player cardThrownByPlayer, String topCardNow) {

        lock.lock();
        Game g = allgames.getRunningGamesMap().get(room);
        ArrayList<Player> plist = (ArrayList<Player>) g.getPlayers();
        try {
            for (Session s : rooms.get(room)) {
                JsonObject obj = Json.createObjectBuilder().add("link", topCardNow).add("cmd", "topcard").build();
                s.getBasicRemote().sendText(obj.toString());
            }

        } catch (IOException ex) {
            Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    void broadcastTopCardAfterTakeBack(String room, String topCardNow, String playerid) {
        lock.lock();
        try {
            for (Session s : rooms.get(room)) {
                JsonObject obj = Json.createObjectBuilder().add("link", topCardNow).add("cmd", "topcard").build();
                s.getBasicRemote().sendText(obj.toString());
            }

        } catch (IOException ex) {
            Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    void BroadcastScore(String room, String playerid, int score) {

        lock.lock();
        try {
            for (Session s : rooms.get(room)) {
                JsonObject obj = Json.createObjectBuilder().add("link", score).add("cmd", "PlayerScore").build();
                s.getBasicRemote().sendText(obj.toString());
            }

        } catch (IOException ex) {
            Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

}
