package travel_reminder;


import java.io.*;
import java.util.Scanner;
public class CNT_SourceDest{

    INT_SourceDest ISD=new INT_SourceDest();
    private String source;
    private String destination;
    private int source_index;
    private int dest_index;


    public void setSourceIndex(int s_index){
        source_index=s_index;
    }

    public void setDestIndex(int d_index){
        dest_index=d_index;
    }

    public int getSourceIndex(){
        return source_index;
    }
    public int getDestIndex(){
        return dest_index;
    }

    public boolean validateLocation(ENT_Location imapObj, String source, String destination)
    {
        int source_index = -1;
        int dest_index = -1;
      //  System.out.println("Size of location : "+ imapObj.location.length);
        for (int i=0; i<imapObj.location.length; i++)
        {
            if(imapObj.location[i].equals(source))
            {
                source_index = i;
                setSourceIndex(source_index);
            }

            if(imapObj.location[i].equals(destination) )
            {
                dest_index = i;
                setDestIndex(dest_index);
            }

        }

        if(source_index == dest_index){
            System.out.println("Invalid Input");
            System.out.println("--------------------");
            return false;
        }

        if(source_index!=-1 && dest_index!=-1)
        {
            System.out.println("Valid Input");
            return true;
        }

        System.out.println("Invalid Source or Destination!");
        return false;
    }



    public void getSourceDest(ENT_Location imapObj){

      source=ISD.getSource();
      destination=ISD.getDest();
       while(!validateLocation(imapObj,  source,  destination)){
         source=ISD.getSource();
         destination=ISD.getDest();
       }
    }



}
