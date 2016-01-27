package Main;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;

@ApplicationScoped
public class Game {

    private List<Player> players = new ArrayList<>();
    private ArrayList<Unocard> deck = new ArrayList<>();
    private ArrayList<Unocard> discard = new ArrayList<>();
    private Unocard currentcard;
    private String description;
    private String gameId;
    private String creater;
    private int maxPlayer;
    private String firstCardOnDiscardLink;

    public Game() {
        for (int i = 0; i < 108; i++) {
            Unocard x = new Unocard();
            x.setLink("Images/" + "c" + i + ".png");
            deck.add(x);
        }
        setColourSymbol();
        Collections.shuffle(deck);
        gameId = this.UUIDgenerator();

    }

    public String getFirstCardOnDiscardLink() {
        return firstCardOnDiscardLink;
    }

    public void setFirstCardOnDiscardLink(String firstCardOnDiscardLink) {
        this.firstCardOnDiscardLink = firstCardOnDiscardLink;
    }

    public ArrayList<Unocard> getDiscard() {
        return discard;
    }

    public void setDiscard(ArrayList<Unocard> discard) {
        this.discard = discard;
    }

    public void setCreater(String s) {
        creater = s;

    }

    public String getCreater() {
        return creater;
    }

    public String getGameId() {
        return gameId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String UUIDgenerator() {
        UUID gameId = UUID.randomUUID();
        return gameId.toString().substring(0, 8);
    }

    public void display() {
        for (int i = 0; i < 108; i++) {
            System.out.println(deck.get(i).getLink());
        }
    }

    public ArrayList<Unocard> shuffle(ArrayList<Unocard> deck) {
        Collections.shuffle(deck);
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public ArrayList<Unocard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Unocard> deck) {
        this.deck = deck;
    }

    public Unocard getCurrentcard() {
        return currentcard;
    }

    public void setCurrentcard(Unocard currentcard) {
        this.currentcard = currentcard;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    private void setColourSymbol() {

        deck.get(0).setColour("red");
        deck.get(0).setSymbol("zero");
        deck.get(0).setScore(0);
        deck.get(1).setColour("red");
        deck.get(1).setSymbol("one");
        deck.get(1).setScore(1);
        deck.get(2).setColour("red");
        deck.get(2).setSymbol("two");
        deck.get(2).setScore(2);
        deck.get(3).setColour("red");
        deck.get(3).setSymbol("three");
        deck.get(3).setScore(3);
        deck.get(4).setColour("red");
        deck.get(4).setSymbol("four");
        deck.get(4).setScore(4);
        deck.get(5).setColour("red");
        deck.get(5).setSymbol("five");
        deck.get(5).setScore(5);
        deck.get(6).setColour("red");
        deck.get(6).setSymbol("six");
        deck.get(6).setScore(6);
        deck.get(7).setColour("red");
        deck.get(7).setSymbol("seven");
        deck.get(7).setScore(7);
        deck.get(8).setColour("red");
        deck.get(8).setSymbol("eight");
        deck.get(8).setScore(8);
        deck.get(9).setColour("red");
        deck.get(9).setSymbol("nine");
        deck.get(9).setScore(9);
        deck.get(10).setColour("red");
        deck.get(10).setSymbol("skip");
        deck.get(10).setScore(20);
        deck.get(11).setColour("red");
        deck.get(11).setSymbol("reverse");
        deck.get(11).setScore(20);
        deck.get(12).setColour("red");
        deck.get(12).setSymbol("drawtwo");
        deck.get(12).setScore(20);
        deck.get(13).setColour("all");
        deck.get(13).setSymbol("wild");
        deck.get(13).setScore(50);
        deck.get(14).setColour("yellow");
        deck.get(14).setSymbol("zero");
        deck.get(14).setScore(0);
        deck.get(15).setColour("yellow");
        deck.get(15).setSymbol("one");
        deck.get(15).setScore(1);
        deck.get(16).setColour("yellow");
        deck.get(16).setSymbol("two");
        deck.get(16).setScore(2);
        deck.get(17).setColour("yellow");
        deck.get(17).setSymbol("three");
        deck.get(17).setScore(3);
        deck.get(18).setColour("yellow");
        deck.get(18).setSymbol("four");
        deck.get(18).setScore(4);
        deck.get(19).setColour("yellow");
        deck.get(19).setSymbol("five");
        deck.get(19).setScore(5);
        deck.get(20).setColour("yellow");
        deck.get(20).setSymbol("six");
        deck.get(20).setScore(6);
        deck.get(21).setColour("yellow");
        deck.get(21).setSymbol("seven");
        deck.get(21).setScore(7);
        deck.get(22).setColour("yellow");
        deck.get(22).setSymbol("eight");
        deck.get(22).setScore(8);
        deck.get(23).setColour("yellow");
        deck.get(23).setSymbol("nine");
        deck.get(23).setScore(9);
        deck.get(24).setColour("yellow");
        deck.get(24).setSymbol("skip");
        deck.get(24).setScore(20);
        deck.get(25).setColour("yellow");
        deck.get(25).setSymbol("reverse");
        deck.get(25).setScore(20);
        deck.get(26).setColour("yellow");
        deck.get(26).setSymbol("drawtwo");
        deck.get(26).setScore(20);
        deck.get(27).setColour("all");
        deck.get(27).setSymbol("wild");
        deck.get(27).setScore(50);
        deck.get(28).setColour("green");
        deck.get(28).setSymbol("zero");
        deck.get(28).setScore(0);
        deck.get(29).setColour("green");
        deck.get(29).setSymbol("one");
        deck.get(29).setScore(1);
        deck.get(30).setColour("green");
        deck.get(30).setSymbol("two");
        deck.get(30).setScore(2);
        deck.get(31).setColour("green");
        deck.get(31).setSymbol("three");
        deck.get(31).setScore(3);
        deck.get(32).setColour("green");
        deck.get(32).setSymbol("four");
        deck.get(32).setScore(4);
        deck.get(33).setColour("green");
        deck.get(33).setSymbol("five");
        deck.get(33).setScore(5);
        deck.get(34).setColour("green");
        deck.get(34).setSymbol("six");
        deck.get(34).setScore(6);
        deck.get(35).setColour("green");
        deck.get(35).setSymbol("seven");
        deck.get(35).setScore(7);
        deck.get(36).setColour("green");
        deck.get(36).setSymbol("eight");
        deck.get(36).setScore(8);
        deck.get(37).setColour("green");
        deck.get(37).setSymbol("nine");
        deck.get(37).setScore(9);
        deck.get(38).setColour("green");
        deck.get(38).setSymbol("skip");
        deck.get(38).setScore(20);
        deck.get(39).setColour("green");
        deck.get(39).setSymbol("reverse");
        deck.get(39).setScore(20);
        deck.get(40).setColour("green");
        deck.get(40).setSymbol("drawtwo");
        deck.get(40).setScore(20);
        deck.get(41).setColour("all");
        deck.get(41).setSymbol("wild");
        deck.get(41).setScore(50);
        deck.get(42).setColour("blue");
        deck.get(42).setSymbol("zero");
        deck.get(42).setScore(0);
        deck.get(43).setColour("blue");
        deck.get(43).setSymbol("one");
        deck.get(43).setScore(1);
        deck.get(44).setColour("blue");
        deck.get(44).setSymbol("two");
        deck.get(44).setScore(2);
        deck.get(45).setColour("blue");
        deck.get(45).setSymbol("three");
        deck.get(45).setScore(3);
        deck.get(46).setColour("blue");
        deck.get(46).setSymbol("four");
        deck.get(46).setScore(4);
        deck.get(47).setColour("blue");
        deck.get(47).setSymbol("five");
        deck.get(47).setScore(5);
        deck.get(48).setColour("blue");
        deck.get(48).setSymbol("six");
        deck.get(48).setScore(6);
        deck.get(49).setColour("blue");
        deck.get(49).setSymbol("seven");
        deck.get(49).setScore(7);
        deck.get(50).setColour("blue");
        deck.get(50).setSymbol("eight");
        deck.get(50).setScore(8);
        deck.get(51).setColour("blue");
        deck.get(51).setSymbol("nine");
        deck.get(51).setScore(9);
        deck.get(52).setColour("blue");
        deck.get(52).setSymbol("skip");
        deck.get(52).setScore(20);
        deck.get(53).setColour("blue");
        deck.get(53).setSymbol("reverse");
        deck.get(53).setScore(20);
        deck.get(54).setColour("blue");
        deck.get(54).setSymbol("drawtwo");
        deck.get(54).setScore(20);
        deck.get(55).setColour("all");
        deck.get(55).setSymbol("wild");
        deck.get(55).setScore(50);
        deck.get(56).setColour("red");
        deck.get(56).setSymbol("one");
        deck.get(56).setScore(1);
        deck.get(57).setColour("red");
        deck.get(57).setSymbol("one");
        deck.get(57).setScore(1);
        deck.get(58).setColour("red");
        deck.get(58).setSymbol("two");
        deck.get(58).setScore(2);
        deck.get(59).setColour("red");
        deck.get(59).setSymbol("three");
        deck.get(59).setScore(3);
        deck.get(60).setColour("red");
        deck.get(60).setSymbol("four");
        deck.get(60).setScore(4);
        deck.get(61).setColour("red");
        deck.get(61).setSymbol("five");
        deck.get(61).setScore(5);
        deck.get(62).setColour("red");
        deck.get(62).setSymbol("six");
        deck.get(62).setScore(6);
        deck.get(63).setColour("red");
        deck.get(63).setSymbol("seven");
        deck.get(63).setScore(7);
        deck.get(64).setColour("red");
        deck.get(64).setSymbol("eight");
        deck.get(64).setScore(8);
        deck.get(65).setColour("red");
        deck.get(65).setSymbol("nine");
        deck.get(65).setScore(9);
        deck.get(66).setColour("red");
        deck.get(66).setSymbol("skip");
        deck.get(66).setScore(20);
        deck.get(67).setColour("red");
        deck.get(67).setSymbol("reverse");
        deck.get(67).setScore(20);
        deck.get(68).setColour("black");
        deck.get(68).setSymbol("wilddrawfour");
        deck.get(68).setScore(50);
        deck.get(69).setColour("yellow");
        deck.get(69).setSymbol("one");
        deck.get(69).setScore(1);
        deck.get(70).setColour("yellow");
        deck.get(70).setSymbol("one");
        deck.get(70).setScore(1);
        deck.get(71).setColour("yellow");
        deck.get(71).setSymbol("two");
        deck.get(71).setScore(2);
        deck.get(72).setColour("yellow");
        deck.get(72).setSymbol("three");
        deck.get(72).setScore(3);
        deck.get(73).setColour("yellow");
        deck.get(73).setSymbol("four");
        deck.get(73).setScore(4);
        deck.get(74).setColour("yellow");
        deck.get(74).setSymbol("five");
        deck.get(74).setScore(5);
        deck.get(75).setColour("yellow");
        deck.get(75).setSymbol("six");
        deck.get(74).setScore(6);
        deck.get(76).setColour("yellow");
        deck.get(76).setSymbol("seven");
        deck.get(76).setScore(7);
        deck.get(77).setColour("yellow");
        deck.get(77).setSymbol("eight");
        deck.get(77).setScore(8);
        deck.get(78).setColour("yellow");
        deck.get(78).setSymbol("nine");
        deck.get(78).setScore(9);
        deck.get(79).setColour("yellow");
        deck.get(79).setSymbol("skip");
        deck.get(79).setScore(20);
        deck.get(80).setColour("yellow");
        deck.get(80).setSymbol("reverse");
        deck.get(80).setScore(20);
        deck.get(81).setColour("black");
        deck.get(81).setSymbol("wilddrawfour");
        deck.get(81).setScore(50);
        deck.get(82).setColour("green");
        deck.get(82).setSymbol("one");
        deck.get(82).setScore(1);
        deck.get(83).setColour("green");
        deck.get(83).setSymbol("one");
        deck.get(83).setScore(1);
        deck.get(84).setColour("green");
        deck.get(84).setSymbol("two");
        deck.get(84).setScore(2);
        deck.get(85).setColour("green");
        deck.get(85).setSymbol("three");
        deck.get(85).setScore(3);
        deck.get(86).setColour("green");
        deck.get(86).setSymbol("four");
        deck.get(86).setScore(4);
        deck.get(87).setColour("green");
        deck.get(87).setSymbol("five");
        deck.get(87).setScore(5);
        deck.get(88).setColour("green");
        deck.get(88).setSymbol("six");
        deck.get(88).setScore(6);
        deck.get(89).setColour("green");
        deck.get(89).setSymbol("seven");
        deck.get(89).setScore(7);
        deck.get(90).setColour("green");
        deck.get(90).setSymbol("eight");
        deck.get(90).setScore(8);
        deck.get(91).setColour("green");
        deck.get(91).setSymbol("nine");
        deck.get(91).setScore(9);
        deck.get(92).setColour("green");
        deck.get(92).setSymbol("skip");
        deck.get(92).setScore(20);
        deck.get(93).setColour("green");
        deck.get(93).setSymbol("reverse");
        deck.get(93).setScore(20);
        deck.get(94).setColour("black");
        deck.get(94).setSymbol("wilddrawfour");
        deck.get(94).setScore(50);
        deck.get(95).setColour("blue");
        deck.get(95).setSymbol("one");
        deck.get(95).setScore(1);
        deck.get(96).setColour("blue");
        deck.get(96).setSymbol("one");
        deck.get(96).setScore(1);
        deck.get(97).setColour("blue");
        deck.get(97).setSymbol("two");
        deck.get(97).setScore(2);
        deck.get(98).setColour("blue");
        deck.get(98).setSymbol("three");
        deck.get(98).setScore(3);
        deck.get(99).setColour("blue");
        deck.get(99).setSymbol("four");
        deck.get(99).setScore(4);
        deck.get(100).setColour("blue");
        deck.get(100).setSymbol("five");
        deck.get(100).setScore(5);
        deck.get(101).setColour("blue");
        deck.get(101).setSymbol("six");
        deck.get(101).setScore(6);
        deck.get(102).setColour("blue");
        deck.get(102).setSymbol("seven");
        deck.get(102).setScore(7);
        deck.get(103).setColour("blue");
        deck.get(103).setSymbol("eight");
        deck.get(103).setScore(8);
        deck.get(104).setColour("blue");
        deck.get(104).setSymbol("nine");
        deck.get(104).setScore(9);
        deck.get(105).setColour("blue");
        deck.get(105).setSymbol("skip");
        deck.get(105).setScore(20);
        deck.get(106).setColour("blue");
        deck.get(106).setSymbol("reverse");
        deck.get(106).setScore(20);
        deck.get(107).setColour("black");
        deck.get(107).setSymbol("wilddrawfour");
        deck.get(107).setScore(50);
    }

}
