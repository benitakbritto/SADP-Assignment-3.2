import java.io.*;
import travel_reminder.*;
public class Tester
{
  public static void main(String Args[])
  {
      INT_Account i = new INT_Account();
      ENT_Client e = new ENT_Client();
      CNT_IAccount c = new CNT_Account(i, e);

      i.getUsernamePassword();
      e.initializeClients();

      if(c.validateLoginInfo(i.getUsername(), i.getPassword()))
      {
        CNT_SourceDest SD_obj= new CNT_SourceDest();
        ENT_Location Loc_Obj = new ENT_Location();
        SD_obj.getSourceDest(Loc_Obj);

        CNT_iGPS gps_obj = new CNT_GPS();
        gps_obj.isGpsWeak();

        CNT_iMap map_obj = new CNT_Map();

        CNT_ETA eta_obj = new CNT_ETA();

        int source_index = SD_obj.getSourceIndex();
        int dest_index = SD_obj.getDestIndex();
        eta_obj.test_ETA(Loc_Obj.graph, source_index, dest_index);
    }
    else
    {
        System.exit(0);
    }

  }
}







/*  int source_index= 2;
  int dest_index = 4;

  int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                             {4, 0, 8, 0, 0, 0, 0, 11, 0},
                             {0, 8, 0, 7, 0, 4, 0, 0, 2},
                             {0, 0, 7, 0, 9, 14, 0, 0, 0},
                             {0, 0, 0, 9, 0, 10, 0, 0, 0},
                             {0, 0, 4, 14, 10, 0, 2, 0, 0},
                             {0, 0, 0, 0, 0, 2, 0, 1, 6},
                             {8, 11, 0, 0, 0, 0, 1, 0, 7},
                             {0, 0, 2, 0, 0, 0, 6, 7, 0}
                           };
  int distance = map_obj.dijkstra(graph, source_index, dest_index);
  System.out.println(distance);*/
