
public class Card {
	
	private int pointValue;
	private Suit st;
	
	public Card (int pt, Suit s){		
		pointValue=pt;
		st=s;
	}		
	
	public boolean isEqual(Card a){
		return (a.getValue()==pointValue)&&(a.getSuit()==st);
	}
	
	public int compareTo(Card a){
		if(a.getValue()==1&&pointValue!=1)
			return -1;
		else if(a.getValue()!=1&&pointValue==1)
			return 1;
		else
			return pointValue-a.getValue();		
	}
	
	public Suit getSuit(Card a){
		return a.getSuit();
	}
	
	public String toString(){
		return pointValue+" of "+st;
	}
	
	public boolean isRoyal(){
		return pointValue==11||pointValue==12||pointValue==13;
	}
	
	public boolean isAce(){
		return pointValue==1;
	}
	
	public int getValue(){
		return pointValue;
	}
	
	public Suit getSuit(){
		return st;
	}
	
}
