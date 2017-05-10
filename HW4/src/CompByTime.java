import java.util.Comparator;

public class CompByTime implements Comparator<Playable>{
	@Override
	public int compare(Playable p1, Playable p2){
		int result = p1.getPlayTimeSeconds() - p2.getPlayTimeSeconds();
		if(result<0){
			return -1;
		}
		else 
			if(result > 0){
				return 1;
			}
		return 0;
	}

}
