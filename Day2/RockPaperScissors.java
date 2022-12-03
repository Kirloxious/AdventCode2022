import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RockPaperScissors {
    
    /*
     * Score
     * A  X  Rock = 1        
     * B  Y  Paper = 2
     * C  Z  Scissors = 3
     * 
     * win = 6
     * draw = 3
     * lost = 0
     *
     */

    final static int ROCK_SCORE = 1;
    final static int PAPER_SCORE = 2;
    final static int SCISSORS_SCORE = 3;

    final static int WIN_SCORE = 6;
    final static int DRAW_SCORE = 3;
    final static int LOST_SCORE = 0;
    

    public static int round(String opponentMove, String playerMove){
        int roundScore = 0;


        //Opponent Rock
        if(opponentMove.equals("A")){
            //Player must lose
            if(playerMove.equals("X")){
                roundScore += LOST_SCORE + SCISSORS_SCORE;
            }
            //Player must draw
            else if(playerMove.equals("Y")){
                roundScore += DRAW_SCORE + ROCK_SCORE;
            }
            //Player must win
            else if(playerMove.equals("Z")){
                roundScore += WIN_SCORE + PAPER_SCORE;
            }
        }

        //Opponent Paper
        else if(opponentMove.equals("B")){
            //Player must lose
            if(playerMove.equals("X")){
                roundScore += LOST_SCORE + ROCK_SCORE;
            }
            //Player must draw
            else if(playerMove.equals("Y")){
                roundScore += DRAW_SCORE + PAPER_SCORE;
            }
            //Player must win
            else if(playerMove.equals("Z")){
                roundScore += WIN_SCORE + SCISSORS_SCORE;
            }
        }

        //Opponent Scissors
        else if(opponentMove.equals("C")){
            //Player must lose
            if(playerMove.equals("X")){
                roundScore += LOST_SCORE + PAPER_SCORE;
            }
            //Player must draw
            else if(playerMove.equals("Y")){
                roundScore += DRAW_SCORE + SCISSORS_SCORE;
            }
            //Player must win
            else if(playerMove.equals("Z")){
                roundScore += WIN_SCORE + ROCK_SCORE;
            }
        }

        return roundScore;
    }



    public static int read(String filename) {
        
        String oppenentMove, playerMove;
        int totalScore = 0;

        try (Scanner sc = new Scanner(new File(filename))) {

            while (sc.hasNextLine())  
            {  
                oppenentMove = sc.next();
                playerMove = sc.next();
                totalScore += round(oppenentMove, playerMove);
            }   

            sc.close(); //closes the scanner    
            return totalScore; 
        } catch ( NumberFormatException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return totalScore;

    }

    public static void main(String[] args) {
        
        int totalScore = read("input.txt");;
        System.out.println(totalScore);
    }
}
