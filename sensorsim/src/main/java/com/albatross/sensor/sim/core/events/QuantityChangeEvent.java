package com.albatross.sensor.sim.core.events;

import com.albatross.sensor.sim.core.Measurer;
import com.albatross.sensor.sim.core.Quantity;

/**
 * Event used for notifying the Quantity Listeners about change in measurement.
 * @author iamrp 
 * 
 */
public class QuantityChangeEvent {

    private Measurer source;
    private Quantity value;

    /**
     *
     * @param source
     * @param value
     */
    public QuantityChangeEvent(Measurer source, Quantity value) {
        super();
        this.source = source;
        this.value = value;
    }

    /**
     *
     * @return Source it can be a Sensor/Device.
     */
    public Measurer getSource() {
        return source;
    }

    /**
     *
     * @param source
     */
    public void setSource(Measurer source) {
        this.source = source;
    }

    /**
     *
     * @return
     */
    public Quantity getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(Quantity value) {
        this.value = value;
    }

}
