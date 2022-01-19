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
        if(MainCharacter.player.getX() > 575){
            MainCharacter.player.setLocation(575, MainCharacter.player.getY());
        }
        else if(MainCharacter.player.getX() < 25){
            MainCharacter.player.setLocation(25, MainCharacter.player.getY());
        }
        else if(MainCharacter.player.getY() > 370){
            MainCharacter.player.setLocation(MainCharacter.player.getX(), 370);
        }
        else if(MainCharacter.player.getY() < 30){
            MainCharacter.player.setLocation(MainCharacter.player.getX(), 30);
        }
    }
}
