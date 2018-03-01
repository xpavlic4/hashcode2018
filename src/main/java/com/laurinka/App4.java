package com.laurinka;

import sun.tools.tree.BooleanExpression;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App4
{
    private static Integer vehicles;

    public static void main(String[] args ) throws IOException {
        process("a_example.in", "a.out");
        process("b_should_be_easy.in", "b.out");
        process("c_no_hurry.in", "c.out");
        process("d_metropolis.in", "d.out");
        process("e_high_bonus.in", "e.out");
    }
     static void process (String input, String output) throws IOException {
//         System.out.println( "Hello World!" );
         File in = new File(input);
//         System.out.println(in.getAbsolutePath());
         BufferedReader fr = new BufferedReader(new
                 FileReader(in));
         String line = fr.readLine();

         String[] split = line.split(" ");
         vehicles = Integer.valueOf(split[2]);
         int rides = Integer.valueOf(split[3]);

         String l;
         List<String> records = new ArrayList<String>();
         while ((l = fr.readLine()) != null)
         {
             records.add(l);
         }
         fr.close();

         int[] lenghts = new int[rides];
         for (int i = 0; i< lenghts.length; i ++){
             String s = records.get(i);
             String[] split1 = s.split(" ");
             int d = Math.abs(Integer.valueOf(split1[0]) - Integer.valueOf(split1[2]));
             int d2 = Math.abs(Integer.valueOf(split1[1]) - Integer.valueOf(split1[3]));
             lenghts[i] = d+d2;
         }

         String[] vehiclesRides = new String[vehicles];
         int[] vehicleAt1 = new int[vehicles];
         int[] vehicleAt2 = new int[vehicles];

         int[] vehiclesTime = new int[vehicles];
         for(int i = 0; i< vehicles; i++) {
             vehiclesTime[i] = 0;
             vehicleAt1[i] = 0;
             vehicleAt2[i] = 0;
             vehiclesRides[i] = "";
         }

         boolean[] ridesRidden = new boolean[rides];
         int[] rideStartsAt1 = new int[rides];
         int[] rideStartsAt2 = new int[rides];
         int[] rideEndsAt1 = new int[rides];
         int[] rideEndsAt2 = new int[rides];

         for(int i = 0; i< rides; i++) {
             ridesRidden[i] = false;
             String[] split1 = records.get(i).split(" ");
             rideStartsAt1[i] = Integer.valueOf(split1[0]);
             rideStartsAt2[i] = Integer.valueOf(split1[1]);
             rideEndsAt1[i] = Integer.valueOf(split1[3]);
             rideEndsAt2[i] = Integer.valueOf(split1[4]);
         }

         int ridesTaken = 0;
         while (ridesTaken < rides) {
            int currVehicle = -1;
            int minTime = Integer.MAX_VALUE;
             for (int i = 0; i< vehicles; i++) {
                if (vehiclesTime[i] < minTime) {
                    currVehicle = i;
                    minTime = vehiclesTime[i];
                }
            }
            int rideIndex = Integer.MAX_VALUE;
             int maxDist = Integer.MAX_VALUE;
            int currVehicleAt1 = vehicleAt1[currVehicle];
             int currVehicleAt2 = vehicleAt2[currVehicle];
            for (int i = 0; i < rides; i++ ) {
                 if (!ridesRidden[i]) {
                     int i1 = Math.abs(rideStartsAt1[i] - currVehicleAt1) + Math.abs(rideStartsAt2[i] - currVehicleAt2);
                     if (i1 < maxDist) {
                         maxDist = i1;
                         rideIndex = i;
                     }

                 }
            }
             ridesRidden[rideIndex] = true;
             vehiclesRides[currVehicle] = vehiclesRides[currVehicle] + " " + rideIndex;
             vehiclesTime[currVehicle] = vehiclesTime[currVehicle] + lenghts[rideIndex];
             vehicleAt1[currVehicle] = rideEndsAt1[rideIndex];
             vehicleAt2[currVehicle] = rideEndsAt2[rideIndex];
             ridesTaken++;

         }

         File f = new File(output);
         FileWriter fileWriter = new FileWriter(f);
         for (int i = 0; i< vehiclesRides.length; i++) {
             String s = vehiclesRides[i];
             String[] split1 = s.split(" ");
             fileWriter.write(split1.length -1 + ""+ s);
             fileWriter.write(System.lineSeparator());
         }
         fileWriter.close();
     }

    private static int countTime(String s) {
        return 0;
    }


}
