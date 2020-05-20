package test.furloughPractice.designpattern.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing Vlc file format");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("do nothing");
    }
}
