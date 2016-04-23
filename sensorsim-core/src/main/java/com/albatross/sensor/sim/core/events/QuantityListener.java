package com.albatross.sensor.sim.core.events;

/**
 *
 * A Listener which listens to latest value of Sensor/Device.
 * @author iamrp
 * 
 */
public interface QuantityListener {

    /**
     *
     * @param evt
     */
    public void getQuantityChangeValues(QuantityChangeEvent evt);

}
