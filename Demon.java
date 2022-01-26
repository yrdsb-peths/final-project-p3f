import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Demon designed to attack the main character
 * 
 * Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj
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
        if(GameWorld.timer.millisElapsed() > 2500){
            checkY();
        }
    }
    
    // Method to move the demon and remove it if in contact with the player
    public void checkY(){
        if(isTouching(MainCharacter.class)){
            getWorld().removeObject(this);
            MainCharacter.cutscene = false;
            GameWorld.wakeUpInRoom = true;
        }
        else{
            setLocation(getX(), getY() + deltaX(1));
        }
    }
    
    // Recursive method to set the speed of the moving demon
    public int deltaX(int n){
        if(n >= 4){
            return 0;
        }
        return n + deltaX(n + 1);
    }
}
