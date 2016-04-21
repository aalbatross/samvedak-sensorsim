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
