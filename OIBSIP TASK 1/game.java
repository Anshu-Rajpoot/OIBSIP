import java.util.Random;
import java.util.Scanner;

public class game{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        Random r=new Random();

        System.out.println("Welcome to the Number Guessing Game !!!");
        System.out.println("I have Selected a Number between 1 and 100");
        System.out.println("You have to guess the number I have selected in 10  Attempts !!");

        int score=0;
        int attempt=0;
        int ng = r.nextInt(100 - 1 + 1) + 1;
        boolean a=false;

        //maximum limit is described here
        while (attempt<10){
            System.out.print("Enter your Guess number "+ (attempt+1)+ " : ");
            int num=s.nextInt();
            attempt++;

        if(num<1){
            System.out.println("Number is not in Range of 1 to 100");
        }
        if(num>100){
            System.out.println("Number is not in Range of 1 to 100");
        }
        if(num==ng){
            System.out.println("Congratulations!! You Guessed the Correct Number in "+attempt+" Attempts.");
            score += 10 - attempt+1;
            a=true;
            break;
        }
        else if(num<ng){
            System.out.println("Try a Higher number.");
        }
        else{
            System.out.println("Try a Lower Number.");
        }
        }
        if(a=false){
            System.out.println("Sorry!! You are out of moves. Better Luck next time.");
        }
        System.out.println("Your Score is "+ score);
        System.out.println("Play again");
        s.close();

    }
}