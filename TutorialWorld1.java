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
        addObject(MainCharacter.player, 300, 25);
    }
    
    public void act(){
        checkCrossWorld1();
    }
    
    public void checkCrossWorld1(){
        if(MainCharacter.player.getY() < 30 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("w"))){
            Greenfoot.setWorld(new TutorialWorld2());
        }
    }
}
