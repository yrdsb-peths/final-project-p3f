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
        if(GameWorld.player.getX() > 560){
            GameWorld.player.setLocation(560, GameWorld.player.getY());
        }
        // Left side of world
        else if(GameWorld.player.getX() < 15){
            GameWorld.player.setLocation(15, GameWorld.player.getY());
        }
        // Bottom side of world
        else if(GameWorld.player.getY() > 375){
            GameWorld.player.setLocation(GameWorld.player.getX(), 375);
        }
        // Top side of world
        else if(GameWorld.player.getY() < 25){
            GameWorld.player.setLocation(GameWorld.player.getX(), 25);
        }
        
        // Tutorial world 1 boundaries
        if(GameWorld.isTutorial1){
            // Bottom of left stone wall
            if(GameWorld.player.getX() < 230 && GameWorld.player.getY() < 175){
                GameWorld.player.setLocation(GameWorld.player.getX(), 175);                
            }
            // Right of left stone wall
            else if(GameWorld.player.getX() < 240 && GameWorld.player.getY() < 170){
                GameWorld.player.setLocation(240, GameWorld.player.getY());
            }
            // Bottom of right stone wall
            else if(GameWorld.player.getX() > 370 && GameWorld.player.getY() < 175){
                GameWorld.player.setLocation(GameWorld.player.getX(), 175); 
            }
            // Left of right stone wall
            else if(GameWorld.player.getX() > 360 && GameWorld.player.getY() < 170){
                GameWorld.player.setLocation(360, GameWorld.player.getY());
            }
            // Trees
            else if(GameWorld.player.getY() > 285){
                GameWorld.player.setLocation(GameWorld.player.getX(), 285);
            }
        }
        
        // Tutorial world 2 boundaries
        else if(GameWorld.isTutorial2){
            // Left stones
            if(GameWorld.player.getX() < 250 && GameWorld.player.getY() < 200){
                GameWorld.player.setLocation(GameWorld.player.getX(), 200);                
            }
            // Right stones
            else if(GameWorld.player.getX() > 350 && GameWorld.player.getY() < 200){
                GameWorld.player.setLocation(GameWorld.player.getX(), 200);
            }
            // Left side of stairs
            else if(GameWorld.player.getX() < 260 && GameWorld.player.getY() < 180){
                GameWorld.player.setLocation(260, GameWorld.player.getY());
            }
            // Right side of stairs
            else if(GameWorld.player.getX() > 325 && GameWorld.player.getY() < 180){
                GameWorld.player.setLocation(325, GameWorld.player.getY());
            }
            // Top of stairs
            else if(GameWorld.player.getY() < 155){
                GameWorld.player.setLocation(GameWorld.player.getX(), 155);                
            }
        }
        else if(GameWorld.isRoom){
            // Right wall
            if(GameWorld.player.getX() > 370){
                GameWorld.player.setLocation(370, GameWorld.player.getY());
            }
            // Left wall
            else if(GameWorld.player.getX() < 240){
                GameWorld.player.setLocation(240, GameWorld.player.getY());
            }
            // Bottom left wall
            else if(GameWorld.player.getX() < 330 && GameWorld.player.getY() > 235){
                GameWorld.player.setLocation(GameWorld.player.getX(), 235);
            }
            // Bottom right wall
            else if(GameWorld.player.getX() > 345 && GameWorld.player.getY() > 235){
                GameWorld.player.setLocation(GameWorld.player.getX(), 235);
            }
            // Left of bed
            else if(GameWorld.player.getX() > 255 && GameWorld.player.getX() < 270 && GameWorld.player.getY() < 220){
                GameWorld.player.setLocation(255, GameWorld.player.getY());
            }
            // Bottom of bed
            else if(GameWorld.player.getX() < 305 && GameWorld.player.getX() > 255 && GameWorld.player.getY() < 220){
                GameWorld.player.setLocation(GameWorld.player.getX(), 220);
            }
            // Right of bed
            else if(GameWorld.player.getX() < 320 && GameWorld.player.getX() > 295 && GameWorld.player.getY() < 220){
                GameWorld.player.setLocation(320, GameWorld.player.getY());
            }
            // Shelf boundary
            else if(GameWorld.player.getX() < 265 && GameWorld.player.getY() < 200){
                GameWorld.player.setLocation(GameWorld.player.getX(), 200);
            }
            // Desk boundary
            else if(GameWorld.player.getX() > 310 && GameWorld.player.getY() < 200){
                GameWorld.player.setLocation(GameWorld.player.getX(), 200);
            }
        }
        else if(GameWorld.isHallway){
            // Bottom of hallway
            if(GameWorld.player.getY() > 235){
                GameWorld.player.setLocation(GameWorld.player.getX(), 235);
            }
            // Top of hallway
            else if(GameWorld.player.getY() < 185){
                GameWorld.player.setLocation(GameWorld.player.getX(), 185);
            }
        }
    }
}
