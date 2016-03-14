import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card>dk = new ArrayList<Card>();

	//Constructor
	public Deck(){
		for(int i = 0; i< 4; i++){
			for(int j = 1; j <= 13; j++){
				dk.add(new Card(j, Suit.values()[i]));
			}
		}
	}

	//Static methods for getting information about an ArrayList of Cards
	public static int getHightestCardIndex(ArrayList<Card>al){
		Card max = al.get(0);
		int maxIdx = 0;
		for(int i = 1; i < al.size(); i++){
			if (max.compareTo(al.get(i)) < 0){
				max = al.get(i);
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	public static boolean exsistMultipleWinners(ArrayList<Card>al){
		Card winner = al.get(getHightestCardIndex(al));
		for(int i = 0; i < al.size(); i++){
			if ((al.get(i)==winner)&&(i!=getHightestCardIndex(al))){
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Integer> getWinners(ArrayList<Card>al){
		ArrayList<Integer>ans = new ArrayList<>();
		ans.add(getHightestCardIndex(al));
		if (!exsistMultipleWinners(al)) return ans;
		for(int i = 0; i < al.size(); i++){
			if ((al.get(getHightestCardIndex(al))==al.get(i))&&(i!=getHightestCardIndex(al))) ans.add(i);
		}
		return ans;
	}

	//Deck operations
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

	//Helper functions
	public int cardsLeft(){
		return dk.size();
	}
	
	public int cardsDealt(){
		return 52-dk.size();
	}
	
	public boolean hasNext(){
		return dk.size()!=0;
	}

	//Getting a new set of cards in random order without using a new Deck object
	void replenish(){
		for(int i = 0; i< 4; i++){
			for(int j = 1; j <= 13; j++){
				dk.clear();
				dk.add(new Card(j, Suit.values()[i]));
			}
		}
		shuffle();
	}
}
