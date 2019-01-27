package strategyGame.music;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public void playMusic(File music) {

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(music));
            clip.start();
            Thread.sleep(1000000);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
