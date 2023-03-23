import ecs100.*;
import java.awt.Color;
/**
 * make a lamp
 * @author Ruth Moore
 * @version 21/03/2023
 */
public class Lamp
{
    //bulb measurements 
    private double lampX;
    private double lampY;
    private int bulbSize;
    
    private Color colour1;
    
    //stem measurements 
    private double bulbMiddle; // is the middle of the buld where the stem will be.
    private double stemEnd;
    private double stemStart;
    private double stemWidth = 10;
    
    //stem click box 
    private double x1;
    private double x2;
    
    //on or off for the light
    private boolean onOrOff;
    
    

    /**
     * Constructor for objects of class Lamp
     */
    public Lamp(double x, double y, int width, Color col)
    {
     //lamp measurements    
     lampX = x;
     lampY = y;
     bulbSize = width; 

     colour1 = col;
     
     //stem measurements 
     bulbMiddle = x + width/2;
     stemStart = y + width;
     stemEnd = y + 3 * width;
     
     //stem click box
     x1 = x + width/2 - 5; //bulb middle - half of width 
     x2 = x + width/2 +5; //bulb middle + half of width 
     
     onOrOff = true;
     
     
     
    UI.initialise();
    UI.setMouseListener(this::doMouse);
     
    }
    
    /**
     * draws the light bulb with a colour.
    */
    public void draw(){
        UI.setColor(colour1);
        UI.fillOval(lampX, lampY, bulbSize, bulbSize);
        
        UI.setColor(Color.black);
        UI.setLineWidth(stemWidth);
        UI.drawLine(bulbMiddle, stemStart, bulbMiddle, stemEnd);
        
        
    }
    
    private void doMouse(String action, double x, double y){
    if (action.equals("clicked")){
        
    if (x>x1 && x<x2 && y > stemStart && y<stemEnd){
    Color oldColour = colour1;
    this.onOff();}
    
    if(x>lampX && x < lampX + bulbSize &&  y > lampY && y<lampY+bulbSize){
        this.changeColour();
    }}}
    
    private void onOff(){
        if(onOrOff == true ){
        onOrOff = false;        
        colour1 = Color.black;
        this.draw();
    }
    else if (onOrOff == false){
        onOrOff = true;
        
    }
    }
    
    /**
     * changes colour of the light bulb.
    */
    private void changeColour(){
        if (onOrOff == true){
        colour1 = new Color ((float)Math.random(), (float)Math.random(),(float)Math.random());
        this.draw();}
    }
    
}
