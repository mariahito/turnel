//Maria Hito (mh4wt)
//Homework 4
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PlayList implements Playable {
	private String name;
	private ArrayList<Playable>playableList;

	//Mutators	
	public PlayList(){
		name = "Untitled";
		playableList = new ArrayList<Playable>();
	}
	public PlayList(String name){
		this.name = name;
		playableList = new ArrayList<Playable>();
	}

	//Getters	 
	public String getName(){
		return name;
	}
	public ArrayList<Playable> getPlayableList(){
		return playableList;
	}

	//Setters
	public void setName(String name){
		this.name = name;
	}
	public void setPlayableList(ArrayList<Playable> playableList){
		this.playableList = playableList;
	}

	//Methods
	@Override
	public String toString(){
		return "name of playlist: "  + name + "music: " + playableList;
	}
	// loads songs from file, more on this below
	public boolean loadSong(String fileName){

/*		String artist = null;
		String title = null;
		int minutes = -1;
		int seconds = -1;
		File songFile = new File(fileName);
		try {
			Scanner file = new Scanner(songFile);
			while(file.hasNext()){
				String str = file.nextLine();
				if(!str.equals("")){
					if(title == null){
						title = str;
					}
					else if(artist == null){
						artist = str;
					}
					else if(minutes ==-1){
						String[]minSec = str.split(":");
						minutes = Integer.parseInt(minSec[0]);
						seconds = Integer.parseInt(minSec[1]);
					}
				}else{
					Playable song = new Song(artist,title,minutes,seconds);
					playableList.add(song);
					artist = null;
					title = null;
					minutes = -1;
					seconds = -1;
				}
			}
			return true;*/
			File file = new File(fileName);
			Scanner scan;
			try {
				scan = new Scanner(file);
				while (scan.hasNext()) {
					String title,artist;
					int minutes,seconds;
					String line[] = scan.nextLine().split(",");
					title=line[0];
					artist=line[1];
					minutes=Integer.parseInt(line[2]);
					seconds=Integer.parseInt(line[3]);
					Song newSong=new Song(artist, title, minutes, seconds);
					this.addSong(newSong);
				}
				return true;
		}catch(FileNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}

	public void space(String s){
		if(s == ""){
			return;
		}
		else
			s.trim(); //delete leading and trailing spaces
	}

	// removes all playable elements in the play list
	public boolean clear(){
		if(!playableList.isEmpty()){
			playableList.clear();
			return true;
		}
		return false;
	}
	// adds Song s to the end of the play list
	public boolean addSong(Song s){
		playableList.add(s);
		return true;
	}
	// removes Playable element at index from the list and returns it
	public Playable removePlayable(int index){
		Playable removedP = null;
		for(int i=0; i<playableList.size();i++){
			if(i == index){
				removedP = playableList.get(i);
				playableList.remove(i);
			}		
		}
		return removedP;
	}
	// removes every occurrence of Playable p from the list and returns p
	public Playable removePlayable(Playable p){
		Playable removedP = null;
		for (int k=0;k<playableList.size();k++){
			if(playableList.get(k).equals(p)){
				removedP = playableList.get(k);
				playableList.remove(k);
			}
		}
		return removedP;
	}
	// returns the Playable element at the appropriate index
	public Playable getPlayable(int index){

		/*if(index>=0 && index<playableList.size()){
			for(int i = 0; i<playableList.size();i++){
				if(i == index){
					return playableList.get(index);
				}
			}
		}
		return null;
		*/
		int i = 0;
		if(index>=0 && index<playableList.size()){
			for(i = 0; i<playableList.size();i++){
				playableList.get(i);
			}
		}
		return playableList.get(i);
	}
	//adds the PlayList that is being passed to the end of the playableList and returns true 
	
	public boolean addPlayList(PlayList pl){
		if(!playableList.contains(pl)){
			this.addPlayList(pl);
			return true;
		}
		return false;
	}
	
	public boolean add(PlayList pl) {
		return true;
	}
	
	//plays the play list by calling play() on each item in the play list in order
	public void play(){
		/*
		for(Playable p: playableList){
			p.play();
		}
		*/
		for(int i=0;i<playableList.size();i++){
			playableList.get(i).play();
		}
	}
	//returns the number of songs in the play list and all songs contained in any of the nested play lists
	public int size(){
		int total = playableList.size();
		for(Playable p: playableList){
			if(p instanceof PlayList){
				PlayList p1 = (PlayList)p;
				total = total + p1.size();
			}
		}
		return total;
	}
	//sort the Playable items by the value returned by getName() in ascending order.
	public void sortByName(){
		//Collections.sort(playableList, new CmpByTime());
		Comparator<Playable> comparator = new Comparator<Playable>() {
			@Override
			public int compare(Playable arg0, Playable arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		};
		Collections.sort(playableList, comparator);
	}
	//sorts by the Song or PlayList's total time in seconds, in ascending order (shortest first)
	public void sortByTime(){ 
		Comparator<Playable> comparator = new Comparator<Playable>() {
			@Override
			public int compare(Playable arg0, Playable arg1) {
				return arg1.getPlayTimeSeconds()-arg0.getPlayTimeSeconds();
			}
		};
		Collections.sort(playableList, comparator);
	}
	/*
	public int compare(Playable p1,Playable p2){
		return p1.getName().compareTo(p2.getName());
	}
	public int getPlayTimeSeconds(){
		int result = 0;
		for(Playable p: playableList){
			result = result + p.getPlayTimeSeconds();
		}
		return result;
	}
	 */
	@Override
	public int getPlayTimeSeconds() {
		// TODO Auto-generated method stub
		return 0;
	}

}
