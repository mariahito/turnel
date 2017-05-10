import java.util.Comparator;

public class CompByName implements Comparator<Playable> {
	public int compare(Playable p1, Playable p2){
		return p1.getName().compareTo(p2.getName());
	}
}
