package entity;

import core.Position;
import core.Size;
import game.state.State;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject() {
        position = new Position(50, 50);
        size = new Size(50, 50);
    }

    public abstract void update(State state);
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return size;
    }
}