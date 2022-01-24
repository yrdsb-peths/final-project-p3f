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
    public static boolean isHallwayWorld;
    
    public boolean spawned;
    // A simple timer
    public static SimpleTimer timer = new SimpleTimer();
    
    // Worlds
    GreenfootImage tutorialWorld1 = new GreenfootImage("Worlds/TutorialWorld1.png");
    GreenfootImage tutorialWorld2 = new GreenfootImage("Worlds/TutorialWorld2.png");
    GreenfootImage foyerWorld = new GreenfootImage("Worlds/Foyer.png");
    GreenfootImage roomWorld = new GreenfootImage("Worlds/Room.png");
    GreenfootImage hallwayWorld = new GreenfootImage("Worlds/Hallway.png");
    
    // Create character
    public static MainCharacter player = new MainCharacter();
    
    // Create labels
    Label movement = new Label("Use W, A, S, D \n to move", 30);
    Label interact = new Label("Use E to \ninteract with\n objects", 35);
    Label foyerDialogue1 = new Label("What the hell is that!?!?!", 30);
    
    Paper tutorialNote = new Paper();
    
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
        isHallwayWorld = false;
        setBackground(tutorialWorld1);
        addObject(player, 300, 200);
    }
    
    public void act(){
        changeWorlds();
        if(isTutorialWorld1 || isTutorialWorld2){
            checkCrossWorlds();
        }
    }
    
    public void changeWorlds(){
        if(isTutorialWorld1){
            addObject(movement, 115, 110);
            removeObject(tutorialNote);
            removeObject(interact);
        }
        else if(isTutorialWorld2){
            addObject(tutorialNote, 300, 300);
            addObject(interact, 90, 300);
            removeObject(movement);
            if(player.getY() < 165 && Greenfoot.isKeyDown("e")){
                isTutorialWorld2 = false;
                isFoyerWorld = true;
                MainCharacter.cutscene = true;
                player.setLocation(300, 320);
            }             
        }
        if(isFoyerWorld){
            setBackground(foyerWorld);
            removeObject(interact);
            removeObject(tutorialNote);
            addObject(demon, 300, 130);
            addObject(foyerDialogue1, 300, 370);
            isFoyerWorld = false;
            timer.mark();
        }
        if(isRoomWorld){
            if(!spawned){
                removeObject(player);
                addObject(player, 250, 210);
                spawned = true;
            }
            setBackground(roomWorld);
            removeObject(foyerDialogue1);
            if(player.getY() > 240){
                spawned = false;
                isHallwayWorld = true;
                isRoomWorld = false;
            }
        }
        if(isHallwayWorld){
            setBackground(hallwayWorld);
            if(!spawned){
                removeObject(player);
                addObject(player, 50, 200);
                spawned = true;
            }
        }
    }
    
    public void checkCrossWorlds(){
        if(player.getY() < 30 && (player.getX() > 225 && player.getX() < 375 && Greenfoot.isKeyDown("w"))){
            setBackground(tutorialWorld2);
            player.setLocation(300, 390);
            isTutorialWorld1 = false;
            isTutorialWorld2 = true;
        }
        else if(player.getY() > 370 && (player.getX() > 225 && player.getX() < 375 && Greenfoot.isKeyDown("s"))){
            setBackground(tutorialWorld1);
            player.setLocation(300, 25);
            isTutorialWorld1 = true;
            isTutorialWorld2 = false;
        }
    }
}
