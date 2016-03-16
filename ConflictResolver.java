import java.util.ArrayList;

/**
 * Created by Yuanping Song on 3/15/2016.
 */
public class ConflictResolver {
    private ArrayList<Card>stake = new ArrayList<>();
    private ArrayList<Card>currCards = new ArrayList<>();
    private ArrayList<Player>players = new ArrayList<>();
    private ArrayList<Integer>indexes = new ArrayList<>();

    public ConflictResolver(ArrayList<Player>al){
        players = al;
        for(int i = 0; i < players.size(); i++){
            indexes.add(i);
        }
        for(Player p; players){
            if(!p.getLost()){
            currCards.add(p.playNext());
            }
        }
    }

    public Player resolve (ArrayList<Player>al){

    }

}
