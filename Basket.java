import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A basket to put certain items inside
 * 
 * @author Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj
 */
public class Basket extends Actor
{
    // Sound effects
    GreenfootSound achieved = new GreenfootSound("right.mp3");
    GreenfootSound failed = new GreenfootSound("wrong.mp3");
    
    // booleans to determine if a bear was sewed properly
    public static boolean sewedBearFail;
    public static boolean sewedBearProperly;
    
    // booleans to check if the correct book was found
    public static boolean bookBasketCorrect;
    public static boolean bookBasketFailed;
    
    // Labels that tell you if you failed
    public static Label failedRoom1Task = new Label("You failed. Find 5 pieces and the needle & \n thread BEFORE interacting with the basket", 30);
    public static Label failedRoom3Task = new Label("You failed to place the correct book in the basket", 30);
    /**
     * Act - do whatever the EmptyBasket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/EmptyBasket.png");
        checkSewedBear();  
        checkCorrectBook();
    }
    
    // Checks if task 1 is done right. If you have all the bear's parts with a needle and thread, sew him and put him in the basket
    public void checkSewedBear(){
        if(GameWorld.isRoom1){
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                GameWorld.room1Basket = true;
                if(GameWorld.pieceOne && GameWorld.pieceTwo && GameWorld.pieceThree && GameWorld.pieceFour && GameWorld.pieceFive && GameWorld.needleAndThread){
                    sewedBearProperly = true;
                    achieved.play();
                }
                if(!GameWorld.pieceOne || !GameWorld.pieceTwo || !GameWorld.pieceThree || !GameWorld.pieceFour || !GameWorld.pieceFive || !GameWorld.needleAndThread){
                    sewedBearFail = true;
                    failed.play();
                    GameWorld game = (GameWorld) getWorld();
                    game.addObject(failedRoom1Task, 300, 320);
                    GameWorld.timer.mark();
                }
            }
        }
        if(sewedBearProperly){
            setImage("Objects/BearBasket.png");
        }
    }

    // Checks if task 2 is done right. If you have the correct book, put him in the basket
    public void checkCorrectBook(){
        if(GameWorld.isRoom3 && GameWorld.hallwayFirstHalfKey && isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
            GameWorld.room3Basket = true;
            if(GameWorld.room5Book == true){
                bookBasketCorrect = true;
                achieved.play();
            }
            else{
                bookBasketFailed = true;
                failed.play();
                GameWorld game = (GameWorld) getWorld();
                game.addObject(failedRoom3Task, 300, 320);
                GameWorld.timer.mark();
            }
        }
        if(bookBasketCorrect){
            setImage("Objects/BookBasket.png");
        }
    }
}
