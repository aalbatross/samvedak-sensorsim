package com.albatross.sensor.sim.core;

import org.apache.commons.math3.distribution.AbstractIntegerDistribution;
import org.apache.commons.math3.distribution.AbstractRealDistribution;

/**
 * DataDistribution of the simulated sensor/device measurement.
 * @author iamrp
 * 
 */
public class SimulationDataDistribution {

    /**
     *
     */
    public enum DistributionCategoryType {

            /**
             *
             */
            IntegerDistribution,

            /**
             *
             */
            RealDistribution
	};

	private DistributionCategoryType distributionType;

	private AbstractIntegerDistribution integerDistribution;
	private AbstractRealDistribution realDistribution;

    /**
     *
     * @param distribution
     */
    public SimulationDataDistribution(AbstractIntegerDistribution distribution) {

		distributionType = distributionType.IntegerDistribution;
		integerDistribution = distribution;
	}

    /**
     *
     * @param distribution
     */
    public SimulationDataDistribution(AbstractRealDistribution distribution) {

		distributionType = distributionType.RealDistribution;
		realDistribution = distribution;
	}

    /**
     *
     * @return
     */
    public DistributionCategoryType getDistributionType() {
		return distributionType;
	}

    /**
     *
     * @return
     */
    public int getNextIntegerValue() {
		if (integerDistribution == null) {
			System.err.println("Not allowed on real distribution");
			return Integer.MIN_VALUE;
		}
		return integerDistribution.sample();
	}

    /**
     *
     * @return
     */
    public double getNextRealValue() {
		if (realDistribution == null) {
			System.err.println("Not allowed on integer distribution");
			return Double.MIN_VALUE;
		}
		return realDistribution.sample();
	}

}
