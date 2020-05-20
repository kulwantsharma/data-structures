package test.furloughPractice.designpattern.adapter;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("do nothing..");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file format");
    }
}
