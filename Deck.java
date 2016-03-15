import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card>dk = new ArrayList<Card>();
	private static ArrayList<Card>stake = new ArrayList<Card>();

	//Constructor
	public Deck(){
		for(int i = 0; i< 4; i++){
			for(int j = 1; j <= 13; j++){
				dk.add(new Card(j, Suit.values()[i]));
			}
		}
	}

	//Static methods for getting information about an ArrayList of Cards
	public static int getHighestCardIndex(ArrayList<Card>al){
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
		Card winner = al.get(getHighestCardIndex(al));
		for(int i = 0; i < al.size(); i++){
			if ((al.get(i)==winner)&&(i!=getHighestCardIndex(al))){
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Integer> getWinnersIndex(ArrayList<Card>al){
		ArrayList<Integer>ans = new ArrayList<>();
		ans.add(getHighestCardIndex(al));
		if (!exsistMultipleWinners(al)) return ans;
		for(int i = 0; i < al.size(); i++){
			if ((al.get(getHighestCardIndex(al))==al.get(i))&&(i!=getHighestCardIndex(al))) ans.add(i);
		}
		return ans;
	}

	public static ArrayList<Player> getWinners(ArrayList<Integer>x, ArrayList<Player>y){
		ArrayList<Player>ans = new ArrayList<>();
		for(int i = 0; i < x.size(); i++){
			ans.add(y.get(x.get(i)));
		}
	}

	public static Player decideWinner(ArrayList<Player>al){
		ArrayList<Player>temp = new ArrayList<Player>();
		ArrayList<Card>tempCards = new ArrayList<Card>();
		for(int i = 0; i < al.size();i++){
			tempCards.add(al.get(i).playNext());
		}
		temp = getWinners(Deck.getWinnersIndex(tempCards),al);
		if(temp.size()==1) {
			temp.get(0).add(tempCards);
			temp.get(0).add(stake);
			return temp.get(0);
		}

		else {
			return decideWinner(temp);
		}
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
