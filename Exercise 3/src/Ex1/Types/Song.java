package Ex1.Types;
import Ex1.Enums.Genre;

public class Song implements Playable
{
    private Genre genre;
    private String songName;


    public Song(String songName, Genre genre)
    {
        this.songName = songName;
        this.genre    = genre;
    }

    @Override
    public void play()
    {
        System.out.printf("Playing: '%s', (Genre: %s)",songName, genre);
        System.out.println();
    }
}
