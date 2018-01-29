import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Walls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Walls extends Actor
{
     /**
     * Walls sets the size of the wall equal to one cell size
     * 
     * @param there are no parameters
     * 
     * @return nothing is returned 
     */
    public Walls()
    {
        getImage().scale(getImage().getWidth()-5,getImage().getHeight()-5);
    }
    
    /**
     * Act - do whatever the Walls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
