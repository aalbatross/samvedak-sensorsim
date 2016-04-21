package com.albatross.sensor.sim.core;

/**
 * Abstraction of Sensor which measures reading of quantifiable object.
 * @author iamrp
 * 
 */
public abstract class Sensor extends AbstractMeasurer {

    /**
     *
     * @param samplingFrequency
     * @param friendlyName
     * @param distribution
     */
    public Sensor(long samplingFrequency, String friendlyName, SimulationDataDistribution distribution) {
		super(samplingFrequency, friendlyName, distribution);
		// TODO Auto-generated constructor stub
	}

    /**
     *
     * @return
     */
    public Quantity<?> generateNextQuantity() {
		if (this.distribution.getDistributionType()
				.equals(SimulationDataDistribution.DistributionCategoryType.IntegerDistribution)) {
			this.quantity = new Quantity(this.getType(), this.distribution.getNextIntegerValue(), this.getSensorID());
			return this.quantity;
		}
		if (this.distribution.getDistributionType()
				.equals(SimulationDataDistribution.DistributionCategoryType.RealDistribution)) {
			this.quantity = new Quantity(this.getType(), this.distribution.getNextRealValue(), this.getSensorID());
			return this.quantity;
		}
		return null;
	}

}
