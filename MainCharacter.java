import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainCharacter extends Actor
{
    public static MainCharacter player = new MainCharacter();
    private GreenfootImage[] upWalkCycle = new GreenfootImage[4];
    private GreenfootImage[] downWalkCycle = new GreenfootImage[4];
    private GreenfootImage[] rightWalkCycle = new GreenfootImage[4];
    private GreenfootImage[] leftWalkCycle = new GreenfootImage[4];
    
    private int j = 3, deltaD = 10, upCycleFrame = 0, downCycleFrame = 0, leftCycleFrame = 0, rightCycleFrame = 0; 
    
    public void addedToWorld(World MyWorld)
    {
        for(int i = 0; i < upWalkCycle.length; i++) upWalkCycle[i] = new GreenfootImage("PlayerUp-" + i + ".png");
        for(int i = 0; i < downWalkCycle.length; i++) downWalkCycle[i] = new GreenfootImage("PlayerDown-" + i + ".png");
        for(int i = 0; i < rightWalkCycle.length; i++) rightWalkCycle[i] = new GreenfootImage("PlayerRight-" + i + ".png");
        for(int i = 0; i < leftWalkCycle.length; i++) leftWalkCycle[i] = new GreenfootImage("PlayerLeft-" + i + ".png");
        setImage(downWalkCycle[0]);
    }
        
    /**
     * Act - do whatever the MainCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeys();
        Boundaries.checkBoundaries();
    }
    
    private void checkKeys(){
        if(Greenfoot.isKeyDown("w"))
        {
            if(j == 0)j = 3;
            if(j == 1)
            {
                setImage(upWalkCycle[upCycleFrame]);
                upCycleFrame++;
                if(upCycleFrame >= upWalkCycle.length) upCycleFrame = 0;
                setLocation(getX(), getY() - deltaD);
            }
            if(j > 0) j--;
        }
            
        else if(Greenfoot.isKeyDown("s"))
        {
            if(j == 0)j = 3;
            if(j == 1)
            {
                setImage(downWalkCycle[downCycleFrame]);
                downCycleFrame++;
                if(downCycleFrame >= downWalkCycle.length) downCycleFrame = 0;
                setLocation(getX(), getY() + deltaD);
            }
            if(j > 0) j--;
        }
            
        else if(Greenfoot.isKeyDown("d"))
        {
            if(j == 0)j = 3;
            if(j == 1)
            {
                setImage(rightWalkCycle[rightCycleFrame]);
                rightCycleFrame++;
                if(rightCycleFrame >= rightWalkCycle.length) rightCycleFrame = 0;
                setLocation(getX() + deltaD, getY());
            }
            if(j > 0) j--;    
        }
            
        else if(Greenfoot.isKeyDown("a"))
        {
            if(j == 0)j = 3;
            if(j == 1)
            {
                setImage(leftWalkCycle[leftCycleFrame]);
                leftCycleFrame++;
                if(leftCycleFrame >= leftWalkCycle.length) leftCycleFrame = 0;
                setLocation(getX() - deltaD, getY());
            }
            if(j > 0) j--;
        }
    }
}
