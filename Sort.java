import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        int num1, num2, num3;
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        num1 = inp.nextInt();

        System.out.println("Enter the second number: ");
        num2 = inp.nextInt();

        System.out.println("Enter the third number: ");
        num3 = inp.nextInt();

        int min, middle, max;
        if (num1 <= num2 && num1 <= num3) {
            min = num1;
            if (num2 <= num3) {
                middle = num2;
                max = num3;
            } else {
                middle = num3;
                max = num2;
            }
        } else if (num2 <= num1 && num2 <= num3) {
            min = num2;
            if (num1 <= num3) {
                middle = num1;
                max = num3;
            } else {
                middle = num3;
                max = num1;
            }
        } else {
            min = num3;
            if (num1 <= num2) {
                middle = num1;
                max = num2;
            } else {
                middle = num2;
                max = num1;
            }
        }
        System.out.println("Sort from the smallest to largest: " + min + " < " + middle + " < " + max);
    }
}
