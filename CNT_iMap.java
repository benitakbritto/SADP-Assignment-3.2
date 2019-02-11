import java.io.*;

interface CNT_iMap
{

  public int dijkstra(int graph[][], int src, int dest_index);

  public int printShortestDistance(int dist[], int n, int dest_index);
}
