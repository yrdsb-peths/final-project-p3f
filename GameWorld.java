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
    public static boolean wakeUpInRoom;
    
    public static boolean roomBoundaries;

    public boolean spawned;

    boolean lockedRoom1, lockedRoom2, lockedRoom3, lockedRoom4 = true, lockedRoom5, lockedRoom6 = true;
    
    boolean room1TrashSearched, room2TrashSearched, room2DrawerSearched, room3TrashSearched, leftHallwayTrashSearched, rightHallwayTrashSearched;
    
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
    
    // Create instruction labels
    Label movement = new Label("Use W, A, S, D \n to move", 30);
    Label interact = new Label("Use E to \ninteract with\n objects", 35);
    
    Label foyerDialogue = new Label("What the hell is that!?!?!", 30);
    Label wokeUpDialogue = new Label("Where am I?", 30);
    Label room1TrashText = new Label("You found the body & head \n(piece one of five)", 30);
    Label room2TrashText = new Label("You found a teddy bear arm \n(piece two of five)", 30);
    Label room2DrawerText = new Label("You found a needle and thread.\n Sew the teddy bear and then\n place it in the basket", 30);
    Label room3TrashText = new Label("You found a teddy bear arm \n(piece three of five)", 30);
    Label leftHallwayTrashText = new Label("You found a limb \n(piece four of five)", 30);
    Label rightHallwayTrashText = new Label("You found a limb \n(piece five of five)", 30);
    
    Label lockedDoor4 = new Label("Door number 4 is locked", 30);
    Label lockedDoor6 = new Label("Door number 6 is locked", 30);
    
    // Create objects of actors
    Paper tutorialPaper = new Paper();
    Paper room1Letter = new Paper();
    Demon demon = new Demon();
    EmptyBasket emptyBasket = new EmptyBasket();
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
        
        removeRoomItemLabels();
        
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d")){
            removeObject(lockedDoor4);
            removeObject(lockedDoor6);
        }
    }
    
    public void removeRoomItemLabels(){
        if(timer.millisElapsed() > 2500){
            if(room1TrashSearched){
                removeObject(room1TrashText);
            }
            if(room2TrashSearched){
                removeObject(room2TrashText);
            }
            if(room3TrashSearched){
                removeObject(room3TrashText);
            }
            if(leftHallwayTrashSearched){
                removeObject(leftHallwayTrashText);
            }
            if(rightHallwayTrashSearched){
                removeObject(rightHallwayTrashText);
            }
        }
        if(timer.millisElapsed() > 3500){
            if(room2DrawerSearched){
                removeObject(room2DrawerText);
            }
        }
    }
    
    public void leaveRooms(){
        spawned = false;
        roomBoundaries = false;
        wakeUpInRoom = false;
        isRoom1 = false;
        isRoom2 = false;
        isRoom3 = false;
        isRoom4 = false;
        isRoom5 = false;
        isRoom6 = false;
        isHallway = true;
    }
    
    public void changeWorlds(){
        if(isTutorial1){
            addObject(movement, 115, 110);
            removeObject(tutorialPaper);
            removeObject(interact);
        }
        
        if(isTutorial2){
            addObject(tutorialPaper, 300, 300);
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
            removeObject(tutorialPaper);
            removeObject(interact);
            player.setLocation(300, 320);
            addObject(demon, 300, 185);
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
            if(player.getY() > 250){
                leaveRooms();
                removeObject(wokeUpDialogue);
                respawn(145, 185);
            }
        }
        
        if(isRoom1){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            addObject(emptyBasket, 290, 205);
            addObject(room1Letter, 330, 185);
            removeObject(rightHallwayTrashText);
            removeObject(leftHallwayTrashText);
            if(!room1TrashSearched){
                if(player.getX() > 360 && player.getY() < 205 && Greenfoot.isKeyDown("e")){
                    addObject(room1TrashText, 300, 320);
                    timer.mark();
                    room1TrashSearched = true;
                }
            }
            if(player.getY() > 250){
                removeObject(room1TrashText);
                removeObject(emptyBasket);
                removeObject(room1Letter);
                leaveRooms();
                respawn(45, 185);
            }
        }
        
        if(isRoom2){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            removeObject(rightHallwayTrashText);
            removeObject(leftHallwayTrashText);
            if(Greenfoot.isKeyDown("e")){
                if(!room2TrashSearched){
                    if(player.getX() > 360 && player.getY() < 205){
                        removeObject(room2DrawerText);
                        addObject(room2TrashText, 300, 320);
                        room2TrashSearched = true;
                    }
                }
                if(!room2DrawerSearched){
                    if(player.getX() < 265 && player.getY() < 210){
                        removeObject(room2TrashText);
                        addObject(room2DrawerText, 300, 320);
                        room2DrawerSearched = true;
                    }
                }
                timer.mark();
            }
            if(player.getY() > 250){
                removeObject(room2TrashText);
                removeObject(room2DrawerText);
                leaveRooms();
                respawn(145, 185);
            }
        }
        
        if(isRoom3){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            removeObject(rightHallwayTrashText);
            removeObject(leftHallwayTrashText);
            if(!room3TrashSearched){
                if(player.getX() > 360 && player.getY() < 205 && Greenfoot.isKeyDown("e")){
                    addObject(room3TrashText, 300, 320);
                    timer.mark();
                    room3TrashSearched = true;
                }
            }
            if(player.getY() > 250){
                removeObject(room3TrashText);
                leaveRooms();
                respawn(245, 185);
            }
        }
        
        if(isRoom4){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 250){
                leaveRooms();
                respawn(335, 185);
            }
        }
        
        if(isRoom5){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            removeObject(rightHallwayTrashText);
            removeObject(leftHallwayTrashText);
            if(player.getY() > 250){
                leaveRooms();
                respawn(435, 185);
            }
        }
        
        if(isRoom6){
            isHallway = false;
            setBackground(roomWorld);
            roomBoundaries = true;
            if(player.getY() > 250){
                leaveRooms();
                respawn(530, 185);
            }
        }
        
        if(isHallway){
            setBackground(hallwayWorld);
            if(Greenfoot.isKeyDown("e")){
                if(!leftHallwayTrashSearched){
                    if(player.getX() < 25 && player.getY() < 195){
                        addObject(leftHallwayTrashText, 300, 320);
                        leftHallwayTrashSearched = true;
                    }
                }
                if(!rightHallwayTrashSearched){
                    if(player.getX() > 550 && player.getY() < 195){
                        addObject(rightHallwayTrashText, 300, 320);
                        rightHallwayTrashSearched = true;
                    }
                }
                timer.mark();
            }
            hallwayRooms();
        }
        
    }
    
    public void hallwayRooms(){ 
        if(player.getX() > 30 & player.getX() < 60 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom1){
                player.setLocation(340, 240);
                isRoom1 = true;
            }
        }
        if(player.getX() > 130 & player.getX() < 160 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom2){
                isRoom2 = true;
                player.setLocation(340, 240);
            }
        }
        if(player.getX() > 230 & player.getX() < 260 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom3){
                isRoom3 = true;
                player.setLocation(340, 240);
            }
        }
        if(player.getX() > 320 & player.getX() < 350 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom4){
                isRoom4 = true;
                player.setLocation(340, 240);
            }
            else{
                addObject(lockedDoor4, 300, 330);
                if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d")){
                    removeObject(lockedDoor4);
                }
            }
        }
        if(player.getX() > 420 & player.getX() < 450 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom5){
                isRoom5 = true;
                player.setLocation(340, 240);
            }
        }
        if(player.getX() > 510 & player.getX() < 550 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom6){
                isRoom6 = true;
                player.setLocation(340, 240);
            }
            else{
                addObject(lockedDoor6, 300, 330);
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
