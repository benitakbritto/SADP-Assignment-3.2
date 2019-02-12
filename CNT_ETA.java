package travel_reminder;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class CNT_ETA implements INT_ETA {

    private Scanner sc;
    private int distance;
    private int time;
    private static int DIST_TIME_CONVERSION_FACTOR = 5;

    private void alarmTrigger() {
        char stop = 'Y';
        System.out.println("ALERT!");
        System.out.println("Alarm rings\nAlmost there\nWake up");

        sc = new Scanner(System.in);

        while (stop != 'X' && stop != 'x') {
            System.out.println("Enter X to stop alarm");
            stop = sc.next().charAt(0);
        }

        sc.close();
        System.out.println("-----------------------------------------------");
    }

    private String HoursMinute(int time) {
        if (time >= 60) {
            System.out.println("Time to destination is " + (time / 60) + " hrs and " + (time % 60) + " mins");
        } else {
            System.out.println("Time to destination is " + time + "mins");
        }
        return "" + (time / 60) + " hrs and " + (time % 60) + " mins";

    }

    private int calculateDistance(int graph[][], int src_i, int dest_i) {
        CNT_iMap mapObj = new CNT_Map();
        this.distance = mapObj.dijkstra(graph, src_i, dest_i);
        return this.distance;
    }

    private int calculateTime() {

        this.time = this.distance * DIST_TIME_CONVERSION_FACTOR;

        HoursMinute(time);
        return time;
    }

    private void decrementTime() {

        int time = calculateTime();
        try {
            while (time > 5) {
                time -= 1;
                System.out.println("Time to destination = " + time);
                TimeUnit.MILLISECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
        alarmTrigger();
    }

    public int displayTime() {

        return this.time;
    }

    public int displayDistance() {
        return this.distance;
    }

    private void goToStart() {
        char q_char = 'n';
        sc = new Scanner(System.in);
        while (q_char != 'Q' && q_char != 'q') {
            System.out.println("Enter Q to quit");
            q_char = sc.next().charAt(0);
        }
        System.out.println("------------------------------------------------");
        System.exit(0);
    }

    public void test_ETA(int graph[][], int src_i, int dest_i) {
        calculateDistance(graph, src_i, dest_i);
        decrementTime();

        System.out.println("Journey report:");
        System.out.println("Time taken = " + displayTime() + " mins");
        System.out.println("Distance = " + displayDistance() + "km");
    }
}