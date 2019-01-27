package strategyGame.mvp;

import strategyGame.music.Music;

import java.awt.*;
import java.io.File;

public class Main {

   public static void main(String... args) {
        EventQueue.invokeLater(() -> {
                Displayer displayer = new Displayer();
                displayer.setVisible(true);

            System.out.println(displayer.getButtons()[9][9].getX() + 75);
        });

        Music music = new Music();
        music.playMusic(new File(
                "D:\\java\\Battle_Realm\\src\\strategyGame\\music\\Fantasy_Celtic_Music_Spirit_of_the_Wild.wav"));
   }
}