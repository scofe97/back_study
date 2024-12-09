package headfirst.practice.adapter;

public record LegacyAudioPlayer() {
    public void start() {
        System.out.println("구식 플레이어 재생");
    }
}
