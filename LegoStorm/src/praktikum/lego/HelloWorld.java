package praktikum.lego;

import lejos.nxt.Motor;
import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;



public class HelloWorld {
	
    /**
     * @param args
     */
    public static void main(String[] args) {
    	boolean rotate = true;
    	boolean left = true;
    	boolean right = false;
    	int count = 0;

    	LightSensor light = new LightSensor(SensorPort.S1);
    	
    	LCD.drawString("Follow Line", 0, 0);
    	LCD.refresh();
    	Motor.A.setSpeed(30);
       	Motor.B.setSpeed(30);
      while (true) {
       	
    	while(rotate && left && count > 3) {
	    	count++;

	    	Motor.A.forward();   
	    	Motor.B.backward();
	    	if (light.getLightValue() > 32) {
	    		rotate = false;
	    		right = true;
	    		left = false;
	    		count = 0;
	    	}
	    	
	    	
    	}
    	
    	while(rotate && right && count > 3) {
	    	count++;

	    	Motor.B.forward();   
	    	Motor.A.backward();
	    	if (light.getLightValue() > 32) {
	    		rotate = false;
	    		right = false;
	    		left = true;
	    		count = 0;

	    	}
	    	
    	}
    	
    	while(!rotate) {
	    	Motor.B.backward();   
	    	Motor.C.backward();
	    	if (light.getLightValue() < 32) {
	    		rotate = true;
	    	}
	    	
    	}
    	
      }
    	
    	
       
        
    }

}
