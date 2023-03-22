package BullsCows;

import java.util.Scanner;

public class Stage3 {

    private static int getLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Length of Secret Code");
        return scanner.nextInt();
    }
    private static StringBuilder generateRandom() {
        int nanoTime = (int) System.nanoTime();
        StringBuilder sb = new StringBuilder(String.valueOf(nanoTime));
        sb.reverse();
        return sb;
    }

    public static String createSecret(int secretLength) {
        StringBuilder createdSecret = new StringBuilder(secretLength);
        StringBuilder randomData = generateRandom();

        for (int i=0; createdSecret.length() < secretLength; i++) {
            if (i == randomData.length()) {
                randomData = generateRandom();
                i = 0;
            }

            if (createdSecret.toString().indexOf(randomData.charAt(i)) == -1) {
                if(createdSecret.length() ==0 && randomData.charAt(i) == '0') {
                    continue;
                }
                createdSecret.append(randomData.charAt(i));
            }
        }

        return createdSecret.toString();
    }

    public static void main(String[] args) {
        int secretLength = getLength();
        if (secretLength > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.\n", secretLength);
        } else {
            String secret = createSecret(secretLength);
            System.out.printf("The random secret number is %s.", secret);
        }
    }
}
