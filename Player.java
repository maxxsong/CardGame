import java.util.ArrayList;

public class Player {
    private ArrayList<Card>hand = new ArrayList<Card>();
    private String name;
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

    //Constructor
    public Player(String name){
        this.name = name;
    }
}
