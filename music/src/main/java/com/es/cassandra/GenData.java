package com.es.cassandra;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenData {

  public static void main(String[] args) {

    List<User> users = genUsers(10);
    System.out.println(users);

    List<Song> songs = genSongs(100);
    System.out.println(songs);

    List<Playlist> playlists = genPlaylists(10);
    System.out.println (playlists);
  }

  public static List<User> genUsers(int num) {
    List<User> users = new ArrayList<User>(num);

    for (int i = 1; i <= num; i++) {
      User u = new User();
      u.setId("user" + i);
      u.setName("Joe " + i);
      users.add(u);
    }

    return users;
  }

  public static List<Song> genSongs(int num) {
    List<Song> songs = new ArrayList<Song>(num);

    for (int i = 1; i <= num; i++) {
      Song s = new Song();
      s.setId(UUID.randomUUID().toString());
      s.setName("song " + i);
      songs.add(s);
    }

    return songs;
  }

  public static List<Playlist> genPlaylists(int num) {
    List<Playlist> playlists = new ArrayList<Playlist>(num);

    for (int i = 1; i <= num; i++) {
      Playlist playlist = new Playlist();
      playlist.setId(UUID.randomUUID().toString());
      playlist.setName("play list " + i);

      playlists.add(playlist);
    }
    return playlists;
  }

}
