package day6;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class part2 {
    public static void main(String[] args){
        ArrayList<String> dat = new ArrayList<String>();
        dataToList(dat, "day6/data.txt");
        long answer = distanceCalc(dat);
        System.out.println(answer);
    }

    public static void dataToList(ArrayList<String> arr, String fName){
        try {
            File myObj = new File(fName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              arr.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static long distanceCalc(ArrayList<String> dat){
        long maxDistance, tempTime, ans = 0; //make time and distance placeholders
        String[] times = dat.get(0).split("\\s+");
        String[] distances = dat.get(1).split("\\s+");
        String combinedTimes = times[0] + times[1] + times[2] + times[3];
        String combinedDistances = distances[0] + distances[1] + distances[2] + distances[3];
        maxDistance = Long.parseLong(combinedDistances); //convert to longs
        tempTime = Long.parseLong(combinedTimes);
        //System.out.println(maxDistance + " " + tempTime);
        for (long i = 0; i < tempTime; i++){  //use longs
            if (i * (tempTime - i) > maxDistance){
                ans += 1;
            }
        }
        return ans;
    }
}
