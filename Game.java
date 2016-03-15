import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

public class Game {
	private ArrayList<Player>players = new ArrayList<Player>();
	private Deck dk = new Deck();
	private ArrayList<Card>currCards = new ArrayList<Card>();
	private ArrayList<Integer>roundWinners = new ArrayList<>();

	private void initialize(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the names of the Player(s)to terminate, enter x");
		while(sc.hasNext()&&!sc.next().equals("x")){
			players.add(new Player(sc.next()));
			System.out.println("We have Players: ");
			for(int i = 0; i < players.size(); i++){
				System.out.println(i + ". " + players.get(i));
			}
		}
	}
	public void playWarGame(){
		dk.shuffle();
		initialize();
		boolean keep_going = true;

		while(keep_going){

			for (int i = 0; i < players.size(); i++) {
				currCards.add(players.get(i).playNext());
				System.out.println("Player " + players.get(i).getName() + " played" + currCards.get(i));
			}
			roundWinners = Deck.getWinners(currCards);
			if(roundWinners.size()==1){
				System.out.println("\n" + players.get(Deck.getHighestCardIndex(currCards)) + "won this round");
				players.get(Deck.getHighestCardIndex(currCards)).isWinner();
				for (Player p; players){
					if(players.indexOf(p)!=Deck.getHighestCardIndex(currCards)){
						p.isLoser();
					}
				}
			}else{
				ArrayList<Card>stake = new ArrayList<Card>();
				for(int i = 0; i < roundWinners.size(); i++){
					stake.add(players.get(roundWinners.get(i)).playNext());
					if(Deck.getHighestCardIndex(stake).size()<1
				}
			}

			wins[Deck.getHighestCardIndex(currCards)]++;
			players.get(Deck.getHighestCardIndex(currCards)).insert(currCards);
			for (Player x :
					players) {
				keep_going = x.hasNext()&&keep_going;
			}
	}



	}
	

}
