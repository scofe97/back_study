package headfirst.practice.adapter;

public class MainAdapter {

    public static void main(String[] args) {
        LegacyAudioPlayer legacy = new LegacyAudioPlayer();
        LegacyAudioPlayerAdapter player = new LegacyAudioPlayerAdapter(legacy);

        player.play();
    }
}
