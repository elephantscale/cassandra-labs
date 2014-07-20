package com.es.cassandra;

import java.util.List;

public class User {
  String id;
  String name;
  List<Playlist> playlists;

  public String toString() {
    return "{class: User, id: " + id + ",  name: " + name + "}";
  }

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

  public List<Playlist> getPlaylists() {
    return playlists;
  }

  public void setPlaylists(List<Playlist> playlists) {
    this.playlists = playlists;
  }

}
