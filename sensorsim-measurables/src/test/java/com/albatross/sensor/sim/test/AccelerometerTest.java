/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.test;

import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;
import com.albatross.sensor.sim.measurables.devices.Accelerometer;

/**
 *
 * @author iamrp
 */
public class AccelerometerTest implements QuantityListener {

    public static void main(String[] args) {
        //Quantity Listener listening device values
        AccelerometerTest test = new AccelerometerTest();
        
        Accelerometer device = new Accelerometer(4000, "GENERICAccelerometer");
        device.addQuantityListener(test);
        //starting the device
        device.start();

    }

    public void getQuantityChangeValues(QuantityChangeEvent evt) {
        // TODO Auto-generated method stub
        System.out.println(evt.getValue().getJsonString());
    }

}

