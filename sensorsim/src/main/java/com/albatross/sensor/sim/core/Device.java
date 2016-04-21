package com.albatross.sensor.sim.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 * Abstract class representing composition of Components having more than one sensors or devices
 * @author iamrp 
 * 
 */
public abstract class Device extends AbstractMeasurer {

    private Vector<AbstractMeasurer> listOfSensors;

    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     */
    public Device(long samplingFrequency, String friendlyName) {
        super(samplingFrequency, friendlyName, new SimulationDataDistribution(new BinomialDistribution(1000, .40)));
        listOfSensors = new Vector<AbstractMeasurer>();
        // TODO Auto-generated constructor stub
    }

    private void ensureAllSensorsAreStart() {
        for (int i = 0; i < listOfSensors.size(); i++) {
            if (!listOfSensors.get(i).isAlive()) {
                listOfSensors.get(i).start();
            }
        }
    }

    /**
     *
     */
    public void start() {
        super.start();
        ensureAllSensorsAreStart();
    }

    /**
     *
     * @param sensor
     */
    public void addSensorOrDevice(AbstractMeasurer sensor) {
        listOfSensors.addElement(sensor);
        if (!sensor.isAlive()) {
            sensor.start();
        }
    }

    /**
     *
     * @param sensor
     */
    public void removeSensorOrDevice(AbstractMeasurer sensor) {
        listOfSensors.removeElement(sensor);
    }

    /**
     *
     * @return
     */
    public Quantity<?> generateNextQuantity() {
        List<Quantity> value = new ArrayList<Quantity>();
        for (int i = 0; i < listOfSensors.size(); i++) {
            value.add(listOfSensors.get(i).getQuantity());
        }
        return new Quantity(this.getType(), value, this.getSensorID());
    }

}
