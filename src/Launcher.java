import combat.encounter;
import game.Game;
import game.GameLoop;
import Character.character;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
/*
        SaveManager sl = new SaveManager();
        sl.SaveLoader();
        sl.saveNumbers[1].sc[1].setHealth(99);
        sl.SaveBuilder();
*/
        character ch1 = new character("Oliver", 1, true);
        character ch2 = new character("Harry", 2,true);
        character ch3 = new character("George", 3,true);
        character ch4 = new character("Noah", 1,true);
        character ch5 = new character("Jack", 2,true);
        character ch6 = new character("Jacob", 3,true);
        new Thread(new encounter(ch1, ch2, ch3, ch4, ch5, ch6)).start();
        new Thread(new GameLoop(new Game(800, 600))).start();
        }
}
