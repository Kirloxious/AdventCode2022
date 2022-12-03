import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * CalorieCounting
 */
public class CalorieCounting {




  // reads a csv file of 3D points
  public static List<Integer> read(String filename) {
	  
    List<Integer> calorieMap = new ArrayList<>();
    int calorieTotal = 0;

	try (Scanner sc = new Scanner(new File(filename))) {
        // read points
        while (sc.hasNextLine())  
        {  
            String input = sc.nextLine();
            if(input.isEmpty()){
                calorieMap.add(calorieTotal);
                calorieTotal = 0;
            }
            else calorieTotal += Integer.parseInt(input);
        }   

        sc.close(); //closes the scanner    
        return calorieMap; 
    } catch ( NumberFormatException | FileNotFoundException e) {
        e.printStackTrace();
    }
	return calorieMap;

  }

    public static void main(String[] args) {
        List<Integer> calorieMap = read("calories.txt");
        Collections.sort(calorieMap);
        int total = 0;
        for(int i= 1; i<=3; i++){
            int max = calorieMap.get(calorieMap.size()-i);
            total += max;
        }

        System.out.println(Collections.max(calorieMap));
        System.out.println(total);
    }

}