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
        addObject(MainCharacter.player, 300, 390);
    }
    
    public void act(){
        checkCrossWorld2();
    }
    
    public void checkCrossWorld2(){
        if(MainCharacter.player.getY() > 370 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("s"))){
            Greenfoot.setWorld(new TutorialWorld1());
        }
    }
}
