package game;

import core.Size;
import display.Display;
import game.state.GameState;
import game.state.State;
import input.Input;

public class Game {

    //region FIELDS

    public static int SPRITE_SIZE = 64;

    private Display display;
    private Input input;
    private State state;

    //endregion

    //region Game Constructor

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        state = new GameState(new Size(width, height), input);
    }

    //endregion

    //region Update & Render

    public void update() {
        state.update();
    }

    public void render() {
        display.render(state);
    }

    //endregion
}
