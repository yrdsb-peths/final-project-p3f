import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialWorld2 extends World
{

    /**
     * Constructor for objects of class TutorialWorld2.
     * 
     */
    public TutorialWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(MyWorld.player, 300, 390);
    }
}
