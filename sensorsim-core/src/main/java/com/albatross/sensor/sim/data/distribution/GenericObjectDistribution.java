/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.data.distribution;

import java.util.Vector;
import org.apache.commons.math3.distribution.AbstractIntegerDistribution;

/**
 * Class can generate any objects (Character,String,Audio,Video,Files) provided in the dictionary based on the results of IntegerDistribution provided. Result of IntegerDistribution should always be less than equal to Dictionary size.
 * @author iamrp
 */
public class GenericObjectDistribution {
    
    private final Vector dictionary;
    private final AbstractIntegerDistribution distribution;
    
    public GenericObjectDistribution(AbstractIntegerDistribution distribution,Vector dictionary){
        this.dictionary = dictionary;
        this.distribution = distribution;
    }
    
    public Object sample(){
        return this.dictionary.get(this.distribution.sample());
    }
    
    
}
