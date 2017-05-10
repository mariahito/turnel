import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Test;

public class HW4Test {

	@Test
	public void testGetName1() 
	{
		PlayList list=new PlayList("Favorite songs");
		assertEquals("Favorite songs", list.getName());
	}
	
	@Test
	public void testGetName2() 
	{
		PlayList list=new PlayList();
		list.setName("Romantic Collection");
		assertTrue(list.getName().equals("Romantic Collection"));
	}

	@Test
	public void testGetPlayableList1() 
	{
		PlayList list1=new PlayList();
		Song song1=new Song("Rihana", "Needed me");
		Song song2=new Song("Justin Bieber","Sorry");
		list1.addSong(song1);
		list1.addSong(song2);
		PlayList list2=new PlayList();
		Song song3=new Song("Rihana", "Needed me");
		Song song4=new Song("Justin Bieber","Sorry");
		list2.addSong(song3);
		list2.addSong(song4);
		assertEquals(list1.getPlayableList(), list2.getPlayableList());
	}
	@Test
	public void testGetPlayableList2() 
	{
		PlayList list1=new PlayList();
		Song song1=new Song("Pitbull", "Rain over me");
		Song song2=new Song("Akon","Lonly");
		list1.addSong(song1);
		list1.addSong(song2);
		PlayList list2=new PlayList();
		Song song3=new Song("Rihana", "Needed me");
		Song song4=new Song("Justin Bieber","Sorry");
		list2.addSong(song3);
		list2.addSong(song4);
		assertFalse("False", list1.getPlayableList().equals(list2.getPlayableList()));
	}
	
	@Test
	public void testSetName1() 
	{
		PlayList list=new PlayList();
		list.setName("Rap music");
		assertEquals("Rap music",list.getName());
	}
	@Test
	public void testSetName2() 
	{
		PlayList list1=new PlayList();
		list1.setName("Melodious");
		PlayList list2=new PlayList();
		list2.setName("Rap music");
		assertFalse("False", list1.getName().equals(list2.getName()));
	}
	
	@Test
	public void testSetPlayableList1() 
	{
		ArrayList<Playable> playableList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		list.setPlayableList(playableList);
		assertEquals(list.getPlayableList(), playableList);
	}
	@Test
	public void testSetPlayableList2() 
	{
		ArrayList<Playable> playableList1=new ArrayList<Playable>();
		ArrayList<Playable> playableList2=new ArrayList<Playable>();
		playableList1.add(new Song("Pitbull","Rain over me"));
		playableList2.add(new Song("Britney","Criminal"));
		PlayList list1=new PlayList();
		PlayList list2=new PlayList();
		list1.setPlayableList(playableList1);
		list2.setPlayableList(playableList2);
		assertFalse("False", list1.getPlayableList().equals(list2.getPlayableList()));
	}
	
	@Test
	public void testToString1() 
	{
		PlayList list=new PlayList();
		String string="name of playlist: "  + list.getName() + "music: " + list.getPlayableList();
		assertEquals(list.toString(), string);
	}
	@Test
	public void testToString2() 
	{
		PlayList list1=new PlayList("Play List 1");
		PlayList list2=new PlayList("Play List 2");
		assertFalse("False", list1.toString().equals(list2.toString()));
	}
	
	@Test
	public void testLoadSong1() 
	{
		PlayList list=new PlayList();
		assertEquals(true, list.loadSong("Songs.txt"));
	}
	@Test
	public void testLoadSong2() 
	{
		PlayList list=new PlayList();
		list.loadSong("Songs.txt");
		assertTrue("True", list.size()>0);
		
	}
	@Test
	public void testClear1() 
	{
		PlayList list=new PlayList();
		list.addSong(new Song("Avicii", "Wake me up"));
		assertEquals(true, list.clear());
	}
	@Test
	public void testClear2() 
	{
		PlayList list=new PlayList();
		assertFalse("False statement", list.clear());
	}
	@Test
	public void testAddSong1() 
	{
		PlayList list=new PlayList();
		list.addSong(new Song("Ellie Goulding", "Burn"));
		list.addSong(new Song("Iggy Azalea", "Fancy"));
		
		assertEquals(2, list.size());
	}
	@Test
	public void testAddSong2() 
	{
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		list.addSong(song1);
		list.addSong(song2);
		list.addSong(song3);
		assertFalse("False statement", list.size()<=0);
	}
	@Test
	public void testRemovePlayable1() 
	{
		ArrayList<Playable>playList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		playList.remove(0);
		assertEquals(playList.get(0), song2);
	}
	@Test
	public void testRemovePlayable2() 
	{
		ArrayList<Playable>playList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		assertFalse("False statement", playList.remove(0).equals(playList));
	}
	
	@Test
	public void testRemovePlayable3() 
	{
		ArrayList<Playable>playList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		playList.remove(song2);
		assertEquals(playList.get(1), song3);
	}
	@Test
	public void testRemovePlayable4() 
	{
		ArrayList<Playable>playList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		playList.remove(song1);
		assertFalse("False statement", playList.size()==3);
	}
	
	@Test
	public void testGetPlayable1() 
	{
		ArrayList<Playable>playList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		assertEquals(song3, playList.get(2));
	}
	@Test
	public void testGetPlayable2() 
	{
		ArrayList<Playable>playList=new ArrayList<Playable>();
		PlayList list=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		playList.remove(song1);
		assertFalse("False statement", playList.get(0).equals(playList.get(1)));
	}
	/*
	public void testAddPlayList1() 
	{
		PlayList list1=new PlayList();
		PlayList list2=new PlayList();
		Song song1=new Song("Kyla & Wizkid", "One Dance");
		Song song2=new Song("Iggy Azalea", "Fancy");
		Song song3=new Song("Britney", "toxic");
		list1.addSong(song1);
		list2.addSong(song2);
		list2.addSong(song3);
		assertEquals(true, list1.addPlayList(list2));
	}*/
	
}
