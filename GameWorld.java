import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world that the game is in
 * 
 * @author Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj
 */
public class GameWorld extends World
{
    // Booleans to check the background of world
    public static boolean isTutorial1, isTutorial2; 
    public static boolean isFoyer, isHallway;
    public static boolean isRoom1, isRoom2, isRoom3, isRoom5; 
    public static boolean wakeUpInRoom;
    
    // Check if boundaries for a room should be set
    public static boolean roomBoundaries;

    // To keep track of respawning the player
    public boolean spawned;

    // Check if rooms are locked 
    public static boolean lockedRoom1, lockedRoom2, lockedRoom3, lockedRoom4 = true, lockedRoom5, lockedRoom6 = true;
    
    // Check if items have been searched
    public static boolean room1Trash, room1Basket, room2Trash, room2NeedleAndThread, room3Trash, room3Basket, room1Book, room5Book; 
    public static boolean leftHallwayTrash, rightHallwayTrash, hallwayFirstHalfKey, hallwaySecondHalfKey;
    
    // Room 1 task pieces to be found
    public static boolean pieceOne, pieceTwo, pieceThree, pieceFour, pieceFive, needleAndThread;
    
    // A simple timer
    public static SimpleTimer timer = new SimpleTimer();
    
    // Backgrounds for world
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
    Label room1TrashText = new Label("You found the body & head \n(piece one of five)", 30);
    Label room2TrashText = new Label("You found a teddy bear arm \n(piece two of five)", 30);
    Label room2DrawerText = new Label("You found a needle and thread \nto sew the bear", 30);
    Label room3TrashText = new Label("You found a teddy bear arm \n(piece three of five)", 30);
    Label leftHallwayTrashText = new Label("You found a limb \n(piece four of five)", 30);
    Label rightHallwayTrashText = new Label("You found a limb \n(piece five of five)", 30);
    Label room1BookText = new Label("You found a book called '25 December Wishes'", 30);
    Label room5BookText = new Label("You found a book called 'REDRUM'", 30);
    Label lockedDoor4 = new Label("Door number 4 is locked", 30);
    Label lockedDoor6 = new Label("Door number 6 is locked", 30);
    
    // Sound Effect
    GreenfootSound rain = new GreenfootSound("Sound Effect - 'Rain & Thunder'.wav");
    
    // Create objects of actors
    Paper note = new Paper();
    Demon demon = new Demon();
    Basket emptyBasket = new Basket();
    EvilBear bear = new EvilBear();
    Keys firstHalfExitKey = new Keys();
    Keys secondHalfExitKey = new Keys();
    
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
        reset();
    }
    
    public void act(){
        rainSound();
        changeWorlds();
        checkCrossTutorials();
        removeRoomLabels();
        
        // If doors are locked, remove "it's locked" texts when player moves.
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d")){
            removeObject(lockedDoor4);
            removeObject(lockedDoor6);
        }
    }
    
    // Method to play rain sound
    public void rainSound(){
        if(isTutorial1 || isTutorial2 || isFoyer){
            rain.setVolume(0);
            rain.play();
        }else{
            rain.setVolume(25);
            rain.play();
        }
    }
    
    // Method to restore the values of variables
    public void reset(){
        MainCharacter.cutscene = false;
        isTutorial1 = true;
        isTutorial2 = false;
        isFoyer = false;
        isHallway = false;
        wakeUpInRoom = false;
        boolean isRoom1 = false, isRoom2 = false, isRoom3 = false, isRoom5 = false;
        boolean room1Trash = false, room1Basket = false, room3Basket = false, room2Trash = false, room2Drawer = false, room3Trash = false, room1Book = false, room5Book = false; 
        boolean leftHallwayTrash = false, rightHallwayTrash = false;
        boolean pieceOne = false, pieceTwo = false, pieceThree = false, pieceFour = false, pieceFive = false, needleAndThread = false;
    } 
    
    // Labels show up from searching for items within the rooms and this method removes them after a few seconds.
    public void removeRoomLabels(){
        if(timer.millisElapsed() > 2500){
            if(room1Basket || room3Basket || room1Trash || room2Trash || room3Trash || room1Book || room5Book || leftHallwayTrash || rightHallwayTrash || hallwayFirstHalfKey || hallwaySecondHalfKey){
                removeObject(Basket.failedRoom1Task);
                removeObject(Basket.failedRoom3Task);
                removeObject(room1TrashText);
                removeObject(room2TrashText);
                removeObject(room3TrashText);
                removeObject(room1BookText);
                removeObject(room5BookText);
                removeObject(leftHallwayTrashText);
                removeObject(rightHallwayTrashText);
                removeObject(Keys.foundHalfKey);
                removeObject(Keys.foundOtherHalfKey);
            }
        }
        if(timer.millisElapsed() > 3500){
            if(room2NeedleAndThread){
                removeObject(room2DrawerText);
            }
        }
    }
    
    // Set the world when the player is in a room
    public void createRoom(){
        isHallway = false;
        setBackground(roomWorld);
        roomBoundaries = true;
        removeObject(rightHallwayTrashText);
        removeObject(leftHallwayTrashText);
    }
    
    // Set the world for when the player leaves a room
    public void leaveRoom(){
        spawned = false;
        roomBoundaries = false;
        wakeUpInRoom = false;
        isRoom1 = false;
        isRoom2 = false;
        isRoom3 = false;
        isRoom5 = false;
        isHallway = true;
        removeObject(room1TrashText);
        removeObject(emptyBasket);
        removeObject(note);
        removeObject(Basket.failedRoom1Task);
        removeObject(room1BookText);
        removeObject(room2TrashText);
        removeObject(room2DrawerText);
        removeObject(room3TrashText);
        removeObject(Basket.failedRoom3Task);
        removeObject(room5BookText);
    }

    // Create a method to change the world when you switch between backgrounds.
    public void changeWorlds(){
        // if the world's background is tutorial world 1
        if(isTutorial1){
            addObject(movement, 115, 110);
            removeObject(note);
            removeObject(interact);
        }
        
        // if the world's background is tutorial world 2
        if(isTutorial2){
            addObject(note, 290, 300);
            addObject(interact, 90, 290);
            removeObject(movement);
            if(player.getY() < 160 && Greenfoot.isKeyDown("e")){
                isTutorial2 = false;
                isFoyer = true;
                removeObject(note);
                removeObject(interact);
            }             
        }
        
        // if the world's background is foyer world
        if(isFoyer){
            isFoyer = false;
            player.setLocation(300, 320);
            setBackground(foyerWorld);
            MainCharacter.cutscene = true;
            addObject(demon, 300, 185);
            addObject(foyerDialogue, 300, 370);
            timer.mark();
        }
        
        // if player wakes up in a strange room
        if(wakeUpInRoom){
            removeObject(foyerDialogue);
            respawn(250, 210);
            createRoom();
            addObject(wokeUpDialogue, 300, 310); 
            if(player.getY() > 250){
                leaveRoom();
                removeObject(wokeUpDialogue);
                respawn(145, 185);
            }
        }
        
        // if player is in room 1, start a task to find the first half of a key. If it's found, give another task to find the second half of the key.
        if(isRoom1){
            createRoom();
            if(!hallwayFirstHalfKey){
                addObject(emptyBasket, 290, 205);
                addObject(note, 330, 185);
            }
            if(!room1Trash){
                if(GameWorld.player.getX() > 360 && player.getY() < 205 && Greenfoot.isKeyDown("e")){
                    addObject(room1TrashText, 300, 320);
                    timer.mark();
                    removeObject(Basket.failedRoom1Task);
                    room1Trash = true;
                    pieceOne = true;
                }
            }
            if(!room1Book){
                if(player.getX() < 290 && player.getY() < 210 && Greenfoot.isKeyDown("e") && hallwayFirstHalfKey){
                    addObject(room1BookText, 300, 320);
                    removeObject(room1TrashText);
                    room1Book = true;
                }
            }
            if(player.getY() > 250){
                if(Basket.sewedBearProperly){
                    hallwayFirstHalfKey = true;
                    addObject(firstHalfExitKey, 45, 230);
                    Basket.sewedBearProperly = false;
                }
                if(Basket.sewedBearFail){
                    addObject(bear, 530, 200);
                    MainCharacter.cutscene = true;
                    timer.mark();
                }
                leaveRoom();
                respawn(45, 185);
            }
        }
        
        // if it's room 2, set up items in room
        if(isRoom2){
            createRoom();
            if(Greenfoot.isKeyDown("e")){
                if(!room2Trash){
                    if(player.getX() > 360 && player.getY() < 205){
                        removeObject(room2DrawerText);
                        addObject(room2TrashText, 300, 320);
                        room2Trash = true;
                        pieceTwo = true;
                    }
                }
                if(!room2NeedleAndThread){
                    if(player.getX() < 290 && player.getY() < 210){
                        removeObject(room2TrashText);
                        addObject(room2DrawerText, 300, 320);
                        room2NeedleAndThread = true;
                        needleAndThread = true;
                    }
                }
                timer.mark();
            }
            if(player.getY() > 250){
                leaveRoom();
                respawn(145, 185);
            }
        }
        
        // Room 3 is where the task for the second half of the key will start and it'll be used for the first task
        if(isRoom3){
            createRoom();
            if(!room3Trash){
                if(player.getX() > 360 && player.getY() < 205 && Greenfoot.isKeyDown("e")){
                    addObject(room3TrashText, 300, 320);
                    timer.mark();
                    room3Trash = true;
                    pieceThree = true;
                }
            }
            if(hallwayFirstHalfKey){
                addObject(emptyBasket, 290, 205);
                addObject(note, 330, 185);
            }
            if(player.getY() > 250){
                if(Basket.bookBasketCorrect){
                    hallwayFirstHalfKey = false;
                    hallwaySecondHalfKey = true;
                    addObject(secondHalfExitKey, 45, 230);
                    Basket.bookBasketCorrect = false;
                }
                if(Basket.bookBasketFailed){
                    addObject(bear, 530, 200);
                    MainCharacter.cutscene = true;
                    timer.mark();
                }
                leaveRoom();
                respawn(245, 185);
            }
        }
        
        // Set up room 5 and put an item (book) for task two
        if(isRoom5){
            createRoom();
            if(!room5Book){
                if(player.getX() < 290 && player.getY() < 210 && Greenfoot.isKeyDown("e") && hallwayFirstHalfKey){
                    addObject(room5BookText, 300, 320);
                    room5Book = true;
                }
            }
            if(player.getY() > 250){
                leaveRoom();
                respawn(435, 185);
            }
        }
        
        // Set up the hallway
        if(isHallway){
            setBackground(hallwayWorld);
            if(Greenfoot.isKeyDown("e")){
                if(!leftHallwayTrash){
                    if(player.getX() < 25 && player.getY() < 195){
                        addObject(leftHallwayTrashText, 300, 320);
                        leftHallwayTrash = true;
                        pieceFour = true;
                    }
                }
                if(!rightHallwayTrash){
                    if(player.getX() > 550 && player.getY() < 195){
                        addObject(rightHallwayTrashText, 300, 320);
                        rightHallwayTrash = true;
                        pieceFive = true;
                    }
                }
                timer.mark();
            }
            hallwayRooms();
        }
    }
    
    // A method to check if player is entering the rooms
    public void hallwayRooms(){ 
        if(player.getX() > 30 & player.getX() < 60 && player.getY() == 185 && Greenfoot.isKeyDown("e")){
            if(!lockedRoom1){
                isRoom1 = true;
                player.setLocation(340, 240);
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
            if(lockedRoom4){
                addObject(lockedDoor4, 300, 330);
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
                GameWon won = new GameWon();
                Greenfoot.setWorld(won);
            }
            else{
                addObject(lockedDoor6, 300, 330);
            }
        }
    }
    
    /** 
     * Removes the main character and then adds him again
     * @param x - The x coordinate
     * @param y - the y coordinate
     */
    public void respawn(int x, int y){
        if(!spawned){
            removeObject(player);
            addObject(player, x, y);
            spawned = true;
        }
    }

    // Method to cross between tutorial world 1 and tutorial world 2
    public void checkCrossTutorials(){
        if(isTutorial1 || isTutorial2){
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
}
