
//package Controller;
//
//import Main.Game;
//import Model.AllGames;
//import Model.Player;
//import Model.Unocard;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import javax.inject.Inject;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebServlet(name = "showcard", urlPatterns = {"/showcard"})
//public class ShowCard extends HttpServlet {
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    
//    }
//    @Inject private AllGames allgames;
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//         String testkey = request.getParameter("gamekey");
//         System.out.println("game id in Show Card : "+testkey);
//         request.setAttribute("gameid", testkey);
//         HashMap<String,Game> testmap = allgames.getRunningGamesMap();
//         Game testgame = testmap.get(testkey);
//         ArrayList<Player> testplayers = (ArrayList<Player>) testgame.getPlayers();
//         System.out.println("size of players in ShowCard="+testplayers.size());
//         System.out.println("size of the deck in ShowCard="+testgame.getDeck().size());
////             for(int i=0;i<4;i++)
////           {
////               for(int j=0;j<7;j++)
////               {
////                   ArrayList<Unocard> cardinhand=testplayers.get(i).getCardinhand();
////                   Unocard nextcard=testgame.getDeck().get(0);
////                   cardinhand.add(nextcard);
////                   
//////                  testplayers.get(i).getCardinhand().add(testgame.getDeck().get(0));
////                  testgame.getDeck().remove(0);
////               }
////           }
////             
////             testplayers.get(4).getCardinhand().add(testgame.getDeck().get(0));
////             System.out.println("all games "+allgames.toString());
////        System.out.println("map"+allgames.getRunningGamesMap().toString());
//
//        
//       
////        System.out.println("test map"+testmap);
//
//        
//       
////         System.out.println("gameid = "+testkey);
//       
//        
////        System.out.println("game object"+testgame.toString());
//       
//        for(int i=0;i<testplayers.size();i++)
//        {
////            System.out.println("players:"+testplayers.get(i).getUserid());
//        }
//        RequestDispatcher rd = request.getRequestDispatcher("/startgame.jsp");
//                rd.forward(request,response);
//        
//                
//     
//    }
//
//    
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//
//}
