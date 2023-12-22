package day6;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class part1 {
    public static void main(String[] args){
        ArrayList<String> dat = new ArrayList<String>();
        dataToList(dat, "day6/data.txt");
        int answer = distanceCalc(dat);
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

    public static int distanceCalc(ArrayList<String> dat){
        int maxDistance, tempTime, ans = 1; //make time and distance placeholders
        String[] times = dat.get(0).split("\\s+");
        String[] distances = dat.get(1).split("\\s+");
        for (int i = 0; i < times.length; i++){
            maxDistance = Integer.parseInt(distances[i]); //convert to ints
            tempTime = Integer.parseInt(times[i]);
            int sols = 0;
            for (int j = 0; j < tempTime; j++){
                if (j * (tempTime - j) > maxDistance){
                    sols += 1;
                }
            }
            if (sols != 0)
                ans *= sols;
        }
        return ans;
    }
}