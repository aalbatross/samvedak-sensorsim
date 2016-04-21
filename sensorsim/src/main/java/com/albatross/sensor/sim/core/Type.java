package com.albatross.sensor.sim.core;

/**
 * Defines Measurer's attributes.
 * @author iamrp
 * 
 */
public class Type {

    
    /**
     *
     */
    public enum IsMeasuredAs {

        /**
         *
         */
        SENSOR,

            /**
             *
             */
            DEVICE
	};

	private IsMeasuredAs type;
	private String ofCategory;
	private String productOf;
	private String name;
	private String measurementUnits;
        private String friendlyName;
    /**
     *
     * @param type
     * @param ofCategory
     * @param productOf
     * @param name
     * @param measurementUnits
     */
    public Type(IsMeasuredAs type, String ofCategory, String productOf, String name, String measurementUnits,String friendlyName) {
		super();
		this.type = type;
		this.ofCategory = ofCategory;
		this.productOf = productOf;
		this.name = name;
		this.measurementUnits = measurementUnits;
                this.friendlyName = friendlyName;
	}

    /**
     *
     * @return
     */
    public String getOfCategory() {
		return ofCategory;
	}

    /**
     *
     * @param ofCategory
     */
    public void setOfCategory(String ofCategory) {
		this.ofCategory = ofCategory;
	}

    /**
     *
     * @return
     */
    public String getProductOf() {
		return productOf;
	}

    /**
     *
     * @param productOf
     */
    public void setProductOf(String productOf) {
		this.productOf = productOf;
	}

    /**
     *
     * @return
     */
    public IsMeasuredAs getType() {
		return type;
	}

    /**
     *
     * @param type
     */
    public void setType(IsMeasuredAs type) {
		this.type = type;
	}

    /**
     *
     * @return
     */
    public String getName() {
		return name;
	}

    /**
     *
     * @param name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     *
     * @return
     */
    public String getMeasurementUnits() {
		return measurementUnits;
	}

    /**
     *
     * @param measurementUnits
     */
    public void setMeasurementUnits(String measurementUnits) {
		this.measurementUnits = measurementUnits;
	}

    
    /**
     * @return the friendlyName
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    @Override
    public String toString() {
        return "Type{" + "type=" + type + ", ofCategory=" + ofCategory + ", productOf=" + productOf + ", name=" + name + ", measurementUnits=" + measurementUnits + ", friendlyName=" + friendlyName + '}';
    }


}
