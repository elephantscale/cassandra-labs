package com.es.cassandra;

import com.datastax.driver.core.Session;

public class Song {
    private String name;
    private String id;

    // other attributes like duration ... go here

    @Override
    public String toString() {
	return "{class: Song, id: " + id + ",  name: " + name + "}";
    }

    public void save(Session session) {
	String cql = String.format(
		"insert into songs(id, name) values('%s', '%s'", getId(),
		getName());
	System.out.println(cql);
	session.execute(cql);
	// System.out.println ("saved song: " + getId());
    }

    // --- getters & seters ---

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

}
