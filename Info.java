import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Info here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Info extends Actor
{
    private int  time;
    private int score;
    private GreenfootImage info;
    /**
     * Info creats a black box at the top of the world, and sets the score and time to 0
     */
    public Info()
    {
        info = new GreenfootImage(1000, 45);
        info.setColor(Color.BLACK);
        info.fillRect(0, 0, info.getWidth(), info.getHeight());
        setImage (info);
        
        score = 0;
        time  = 0;
        //reseting data on reset;
    }
    
    /**
     * display score checks score and displays it for the player
     * 
     * @param there are no parameters
     * 
     * @return nothing is returned
     */
    public void displayScore()
    {
        World1 world = (World1)getWorld();
        
        if( world.getStarted() == true )
        {
            info.clear();
            info.setColor(Color.BLACK);
            info.fillRect(0, 0, info.getWidth(), info.getHeight());
            info.setColor(Color.WHITE);
            info.drawString("Score  " + score, getImage().getWidth() /4, getImage().getHeight()/ 2);
            info.drawString("Time  " + time, getImage().getWidth() /8, getImage().getHeight()/ 2);
            setImage(info);
        }
    }
    
    /**
     * Act - do whatever the Info wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World1 world = (World1)getWorld();
        Charecter1 player;
        
        if( world.getObjects(Charecter1.class).size() > 0 )
        {
            player = world.getObjects(Charecter1.class).get(0);
            score = player.moveCount();
        }
        
        if(world.getStarted() == true)
        {
            setTime(time + 1);
            Greenfoot.delay(5);
        }
        displayScore();
    }   
    
    
     /**
     * setTime sets Time equal to Time
     * 
     * @param Time = int Time
     * 
     * @return nothing is returned
     */
    public void setTime(int Time)
    {
        time = Time;
    }
}
