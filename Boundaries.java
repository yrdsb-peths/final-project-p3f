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
        // Right side of world
        if(MainCharacter.player.getX() > 580){
            MainCharacter.player.setLocation(580, MainCharacter.player.getY());
        }
        // Left side of world
        else if(MainCharacter.player.getX() < 20){
            MainCharacter.player.setLocation(20, MainCharacter.player.getY());
        }
        // Bottom side of world
        else if(MainCharacter.player.getY() > 375){
            MainCharacter.player.setLocation(MainCharacter.player.getX(), 375);
        }
        // Top side of world
        else if(MainCharacter.player.getY() < 25){
            MainCharacter.player.setLocation(MainCharacter.player.getX(), 25);
        }
        
        // Tutorial world 1 boundaries
        if(MainCharacter.player.getWorld() instanceof TutorialWorld1){
            if(MainCharacter.player.getY() <= 185 && MainCharacter.player.getX() < 230){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 185);                
            }
            else if(MainCharacter.player.getX() < 240 && MainCharacter.player.getY() < 180){
                MainCharacter.player.setLocation(240, MainCharacter.player.getY());
            }
            else if(MainCharacter.player.getY() <= 185 && MainCharacter.player.getX() > 370){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 185); 
            }
            else if(MainCharacter.player.getX() > 360 && MainCharacter.player.getY() < 180){
                MainCharacter.player.setLocation(360, MainCharacter.player.getY());
            }
            
        }
    }
}
