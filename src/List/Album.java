package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        ArrayList<Song> songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
      if (findSong(title)!=null){
          return false;
      };
      songs.add(new Song(title,duration));
      return true;
    }

    private Song findSong(String title) {
        for (Song s :
                songs) {
            if (s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
            if (trackNumber >= 0 || trackNumber > playlist.size()){
                return false;
            }
            Song songAdd = songs.get(trackNumber -1);
            String songTitle = songAdd.getTitle();
        ListIterator<Song> playListIterator = playlist.listIterator();
        while (playListIterator.hasNext()) {
            if (playListIterator.next().getTitle().compareTo(songTitle)==0){
                return false;
            }
        }
        playlist.add(songAdd);
        return true;    
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {

        Song songAdd = findSong(title);
        if (songAdd == null){
            return false;
        }

          var iterator = playlist.listIterator();
          while (iterator.hasNext()){
              if (iterator.next().getTitle().compareTo(songAdd.getTitle())==0){
                  return false;
              }

          }

        playlist.add(songAdd);
          return true;
    }
}
