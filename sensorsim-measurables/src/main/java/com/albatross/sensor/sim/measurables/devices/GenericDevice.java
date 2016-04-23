package com.albatross.sensor.sim.measurables.devices;



import com.albatross.sensor.sim.core.AbstractMeasurer;
import com.albatross.sensor.sim.measurables.Category;
import com.albatross.sensor.sim.core.Device;
import com.albatross.sensor.sim.core.Type;
import java.util.Vector;

/**
 * Generic Device Implementation using the API.
 * @author iamrp 
 */
public class GenericDevice extends Device {

    private static final String PRODUCT = "albatross";
    private static final String NAME = "albatross.genericdevice";
    private static final String MEASURED_UNIT = "albatross.nounit";

    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param listOfSensors
     */
    public GenericDevice(long samplingFrequency, String friendlyName,Vector<AbstractMeasurer> listOfSensors) {
        super(samplingFrequency, friendlyName,listOfSensors);
    }

    /**
     *
     * @return
     */
    public Type getType() {
        return new Type(Type.IsMeasuredAs.DEVICE, Category.DEVICE_GENERIC, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
    }

}
