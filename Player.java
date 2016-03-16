import java.util.ArrayList;

public class Player {
    private ArrayList<Card>hand = new ArrayList<Card>();
    private String name;
    private int wins;
    private int losses;
    private boolean isLost;

    //add
    public void add(Card c){
        hand.add(c);
    }
    public void add(ArrayList<Card>al){
        hand.addAll(al);
    }
    public void insert(ArrayList<Card>al){
        hand.addAll(0,al);
    }
    //return
    public Card nextCard(){
        return hand.get(hand.size()-1);
    }
    public Card playNext(){
        if (hand.size()==0) {
            System.exit(1);
        }
        return hand.remove(hand.size()-1);
    }
    //can continue?
    public boolean hasNext(){
        return (hand.size()>0);
    }
    public int numLeft(){
        return hand.size();
    }
    public boolean getLost(){
        return isLost;
    }
    //get info
    public String getName(){
        return name;
    }

    //stats:
    public void isWinner(){
        wins++;
    }
    public void isLoser(){
        losses++;
    }
    public void setLost(){
        isLost=true;
    }


    public String toString(){
        return "Player " + name + " won " + wins + " rounds and lost " + losses + " rounds.";
    }
    //Proclaimations
    public void declearFailure(){
        System.out.println(name + " has ran out of cards. He is a failure!");
    }
    public void declearVictory(){
        System.out.println(name + " defeated the evil alliance. He is the champion!");
    }
    //Constructor
    public Player(){
        name = "Evil Computer";
        wins = 0;
        losses = 0;
        isLost = false;
    }
    public Player(String name){
        this.name = name;
        wins = 0;
        losses = 0;
        isLost = false;
    }
}
