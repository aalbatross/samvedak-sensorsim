package com.albatross.sensor.sim.measurables;

import com.albatross.sensor.sim.core.Category;
import com.albatross.sensor.sim.core.Sensor;
import com.albatross.sensor.sim.core.SimulationDataDistribution;
import com.albatross.sensor.sim.core.Type;

/**
 * Generic Sensor Implementation using the API.
 * @author iamrp 
 * 
 */
public class GenericSensor extends Sensor {

    private static String PRODUCT = "albatross";
    private static String NAME = "albatross.genericsensor";
    private static String MEASURED_UNIT = "albatross.virtualunits";

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
        return new Type(Type.IsMeasuredAs.SENSOR, Category.SENSOR_GENERIC, PRODUCT, NAME, MEASURED_UNIT);
    }

}
