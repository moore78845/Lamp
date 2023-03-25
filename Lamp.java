import ecs100.*;
import java.awt.Color;
/**
 * make a lamp, which has a bulb (a circle) and a stem(a line). The bulb will have a click box and same as the stem.
 * The lamp will be able to change colours when you click the light bulb and will turn off when you click the stem.
 * @author Ruth Moore
 * @version 21/03/2023
 */
public class Lamp
{
    //bulb measurements 
    private double lampX;
    private double lampY;
    private int bulbSize;
    
    //colour of the light 
    private Color colour1;
    private Color oldColour; // when the lamp is turned on it turns on to th last colour of the light.
    
    //stem measurements 
    private double bulbMiddle; // is the middle of the bulb where the stem will be start as its a line.
    private double stemEnd; // y measurement 
    private double stemStart; //y measurement 
    private double stemWidth = 10;
    
    //stem click box measurements as the stem is a line  
    private double x1; // top left of the line
    private double x2; // top right of the line 
    
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
     bulbMiddle = x + width/2; // the middle is the top left of the circle + half the width
     stemStart = y + width +5; //+ half the stem width as its a line. 
     stemEnd = y + 3 * width;
     
     //stem click box
     x1 = x + width/2 - 5; //bulb middle - half of width 
     x2 = x + width/2 +5; //bulb middle + half of width 
     
     //the light starts on 
     onOrOff = true;
     
    }
    
    /**
     * draws the light bulb via an oval with a colour and a black stem.
    */
    public void draw(){
        UI.setColor(colour1);
        UI.fillOval(lampX, lampY, bulbSize, bulbSize);
        
        UI.setColor(Color.black);
        UI.setLineWidth(stemWidth);
        UI.drawLine(bulbMiddle, stemStart, bulbMiddle, stemEnd);
        
        
    }
      
    /**
     * when this method is called it means that the user has clicked on the stem to turn it on or off 
     * so the onOrOff value will go to the opposite of what is was before.
    */
    public void onOff(){
        // the light is true(on)so we change the light to off (false) 
        if(onOrOff == true ){
        onOrOff = false; 
        oldColour = colour1; //old colour for when the light turns back on.
        colour1 = Color.black; // black colour = off
        this.draw();
    }
    // the light is off (false) so we change the light to on(true)
    else if (onOrOff == false){
        colour1 = oldColour; //colouring the light to the colour it was before it turned off.
        this.draw();
        onOrOff = true;
        
    }
    }
    
    /**
     * changes colour of the light bulb randomly for when the light bulb is clicked.
    */
    public void changeColour(){
        
        if (onOrOff == true){ //checks to see if the light is on or not. if not will not change colour.
        colour1 = new Color ((float)Math.random(), (float)Math.random(),(float)Math.random());
        this.draw();}
    }
    
    /**
     * gets stem start for other classes
    */
    public double getstemStart(){
    return stemStart;}
    
    /**
     * gets stemend for other classes
    */
    public double getstemEnd(){
    return stemEnd;}
    
    /**
     * gets lampx for other classes
    */
    public double getlampX(){
    return lampX;}
    /**
     * gets lampY for other classes
    */
    public double getlampY(){
    return lampY;}
    /**
     * gets x1 for other classes
    */
    public double getx1(){
    return x1;}
    /**
     * gets x2 for other classes
    */
    public double getx2(){
    return x2;}
    /**
     * gets bulb size for other classes
    */
    public int getbulbSize(){
    return bulbSize;}
}
