/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.measurables.devices;

import com.albatross.sensor.sim.core.AbstractMeasurer;
import com.albatross.sensor.sim.core.Device;
import com.albatross.sensor.sim.core.Type;
import com.albatross.sensor.sim.measurables.Category;
import com.albatross.sensor.sim.measurables.sensors.AccelerometerAXISSensor;
import com.albatross.sensor.sim.measurables.sensors.AmbientHumiditySensor;
import com.albatross.sensor.sim.measurables.sensors.AmbientTemperatureSensor;
import java.util.Vector;

/**
 *
 * @author iamrp
 */
public class SmartPhone extends Device {

    private static final String PRODUCT = "albatross";
    private static final String NAME = "SmartPhone";
    private static final String MEASURED_UNIT = "no units";


    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param listOfSensors
     */
    public SmartPhone(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName,new Vector<AbstractMeasurer>());
        //Generic sensor creation sensor 1
        Accelerometer sensor1 = new Accelerometer(4000, "Accelerometer");
        //Generic sensor creation sensor 2
        AmbientHumiditySensor sensor2 = new AmbientHumiditySensor(4000, "Humidity");
        //Generic sensor creation sensor 3
        AmbientTemperatureSensor sensor3 = new AmbientTemperatureSensor(4000, "Temperature");
        
        this.addSensorOrDevice(sensor1);
        this.addSensorOrDevice(sensor2);
        this.addSensorOrDevice(sensor3);
        this.ensureAllSensorsAreStart();
    }

    
    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param listOfSensors
     */
    public SmartPhone(long samplingFrequency, String friendlyName,Vector<AbstractMeasurer> listOfSensors) {
        super(samplingFrequency, friendlyName,listOfSensors);
    }

    /**
     *
     * @return
     */
    public Type getType() {
        return new Type(Type.IsMeasuredAs.DEVICE, Category.DEVICE_SMARTPHONE, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
    }

}


