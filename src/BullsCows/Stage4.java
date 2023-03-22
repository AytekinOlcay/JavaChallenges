package BullsCows;

import java.util.Scanner;


class Stage4 {
    int turn = 1;
    String secretCode;
    int cows, bulls;
    int secretLength;

    private int getLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Length of Secret Code");
        return scanner.nextInt();
    }

    private StringBuilder generateRandom() {
        int nanoTime = (int) System.nanoTime();
        StringBuilder sb = new StringBuilder(String.valueOf(nanoTime));
        sb.reverse();
        return sb;
    }

    private String createSecret() {
        StringBuilder createdSecret = new StringBuilder(this.secretLength);
        StringBuilder randomData = this.generateRandom();

        for (int i = 0; createdSecret.length() < this.secretLength; i++) {
            if (i == randomData.length()) {
                randomData = this.generateRandom();
                i = 0;
            }

            if (createdSecret.toString().indexOf(randomData.charAt(i)) == -1) {
                if (createdSecret.length() == 0 && randomData.charAt(i) == '0') {
                    continue;
                }
                createdSecret.append(randomData.charAt(i));
            }
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



    public static void main(String[] args) {
        Stage4 stage4 = new Stage4();
        String guess;
        stage4.secretLength = stage4.getLength();
        while (stage4.secretLength > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.\n", stage4.secretLength);
            stage4.secretLength = stage4.getLength();
        }

        stage4.secretCode = stage4.createSecret();

        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n", stage4.turn);
            guess = stage4.getUserGuess();
            stage4.calculate(guess);
            stage4.turn += 1;
        } while (!guess.equals(stage4.secretCode));

        System.out.println("Congratulations! You guessed the secret code.");
    }
}
