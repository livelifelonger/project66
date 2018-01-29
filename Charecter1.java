import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Charecter1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charecter1 extends Actor
{
    public int addWallCount;
    public int moveCount;
    public int moveDelay;
    private int highScore;
     /**
     * Walls sets the size of the wall equal to one cell size
     * 
     * @param there are no parameters
     * 
     * @return nothing is returned 
     */
    public Charecter1()
    {
        getImage().scale(getImage().getWidth()-20,getImage().getHeight()-10);
        moveCount    = 0 ;
        moveDelay    = 15;
        addWallCount = 5 ;
        highScore    = 40;
    }
    
    /**
     * Act - do whatever the Charecter1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }    
    
    public int moveDelay()
    {
        return moveDelay;
    }
    
    public int addWallCount()
    {
        return addWallCount;
    }
    
    public int moveCount()
    {
        return moveCount;
    }
    
     /**
     * movements is how the player controls Charecter1 or if Charecter1 touches a wall
     * 
     * @param xlocation is the current location on the X axis
     * @param ylocation is the current location on the Y axis
     * 
     * @return nothing is returned 
     */
    public void movement()
    {
        World1 world = (World1)getWorld();
        int xLocation = getX();
        int yLocation = getY();
        if ( Greenfoot.isKeyDown("up") == true )
        {
            setLocation( getX(), getY() - 1 );
            Greenfoot.delay(moveDelay);
            getWorld().addObject(new Walls(), xLocation, yLocation);
            randomWalls(addWallCount);
            moveCount ++;
        }
        
        if ( Greenfoot.isKeyDown("down") == true )
        {
            setLocation( getX(), getY() + 1 );
            Greenfoot.delay(moveDelay);
            getWorld().addObject(new Walls(), xLocation, yLocation);
            randomWalls(addWallCount);
            moveCount ++;
        }
        
        if ( Greenfoot.isKeyDown("left") == true )
        {
            setLocation( getX() - 1, getY());
            Greenfoot.delay(moveDelay);
            getWorld().addObject(new Walls(), xLocation, yLocation);
            randomWalls(addWallCount);
            moveCount ++;
        }
        
        if ( Greenfoot.isKeyDown("right") == true )
        {
            setLocation( getX() + 1, getY());
            Greenfoot.delay(moveDelay);
            getWorld().addObject(new Walls(), xLocation, yLocation);
            randomWalls(addWallCount);
            moveCount ++;
        }
        
        //defeat code.
        endGame();
    }
    
    private void endGame()
    {
        World1 world = (World1)getWorld();
        Info  Touching1 = (Info)getOneIntersectingObject( Info.class);
        Walls Touching = (Walls)getOneIntersectingObject(Walls.class);
        
        if( world.getStarted() == true)
        {
            if (Touching != null)
            {
                if(moveCount <= 9)
                {
                    world.showText( "Walls Win!", getWorld().getWidth()/2, getWorld().getHeight()/2);
                }
                else if(moveCount <= 19)
                {
                    world.showText( "Getting gud", getWorld().getWidth()/2, getWorld().getHeight()/2);
                }
                else if(moveCount <= 29)
                {
                    world.showText( "pretty Good", getWorld().getWidth()/2, getWorld().getHeight()/2);
                }
                else if(moveCount <= 39)
                {
                    world.showText( "Real Gud", getWorld().getWidth()/2, getWorld().getHeight()/2);
                }
                else if(moveCount <= highScore - 1)
                {
                    world.showText( "Close, but no new High Score!!!", getWorld().getWidth()/2, getWorld().getHeight()/2);
                }
                else if(moveCount >= highScore)
                {
                    world.showText( "new High Score", getWorld().getWidth()/2, getWorld().getHeight()/2);
                    highScore = moveCount;
                }
                world.showText( "Final Score = " + moveCount, getWorld().getWidth()/2, getWorld().getHeight()/2 - 2);
                world.setStarted(false);
                world.fixWorld();
            }
        }
        
        
        if (Touching1 != null)
        {
            world.showText( "You No Go There!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            world.showText( "Final Score = 0!!!!!", getWorld().getWidth()/2, getWorld().getHeight()/2 - 2);
            
            Greenfoot.delay(50);
            world.fixWorld();
            Greenfoot.delay(15);
            world.showText( "", getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }
    
    private void randomWalls( int howMany )
    {
        World1 world = (World1)getWorld();
        Walls newWall;
        int x;
        int y;
        
        for( int i = 0; i < howMany; i ++ )
        {
            newWall = new Walls();
            x = Greenfoot.getRandomNumber( world.getWidth()  );
            y = Greenfoot.getRandomNumber( world.getHeight() -1 ) +1;
            
            while( x == getX() )
            {
                x = Greenfoot.getRandomNumber( getWorld().getWidth() );
            }
            
            while( y == getY() )
            {
                y = Greenfoot.getRandomNumber( getWorld().getHeight()-1 ) + 1;
            }
            
            getWorld().addObject(newWall, x, y);
        }
    }
    
    /**
     * setMoveCount sets movecount to count
     * 
     * @param int moveCount = count
     * 
     * @return nothing is returned
     */
    public void setMoveCount(int count)
    {
        moveCount = count;
    }
    
}
