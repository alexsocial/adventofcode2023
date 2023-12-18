import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class part2_1 {
    public static void main(String[] args){
        ArrayList<String> dat = new ArrayList<String>();
        dataToList(dat, "day2/data.txt");
        int ans = gameSum(dat);
        System.out.println(ans);
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

    /* ALGORITHM
     * Game files are interpreted as Game 1: N [type] n [type]; ...; ...;
     * Keep placeholder for game, have a function to process each round for simplification
     * Split lines up by N followed by type.
     * Compare strings using x.compareTo(lim)
     */
    public static int gameSum(ArrayList<String> dat){
        int rLim = 12, gLim = 13, bLim = 14;
        int sum = 0;
        int pl1 = 0;
        String pl2 = "";
        for (int i = 0; i < dat.size(); i++){ 
            String[] game = dat.get(i).split("\\s+");
            boolean check = true;
            int gameNo = i+1;
            for (int j = 2; j < game.length; j+= 2) { // += 2 for pairs
                pl1 = Integer.valueOf(game[j]);
                pl2 = game[j+1];
                //System.out.println(gameNo + " " + pl1 + " " + pl2);
                switch (pl2){ // brute force
                    case "green,":
                    check = pl1 <= gLim;
                    break;
                    case "green;":
                    check = pl1 <= gLim;
                    break;
                    case "blue,":
                    check = pl1 <= bLim;
                    break;
                    case "blue;":
                    check = pl1 <= bLim;
                    break;
                    case "red,":
                    check = pl1 <= rLim;
                    break;
                    case "red;":
                    check = pl1 <= rLim;
                    break;
                    case "blue":
                    check = pl1 <= bLim;
                    break;
                    case "green":
                    check = pl1 <= gLim;
                    break;
                    case "red":
                    check = pl1 <= rLim;
                    break;
                }
                if (check == false){
                    //System.out.println("Game "  + gameNo + "Failed");
                    gameNo = 0;
                    break;
                }
            }
            //System.out.println("Game "  + gameNo + "Success");
            sum += gameNo;
        }
        return sum;
    }
}