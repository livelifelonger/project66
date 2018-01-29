import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World
{
    private boolean startGame;
    private boolean spacePressed;
    
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20, 15, 45); 
        
        Info info = new Info();
        
        fixWorld();
        addObject(info, 10, 0);
        startGame = false;
        showText ( "press Space to Start", getWidth() / 2 , getHeight() / 2 );
    }

    /**
     * fixWorld completely remakes the world
     * 
     * @param Info creates a new info object
     * 
     */
    public void fixWorld()
    {
        List wallObjects=getObjects(Walls.class);
        List characterObjects = getObjects(Charecter1.class);
        removeObjects(wallObjects);
        removeObjects(characterObjects);
        Charecter1 charecter1 = new Charecter1();
        addObject(charecter1, getWidth() /2, getHeight() /2);
        randomWalls(85);
        
    }
    
     /**
      * act checks is the game has been started
      * 
      * @param there are no parameters
      * 
      * @return nothing returned
     */
    public void act()
    {
        Info info = new Info();
        
        if( startGame == false)
        {
            checkKeyPressed();
            if( spacePressed == true )
            {
                spacePressed = false;
                fixWorld();
                showText( "", getWidth()/2, getHeight()/2 - 2);
                addObject(info, 10, 0);
                Greenfoot.delay(10);
                startGame = true;
                showText("", getWidth() / 2, getHeight() / 2);
                showText("Press Space To Reset", getWidth() /2/2*3,0 );
            }
        }
        else if( startGame == true)
        {
            checkKeyPressed();
            if( spacePressed == true )
            {
                spacePressed = false;
                fixWorld();
                Greenfoot.delay(10);
                showText("", getWidth() / 2, getHeight() / 2);
                showText("Press Space To Reset", getWidth() /2/2*3,0 );
            }
        }else
        {
            spacePressed = false;
        }
    }
    
     /**
      * getStarted returns startGame
      * 
      * @param there are no parameters
      * 
      * @return startGame
     */
    public boolean getStarted()
    {
        return startGame;
    }
    
     /**
      * checkKeyPressed checks if the space key is pressed
      * 
      * @param there are no parameters
      * 
      * @return if the space key is pressed
     */
    private void checkKeyPressed()
    {
        if ( Greenfoot.isKeyDown("space"))
        {
            spacePressed = true;
        }
    }
    
     /**
      * randomWalls adds specified number of walls randomly to the world
      * 
      * @param x defins X cordinate (randomized per wall)
      * @param y defins Y cordinate (randomized per wall)
      * 
      * @return nothing returned
     */
    private void randomWalls( int howMany )
    {
        Walls newWall;
        int x;
        int y;

        for( int i = 0; i < howMany; i ++ )
        {
            newWall = new Walls();
            x = Greenfoot.getRandomNumber( getWidth() );
            y = Greenfoot.getRandomNumber( getHeight()-1 ) + 1;
            
            while( x == getWidth()/2 )
            {
                x = Greenfoot.getRandomNumber( getWidth() );
            }
            
            while( y == getHeight()/2 )
            {
                y = Greenfoot.getRandomNumber( getHeight()-1 ) + 1;
            }
            
            addObject( newWall, x, y );
        }
    }
    
    public void setStarted(boolean s)
    {
        startGame = s;
    }
}
