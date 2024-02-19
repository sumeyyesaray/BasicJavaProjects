import java.util.Scanner;

public class Calculator {
    static void plus() {
        Scanner inp = new Scanner(System.in);
        int number, result = 0, i = 1;

        System.out.print("How many numbers will you enter? ");
        int count = inp.nextInt();

        while (i <= count) {
            System.out.println(i++ + ". number :");
            number = inp.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
            continue;
        }
        System.out.println("Result : " + result);
    }

    static void minus() {
        Scanner inp = new Scanner(System.in);
        System.out.print("How many numbers will you enter ? ");
        int count = inp.nextInt();
        int number, result = 0;
        for (int i = 1; i <= count; i++) {
            System.out.print(i + ". number :");
            number = inp.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }
        System.out.println("Result : " + result);
    }

    static void times() {
        Scanner inp = new Scanner(System.in);
        int number, result = 1, i = 1;
        System.out.print("How many numbers will you enter? ");
        int count = inp.nextInt();

        while( i <= count){
            System.out.println(i++ + ". number :");
            number = inp.nextInt();
            if (number == 1) {
                break;
            }
            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }
        System.out.println("Result : " + result);
    }

    static void divided() {
        Scanner inp = new Scanner(System.in);
        System.out.print("How many numbers will you enter ? ");
        int counter = inp.nextInt();
        double number , result = 0.0;
        for (int i = 1 ; i <= counter ; i++){
            System.out.print( i + ". number :");
            number = inp.nextDouble();
            if (i != 1 && number == 0){
                System.out.println("You can not enter the divisor as 0!");
                continue;
            }
            if( i == 1){
                result = number;
                continue;
            }
            result /= number;
        }
        System.out.println("Result : " + result);
    }

    static void power() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter base value : ");
        int base = inp.nextInt();
        System.out.println("Enter exponent value : ");
        int exponent = inp.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println("Result : " + result);
    }

    static void factorial() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = inp.nextInt();
        int result = 1;

        for (int i = 1; i <= n ; i++){
            result *= i;
        }
        System.out.println("Result : " + result);
    }

    static void mod() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the dividend number : ");
        int dividend = inp.nextInt();
        System.out.println("Enter the divisor number : ");
        int divisor = inp.nextInt();

        int mod = dividend % divisor;
        System.out.println("Result : " + mod);
    }

    static void rectangleAreaPerimeter() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the lenght of the rectangle : ");
        int length = inp.nextInt();
        System.out.println("Enter the width of the rectangle : ");
        int width = inp.nextInt();

        int area = length * width;
        int perimeter = 2 * (length + width);
        System.out.println("Area : " + area );
        System.out.println("Perimeter : " + perimeter );
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int select;
        String menu= "1- Addition: \n"
                + "2- Subtraction: \n"
                + "3- Multiplication: \n"
                + "4- Division: \n"
                + "5- Power: \n"
                + "6- Factorial: \n"
                + "7- Mod: \n"
                + "8- Rectangular area and perimeter calculation: \n"
                + "9- Log out: ";
        do {
            System.out.println(menu);
            System.out.println("Please select an action :");
            select = inp.nextInt();
            switch (select){
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    times();
                    break;
                case 4:
                    divided();
                    break;
                case 5:
                    power();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    mod();
                    break;
                case 8:
                    rectangleAreaPerimeter();
                    break;
                case 9:
                    System.out.println("Logging out... ");
                    break;
                default:
                    System.out.println("You entered the wrong valur , please try again !");
            }
        } while (select != 9);
    }
}




