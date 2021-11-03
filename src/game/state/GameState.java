package game.state;

import controller.NPCController;
import controller.PlayerController;
import core.Position;
import core.Size;
import entity.NPC;
import entity.Player;
import game.Game;
import input.Input;
import map.GameMap;

import java.util.List;

public class GameState extends State {

    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        gameMap = new GameMap(new Size(20, 20), spriteLibrary);
        initializeCharacters();
        initializeNPCs(50);
    }

    private void initializeCharacters() {
        Player player = new Player(new PlayerController(input), spriteLibrary);
        NPC npc = new NPC(new NPCController(), spriteLibrary);
        npc.setPosition(new Position(3 * Game.SPRITE_SIZE, 2 * Game.SPRITE_SIZE));
        gameObjects.addAll(List.of(player, npc));
        camera.focusOn(player);
    }
    private void initializeNPCs(int numberOfNPCs) {
        for(int i = 0; i < numberOfNPCs; i++) {
            NPC npc = new NPC(new NPCController(), spriteLibrary);
            npc.setPosition(gameMap.getRandomPosition());
            gameObjects.add(npc);
        }
    }
}
