import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

import com.parktikum.linesearch.Forward;
import com.parktikum.linesearch.SearchLine;

import lejos.nxt.*;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightSensor light=new LightSensor(SensorPort.S1);
		
		Behavior b1 = new Forward(light);
	    Behavior b2 = new SearchLine(light);
	    Behavior [] bArray = {b1, b2};
	    Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	    }


}
