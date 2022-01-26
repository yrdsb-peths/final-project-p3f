import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Evil bear
 * 
 * @author Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj
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
        if(GameWorld.timer.millisElapsed() > 1500){
            checkY();
        }
    }
    
    // Method to move the bear and remove it if in contact with the player
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
        
    /**
     * Recursive method to set the speed of the moving demon
     * @param n - integer that sets the speed
     */ 
    public int deltaX(int n){
        if(n >= 4){
            return 0;
        }
        return n + deltaX(n + 1);
    }
}
