import java.util.ArrayList;

public class Player {
    private ArrayList<Card>hand = new ArrayList<Card>();
    private String name;
    private int wins;
    private int losses;
    //add
    public void add(Card c){
        hand.add(c);
    }
    public void add(ArrayList<Card>al){
        hand.addAll(al);
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

    public String toString(){
        return "Player " + name + " won " + wins + " rounds and lost " + losses + " rounds.";
    }
    //Constructor
    public Player(String name){
        this.name = name;
        wins = 0;
        losses = 0;
    }
}
