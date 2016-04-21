package com.albatross.sensor.sim.measurables;

import com.albatross.sensor.sim.core.Category;
import com.albatross.sensor.sim.core.Device;
import com.albatross.sensor.sim.core.Type;

/**
 * Generic Device Implementation using the API.
 * @author iamrp 
 */
public class GenericDevice extends Device {

    private static String PRODUCT = "albatross";
    private static String NAME = "albatross.genericdevice";
    private static String MEASURED_UNIT = "albatross.nounit";

    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     */
    public GenericDevice(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    public Type getType() {
        // TODO Auto-generated method stub
        return new Type(Type.IsMeasuredAs.DEVICE, Category.DEVICE_GENERIC, PRODUCT, NAME, MEASURED_UNIT,this.getFriendlyName());
    }

}
