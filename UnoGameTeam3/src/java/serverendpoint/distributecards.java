package serverendpoint;

import Main.Game;
import Model.AllGames;
import Model.Player;
import Model.Unocard;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import javax.websocket.server.ServerEndpoint;

@RequestScoped
@ServerEndpoint("/distributecards/{gamekey}")
public class distributecards {

    @Inject
    private GameRooms rooms;
    @Inject
    private AllGames allgames;
    private Session session;
    private static int count = 0;

    @OnOpen
    public void open(Session s, @PathParam("gamekey") String room) {
        System.out.println(room + ">>> @OnOpen = " + s.getId());
        session = s;
        rooms.add(room, session);

    }

    @OnMessage
    public void message(String msg) {
        System.out.println(">>> msg = " + msg + "session id = " + session.getId());

        JsonReader reader = Json.createReader(new ByteArrayInputStream(msg.getBytes()));
        JsonObject json = reader.readObject();
        String room = json.getString("room");
        String cmd = json.getString("cmd");
        System.out.println("cmd on message = " + cmd);
        String playerid = json.getString("playerid");
        switch (cmd) {
            case "logout":
                rooms.broadcast(room, playerid, "logout");
                break;
            case "takebackcard":
                rooms.broadcast(room, playerid, "takebackcard");

                break;
            case "takeacard":
                rooms.broadcast(room, playerid, "takeacard");
                break;
            case "setusername":
                ArrayList<Player> playerlist = (ArrayList<Player>) allgames.getRunningGamesMap().get(room).getPlayers();
                for (int i = 0; i < playerlist.size() - 1; i++) {
                    if (playerlist.get(i).getUserid().equals(playerid)) {
                        count++;
                        System.out.println("playerid = " + playerid + "userid = " + playerlist.get(i).getUserid());
                        playerlist.get(i).setSessionid(session.getId());
                        System.out.println("psid for " + playerlist.get(i).getUserid() + " = " + playerlist.get(i).getSessionid());
                    }
                }

                if (count == allgames.getRunningGamesMap().get(room).getMaxPlayer()) {
                    rooms.broadcast(room, playerid, "sevenandtop");
                }

                break;

            case "throwCard":
                Unocard thrownCard = null;
                int score = 0;
                Player cardThrownByPlayer = null;
                String cardThrown = json.getString("cardThrown");
                playerlist = (ArrayList<Player>) allgames.getRunningGamesMap().get(room).getPlayers();
                Game g = allgames.getRunningGamesMap().get(room);
                for (int i = 0; i < playerlist.size(); i++) {

                    if (playerlist.get(i).getUserid().equals(playerid)) {
                        cardThrownByPlayer = playerlist.get(i);
                        ArrayList<Unocard> cardsWithPlayers = playerlist.get(i).getCardinhand();
                        int count = 0;

                        for (int x = 0; x < cardThrownByPlayer.getCardinhand().size(); x++) {
                            Unocard u = cardThrownByPlayer.getCardinhand().get(x);
                            if (u.getLink().equalsIgnoreCase(cardThrown)) {
                                thrownCard = u;
                                u.setThrownByWhom(cardThrownByPlayer.getUserid());
                                g.getDiscard().add(u);
                                System.out.println("discard pile in broadcast after adding = " + g.getDiscard().size());
                                playerlist.get(i).getCardinhand().remove(count);

                                if (playerlist.get(i).getCardinhand().size() > 0) {
                                    System.out.println(">>>>>>>card in hand after removeing>>>" + playerlist.get(i).getCardinhand().size());
                                    rooms.BroadcastDiscard(room, cardThrownByPlayer, thrownCard != null ? thrownCard.getLink() : null);
                                    break;
                                } else {
                                    System.out.println(">>>>>>>>>>>>>>>>>size is zero>>>>>>>>>>>");
                                    rooms.BroadcastDiscard(room, cardThrownByPlayer, thrownCard != null ? thrownCard.getLink() : null);
                                    for (int j = 0; j < playerlist.size() - 1; j++) {
                                        for (int k = 0; k < playerlist.get(j).getCardinhand().size(); k++) {
                                            score = score + playerlist.get(j).getCardinhand().get(k).getScore();
                                        }

                                    }
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>score>>>>>>>>>>>>>>>" + score);
                                    rooms.BroadcastScore(room, playerid, score);

                                }
                            }

                            count++;
                        }
                    }

                }

        }

    }

    @OnClose
    public void close() {
        System.out.println(">>> @OnClose = " + session.getId());
    }

}
