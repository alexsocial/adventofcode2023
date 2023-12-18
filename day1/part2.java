import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class part1_2 {
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
        HashMap<String, String> dict= new HashMap<>();
        dict.put("one", "1");
        dict.put("two", "2");
        dict.put("three", "3");
        dict.put("four", "4");
        dict.put("five", "5");
        dict.put("six", "6");
        dict.put("seven", "7");
        dict.put("eight", "8");
        dict.put("nine", "9");
        int tot = 0;
        for (int i = 0; i < dat.size(); i++){
          String s = dat.get(i);
          int j = 0;
          String c = "";
  
          while(true){
            char t = s.charAt(j);
            String sub3 = "", sub4 = "", sub5 = "";
            //Length checkers to avoid out of bound calls
            if (j < 4 && s.length() >= 6){
                sub3 = s.substring(j,j+3);
            }
            if (j < 5 && s.length() >= 9){
                sub4 = s.substring(j,j+4);
            }
            if (j < 6 && s.length() >= 11){
                sub5 = s.substring(j,j+5);
            }        
            // digit checkers
            if (Character.isDigit(t)){  
              c = c + t;
              break;
            }
            else if (dict.containsKey(sub3)){
                c = c + dict.get(sub3);
                break;
            }
            else if (dict.containsKey(sub4)){
                c = c + dict.get(sub4);
                break;
            }
            else if (dict.containsKey(sub5)){
                c = c + dict.get(sub5);
                break;
            }
            j++;
          }
  
          j = s.length() - 1;
          while(true){
            char t = s.charAt(j);
            String sub3 = "", sub4 = "", sub5 = "";
            //Length checkers to avoid out of bound calls
            if (j > 3 && s.length() >= 6){
                sub3 = s.substring(j-2,j+1);
            }
            if (j > 4 && s.length() >= 9){
                sub4 = s.substring(j-3,j+1);
            }
            if (j > 5 && s.length() >= 11){
                sub5 = s.substring(j-4,j+1);
            }
            
            // digit checkers
            if (Character.isDigit(t)){
              c = c + t;
              break;
            }
            else if (dict.containsKey(sub3)){
                c = c + dict.get(sub3);
                break;
            }
            else if (dict.containsKey(sub4)){
                c = c + dict.get(sub4);
                break;
            }
            else if (dict.containsKey(sub5)){
                c = c + dict.get(sub5);
                break;
            }
            j--;
          }
          tot = tot + Integer.parseInt(c);
        }
        return tot;
      }
}
