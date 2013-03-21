/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensorsimulator;



/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        new Sender("2",5000).start();
        new Sender("3",5000).start();
        new Sender("4",5000).start();
        new Sender("5",5000).start();
       
        
    }



       

  


   

}
