package Model;

import java.util.ArrayList;

public class Player {

    private String userid;
    private String password;
    private ArrayList<Unocard> cardinhand = new ArrayList<Unocard>();
    private Unocard playablecard;
    private String sessionid;

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<Unocard> getCardinhand() {
        return cardinhand;
    }

    public void setCardinhand(ArrayList<Unocard> cardinhand) {
        this.cardinhand = cardinhand;
    }

    public Unocard getPlayablecard() {
        return playablecard;
    }

    public void setPlayablecard(Unocard playablecard) {
        this.playablecard = playablecard;
    }
}
