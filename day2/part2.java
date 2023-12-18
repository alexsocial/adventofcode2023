import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class part2_2 {
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

    /* ALGORITHM (PART 2)
     * Game files are interpreted as Game 1: N [type] n [type]; ...; ...;
     * Keep placeholder for game, have a function to process each round for simplification
     * Split lines up by N followed by type.
     * Have maximum values for each color, override if encountered
     */
    public static int gameSum(ArrayList<String> dat){
        int sum = 0;
        int pl1 = 0;
        String pl2 = "";
        for (int i = 0; i < dat.size(); i++){ 
            String[] game = dat.get(i).split("\\s+");
            int rMax, gMax, bMax;
            rMax = gMax = bMax = 0;
            for (int j = 2; j < game.length; j+= 2) { // += 2 for pairs
                pl1 = Integer.valueOf(game[j]);
                pl2 = game[j+1];
                //System.out.println(gameNo + " " + pl1 + " " + pl2);
                switch (pl2){ // brute force
                    case "green,":
                    if (pl1 > gMax)
                        gMax = pl1;
                    break;
                    case "green;":
                    if (pl1 > gMax)
                        gMax = pl1;
                    break;
                    case "blue,":
                    if (pl1 > bMax)
                        bMax = pl1;
                    break;
                    case "blue;":
                    if (pl1 > bMax)
                        bMax = pl1;
                    break;
                    case "red,":
                    if (pl1 > rMax)
                        rMax = pl1;
                    break;
                    case "red;":
                    if (pl1 > rMax)
                        rMax = pl1;
                    break;
                    case "blue":
                    if (pl1 > bMax)
                        bMax = pl1;
                    break;
                    case "green":
                    if (pl1 > gMax)
                        gMax = pl1;
                    break;
                    case "red":
                    if (pl1 > rMax)
                        rMax = pl1;
                    break;
                }
            }
            //System.out.println("Game "  + gameNo + "Success");
            sum += (rMax * gMax * bMax);
            rMax = gMax = bMax = 0;
        }
        return sum;
    }
}
