import java.io.*;

public class Tester
{
  public static void main(String[] args)
  {
    CNT_iGPS gps_obj = new CNT_GPS();
    gps_obj.isGpsWeak();

      CNT_iMap map_obj = new CNT_Map();
      //
      int source_index= 2;
      int dest_index = 4;
      //
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
      System.out.println(distance);
  }
}
