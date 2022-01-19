import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Boundaries here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boundaries  
{
    public static void checkBoundaries()
    {
        if(MyWorld.player.getX() > 575){
            MyWorld.player.setLocation(575, MyWorld.player.getY());
        }
        else if(MyWorld.player.getX() < 25){
            MyWorld.player.setLocation(25, MyWorld.player.getY());
        }
        else if(MyWorld.player.getY() > 370){
            MyWorld.player.setLocation(MyWorld.player.getX(), 370);
        }
        else if(MyWorld.player.getY() < 30){
            MyWorld.player.setLocation(MyWorld.player.getX(), 30);
        }
    }
}
