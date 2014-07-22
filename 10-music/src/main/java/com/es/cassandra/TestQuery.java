package com.es.cassandra;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class TestQuery {

    public static void main(String[] args) {

	Cluster cluster = Cluster.builder().addContactPoint("localhost")
		.build();
	Session session = cluster.connect("music"); // music keyspace

	try {
	    // --- user
	    String userid = "user1";
	    ResultSet resultSet = session
		    .execute("select * from users where id = '" + userid + "'");
	    Row row = resultSet.one();
	    Set<UUID> playlistIds = row.getSet("playlists", UUID.class);
	    System.out
		    .println(userid + " has playlists : " + playlistIds);

	    // TODO : retrieve each playlist
	    for (UUID playlistId : playlistIds) {
		System.out.println("   querying  playlist : " + playlistId);

		// TODO : complete the play list query
		// TODO : For each playlist query songs
		// TODO : print out the name of each song

		System.out.println();
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.close();
	    cluster.close();
	}
    }

}
