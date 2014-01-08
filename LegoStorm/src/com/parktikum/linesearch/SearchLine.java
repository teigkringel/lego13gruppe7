package com.parktikum.linesearch;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;


public class SearchLine implements Behavior {
	private LightSensor light;

	public SearchLine(LightSensor light) {
		// TODO Auto-generated constructor stub
		this.light=light;
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		if(light.readValue()<=45){
			return true;
		}else{
			return false;
		}
	
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Motor.A.setSpeed(80);
		Motor.B.setSpeed(80);
		int i =0;
		while(true){
			Motor.A.rotate(80+i);
			Motor.B.rotate(-80-i);
			
			if(light.readValue()>45) break;
            Motor.A.stop();
            Motor.B.stop();
            LCD.drawInt(light.readValue(), 0, 0);
			if(light.readValue()>45) break;
			Motor.B.rotate(80+i+3);
			Motor.A.rotate(-80-i-2);
			if(light.readValue()>45) break;
			Motor.A.stop();
            Motor.B.stop();
            LCD.drawInt(light.readValue(), 0, 0);
            if(light.readValue()>45) break;
            i=i+30;
			
		}

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
