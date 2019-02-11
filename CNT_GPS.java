import java.io.*;
import java.util.Random;


public class CNT_GPS implements CNT_iGPS
{

 /* Used to get the number of bars/strength in mobile network
 * Maximum number of bars is five
 * @return int bar_number the number of bars in the network
 */
  public int getMobileNetwork()
  {
    /*
    * generating the strength/ bar number randomly
    */
    Random rand = new Random();
    int bar_number = rand.nextInt(5);
    return bar_number;
  }

  public void isGpsWeak()
  {
    /*
     * calls functions getMobileNetwork() to determine
     * the number of bars/strength
     */
     int bar_number = getMobileNetwork();
    if(bar_number == 0 || bar_number == 1)
    {
        /*
         * network is weak
         * and hence, it tries to check the connectivity again
         */
        System.out.println("GPS connectivity is weak");
        System.out.println("Reconnecting");
        /*
         * connectivity is still weak, then exit the application
         * else, continue with the application
         */
        if(getMobileNetwork() == 0 || getMobileNetwork() == 1)
        {
            System.out.println("Exiting application");
            System.exit(0);
        }
    }
  }

}
