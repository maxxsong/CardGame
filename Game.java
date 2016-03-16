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
	private ArrayList<Card>stake = new ArrayList<>();
	private ArrayList<Player>roundWinners = new ArrayList<>();


	private void initialize(){
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		System.out.println("Please enter the names of the Player(s); to terminate, enter x");
		while(sc.hasNext()&&!sc.next().equals("x")){
			players.add(new Player(sc.next()));
			System.out.println("We have Players: ");
			for(int i = 0; i < players.size(); i++){
				System.out.println(i + ". " + players.get(i).getName());
			}
		}
		System.out.println("Please specify the number of decks of cards you wish to use in this game: (enter positive integer)");
		for(int i = 0; i < sc.nextInt(); i++) {
			dk.shuffle();
			dk.deal(players);
			dk.replenish();
		}
		sc.close();
		scInt.close();
	}
private void checkEligibility(){
	for(int i = 0; i < players.size(); i++){

		if(players.size()==1){
			players.get(0).declearVictory();
			return;
		}
		if(players.get(i).numLeft()==0) {
			players.remove(i).declearFailure();
		}
	}
}
	private static ArrayList<Player> checkEligibility(ArrayList<Player>al){
		ArrayList<Player>ans = new ArrayList<>();
		for(int i = 0; i < al.size(); i++){

			if(al.size()==1){
				return ans;
			}
			if(al.get(i).numLeft()==0) {
				ans.add(al.remove(i));
			}
		}
		if(ans.size()>0) {
			for (Player p; ans)
			{ p.declearFailure();}
		}
		return ans;
	}

	private ArrayList<Player> getWinners(ArrayList<Player>al){
		for(Player p; al){
			currCards.add(p.playNext());
		}
		stake.addAll(currCards);
		return Deck.getWinners(Deck.getWinnersIndex(currCards),al);
	}

	public void playWarGame(){
		initialize();
		boolean keep_going = true;

		while(keep_going){
			checkEligibility();
			for (int i = 0; i < players.size(); i++) {
				currCards.add(players.get(i).playNext());
				System.out.println("Player " + players.get(i).getName() + " played" + currCards.get(i));
				roundWinners = players;
			}
			while(roundWinners.size()>1) {
				players.removeAll(checkEligibility(roundWinners));
				roundWinners = getWinners(roundWinners);
			}
			if(roundWinners.size()==1){
				System.out.println("\n" + roundWinners.get(0) + "won this round");
				players.get(players.indexOf(roundWinners.get(0))).add(stake);
			}
			if(players.size()==1){
				players.get(0).declearVictory();
				keep_going = false;
			}
	}



	}
	

}
