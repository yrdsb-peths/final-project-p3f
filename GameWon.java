import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWon extends World
{

    /**
     * Constructor for objects of class GameWon.
     * 
     */
    public GameWon()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 400, 1);
        removeObject(GameWorld.player);
        setBackground("Worlds/GameWon.png");
    }
}
