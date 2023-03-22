package BullsCows;

import java.util.Scanner;

public class Stage2 {
    String secretCode = "9305";
    int cows, bulls;
    public static void main(String[] args) {
        Stage2 stage2 = new Stage2();
        String userGuess = getUserGuess();
        stage2.calculate(userGuess);
    }

    public static String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("4 Rakamnlı Tahmininizi Girin");
        return scanner.next();
    }

    public void calculate(String guess) {

        for (int i = 0; i < guess.length(); i++) {
            if(this.secretCode.charAt(i) == guess.charAt(i)) {
                this.bulls++;
            } else if (this.secretCode.indexOf(guess.charAt(i))!=-1) {
                this.cows++;
            }
        }
        printResult();
    }

    private void printResult() {
        if (this.bulls != 0 || this.cows != 0) {
            System.out.printf("%d bull(s) and %d cow(s). (The Secret code is %s)", this.bulls, this.cows, this.secretCode);
        } else {
            System.out.printf("None. (The Secret code is %s)", this.secretCode);
        }
        System.out.println();

    }
}
