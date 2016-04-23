/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.measurables.sensors;

import com.albatross.sensor.sim.measurables.Category;
import com.albatross.sensor.sim.core.Sensor;
import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.Type;
import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 *
 * @author iamrp
 */
public class AmbientTemperatureSensor extends Sensor{

    private static final String PRODUCT = "albatross";
    private static final String NAME = "Ambient_Temperature_Sensor";
    private static final String MEASURED_UNIT = "degreeCelsius";
 
    public AmbientTemperatureSensor(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName, new SimulationDataDistribution( new BinomialDistribution(50,.8)) );
    }
    
    public AmbientTemperatureSensor(long samplingFrequency, String friendlyName, SimulationDataDistribution distribution) {
        super(samplingFrequency, friendlyName, distribution);
    }

    public Type getType() {
        return new Type(Type.IsMeasuredAs.SENSOR, Category.SENSOR_TEMPERATURE, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
   }
    
}
