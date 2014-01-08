package com.praktikum.maze;

import lejos.robotics.subsumption.Behavior;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Motor;

public class FollowWall implements Behavior {
	
	private UltrasonicSensor ultrason;
	
	public FollowWall(UltrasonicSensor ultrason) {
		this.ultrason = ultrason;
	}

	@Override
	public boolean takeControl() {
		
		return ultrason.getDistance() <= 3;
	}

	@Override
	public void action() {
		
		Motor.A.backward();
		Motor.B.backward();

		// TODO Auto-generated method stub

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
