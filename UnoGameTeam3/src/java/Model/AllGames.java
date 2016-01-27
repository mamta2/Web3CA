package Model;

import Main.Game;
import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("allgames")
public class AllGames implements Serializable {

    private HashMap<String, Game> waitingGamesMap;
    private HashMap<String, Game> runningGamesMap;

    private int turn = 0;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public AllGames() {
        waitingGamesMap = new HashMap<String, Game>();
        runningGamesMap = new HashMap<String, Game>();

    }

    public HashMap<String, Game> getRunningGamesMap() {
        return runningGamesMap;
    }

    public void setRunningGamesMap(HashMap<String, Game> runningGamesMap) {
        this.runningGamesMap = runningGamesMap;
    }

    public HashMap<String, Game> getWaitingGamesMap() {
        return waitingGamesMap;
    }

    public void setWaitingGamesMap(HashMap<String, Game> waitingGamesMap) {
        this.waitingGamesMap = waitingGamesMap;
    }

}
