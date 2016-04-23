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
    public Device(long samplingFrequency, String friendlyName,Vector<AbstractMeasurer> listOfSensors) {
        super(samplingFrequency, friendlyName, new SimulationDataDistribution(new BinomialDistribution(1000, .40)));
        this.listOfSensors = listOfSensors;
        ensureAllSensorsAreStart();
        // TODO Auto-generated constructor stub
    }

    private void ensureAllSensorsAreStart() {
        for (AbstractMeasurer listOfSensor : listOfSensors) {
            if (!listOfSensor.isAlive()) {
                listOfSensor.start();
            }
        }
    }

    /**
     *
     */
    @Override
    public void start() {
        super.start();
        ensureAllSensorsAreStart();
    }

    /**
     *
     * @param sensor
     */
    protected void addSensorOrDevice(AbstractMeasurer sensor) {
        listOfSensors.addElement(sensor);
        if (!sensor.isAlive()) {
            sensor.start();
        }
    }

    /**
     *
     * @param sensor
     */
    protected void removeSensorOrDevice(AbstractMeasurer sensor) {
        listOfSensors.removeElement(sensor);
    }

    /**
     *
     * @return
     */
    public Quantity<?> generateNextQuantity() {
        List<Quantity> value = new ArrayList<Quantity>();
        for (AbstractMeasurer listOfSensor : listOfSensors) {
            value.add(listOfSensor.getQuantity());
        }
        return new Quantity(this.getType(), value, this.getSensorID());
    }

}
