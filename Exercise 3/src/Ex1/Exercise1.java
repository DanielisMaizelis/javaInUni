package Ex1;

import Ex1.Enums.Genre;
import Ex1.Enums.PodcastType;
import Ex1.Types.Playlist;
import Ex1.Types.Podcast;
import Ex1.Types.Song;

public class Exercise1
{
    public void start()
    {
        User     user1     = new User("Danielis");
        User     user2     = new User("Luna");
        Song     song1     = new Song("Chronic Sunshine", Genre.INDIE);
        Song     song2     = new Song("Song 2", Genre.ROCK);
        Podcast  podcast1  = new Podcast("Joe Rogan, Ep1", PodcastType.FUNNY);
        Playlist playlist1 = new Playlist("My Favourites");
        Playlist playlist2 = new Playlist("Pop Songs");

        playlist1.add(song1);
        playlist1.add(podcast1);
        playlist2.add(song2);

        user1.addPlaylist(playlist1);
        user1.addPlaylist(playlist2);
        user1.playPlaylists();

        user2.addPlaylist(playlist2);
        user2.playPlaylists();

        user1.follow(user2);
        user2.follow(user1);
    }
}