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
        if(MainCharacter.player.getX() > 585){
            MainCharacter.player.setLocation(585, MainCharacter.player.getY());
        }
        // Left side of world
        else if(MainCharacter.player.getX() < 15){
            MainCharacter.player.setLocation(15, MainCharacter.player.getY());
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
        if(GameWorld.isTutorialWorld1){
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
        else if(GameWorld.isTutorialWorld2){
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
        else if(GameWorld.isRoomWorld){
            // Right wall
            if(MainCharacter.player.getX() > 370){
                MainCharacter.player.setLocation(370, MainCharacter.player.getY());
            }
            // Left wall
            else if(MainCharacter.player.getX() < 240){
                MainCharacter.player.setLocation(240, MainCharacter.player.getY());
            }
            // Bottom left wall
            else if(MainCharacter.player.getX() < 330 && MainCharacter.player.getY() > 235){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 235);
            }
            // Bottom right wall
            else if(MainCharacter.player.getX() > 345 && MainCharacter.player.getY() > 235){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 235);
            }
            // Left of bed
            else if(MainCharacter.player.getX() > 255 && MainCharacter.player.getX() < 270 && MainCharacter.player.getY() < 220){
                MainCharacter.player.setLocation(255, MainCharacter.player.getY());
            }
            // Bottom of bed
            else if(MainCharacter.player.getX() < 305 && MainCharacter.player.getX() > 255 && MainCharacter.player.getY() < 220){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 220);
            }
            // Right of bed
            else if(MainCharacter.player.getX() < 320 && MainCharacter.player.getX() > 295 && MainCharacter.player.getY() < 220){
                MainCharacter.player.setLocation(320, MainCharacter.player.getY());
            }
            // Shelf boundary
            else if(MainCharacter.player.getX() < 265 && MainCharacter.player.getY() < 200){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 200);
            }
            // Desk boundary
            else if(MainCharacter.player.getX() > 310 && MainCharacter.player.getY() < 200){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 200);
            }
        }
        else if(GameWorld.isHallwayWorld){
            // Bottom of hallway
            if(MainCharacter.player.getY() > 235){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 235);
            }
            // Top of hallway
            else if(MainCharacter.player.getY() < 185){
                MainCharacter.player.setLocation(MainCharacter.player.getX(), 185);
            }
        }
    }
}
