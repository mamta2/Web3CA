package Controller;

import Main.Game;
import Model.AllGames;
import Model.Player;
import Model.Unocard;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddPlayer", urlPatterns = {"/AddPlayer"})
public class AddPlayer extends HttpServlet {

    @Inject
    private AllGames allgames;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String gameid = request.getParameter("gamekey");

        request.setAttribute("gamekey", gameid);

        Player user = (Player) request.getSession().getAttribute("user");
        if (allgames.getWaitingGamesMap().get(gameid).getPlayers().size() == allgames.getWaitingGamesMap().get(gameid).getMaxPlayer() - 1) {
            allgames.getWaitingGamesMap().get(gameid).getPlayers().add(user);
            allgames.getRunningGamesMap().put(gameid, allgames.getWaitingGamesMap().get(gameid));
            allgames.getWaitingGamesMap().remove(gameid);
            Player table = new Player();
            table.setUserid("table");
            allgames.getRunningGamesMap().get(gameid).getPlayers().add(table);
            System.out.println("number of players in the game = " + allgames.getRunningGamesMap().get(gameid).getPlayers().size());

            HashMap<String, Game> testmap = allgames.getRunningGamesMap();
            Game testgame = testmap.get(gameid);
            ArrayList<Player> testplayers = (ArrayList<Player>) testgame.getPlayers();
            for (int i = 0; i < allgames.getRunningGamesMap().get(gameid).getMaxPlayer(); i++) {
                for (int j = 0; j < 7; j++) {
                    ArrayList<Unocard> cardinhand = testplayers.get(i).getCardinhand();
                    Unocard nextcard = testgame.getDeck().get(0);
                    cardinhand.add(nextcard);

                    testgame.getDeck().remove(0);
                }
            }

            Unocard firstCardOnTable = testgame.getDeck().get(0);
            firstCardOnTable.setIsFirstCardOnDiscard(true);
            testgame.setFirstCardOnDiscardLink(firstCardOnTable.getLink());
            testgame.getDeck().remove(firstCardOnTable);

            testplayers.get(allgames.getRunningGamesMap().get(gameid).getMaxPlayer()).getCardinhand().add(firstCardOnTable);

            for (int i = 0; i < testplayers.size(); i++) {

                System.out.println("size of player's card in hand +" + i + " = " + testplayers.get(i).getCardinhand().size());
            }
        } else {
            allgames.getWaitingGamesMap().get(gameid).getPlayers().add(user);
        }

        RequestDispatcher rd = request.getRequestDispatcher("waittojoin.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
