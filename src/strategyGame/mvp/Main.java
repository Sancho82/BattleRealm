package strategyGame.mvp;

import strategyGame.Music.Music;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

   public static void main(String... args) {
        EventQueue.invokeLater(() -> {
                Displayer displayer = new Displayer();
                displayer.setVisible(true);
        });

        Music music = new Music();
        music.playMusic(new File(
                "D:\\java\\Strategy_Game\\src\\strategyGame\\music\\Fantasy_Celtic_Music_Spirit_of_the_Wild.wav"));
   }
}