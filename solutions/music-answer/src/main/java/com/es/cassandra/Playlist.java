package com.es.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Session;

public class Playlist {
    private String id;
    private String name;
    private List<String> songs = new ArrayList<String>();
    private String userId;

    @Override
    public String toString() {
	String s = "{class: Playlist, id: " + id + ",  name: " + name
		+ ", userId: " + userId + ", songs:[";
	for (String songId : songs) {
	    s += ", " + songId;
	}
	s += "]}";
	return s;
    }

    public void addSong(Song s) {
	songs.add(s.getId());
    }

    public void save(Session session) {
	String songIds = "";
	for (String s : songs) {
	    if (songIds.length() > 0)
		songIds += ",";
	    songIds += s;
	}
	String cql = ""
		.format("insert into playlists(id, name, userid , songs) values(%s, '%s', '%s', [%s])",
			getId(), getName(), getUserId(), songIds);
	System.out.println(cql);
	session.execute(cql);
	// System.out.println ("saved song: " + getId());
    }

    // ---- getters and setters below ----

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

    public List<String> getSongs() {
	return songs;
    }

    public void setSongs(List<String> songs) {
	this.songs = songs;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

}
