import ecs100.*;
import java.awt.Color;
/**
 * driver class for lamps. there is an array of lamps and each lamp can change the colour of the light and turn off and on.
 *
 * @author Ruth Moore
 * @version 25/03/2023
 */
public class arrayLamps
{
    private Lamp [] arrayOfLamps = new Lamp [4];

    /**
     * Constructor for objects of class ClickLamps
     */
    public arrayLamps()
    {
    UI.initialise();
    // a for loop to create all a of the lamps 
    for (int i = 0; i<4; i ++ ){
    arrayOfLamps[i] = new Lamp (50 * i, 50, 50, Color.yellow );}
   // draws all lamps
    for (Lamp lamp : arrayOfLamps){
          lamp.draw();
    }
    UI.setMouseListener(this::doMouse);
    }
    
    /**
     * checks if the mouse has clicked on any of the lamps and hwat part of the lamp e.g light bulb or stem.
    */
    private void doMouse(String action, double x, double y){
    if (action.equals("clicked")){
        for (Lamp lamp : arrayOfLamps){
        
    if (x>lamp.getx1() && x<lamp.getx2() && y > lamp.getstemStart() && y<lamp.getstemEnd()){
    lamp.onOff();} // turns on or off the lamp when stem is clicked
    
    if(x>lamp.getlampX() && x < lamp.getlampX() + lamp.getbulbSize() &&  y > lamp.getlampY() && y<lamp.getlampY()+lamp.getbulbSize()){
        lamp.changeColour(); // changes colour of the lamp if light bulb clicked.
    }}}}

}