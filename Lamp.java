import ecs100.*;
import java.awt.Color;
/**
 * make a lamp
 * @author Ruth Moore
 * @version 21/03/2023
 */
public class Lamp
{

    private double lampX;
    private double lampY;
    
    private int bulbSize;
    
    private Color colour1;

    /**
     * Constructor for objects of class Lamp
     */
    public Lamp(double x, double y, int width, Color col)
    {
     lampX = x;
     lampY = y;
     bulbSize = width;

     colour1 = col;
     
     UI.initialise();
    UI.setMouseListener(this::doMouse);
     
    }
    
    public void draw(){
        UI.setColor(colour1);
        UI.fillOval(lampX, lampY, bulbSize, bulbSize);
    }
    
    private void doMouse(String action, double x, double y){
    if (action.equals("clicked")){
    if(x>lampX && x < lampX + bulbSize &&  y > lampY && y<lampY+bulbSize){
        this.changeColour();
    }}}
    
    private void changeColour(){
        colour1 = new Color ((float)Math.random(), (float)Math.random(),(float)Math.random());
        this.draw();
    }
    public static void main(String [] args){
    
    Lamp lamp1 = new Lamp(50, 50, 50, Color.red);
    lamp1.draw();
}
}
