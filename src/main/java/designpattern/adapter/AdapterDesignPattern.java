package main.java.designpattern.adapter;

//Adapter Design pattern works as a bridge between two incompatible interfaces.
/*
A real life example could be a case of card reader which acts as an adapter between memory card and a laptop.
You plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.
 */
public class AdapterDesignPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

//        MediaPlayer mediaPlayer = new MediaAdapter("mp4");
//        mediaPlayer.play("mp4","kulwant");

    }
}
