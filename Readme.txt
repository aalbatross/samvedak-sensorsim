Sensorsim is a API which helps the developers to generate simulated data with abstraction of sensors and devices.  
 1. It can be used for testing applications which require generating sensor data.
 2. Creating data for simulation environment.
 3. Simulating a device with lot of Sensors.
 4. Sensors of Same and different kind can be evaluated on simulation environment.

How to use:
Examples
1. Using Sensor
    eg:
    	import org.apache.commons.math3.distribution.BinomialDistribution;

	import com.albatross.sensor.sim.core.SimulationDataDistribution;
	import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
	import com.albatross.sensor.sim.core.events.QuantityListener;
	import com.albatross.sensor.sim.measurables.GenericSensor;

	public class GenericSensorTest implements QuantityListener {

		public static void main(String[] args) {
			//Listens to change in value of Sensor and hence implements getQuantityChangedValues
			GenericSensorTest test = new GenericSensorTest();
			//Instantiates a Generic Sensor Implementation here 4000 is 4s for every value, friendly name of sensor GENERICSENSORTEST, 				//and data generated will follow BinomialDistribution 
			GenericSensor sensor = new GenericSensor(4000, "GENERICSENSORTEST",
				new SimulationDataDistribution(new BinomialDistribution(1000, .70)));
			//Adding listener to the sensor
			sensor.addQuantityListener(test);
			//starting the sensor
			sensor.start();
		}

		public void getQuantityChangeValues(QuantityChangeEvent evt) {
			System.out.println(evt.getValue().getJsonString());

		}

	}

Output: 
{"type":{"type":"SENSOR","ofCategory":"Simulator.GenericSensor","productOf":"albatross","name":"albatross.genericsensor","measurementUnits":"albatross.virtualunits","friendlyName":"GENERICSENSORTEST"},"value":710,"timeOfOccurence":1461266204747,"sourceID":"c3302892-ad18-48a8-b3da-a4286f672d49","unitOfMeasurement":"albatross.virtualunits"}

2. Using Device with multiple sensor
package com.albatross.sensor.sim.test;

import org.apache.commons.math3.distribution.BinomialDistribution;

import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;
import com.albatross.sensor.sim.measurables.GenericDevice;
import com.albatross.sensor.sim.measurables.GenericSensor;

public class GenericDeviceTest implements QuantityListener {

    public static void main(String[] args) {
        //Quantity Listener listening device values
        GenericDeviceTest test = new GenericDeviceTest();
        //Generic Device instantiation
        GenericDevice device = new GenericDevice(4000, "GENERICDEVICETEST");
        //Generic sensor creation sensor 1
        GenericSensor sensor1 = new GenericSensor(4000, "GENERICSENSORTEST1",
                new SimulationDataDistribution(new BinomialDistribution(1000, .40)));
        //Generic sensor creation sensor 2
        GenericSensor sensor2 = new GenericSensor(4000, "GENERICSENSORTEST2",
                new SimulationDataDistribution(new BinomialDistribution(1000, .30)));
        //adding sensor 1 to device
        device.addSensorOrDevice(sensor1);
        //adding sensor2 to device
        device.addSensorOrDevice(sensor2);
        //adding quantity listener to device
        device.addQuantityListener(test);
        //starting the device
        device.start();

    }

    public void getQuantityChangeValues(QuantityChangeEvent evt) {
        // TODO Auto-generated method stub
        System.out.println(evt.getValue().getJsonString());
    }

}
Output : {"type":{"type":"DEVICE","ofCategory":"Simulator.GenericDevice","productOf":"albatross","name":"albatross.genericdevice","measurementUnits":"albatross.nounit","friendlyName":"GENERICDEVICETEST"},"value":[{"type":{"type":"SENSOR","ofCategory":"Simulator.GenericSensor","productOf":"albatross","name":"albatross.genericsensor","measurementUnits":"albatross.virtualunits","friendlyName":"GENERICSENSORTEST1"},"value":409,"timeOfOccurence":1461265976850,"sourceID":"e7b50c2b-4d49-4efc-acc9-6d5a6532a684","unitOfMeasurement":"albatross.virtualunits"},{"type":{"type":"SENSOR","ofCategory":"Simulator.GenericSensor","productOf":"albatross","name":"albatross.genericsensor","measurementUnits":"albatross.virtualunits","friendlyName":"GENERICSENSORTEST2"},"value":294,"timeOfOccurence":1461265976850,"sourceID":"f3bf51ba-b8c2-4bf5-b289-b5a8a5b38346","unitOfMeasurement":"albatross.virtualunits"}],"timeOfOccurence":1461265976937,"sourceID":"533a487f-42d3-4469-8877-012ee2a32fc0","unitOfMeasurement":"albatross.nounit"}





  
