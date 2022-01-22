import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static boolean isTutorialWorld1 = true;
    public static boolean isTutorialWorld2 = false;
    
    GreenfootImage tutorialWorld1 = new GreenfootImage("Worlds/TutorialWorld1.png");
    GreenfootImage tutorialWorld2 = new GreenfootImage("Worlds/TutorialWorld2.png");
    
    // Create labels for instructions
    Label movement = new Label("Use W, A, S, D \n to move", 30);
    Label interact = new Label("Use E \nto interact", 35);
    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(tutorialWorld1);
        addObject(MainCharacter.player, 300, 200);
    }
    
    public void act(){
        checkCrossWorlds();
        if(isTutorialWorld1 == true){
            removeObject(interact);
            addObject(movement, 115, 110);
        }
        if(isTutorialWorld2 == true){
            removeObject(movement);
            addObject(interact, 95, 300);
        }
    }
    
    public void checkCrossWorlds(){
        if(MainCharacter.player.getY() < 30 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("w"))){
            setBackground(tutorialWorld2);
            MainCharacter.player.setLocation(300, 390);
            isTutorialWorld1 = false;
            isTutorialWorld2 = true;
        }
        else if(MainCharacter.player.getY() > 370 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("s"))){
            setBackground(tutorialWorld1);
            MainCharacter.player.setLocation(300, 25);
            isTutorialWorld1 = true;
            isTutorialWorld2 = false;
        }
    }
}
