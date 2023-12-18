import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class part1_1 {
    public static void main(String[] args){
        ArrayList<String> dat = new ArrayList<String>();
        dataToList(dat, "day1/data.txt");
        int dist = findDistance(dat);
        System.out.println(dist);
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

    public static int findDistance(ArrayList<String> dat){
      // Loop forward, break when first num found. Then backwards. O(n^2)
      // Loops no more than it has to once found. Would use set but it's order specific.
      int tot = 0;
      for (int i = 0; i < dat.size(); i++){
        String s = dat.get(i);
        int j = 0;
        String c = "";

        while(true){
          char t = s.charAt(j);
          if (Character.isDigit(t)){
            c = c + t;
            break;
          }
          j++;
        }

        j = s.length() - 1;
        while(true){
          char t = s.charAt(j);
          if (Character.isDigit(t)){
            c = c + t;
            break;
          }
          j--;
        }
        tot = tot + Integer.parseInt(c);
      }
      return tot;
    }
}