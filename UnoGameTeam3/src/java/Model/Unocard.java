package Model;

import java.io.Serializable;

public class Unocard implements Serializable {

    private String link;
    private String colour;
    private String symbol;
    private boolean isFirstCardOnDiscard;
    private String thrownByWhom;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getThrownByWhom() {
        return thrownByWhom;
    }

    public void setThrownByWhom(String thrownByWhom) {
        this.thrownByWhom = thrownByWhom;
    }

    public boolean isIsFirstCardOnDiscard() {
        return isFirstCardOnDiscard;
    }

    public void setIsFirstCardOnDiscard(boolean isFirstCardOnDiscard) {
        this.isFirstCardOnDiscard = isFirstCardOnDiscard;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
