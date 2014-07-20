package com.es.cassandra;

import java.util.List;

public class Playlist {
  private String id;
  private String name;
  private List<Song> songs;
  private String userId;

  @Override
  public String toString() {
    return "{class: Playlist, id: " + id + ",  name: " + name + ", userId: "
        + userId + "}";
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

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

}
