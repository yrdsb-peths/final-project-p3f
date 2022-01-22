import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialWorld extends World
{
    public static boolean isTutorialWorld1 = true;
    public static boolean isTutorialWorld2 = false;
    
    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public TutorialWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400 , 1); 
        addObject(MainCharacter.player, 300, 200);
        setBackground("Worlds/TutorialWorld1.png");
    }
    
    public void act(){
        checkCrossWorlds();
    }
    
    public void checkCrossWorlds(){
        if(MainCharacter.player.getY() < 30 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("w"))){
            setBackground("Worlds/TutorialWorld2.png");
            MainCharacter.player.setLocation(300, 390);
            isTutorialWorld1 = false;
            isTutorialWorld2 = true;
        }
        else if(MainCharacter.player.getY() > 370 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("s"))){
            setBackground("Worlds/TutorialWorld1.png");
            MainCharacter.player.setLocation(300, 25);
            isTutorialWorld1 = true;
            isTutorialWorld2 = false;
        }
    }
}
