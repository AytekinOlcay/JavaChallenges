package BullsCows;

import java.util.Random;
import java.util.Scanner;


class Stage5 {
    int turn = 1;
    String secretCode;
    int cows, bulls;
    int secretLength;

    private int getLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Length of Secret Code");
        return scanner.nextInt();
    }

    private String createSecret() {
        StringBuilder createdSecret = new StringBuilder(this.secretLength);
        Random randomData = new Random();

        while (createdSecret.length() < this.secretLength) {
            // Random class yerine Math.random'da kullanabiliriz.
            // String cratedNumber = String.valueOf((int) (Math.random() * (10-1)+1));
            String cratedNumber = String.valueOf(randomData.nextInt(10));
            if (createdSecret.length() == 0 && cratedNumber.equals("0")) {
                continue;
            }
            createdSecret.append(cratedNumber);
        }

        return createdSecret.toString();
    }

    public String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your %d-digit guess", this.secretLength);
        System.out.println();
        return scanner.next();
    }

    public void calculate(String guess) {
        this.bulls = 0;
        this.cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (this.secretCode.charAt(i) == guess.charAt(i)) {
                this.bulls++;
            } else if (this.secretCode.indexOf(guess.charAt(i)) != -1) {
                this.cows++;
            }
        }
        this.printResult();
    }

    private void printResult() {
        if (this.bulls != 0 || this.cows != 0) {
            System.out.printf("%d bull(s) and %d cow(s). (The Secret code is %s)", this.bulls, this.cows, this.secretCode);
        } else {
            System.out.printf("None. (The Secret code is %s)", this.secretCode);
        }
        System.out.println();
    }

    void letsStart() {
        String guess;
        this.secretLength = this.getLength();
        while (this.secretLength > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.\n", this.secretLength);
            this.secretLength = this.getLength();
        }

        this.secretCode = this.createSecret();

        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n", this.turn);
            guess = this.getUserGuess();
            this.calculate(guess);
            this.turn += 1;
        } while (!guess.equals(this.secretCode));

        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static void main(String[] args) {
        Stage5 stage4 = new Stage5();
        stage4.letsStart();
    }
}
