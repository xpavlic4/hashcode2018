package com.laurinka;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        File in = new File("c_no_hurry.in");
        System.out.println(in.getAbsolutePath());
        BufferedReader fr = new BufferedReader(new
                FileReader(in));
        String line = fr.readLine();
        String[] split = line.split(" ");

        File f = new File("out");
        FileWriter fileWriter = new FileWriter(f);
        StringBuffer sb = new StringBuffer();
        int rides = Integer.valueOf(split[3]);
        int vehicles = Integer.valueOf(split[2]);
        System.out.println("Vehicles: " + vehicles);
        for (int i = 0; i< rides; i++) {
            sb.append(" "+ i);
        }
        for (int j = 0; j< vehicles; j++) {
            if (j == 0) {
                fileWriter.write(rides  + sb.toString());
            } else {
                fileWriter.write("0");
            }
            fileWriter.write( System.lineSeparator());
        }
//        fileWriter.write(rides + "" + sb.toString());
//        fileWriter.write(System.lineSeparator());
        fileWriter.close();
    }
}
