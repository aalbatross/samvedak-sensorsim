/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.measurables.sensors;

import com.albatross.sensor.sim.core.Sensor;
import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.Type;
import com.albatross.sensor.sim.measurables.Category;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 *
 * @author iamrp
 */
public class AccelerometerAXISSensor extends Sensor{

    private static final String PRODUCT = "albatross";
    private static final String NAME = "Accelerometer_AXIS";
    private static final String MEASURED_UNIT = "m/s^2";
 
    public AccelerometerAXISSensor(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName, new SimulationDataDistribution( new NormalDistribution(.5,.3)) );
    }
    
    public AccelerometerAXISSensor(long samplingFrequency, String friendlyName, SimulationDataDistribution distribution) {
        super(samplingFrequency, friendlyName, distribution);
    }

    public Type getType() {
        return new Type(Type.IsMeasuredAs.SENSOR, Category.SENSOR_HUMIDITY, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
   }
    
}

