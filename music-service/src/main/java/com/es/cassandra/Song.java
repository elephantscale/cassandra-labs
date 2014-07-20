package com.es.cassandra;

public class Song {
  private String name;
  private String id;

  // other attributes like duration ... go here

  @Override
  public String toString() {
    return "{class: Song, id: " + id + ",  name: " + name + "}";
  }

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
