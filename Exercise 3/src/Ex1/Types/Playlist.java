package Ex1.Types;

import java.util.ArrayList;

public class Playlist implements Playable
{
    private ArrayList<Playable> items;
    private String name;

    public Playlist(String name)
    {
        this.name = name;
        this.items = new ArrayList<>();
    }
    public void add(Playable item)
    {
        items.add(item);
    }

    @Override
    public void play()
    {
        System.out.println();
        System.out.println("Playlist: "+name);
        for(Playable item: items)
        {
            item.play();
        }
    }
}
