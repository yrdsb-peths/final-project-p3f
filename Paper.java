import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Paper
 * 
 * @author Sameer Hidery, Murtaza Asrani, Keira Sutharsanaraj
 */
public class Paper extends Actor
{
    // Large paper
    LargePaper largePaper = new LargePaper();
    
    // Text for large paper in tutorial world
    Label tutorialText = new Label("Look for papers\n like this to help\n progress in the\n game.\n \n Walk through\n the doors to end\n the tutorial", 30);
    
    // Text for large paper in room 1
    Label room1Text = new Label("Mom took Teddy.\n She ripped him\n apart and then \nthrew him away\n saying I was\n being childish. I\n want Teddy back,\n I'm scared.", 30);
    
    // Text for large paper in room 3 
    Label room3Text = new Label("I’ve been wanting\n to read a murder\n mystery story but\n I heard there’s \n only one in this\n hospital. I have no\n idea which room's \nbookshelf has it.", 28);
    
    /**
     * Act - do whatever the Paper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Objects/Paper.png");
        worldPapers();
    }  
    
    // Method to display the paper with the corresponding background of the game world
    public void worldPapers(){
        GameWorld game = (GameWorld) getWorld();
        if(isTouching(MainCharacter.class) && Greenfoot.isKeyDown("e")){
            game.addObject(largePaper, 300, 200);
            if(GameWorld.isTutorial2){
                tutorialText.setFillColor(Color.BLACK);
                tutorialText.setLineColor(Color.WHITE);
                game.addObject(tutorialText, 300, 190);
            }
            if(GameWorld.isRoom1){
                room1Text.setFillColor(Color.BLACK);
                room1Text.setLineColor(Color.WHITE);
                game.addObject(room1Text, 300, 200);
            }
            if(GameWorld.isRoom3){
                room3Text.setFillColor(Color.BLACK);
                room3Text.setLineColor(Color.WHITE);
                game.addObject(room3Text, 300, 200);
            }
        }
        if(isTouching(MainCharacter.class) == false){
            game.removeObject(largePaper);
            game.removeObject(tutorialText);
            game.removeObject(room1Text);
            game.removeObject(room3Text);
        }
    }
}
