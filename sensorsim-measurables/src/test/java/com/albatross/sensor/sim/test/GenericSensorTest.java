package com.albatross.sensor.sim.test;

import org.apache.commons.math3.distribution.BinomialDistribution;

import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;
import com.albatross.sensor.sim.measurables.sensors.GenericSensor;

public class GenericSensorTest implements QuantityListener {

	public static void main(String[] args) {
		GenericSensorTest test = new GenericSensorTest();
		GenericSensor sensor = new GenericSensor(4000, "GENERICSENSORTEST",
				new SimulationDataDistribution(new BinomialDistribution(1000, .70)));
		sensor.addQuantityListener(test);
		sensor.start();
	}

	public void getQuantityChangeValues(QuantityChangeEvent evt) {
		System.out.println(evt.getValue().getJsonString());

	}

}
