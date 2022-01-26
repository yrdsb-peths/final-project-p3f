import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key1 extends Actor
{
    public static Label foundHalfKey = new Label("You found half a key\n now go to room 3", 30);
    /**
     * Act - do whatever the Key1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/Keys-1.png");
        checkGotKey();
    }
    public void checkGotKey(){
        if(GameWorld.isHallway){
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                GameWorld.hallwayFirstHalfKey = true;
                GameWorld game = (GameWorld) getWorld();
                game.addObject(foundHalfKey, 300, 320);
                getWorld().removeObject(this);
            }
        }
    }
}
