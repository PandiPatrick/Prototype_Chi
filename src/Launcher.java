import game.Game;
import game.GameLoop;
import saves.SaveLoader;

public class Launcher {
    public static void main(String[] args) {
        SaveLoader sl = new SaveLoader();
        new Thread(new GameLoop(new Game(800, 600))).start();
        }
}
