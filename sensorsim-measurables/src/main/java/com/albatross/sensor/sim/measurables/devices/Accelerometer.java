/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.measurables.devices;

import com.albatross.sensor.sim.core.AbstractMeasurer;
import com.albatross.sensor.sim.core.Device;
import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.Type;
import com.albatross.sensor.sim.measurables.Category;
import com.albatross.sensor.sim.measurables.sensors.AccelerometerAXISSensor;
import com.albatross.sensor.sim.measurables.sensors.GenericSensor;
import java.util.Vector;
import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 *
 * @author iamrp
 */
public class Accelerometer extends Device {

    private static final String PRODUCT = "albatross";
    private static final String NAME = "Accelerometer";
    private static final String MEASURED_UNIT = "m/s^2";


    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param listOfSensors
     */
    public Accelerometer(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName,new Vector<AbstractMeasurer>());
        //Generic sensor creation sensor 1
        AccelerometerAXISSensor sensor1 = new AccelerometerAXISSensor(4000, "X");
        //Generic sensor creation sensor 2
        AccelerometerAXISSensor sensor2 = new AccelerometerAXISSensor(4000, "Y");
        //Generic sensor creation sensor 3
        AccelerometerAXISSensor sensor3 = new AccelerometerAXISSensor(4000, "Z");
        
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
    public Accelerometer(long samplingFrequency, String friendlyName,Vector<AbstractMeasurer> listOfSensors) {
        super(samplingFrequency, friendlyName,listOfSensors);
    }

    /**
     *
     * @return
     */
    public Type getType() {
        return new Type(Type.IsMeasuredAs.DEVICE, Category.DEVICE_ACCELEROMETER, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
    }

}

