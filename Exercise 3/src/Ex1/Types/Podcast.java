package Ex1.Types;

import Ex1.Enums.PodcastType;

public class Podcast implements Playable
{
    private PodcastType podcastType;
    private String podcastName;

    public Podcast(String podcastName, PodcastType podcastType)
    {
        this.podcastName = podcastName;
        this.podcastType = podcastType;
    }

    @Override
    public void play()
    {
        System.out.printf("Playing: '%s', (Podcast Type: %s)",podcastName, podcastType);
        System.out.println();
    }
}
