package com.albatross.sensor.sim.core;

import java.util.ArrayList;
import java.util.UUID;

import com.albatross.sensor.sim.core.events.QuantityChangeEvent;
import com.albatross.sensor.sim.core.events.QuantityListener;

/**
 * Abstract Class for Measurer
 * @author iamrp
 */
public abstract class AbstractMeasurer extends Thread implements Measurer {

    private long samplingFrequency;
    private UUID sensorID;
    private String friendlyName;
    private boolean isStarted=false;
    /**
     *
     */
    protected SimulationDataDistribution distribution;
    private ArrayList<QuantityListener> listeners;

    /**
     *
     */
    protected Quantity<?> quantity;

    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param distribution
     */
    public AbstractMeasurer(long samplingFrequency, String friendlyName, SimulationDataDistribution distribution) {
        super();
        this.samplingFrequency = samplingFrequency;
        this.sensorID = UUID.randomUUID();
        this.friendlyName = friendlyName;
        this.setDistribution(distribution);
        this.listeners = new ArrayList<QuantityListener>();
    }

    /**
     *
     * @return sampling frequency
     */
    public long getSamplingFrequency() {
        return samplingFrequency;
    }

    /**
     *
     * @param samplingFrequency
     */
    public void setSamplingFrequency(long samplingFrequency) {
        this.samplingFrequency = samplingFrequency;
    }

    /**
     *
     * @return UUID of Device/Sensor
     */
    public UUID getSensorID() {
        return sensorID;
    }

    /**
     *
     * @return String representation of FriendlyName
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    @Override
    public void start(){
        isStarted = true;
        super.start();
    }
    
    /**
     *
     */
    @Override
    public void run() {
        while (isStarted) {
            Quantity value = this.generateNextQuantity();
            if (value != null) {
                sendQuantityChangeEventToAllListener(new QuantityChangeEvent(this, value));
                this.quantity = value;
            }
            try {
                this.sleep(samplingFrequency);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void sendQuantityChangeEventToAllListener(QuantityChangeEvent event) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).getQuantityChangeValues(event);
        }
    }

    /**
     *
     * @return value of measurable thing
     */
    public Quantity<?> getQuantity() {
        return (this.quantity != null ? this.quantity : null);
    }

    /**
     *
     * @param listener
     */
    public void addQuantityListener(QuantityListener listener) {
        listeners.add(listener);
    }

    /**
     *
     * @param listener
     */
    public void removeQuantityListener(QuantityListener listener) {
        listeners.remove(listener);
    }

    /**
     *
     * @return simulation data distribution
     */
    public SimulationDataDistribution getDistribution() {
        return distribution;
    }

    /**
     *
     * @param distribution
     */
    public void setDistribution(SimulationDataDistribution distribution) {
        this.distribution = distribution;
    }

    /**
     * stops the device or sensor 
     */
    public void stopMeasurer(){
        isStarted = false;
        this.quantity = null;
    }
}
