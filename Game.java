import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

public class Game {
	private ArrayList<Player>players = new ArrayList<Player>();
	private Deck dk = new Deck();
	private void initialize(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the names of the Player(s)to terminate, enter x");
		while(sc.hasNext()&&!sc.next().equals("x")){
			players.add(new Player(sc.next()));
		}
	}
	public Game(){
		dk.shuffle();
		initialize();
	}
	
	public StartDocument 
}
