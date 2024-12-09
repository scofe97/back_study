package headfirst.practice.adapter;

public record LegacyAudioPlayerAdapter(
        LegacyAudioPlayer legacyAudioPlayer
) implements AudioPlayerInterface {

    @Override
    public void play() {
        legacyAudioPlayer.start();
    }
}
