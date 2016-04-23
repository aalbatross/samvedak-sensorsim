/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.test;

import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;
import com.albatross.sensor.sim.data.distribution.RecordedSequenceDistribution;
import com.albatross.sensor.sim.measurables.GenericSensor;
import java.util.Vector;
import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 *
 * @author iamrp
 */
public class GenericSensorTestWithRecordedSequenceDistribution implements QuantityListener {

	public static void main(String[] args) {
		GenericSensorTest test = new GenericSensorTest();
                Vector dictionary= new Vector();
        dictionary.add("Ravi");
        dictionary.add("Kavi");
        dictionary.add("Pavi");
		GenericSensor sensor = new GenericSensor(2000, "GENERICSENSORTEST",
				new SimulationDataDistribution(new RecordedSequenceDistribution(dictionary)));
		sensor.addQuantityListener(test);
		sensor.start();
	}

	public void getQuantityChangeValues(QuantityChangeEvent evt) {
		System.out.println(evt.getValue().getJsonString());

	}

}

