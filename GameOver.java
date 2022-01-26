import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Over world
 * 
 * @author Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj
 */
public class GameOver extends World
{
    /**
     * Constructor for objects of class gameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 400, 1);
        removeObject(GameWorld.player);
        setBackground("Worlds/GameOver.png");
    }
}
