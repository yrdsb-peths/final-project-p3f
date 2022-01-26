import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Basket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basket extends Actor
{
    GreenfootSound achieved = new GreenfootSound("right.mp3");
    GreenfootSound failed = new GreenfootSound("wrong.mp3");
    public static boolean sewedBearFail;
    public static boolean sewedBearProperly;
    public static Label failedRoom1Task = new Label("You failed. Find 5 pieces and the needle & \n thread BEFORE interacting with the basket", 30);
    
    /**
     * Act - do whatever the EmptyBasket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/EmptyBasket.png");
        checkSewedBear();    
    }
    
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
}
