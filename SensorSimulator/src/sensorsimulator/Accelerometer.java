/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensorsimulator;


/**
 *
 * @author admin
 */
public class Accelerometer extends Thread {

    Sensor X,Y,Z;
    Accelerometer()
    {
         X=new Sensor("Acc.X",-35,10,1000);
         Y=new Sensor("Acc.Y",-30,11,1000);
         Z=new Sensor("Acc.Z",-15,13,1000);
        this.start();
    }
    @Override
   synchronized public void run()
    {
        while(true)
        {
            try {
                this.sleep(5000);
                System.out.println("Accelerometers : AccX "+ this.X.value+" AccY "+ this.Y.value+" AccZ "+ this.Z.value);

            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
        }
    }


}
