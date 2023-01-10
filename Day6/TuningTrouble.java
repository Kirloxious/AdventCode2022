import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.SortingFocusTraversalPolicy;

/**
 * TuningTrouble
 */
public class TuningTrouble {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")))) {
            
            String str = br.readLine();
            String[] strList = str.split("");

            HashSet<String> set = new HashSet<>();
            int charCount = 0;

         for (String s : strList) {
             if(!set.contains(s)){
                 set.add(s);
                 if(set.size() == 4){
                     System.out.println(charCount);
                     break;
                    }
                }
                else{
                    set.clear();
                    set.add(s);
                }
                charCount++;
            }   


        }
        catch (Exception e) {
            System.out.println("error");
        }
    }


}