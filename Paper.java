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
    LargePaper tutorialLargePaper = new LargePaper();
    Label tutorialText = new Label("Look for papers\n like this to help\n progress in the\n game.\n \n Walk through\n the doors to end\n the tutorial", 30);
    
    // Large paper and text for room 1
    LargePaper room1LargePaper = new LargePaper();
    Label room1Text = new Label("Mom took away\n Teddy. She ripped\n it apart and then \nthrew it away saying \nI was being childish. I want Teddy back,\n I'm scared.", 30);

    /**
     * Act - do whatever the Paper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/Paper.png");
        tutorialWorldPaper();
        room1Paper();
    }  
    public void tutorialWorldPaper(){
        if(GameWorld.isTutorial2){
            GameWorld game = (GameWorld) getWorld();
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(tutorialLargePaper, 300, 200);
                tutorialText.setFillColor(Color.BLACK);
                tutorialText.setLineColor(Color.WHITE);
                game.addObject(tutorialText, 300, 190);
            }
            if(isTouching(MainCharacter.class) == false){
                game.removeObject(tutorialLargePaper);
                game.removeObject(tutorialText);
            }
        }
    }
    public void room1Paper(){
        if(GameWorld.isRoom1){
            GameWorld game = (GameWorld) getWorld();
            if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
                game.addObject(room1LargePaper, 300, 200);
                room1Text.setFillColor(Color.BLACK);
                room1Text.setLineColor(Color.WHITE);
                game.addObject(room1Text, 300, 190);
            }
            if(isTouching(MainCharacter.class) == false){
                game.removeObject(room1LargePaper);
                game.removeObject(room1Text);
            }
        }
    }
}
