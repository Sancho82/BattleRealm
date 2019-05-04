package strategyGame.mvp;

import strategyGame.music.Music;

import java.awt.*;
import java.io.File;

public class Main {

   public static void main(String... args) {
        EventQueue.invokeLater(() -> {
                Displayer displayer = new Displayer();
                displayer.setVisible(true);

        });

        Music music = new Music();
        File file = new File(
                "src\\" +
                "strategyGame\\" +
                "music\\" +
                "Fantasy_Celtic_Music_Spirit_of_the_Wild.wav");

        while (true) {
            music.playMusic(file);
        }
   }
}