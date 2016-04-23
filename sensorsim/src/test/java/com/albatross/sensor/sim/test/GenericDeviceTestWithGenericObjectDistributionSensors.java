/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.test;

import com.albatross.sensor.sim.core.AbstractMeasurer;
import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;
import com.albatross.sensor.sim.data.distribution.GenericObjectDistribution;
import com.albatross.sensor.sim.measurables.GenericDevice;
import com.albatross.sensor.sim.measurables.GenericSensor;
import java.util.Vector;
import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 *
 * @author iamrp
 */
public class GenericDeviceTestWithGenericObjectDistributionSensors implements QuantityListener {

    public static void main(String[] args) {
        //Quantity Listener listening device values
        GenericDeviceTest test = new GenericDeviceTest();
        //Generic sensor creation sensor 1
        Vector dictionary= new Vector();
        dictionary.add("Ravi");
        dictionary.add("Kavi");
        dictionary.add("Pavi");
        GenericSensor sensor1 = new GenericSensor(4000, "GENERICObjectSENSORTEST1",
                new SimulationDataDistribution(new GenericObjectDistribution(new BinomialDistribution(3, .40),dictionary)));
        //Generic sensor creation sensor 2
        GenericSensor sensor2 = new GenericSensor(4000, "GENERICSENSORTEST2",
                new SimulationDataDistribution(new BinomialDistribution(1000, .30)));
        //Generic Device instantiation
        Vector<AbstractMeasurer> values= new Vector<AbstractMeasurer>();
        values.add(sensor2);
        values.add(sensor1);
        
        GenericDevice device = new GenericDevice(4000, "GENERICDEVICETEST",values);
        device.addQuantityListener(test);
        //starting the device
        device.start();

    }

    public void getQuantityChangeValues(QuantityChangeEvent evt) {
        // TODO Auto-generated method stub
        System.out.println(evt.getValue().getJsonString());
    }

}
