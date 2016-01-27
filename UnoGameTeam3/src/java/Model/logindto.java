package Model;

public class logindto {

    private String userid;
    private String password;

    public logindto(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "logindto{" + "userid=" + userid + ", password=" + password + '}';
    }

}
