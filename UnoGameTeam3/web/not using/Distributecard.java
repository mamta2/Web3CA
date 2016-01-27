
package Controller;

import Main.Game;
import Model.Player;
import Model.Unocard;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Distributecard", urlPatterns = {"/Distributecard/*"})
public class Distributecard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in controller");
        String path=request.getPathInfo();
        System.out.println(path);
        Game game = new Game();
   
//        game.check();
        game.setDeck(game.shuffle(game.getDeck()));
//           game.display();
           
           Player p1 = new Player();
           p1.setUserid(request.getParameter("player1"));
          
           game.getPlayers().add(p1);
            Player p2 = new Player();
            p2.setUserid(request.getParameter("player2"));
           
           game.getPlayers().add(p2);
            Player p3 = new Player();
            p3.setUserid(request.getParameter("player3"));
            
           game.getPlayers().add(p3);
            Player p4 = new Player();
            p4.setUserid(request.getParameter("player4"));
           game.getPlayers().add(p4);
           
//           for(int i=0 ; i<4;i++)
//           {
//               System.out.println(game.getPlayers().get(i).getName());
//           }
           for(int i=0;i<4;i++)
           {
               for(int j=0;j<7;j++)
               {
                   game.getPlayers().get(i).getCardinhand().add(game.getDeck().get(0));
                   game.getDeck().remove(0);
               }
           }
//           printing out the cards to players
//            for(int i=0;i<4;i++)
//           {
//                System.out.println(game.getPlayers().get(i).getName());
//               for(int j=0;j<7;j++)
//               {
//                    System.out.println(game.getPlayers().get(i).getCardinhand().get(j).getLink());
//                    
//               }
//              
//           }
//            
//            System.out.println(game.getDeck().get(0));
          
            HashMap<String , ArrayList<Unocard>> inhand = new HashMap<>();
            for(int i=0;i<4;i++)
            {
            inhand.put(game.getPlayers().get(i).getUserid(),game.getPlayers().get(i).getCardinhand());
    }
            request.setAttribute("cardinhand", inhand);
            request.setAttribute("topcard", game.getDeck().get(0));
            RequestDispatcher rd = request.getRequestDispatcher("displaycard.jsp");
            rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
