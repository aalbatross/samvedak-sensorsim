public class App extends Thread
{
  Sensor s;
  int viewRate;// how often to see the output of Sensor
   public static void main(String[] args)
   {
      s= new Sensor("Temperature",0,40,1000);
      this.start();
   }
  synchronized public void run()
  {
      while(true)
      {
          try
            {
             this.sleep(viewRate);
             System.out.println(s.getValue());
            }
          catch(Exception e)
            {
            e.printStackTrace();
            }
      }
  }
}