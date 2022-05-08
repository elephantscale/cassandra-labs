package com.es.cassandra;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class TestInsert {

    public static void main(String[] args) {

	Cluster cluster = Cluster.builder().addContactPoint("localhost")
		.build();
	Session session = cluster.connect("music"); // music keyspace

	try {
	    // --- user
	    String userid = "user1";

	    // --- songs
	    List<Song> songs = new ArrayList<Song>();
	    for (int i = 1; i <= 5; i++) {
		Song s = new Song();
		s.setId(UUID.randomUUID().toString());
		s.setName("song " + i);
		songs.add(s);
		s.save(session);
	    }

	    // playlist
	    Playlist playlist1 = new Playlist();
	    playlist1.setId(UUID.randomUUID().toString());
	    playlist1.setName("playlist 1");
	    playlist1.setUserId(userid);
	    playlist1.addSong(songs.get(0));
	    playlist1.addSong(songs.get(1));
	    playlist1.addSong(songs.get(2));
	    System.out.println(playlist1);
	    playlist1.save(session);

	    Playlist playlist2 = new Playlist();
	    playlist2.setId(UUID.randomUUID().toString());
	    playlist2.setName("playlist 2");
	    playlist2.setUserId(userid);
	    playlist2.addSong(songs.get(3));
	    playlist2.addSong(songs.get(4));
	    System.out.println(playlist2);
	    playlist2.save(session);
	    
	    User u = new User();
	    u.setId(userid);
	    u.setName("Joe 1");
	    u.addPlaylist(playlist1);
	    u.addPlaylist(playlist2);
	    u.save(session);

	    

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.close();
	    cluster.close();
	}
    }

}
