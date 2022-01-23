import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static boolean isTutorialWorld1;
    public static boolean isTutorialWorld2;
    public static boolean isFoyerWorld;
    public static boolean isRoomWorld;
    
    // A simple timer
    public static SimpleTimer timer = new SimpleTimer();
    
    // Worlds
    GreenfootImage tutorialWorld1 = new GreenfootImage("Worlds/TutorialWorld1.png");
    GreenfootImage tutorialWorld2 = new GreenfootImage("Worlds/TutorialWorld2.png");
    GreenfootImage foyerWorld = new GreenfootImage("Worlds/Foyer.png");
    GreenfootImage roomWorld = new GreenfootImage("Worlds/Room.png");
    
    // Create labels
    Label movement = new Label("Use W, A, S, D \n to move", 30);
    Label interact = new Label("Use E to \ninteract with\n objects", 35);
    Label foyerDialogue1 = new Label("What the hell is that!?!?!", 30);
    
    Paper note = new Paper();
    
    Demon demon = new Demon();
    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        isTutorialWorld1 = true;
        isTutorialWorld2 = false;
        isFoyerWorld = false;
        isRoomWorld = false;
        setBackground(tutorialWorld1);
        addObject(MainCharacter.player, 300, 200);
    }
    
    public void act(){
        changeWorlds();
        checkCrossWorlds();
    }
    
    public void changeWorlds(){
        if(isTutorialWorld1){
            MainCharacter.cutscene = false;
            removeObject(interact);
            removeObject(note);
            addObject(movement, 115, 110);
        }
        else if(isTutorialWorld2){
            removeObject(movement);
            addObject(note, 300, 300);
            addObject(interact, 90, 300);
            if(MainCharacter.player.getY() < 165 && Greenfoot.isKeyDown("e")){
                isTutorialWorld2 = false;
                isFoyerWorld = true;
                MainCharacter.cutscene = true;
                MainCharacter.player.setLocation(300, 320);
            }             
        }
        if(isFoyerWorld){
            isFoyerWorld = false;
            setBackground(foyerWorld);
            removeObject(interact);
            removeObject(note);
            addObject(demon, 300, 130);
            addObject(foyerDialogue1, 300, 370);
            timer.mark();
        }
        if(isRoomWorld){
            removeObject(foyerDialogue1);
            setBackground(roomWorld);
        }
    }
    
    public void checkCrossWorlds(){
        if(MainCharacter.player.getY() < 30 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("w"))){
            isTutorialWorld1 = false;
            setBackground(tutorialWorld2);
            MainCharacter.player.setLocation(300, 390);
            isTutorialWorld2 = true;
        }
        else if(MainCharacter.player.getY() > 370 && (MainCharacter.player.getX() > 225 && MainCharacter.player.getX() < 375 && Greenfoot.isKeyDown("s"))){
            isTutorialWorld2 = false;
            setBackground(tutorialWorld1);
            MainCharacter.player.setLocation(300, 25);
            isTutorialWorld1 = true;
        }
    }
}
