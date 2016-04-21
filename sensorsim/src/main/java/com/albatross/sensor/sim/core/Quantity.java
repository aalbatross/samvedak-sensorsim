package com.albatross.sensor.sim.core;

import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;

/**
 *
 * The measured value object from Measurer's.
 * @author iamrp
 * @param <T>
 * 
 */
public class Quantity<T> {
	
	private Type type;
	private T value;
	private long timeOfOccurence;
	private UUID sourceID;
	private String unitOfMeasurement;

    /**
     *
     * @param type
     * @param value
     * @param sourceID
     */
    public Quantity(Type type, T value, UUID sourceID) {
		super();
		this.type = type;
		this.value = value;
		this.sourceID = sourceID;
		this.unitOfMeasurement = this.type.getMeasurementUnits();
		this.timeOfOccurence = new Date().getTime();
	}

    /**
     *
     * @return
     */
    public Type getType() {
		return type;
	}

    /**
     *
     * @return the value of quantity measured.
     */
    public T getValue() {
		return value;
	}

    /**
     *
     * @param value
     */
    public void setValue(T value) {
		this.value = value;
		this.timeOfOccurence = new Date().getTime();
	}

    /**
     *
     * @return time when the value was recorded.
     */
    public long getTimeOfOccurence() {
		return timeOfOccurence;
	}

    /**
     *
     * @return UniqueID of the source of data, source will be a Measurer object.
     */
    public UUID getSourceID() {
		return sourceID;
	}

    /**
     *
     * @return unit in which readings are taken
     */
    public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

    /**
     *
     * @param unitOfMeasurement
     */
    public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

    /**
     *
     * @return
     */
    @Override
	public String toString() {
		return "Quantity [type=" + type + ", value=" + value + ", timeOfOccurence=" + timeOfOccurence + ", sourceID="
				+ sourceID + ", unitOfMeasurement=" + unitOfMeasurement + "]";
	}

    /**
     *
     * @return json representation of the Quantity object
     */
    public String getJsonString(){
		Gson g = new Gson();
		return g.toJson(this);
	}
	
    /**
     *
     * @return
     */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sourceID == null) ? 0 : sourceID.hashCode());
		result = prime * result + (int) (timeOfOccurence ^ (timeOfOccurence >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((unitOfMeasurement == null) ? 0 : unitOfMeasurement.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

    /**
     *
     * @param obj
     * @return
     */
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Quantity))
			return false;
		Quantity other = (Quantity) obj;
		if (sourceID == null) {
			if (other.sourceID != null)
				return false;
		} else if (!sourceID.equals(other.sourceID))
			return false;
		if (timeOfOccurence != other.timeOfOccurence)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (unitOfMeasurement == null) {
			if (other.unitOfMeasurement != null)
				return false;
		} else if (!unitOfMeasurement.equals(other.unitOfMeasurement))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
