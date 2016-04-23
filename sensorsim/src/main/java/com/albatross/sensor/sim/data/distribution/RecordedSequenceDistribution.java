/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatross.sensor.sim.data.distribution;

import java.util.Vector;

/**
 * This class generates dictionary values in sequence. After completion of the dictionary it restarts from first.
 * @author iamrp
 */
public class RecordedSequenceDistribution {
    private final Vector dictionary;
    int currentVal=0;
    public RecordedSequenceDistribution(Vector dictionary){
        this.dictionary = dictionary;
    }
    
    public Object sample(){

        Object ret =this.dictionary.get(currentVal);
        currentVal++;
        if(currentVal>dictionary.size()-1)
            currentVal=0;
        return ret;
    }
    
}
