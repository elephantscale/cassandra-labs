package com.es.cassandra;

import java.util.HashSet;
import java.util.Set;

import com.datastax.driver.core.Session;

public class User {
    String id;
    String name;
    Set<String> playlists = new HashSet<String>();

    @Override
    public String toString() {
	return "{class: User, id: " + id + ",  name: " + name + "}";
    }

    // TODO : complete the save function
    public void save(Session session) {
	String playlistIds = "";
	for (String s : playlists) {
	    if (playlistIds.length() > 0)
		playlistIds += ",";
	    playlistIds += s;
	}

    // TODO : construct the cql, playlists will be a set
	String cql = "";
	System.out.println(cql);
	session.execute(cql);
    }

    public void addPlaylist(Playlist playlist1) {
	playlists.add(playlist1.getId());
    }

    // --- getters & setters ---

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Set<String> getPlaylists() {
	return playlists;
    }

    public void setPlaylists(Set<String> playlists) {
	this.playlists = playlists;
    }

}
