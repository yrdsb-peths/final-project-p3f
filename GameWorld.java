import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static boolean isTutorial1, isTutorial2; 
    public static boolean isFoyer, isHallway;

    public static boolean isRoom1, isRoom2, isRoom3, isRoom4, isRoom5, isRoom6; 
    public static boolean roomBoundaries;
    public static boolean wakeUpInRoom;

    public boolean spawned;

    boolean lockedRoom1 = false, lockedRoom2 = false, lockedRoom3 = false, lockedRoom4 = true, lockedRoom5 = false, lockedRoom6 = true;
    
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
    Label foyerDialogue = new Label("What the hell is that!?!?!", 30);
    Label wokeUpDialogue = new Label("Where am I?", 30);
    
    Paper tutorialNote = new Paper();
    
    Demon demon = new Demon();
    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 400, 1); 
        setBackground(tutorialWorld1);
        addObject(player, 300, 200);
        isTutorial1 = true;
        isTutorial2 = false;
        isFoyer = false;
        wakeUpInRoom = false;
        isRoom1 = false;
        isRoom2 = false;
        isRoom3 = false;
        isRoom4 = false;
        isRoom5 = false;
        isRoom6 = false;
        isHallway = false;
    }
    
    public void act(){
        changeWorlds();
        if(isTutorial1 || isTutorial2){
            checkCrossTutorials();
        }
    }
    
    public void changeWorlds(){
        if(isTutorial1){
            addObject(movement, 115, 110);
            removeObject(tutorialNote);
            removeObject(interact);
        }
        
        if(isTutorial2){
            addObject(tutorialNote, 300, 300);
            addObject(interact, 90, 300);
            removeObject(movement);
            if(player.getY() < 165 && Greenfoot.isKeyDown("e")){
                isTutorial2 = false;
                isFoyer = true;
            }             
        }
        
        if(isFoyer){
            MainCharacter.cutscene = true;
            setBackground(foyerWorld);
            removeObject(interact);
            removeObject(tutorialNote);
            player.setLocation(300, 320);
            addObject(demon, 300, 130);
            addObject(foyerDialogue, 300, 370);
            isFoyer = false;
            timer.mark();
        }
        
        if(wakeUpInRoom){
            removeObject(foyerDialogue);
            respawn(250, 210);
            setBackground(roomWorld);
            roomBoundaries = true;
            addObject(wokeUpDialogue, 300, 310); 
            if(player.getY() > 240){
                spawned = false;
                wakeUpInRoom = false;
                roomBoundaries = false;
                respawn(145, 185);
                removeObject(wokeUpDialogue);
                isHallway = true;
            }
        }

        if(isRoom1){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 240){
                spawned = false;
                isRoom1 = false;
                roomBoundaries = false;
                respawn(45, 185);
                isHallway = true;
            }
        }
        
        if(isRoom2){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 240){
                spawned = false;
                isRoom2 = false;
                roomBoundaries = false;
                respawn(145, 185);
                isHallway = true;
            }
        }
        
        if(isRoom3){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 240){
                spawned = false;
                isRoom3 = false;
                roomBoundaries = false;
                respawn(245, 185);
                isHallway = true;
            }
        }
        
        if(isRoom4){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 240){
                spawned = false;
                isRoom4 = false;
                roomBoundaries = false;
                respawn(335, 185);
                isHallway = true;
            }
        }
        
        if(isRoom5){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 240){
                spawned = false;
                isRoom5 = false;
                roomBoundaries = false;
                respawn(435, 185);
                isHallway = true;
            }
        }
        
        if(isRoom6){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 240){
                spawned = false;
                isRoom6 = false;
                roomBoundaries = false;
                respawn(530, 185);
                isHallway = true;
            }
        }
        
        if(isHallway){
            setBackground(hallwayWorld);
            hallwayRooms();
        }
        
    }
   
    public void hallwayRooms(){
        if(player.getX() > 30 & player.getX() < 60 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom1){
                isRoom1 = true;
                player.setLocation(340, 230);
            }
        }
        if(player.getX() > 130 & player.getX() < 160 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom2){
                isRoom2 = true;
                player.setLocation(340, 230);
            }
        }
        if(player.getX() > 230 & player.getX() < 260 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom3){
                isRoom3 = true;
                player.setLocation(340, 230);
            }
        }
        if(player.getX() > 320 & player.getX() < 350 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom4){
                isRoom4 = true;
                player.setLocation(340, 230);
            }
        }
        if(player.getX() > 420 & player.getX() < 450 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom5){
                isRoom5 = true;
                player.setLocation(340, 230);
            }
        }
        if(player.getX() > 510 & player.getX() < 550 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom6){
                isRoom6 = true;
                player.setLocation(340, 230);
            }
        }
    }
    
    public void respawn(int x, int y){
        if(!spawned){
            removeObject(player);
            addObject(player, x, y);
            spawned = true;
        }
    }

    public void checkCrossTutorials(){
        if(player.getY() < 30 && player.getX() > 225 && player.getX() < 375 && Greenfoot.isKeyDown("w")){
            setBackground(tutorialWorld2);
            player.setLocation(300, 390);
            isTutorial1 = false;
            isTutorial2 = true;
        }
        else if(player.getY() > 370 && player.getX() > 225 && player.getX() < 375 && Greenfoot.isKeyDown("s")){
            setBackground(tutorialWorld1);
            player.setLocation(300, 25);
            isTutorial1 = true;
            isTutorial2 = false;
        }
    }
}
