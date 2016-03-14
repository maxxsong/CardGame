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
	private int[]wins;

	private void initialize(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the names of the Player(s)to terminate, enter x");
		while(sc.hasNext()&&!sc.next().equals("x")){
			players.add(new Player(sc.next()));
			wins = new int[players.size()];
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
				currCards.add(players.get(i).getNext());
				System.out.println("Player " + players.get(i).getName() + " played" + currCards.get(i))
			}
			System.out.println("\n" + players.get(Card.getLargestIndex(currCards)) + "won this round");
			wins[Card.getLargestIndex(currCards]++;
			players.get(Card.getLargestIndex(currCards)).insert(currCards);
			for (Player x :
					players) {
				keep_going = x.hasLeft()&&keep_going;
			}
	}

		List l = Array.asList(ArrayUtils.toObject(wins));
		l.indexOf(Collections.max(b))

	}
	

}
