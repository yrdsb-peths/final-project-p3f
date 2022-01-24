import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Demon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demon extends Actor
{
    /**
     * Act - do whatever the Demon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/Demon.png");
        if(GameWorld.timer.millisElapsed() > 3000){
            checkY();
        }
    }
    
    public void checkY(){
        if(isTouching(MainCharacter.class)){
            getWorld().removeObject(this);
            MainCharacter.cutscene = false;
            GameWorld.isRoomWorld = true;
        }
        else{
            setLocation(getX(), getY() + deltaX(1));
        }
    }
    
    public int deltaX(int n){
        if(n >= 4){
            return 0;
        }
        return n + deltaX(n + 1);
    }
}
