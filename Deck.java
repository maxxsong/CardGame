import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card>dk = new ArrayList<Card>();
	
	public Deck(){
		for(int i = 0; i< 4; i++){
			for(int j = 1; j <= 13; j++){
				dk.add(new Card(j, Suit.values()[i]));
			}
		}
	}
	
	public void shuffle(){
		Random rd = new Random();
		int idx;
		Card temp;
		for (int i = 0; i < dk.size(); i++) {
			idx = i+rd.nextInt(53-i);
			temp = dk.get(idx);
			dk.set(idx, dk.get(i));
			dk.set(i, temp);
		}
	}
	
	public Card deal(){
		return dk.remove(dk.size()-1);
	}
	
	public void deal(ArrayList<Player>players){
		for(int i = 0; i < players.size(); i++){
			for(int j = i; j < cardsLeft(); i+=players.size()){
				players.get(i).add(deal());
			}
		}
	}
	
	public int cardsLeft(){
		return dk.size();
	}
	
	public int cardsDealt(){
		return 52-dk.size();
	}
	
	public boolean hasNext(){
		return dk.size()==0;
	}
	
	void replenish(){
		for(int i = 0; i< 4; i++){
			for(int j = 1; j <= 13; j++){
				dk.clear();
				dk.add(new Card(j, Suit.values()[i]));
			}
		}
	}
}
