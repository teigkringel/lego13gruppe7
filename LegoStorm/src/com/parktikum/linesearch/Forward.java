package com.parktikum.linesearch;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class Forward implements Behavior {
    private LightSensor light;
	public Forward(LightSensor light) {
		this.light=light;
	}

	@Override
	public boolean takeControl() {
		if(light.readValue()>=45){
			return true;
		}else{return false;
			}
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Motor.A.setSpeed(300);
		Motor.B.setSpeed(300);
		Motor.A.forward();
		Motor.B.forward();
		 LCD.drawInt(light.readValue(), 0, 0);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
