import java.util.Date;
public class Sensor extends Thread {
    String name;// give name to sensor
    int value=0;// default value is =0
    int max;// maximum value for the Sensor
    int min;// minimum value allowed for sensor
    int interval;// time to update the sensor
   
        public Sensor(String name,int min,int max,int interval)
        {
            this.name=name;//setting the name
            this.max=max;//setting max value for the sensor
            this.min=min;// setting minimum value for the sensor
            this.interval=interval;//sampling rate to be set
            this.start(); 
        }

        
        public int getValue() // gives the value of sensor at runtime
        {
         return (this.value);    
        }

        public void setValue(int val)// allows to set value to sensor at runtime
        {
         this.value=val;
        }

        
        
    @Override
    synchronized public void run()
        {
          while(true)
          {
            int v= min + (int)(Math.random()*max);// main funcction generates random values between max and minimum, can be replaced by your own function
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



