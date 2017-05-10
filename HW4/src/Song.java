//Maria Hito (mh4wt)
//Homework 4
public class Song implements Comparable<Song>, Playable {
	private String artist;
	private String title;
	private int minutes;
	private int seconds;

	//Constructor
	public Song(String artist, String title){
		this.artist = artist;
		this.title = title;
	}
	public Song(String artist, String title, int minutes, int seconds){
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public Song(Song s){
		this(s.artist,s.title,s.minutes,s.seconds);	
	}

	//getter
	public String getArtist(){
		return artist;
	}
	public String getTitle(){
		return title;
	}
	public int getMinutes(){
		return minutes;
	}
	public int getSeconds(){
		return seconds;
	}

	//Setters
	public void setTitle(String title){
		this.title = title;	
	}

	public void setArtist(String artist){
		this.artist =artist;
	}

	public void setMinutes(int minutes){
		this.minutes = minutes;
	}

	public void setSeconds(int seconds){
		this.seconds = seconds;
	}

	//Methods
	public boolean equals(Object o){
		if(o instanceof Song){
			Song s = (Song)o;
			if ((this.title.equals(s.title)) && (this.artist.equals(s.artist)) && (this.minutes == s.minutes) 
					&&(this.seconds == s.seconds)){
				return true;
			}
		}
		return false;
	}

	public String toString(){
		return "{Song: title = " + title + " artist = " + artist + "}";
	}

	public void play(){
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);
	}

	@Override
	// Songs ordered by artist in ascending order.
	public int compareTo(Song s){
		int a = this.artist.compareTo(s.artist);
		if(a < 0){
			return -1;
		}
		else if(a > 0){
				return 1;
			}
			else
				if(a == 0){
					int a2 = this.title.compareTo(s.title);
					if(a2 < 0){
						return -1;
					}
					else
						if(a2 > 0){
							return 1;
						}
						else 
							if(a2 == 0){
								int a3 = this.title.compareTo(s.title);
								if(a3 < 0){
									return -1;
								}
								else
									if(a3 > 0){
										return 1;
									}
							}
				}
		return 0;
		//return title.compareTo(s.getTitle());
	}
	
	@Override
	public String getName()
	{
		return this.title;
	}
	
	@Override
	public int getPlayTimeSeconds()
	{
		int sum = 0;
		sum = this.minutes*60;
		sum = sum + this.seconds;
		return sum;
	}
}
