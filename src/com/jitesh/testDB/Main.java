package com.jitesh.testDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource datasource= new DataSource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }
        List<Artist> artists = datasource.queryArtists(3);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }
        for (Artist artist: artists){
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());

        }
        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Aerosmith", DataSource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }
        System.out.println("+++++++++++++++++++++++++++++");
        List<SongArtist> songArtists= datasource.queryArtistForSongs("Go Your Own Way",1);
        for (SongArtist songArtist: songArtists){
            System.out.println("Artists = "+songArtist.getArtistName()+" Album = "+songArtist.getAlbumName()+" Track = "+songArtist.getTrack());
        }
//datasource.queryMetaData();
//datasource.createViewForSongArtists();
//        int count= datasource.getCount(DataSource.TABLE_SONGS);
//        System.out.println("Number of songs is "+count);
//        Scanner scanner= new Scanner(System.in);
//        System.out.print("Enter the song name: ");
//        String title= scanner.nextLine();
//
//
//List<SongArtist> songArtists1=datasource.querySongInfoView(title);
//if (songArtists1.isEmpty()){
//    System.out.println("cannot find songs");
//}
//for (var songArtist: songArtists1){
//    System.out.println(songArtist.getArtistName()+" "+ songArtist.getAlbumName()+" "+songArtist.getTrack());
//}
        System.out.println("********************");
        datasource.insertSong("Raju priya Dog", "Kanye West", "CHiky sbb2", 10);

        datasource.close();

    }

}
