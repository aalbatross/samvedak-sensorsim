package com.albatross.sensor.sim.measurables.sensors;

import com.albatross.sensor.sim.measurables.Category;
import com.albatross.sensor.sim.core.Sensor;
import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.Type;

/**
 * Generic Sensor Implementation using the API.
 * @author iamrp 
 * 
 */
public class GenericSensor extends Sensor {

    private static final String PRODUCT = "albatross";
    private static final String NAME = "albatross.genericsensor";
    private static final String MEASURED_UNIT = "albatross.virtualunits";

    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param distribution
     */
    public GenericSensor(long samplingFrequency, String friendlyName, SimulationDataDistribution distribution) {
        super(samplingFrequency, friendlyName, distribution);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    public Type getType() {
        // TODO Auto-generated method stub
        return new Type(Type.IsMeasuredAs.SENSOR, Category.SENSOR_GENERIC, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
    }

}
