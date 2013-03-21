/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensorsimulator;




/**
 *
 * @author admin
 */
public class RFID extends Thread {
   Sensor f,m;
    RFID()
    {
        f=new Sensor("FOOD",0,2,1000);m=new Sensor("MEDICAL",0,2,1000);
        this.start();
        this.setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    synchronized public void run()
    {
       while(true)
       {
           if (f.value == 1) {
               System.out.println("Food Taken");
                try {
                    this.sleep(1000);
                } catch (InterruptedException ex) {
                   ex.printStackTrace();
                }
           }
           if (m.value == 1) {
               System.out.println("Medicine Taken");
           }
       }
    }
}
