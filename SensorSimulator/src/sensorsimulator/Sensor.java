/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensorsimulator;

import java.net.InetAddress;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author Admin
 */
public class Sensor extends Thread {
    String name;
    int value=0;
    int max;
    int min;
    int interval;
   
        public Sensor(String name,int min,int max,int interval)
        {
            this.name=name;
            this.max=max;
            this.min=min;
            this.interval=interval;
            this.start();
        }

        
        public int getValue()
        {
         return (this.value);    
        }

        public void setValue(int val)
        {
         this.value=val;
        }

        
        
    @Override
    synchronized public void run()
        {
          while(true)
          {
            int v= min + (int)(Math.random()*max);
            //System.out.println(this.name+ ": "+this.value+": time- "+new Date().toString());
            this.setValue(v);
            try {
                this.sleep(interval);
                }
            catch (InterruptedException ex)
                {
                ex.printStackTrace();
                System.gc();
                }
            }
        }









   








    





   



    }
 

class Sender extends Thread
 {
    String patid;
    long sampling;
    Sensor s1=new Sensor("HeartRate",1,100,1000);
    Sensor s2=new Sensor("Temperature",1,120,1000);
    Sensor s3=new Sensor("respRate",1,60,1000);
   
    Sensor s5=new Sensor("BatteryStatus",1,100,1000);
    Sensor s6=new Sensor("posture",1,20,1000);
    Sensor s7=new Sensor("ECG",1,20,1000);
    Sensor s8=new Sensor("SPO2",1,100,1000);
    Sensor s9=new Sensor("BP sys",1,100,1000);
    Sensor s10=new Sensor("BP dis",1,100,1000);
   /* Sensor Food=new Sensor("Food",0,2,1000);
    Sensor MED=new Sensor("Med",0,2,1000);*/
    
    Accelerometer acc=new Accelerometer();
     Sender(String patid,long sampling)
    {
    this.patid=patid;
    this.sampling=sampling;
    
     }

    @Override
    synchronized public void run()
    {

                while(true)
                {
                    try {
                        this.sleep(sampling);
                        Date date = new Date();
                        Format formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
                        String dat = formatter.format(date);
                        //xmlconvert(this.patid, s1.value + "", s2.value + "", s3.value + "", s4.value + "", s5.value + "", s6.value + "", s7.value + "", dat);
                        System.out.println("Data Sent            "+  this.patid +" "+ s1.value +" "+s2.value+" "+ s3.value+"  "+s5.value+" "+s6.value+" "+s7.value+" "+ dat);
                        //xmlAccelerometer(this.patid,acc.X.value+"",acc.Y.value+"",acc.Z.value+"",dat);
                      getSensorData(Integer.parseInt(this.patid),s1.value,(float)s3.value,s7.value,acc.X.value,acc.Y.value,acc.Z.value,s6.value,s2.value,s5.value,s8.value,s9.value,s10.value,new Date().toString(),InetAddress.getLocalHost().getHostAddress());
                        System.out.println("Data Sent Accelerometer");
                     
   /* if(Food.value==1)
                      {
                      // xmlconvertfrfid(this.patid,"r1",dat);
                       System.out.println("Data Sent");
                      }
                      
                     if(MED.value==1)
                     {
                      //  medrfid("101","m1",dat);
                        System.out.println("Data Sent");
                     }
     */
                                              

                    } catch (Exception ex) {
                      ex.printStackTrace();
                      System.exit(1);
                     }
        }
    }


     private static void getSensorData(int arg0, int arg1, float arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, java.lang.String arg13, java.lang.String arg14) {
        org.services.Sensors_Service service = new org.services.Sensors_Service();
        org.services.Sensors port = service.getSensorsPort();
        port.getSensorData(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }


 }
