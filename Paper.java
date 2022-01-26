import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paper extends Actor
{
    // Large paper and text for tutorial world
    LargePaper largePaper = new LargePaper();
    Label tutorialText = new Label("Look for papers\n like this to help\n progress in the\n game.\n \n Walk through\n the doors to end\n the tutorial", 30);
    
    // Large paper text for room 1
    Label room1Text = new Label("Mom took Teddy.\n She ripped him\n apart and then \nthrew him away\n saying I was\n being childish. I\n want Teddy back,\n I'm scared.", 30);
    
    // Large paper text for room 3
    Label room3Text = new Label("I’ve been wanting to read a good old murder mystery kind of story, but I heard there’s only story about murder in this hospital. I have no idea which room’s bookshelf has it though.", 30);
    
    /**
     * Act - do whatever the Paper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/Paper.png");
        tutorialWorldPaper();
        room1Paper();
        room3Paper();
    }  
    
    public void tutorialWorldPaper(){
        if(GameWorld.isTutorial2){
            GameWorld game = (GameWorld) getWorld();
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(largePaper, 290, 200);
                tutorialText.setFillColor(Color.BLACK);
                tutorialText.setLineColor(Color.WHITE);
                game.addObject(tutorialText, 290, 190);
            }
            if(isTouching(MainCharacter.class) == false){
                game.removeObject(largePaper);
                game.removeObject(tutorialText);
            }
        }
    }
    
    public void room1Paper(){
        if(GameWorld.isRoom1){
            GameWorld game = (GameWorld) getWorld();
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(largePaper, 300, 200);
                room1Text.setFillColor(Color.BLACK);
                room1Text.setLineColor(Color.WHITE);
                game.addObject(room1Text, 295, 200);
            }
            if(isTouching(MainCharacter.class) == false){
                game.removeObject(largePaper);
                game.removeObject(room1Text);
            }
        }
    }
    public void room3Paper(){
        if(GameWorld.isRoom3){
            GameWorld game = (GameWorld) getWorld();
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(largePaper, 300, 200);
                room1Text.setFillColor(Color.BLACK);
                room1Text.setLineColor(Color.WHITE);
                game.addObject(room1Text, 295, 200);
            }
            if(isTouching(MainCharacter.class) == false){
                game.removeObject(largePaper);
                game.removeObject(room1Text);
            }
        }
    }
}
