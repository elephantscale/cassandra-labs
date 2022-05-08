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

	    for (UUID playlistId : playlistIds) {
		System.out.println("   querying  playlist : " + playlistId);
		ResultSet resultSet2 = session
			.execute("select * from playlists where id = "
				+ playlistId + "");
		Row row2 = resultSet2.one();
		System.out.println("   playlist name : " + row2.getString("name"));

		// get all the songs out
		List<UUID> songIds = row2.getList("songs", UUID.class);
		System.out.println("   playlist has songs : " + songIds);

		for (UUID songId : songIds) {
		    System.out.println ("      querying for song : " + songId);
		    ResultSet resultSet3 = session
				.execute("select * from songs where id = "
					+ songId + "");
		    Row row3 = resultSet3.one();
		    System.out.println ("      song name : " + row3.getString("name"));

		}

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
