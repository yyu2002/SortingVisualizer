import processing.core.PApplet;

import java.util.Scanner;

public class Main extends PApplet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sortName = "BubbleSort";
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("Choose a sort: \n0. Exit \n1. Bubble Sort \n2. SelectionSort \n^D - Exit\n");
            int response = 0;

            if (!in.hasNextInt()) { // invalid input handling
                if (!in.hasNextLine()) { // exit if user enters input like ^D
                    return;
                }
                in.nextLine(); // clear the scanner
                System.out.print("Invalid input. ");
            } else {
                response = in.nextInt();

                if (response < 0 || response > 2) { // continue if input is invalid number
                    System.out.print("Invalid input. ");
                    continue;
                }

                if (response == 0) {
                    continueLoop = false;
                } else if (response == 1) {
                    sortName = "BubbleSort";
                } else if (response == 2) {
                    sortName = "SelectionSort";
                }
            }
            if (response != 0) {
                PApplet.main(new String[]{sortName});
            }
        }

    }
}
