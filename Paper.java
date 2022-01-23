import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paper extends Actor
{
    LargePaper tutorialPaper = new LargePaper();
    Label tutorialPaperText = new Label("Look for papers\n like this to help\n progress in the\n game.\n \np.s. walk through\n the doors to end\n the tutorial", 30);
    /**
     * Act - do whatever the Paper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/Paper.png");
        tutorialWorldPaper();
    }  
    public void tutorialWorldPaper(){
        GameWorld game = (GameWorld) getWorld();
        if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
            game.addObject(tutorialPaper, 300, 200);
            tutorialPaperText.setFillColor(Color.BLACK);
            tutorialPaperText.setLineColor(Color.WHITE);
            game.addObject(tutorialPaperText, 300, 190);
        }
        if(isTouching(MainCharacter.class) == false){
            game.removeObject(tutorialPaper);
            game.removeObject(tutorialPaperText);
        }
    }
}
