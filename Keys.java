import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Keys
 * 
 * @author Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj 
 */
public class Keys extends Actor
{
    // Create labels
    public static Label foundHalfKey = new Label("You found half an exit key\n now go to room 3", 30);
    public static Label foundOtherHalfKey = new Label("You found the other half of the exit key \n use it to escape", 30);
    
    /**
     * Act - do whatever the Key1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkGotKey();
    }
    
    // Check which half of the key gets picked up
    public void checkGotKey(){
        GameWorld game = (GameWorld) getWorld();
        if(GameWorld.hallwayFirstHalfKey){
            setImage("Objects/Keys-1.png");
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(foundHalfKey, 300, 320);
                getWorld().removeObject(this);
            }
        }
        if(GameWorld.hallwaySecondHalfKey){
            setImage("Objects/Keys-2.png");
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(foundOtherHalfKey, 300, 320);
                GameWorld.lockedRoom6 = false;
                getWorld().removeObject(this);
            }
        }
    }
}
