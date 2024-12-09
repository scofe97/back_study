package headfirst.practice.adapter;

public sealed interface AudioPlayerInterface permits LegacyAudioPlayerAdapter{

    void play();
}
