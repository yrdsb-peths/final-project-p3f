import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialWorld1 extends World
{
    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public TutorialWorld1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400 , 1); 
        addObject(MyWorld.player, 300, 200);
    }
    public void act(){
        checkCrossWorld();
    }
    public void checkCrossWorld(){
        if(MyWorld.player.getY() < 32 && (MyWorld.player.getX() > 225 && MyWorld.player.getX() < 375)){
            Greenfoot.setWorld(new TutorialWorld2());
        }
    }
}
