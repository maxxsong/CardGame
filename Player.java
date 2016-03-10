import java.security.PublicKey;
import java.util.ArrayList;

public class Player {
	private ArrayList<Card>hand = new ArrayList<Card>();
	private String name;
	public void add(Card c){
		hand.add(c);
	}
	public Card next(){
		return hand.remove(hand.size()-1);
	}
	public boolean hasNext(){
		return (hand.size()==0);
	}
	public Player(String name){
		this.name = name;
	}
}
