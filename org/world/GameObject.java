package org.world;

public class GameObject {

    // Position of the object
    public float x = 0;
    public float y=0;

    //The size of the object
    public float width = 1;
    public float height = 1;

    // Rotation
    public float rotation = 0;

    public void update() {
        // Implement in subclass
    }

    public void render() {
        // Implrement in subclass
    }

}
