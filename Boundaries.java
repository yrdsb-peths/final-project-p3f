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
        if(GameWorld.isTutorialWorld1 == true){
            if(MainCharacter.player.getX() < 230 && MainCharacter.player.getY() < 185){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 185);                
            }
            else if(MainCharacter.player.getX() < 240 && MainCharacter.player.getY() < 180){
                MainCharacter.player.setLocation(240, MainCharacter.player.getY());
            }
            else if(MainCharacter.player.getX() > 370 && MainCharacter.player.getY() < 185){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 185); 
            }
            else if(MainCharacter.player.getX() > 360 && MainCharacter.player.getY() < 180){
                MainCharacter.player.setLocation(360, MainCharacter.player.getY());
            }
            else if(MainCharacter.player.getY() > 285){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 285);
            }
        }
        
        // Tutorial world 2 boundaries
        else if(GameWorld.isTutorialWorld2 == true){
            // Left stones
            if(MainCharacter.player.getX() < 250 && MainCharacter.player.getY() < 200){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 200);                
            }
            // Right stones
            else if(MainCharacter.player.getX() > 350 && MainCharacter.player.getY() < 200){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 200);
            }
            // Left side of stairs
            else if(MainCharacter.player.getX() < 260 && MainCharacter.player.getY() < 180){
                MainCharacter.player.setLocation(260, MainCharacter.player.getY());
            }
            // Right side of stairs
            else if(MainCharacter.player.getX() > 325 && MainCharacter.player.getY() < 180){
                MainCharacter.player.setLocation(325, MainCharacter.player.getY());
            }
            // Top of stairs
            else if(MainCharacter.player.getY() < 155){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 155);                
            }
        }
    }
}
