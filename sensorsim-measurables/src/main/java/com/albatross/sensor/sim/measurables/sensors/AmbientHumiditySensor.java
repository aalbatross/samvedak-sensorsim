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
import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 *
 * @author iamrp
 */
public class AmbientHumiditySensor extends Sensor{

    private static final String PRODUCT = "albatross";
    private static final String NAME = "Ambient_Humidity_Sensor";
    private static final String MEASURED_UNIT = "%";
 
    public AmbientHumiditySensor(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName, new SimulationDataDistribution( new BinomialDistribution(100,.8)) );
    }
    
    public AmbientHumiditySensor(long samplingFrequency, String friendlyName, SimulationDataDistribution distribution) {
        super(samplingFrequency, friendlyName, distribution);
    }

    public Type getType() {
        return new Type(Type.IsMeasuredAs.SENSOR, Category.SENSOR_HUMIDITY, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
   }
    
}
