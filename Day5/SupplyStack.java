import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * SupplyStack
 */
public class SupplyStack {
    public SupplyStack(){

    }
    public static class Move{
        public int origin;
        public int moveSize;
        public int destination;
        public Move(int origin, int moveSize, int destination){
            this.origin = origin -1;
            this.moveSize = moveSize ;
            this.destination = destination -1;
        }
    }

    public static List<Stack<String>> cargo;
    public static List<Move> moveList = new LinkedList<Move>();

    public static void createStacks(int len){
        cargo = new ArrayList<Stack<String>>();
        for (int i = 0; i < len; i++) {
            cargo.add(new Stack<String>());
        }
    }
    
    public static void parseInputStacks(String line){
        String[] strList = line.split("");
        int j =0;
        if(!line.startsWith("move") && !line.contains(" 1 ")){
            for (int i = 1 ; i <= strList.length; i+=4) {
                if(!strList[i].equals(" ")){
                    cargo.get(j).push(strList[i]);
                }
                j++;
            }
        }
    }

    public static void reverseStacks(){
        for (Stack<String> stack : cargo) {
            Collections.reverse(stack);
        }

    }
    
    public static void parseInputMoves(String line){
        String[] strList = line.split(" ");
        Move move = new Move(Integer.parseInt(strList[3]), Integer.parseInt(strList[1]), Integer.parseInt(strList[5]));
        moveList.add(move);
    }

    //part 1
    public static void executeMoves(){
        reverseStacks();
        for (Move move : moveList) {
            Stack<String> destinationStack = cargo.get(move.destination);
            Stack<String> originStack = cargo.get(move.origin);
            int size = move.moveSize;
            for (int i = 0; i < size; i++) {
                destinationStack.push(originStack.pop());
            }
        }
    }
    
    //part 2
    public static void craneMover(){
        reverseStacks();
        for (Move move : moveList) {
            Stack<String> destinationStack = cargo.get(move.destination);
            Stack<String> originStack = cargo.get(move.origin);
            int size = move.moveSize;
            Stack<String> temp = new Stack<String>();
            for (int j = 0; j< size; j++) {
                temp.push(originStack.pop());
            }
            for (int k = 0; k< size; k++) {
                destinationStack.push(temp.pop());
            }
            temp.clear();
        }
    }
    
    public static void printTops(){
        for (Stack<String> stack : cargo) {
            System.out.print(stack.pop());
        }
    }
    
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")))) {
            String str = br.readLine();
            createStacks((str.length()+1)/4);

            while((str) != null){
                if(str.startsWith("move")){
                    parseInputMoves(str);
                }
                else if(!str.equals("")){
                    parseInputStacks(str);
                }
                str = br.readLine();
            }


            //part 1
            executeMoves();
            printTops();

            //part 2
            craneMover();
            printTops();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}