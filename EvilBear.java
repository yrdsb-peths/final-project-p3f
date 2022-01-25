import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EvilBear extends Actor
{
    /**
     * Act - do whatever the Bear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/TeddyBear.png");
        if(GameWorld.timer.millisElapsed() > 2000){
            checkY();
        }
        
    }
    
    public void checkY(){
        if(isTouching(MainCharacter.class)){
            getWorld().removeObject(this);
            MainCharacter.cutscene = false;
            GameOver lost = new GameOver();
            Greenfoot.setWorld(lost);
        }
        else{
            setLocation(getX() - deltaX(1), getY());
        }
    }
        
    public int deltaX(int n){
        if(n >= 4){
            return 0;
        }
        return n + deltaX(n + 1);
    }
}
