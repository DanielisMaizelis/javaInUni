package Ex1;

import Ex1.Types.Playlist;

import java.util.ArrayList;

public class User
{
    private String username;
    private ArrayList<Playlist> playlists;
    private ArrayList<User> following;

    public User(String username)
    {
        this.username = username;
        this.playlists = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void addPlaylist(Playlist playlist)
    {
        playlists.add(playlist);
    }

    public void playPlaylists()
    {
        System.out.println();
        System.out.printf("%s Playlists:", username);
        for(Playlist playlist: playlists)
        {
            playlist.play();
        }
    }

    public String getUsername()
    {
        return username;
    }

    public void follow(User user)
    {
        System.out.println();
        System.out.printf("Ex1.User: %s, followed %s",username, user.getUsername());
        following.add(user);
    }
}
