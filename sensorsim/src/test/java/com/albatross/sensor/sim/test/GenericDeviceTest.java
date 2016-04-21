package com.albatross.sensor.sim.test;

import org.apache.commons.math3.distribution.BinomialDistribution;

import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;
import com.albatross.sensor.sim.measurables.GenericDevice;
import com.albatross.sensor.sim.measurables.GenericSensor;

public class GenericDeviceTest implements QuantityListener {

	public static void main(String[] args) {
		GenericDeviceTest test = new GenericDeviceTest();
		GenericDevice device = new GenericDevice(4000, "GENERICDEVICETEST");
		GenericSensor sensor1 = new GenericSensor(4000, "GENERICSENSORTEST",
				new SimulationDataDistribution(new BinomialDistribution(1000, .40)));

		GenericSensor sensor2 = new GenericSensor(4000, "GENERICSENSORTEST",
				new SimulationDataDistribution(new BinomialDistribution(1000, .30)));

		
		device.addSensorOrDevice(sensor1);
		device.addSensorOrDevice(sensor2);
		device.addQuantityListener(test);
		device.start();

	}

	public void getQuantityChangeValues(QuantityChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println(evt.getValue().getJsonString());
	}

}
