package Controller;
import Main.Game;
import Model.AllGames;
import Model.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NewGame", urlPatterns = {"/NewGame"})
public class NewGame extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Inject
    private AllGames allgames;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Game game = new Game();
        game.setDescription(request.getParameter("Description"));
        game.setMaxPlayer(Integer.parseInt(request.getParameter("maxPlayer")));

        request.setAttribute("gameId", game.getGameId());

        request.setAttribute("description", game.getDescription());
        Player p = (Player) request.getSession().getAttribute("user");
        game.setCreater(p.getUserid());
        allgames.getWaitingGamesMap().put(game.getGameId(), game);
        allgames.getWaitingGamesMap().get(game.getGameId()).getPlayers().add(p);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("waittojoin.jsp?gamekey=" + game.getGameId());
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
