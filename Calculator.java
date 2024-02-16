import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        int n1 , n2 , select;

        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the first number (n1): ");
        n1 = inp.nextInt();
        System.out.println("Enter the second number (n2): ");
        n2 = inp.nextInt();

        System.out.println("1-Addition \n 2-Subtraction \n 3-Multiplication \n 4-Divison ");
        System.out.println("Which action would you like to take ?");
        select = inp.nextInt();

        if (select == 1){
            System.out.println("Addition : " + (n1 + n2));
        }else if (select == 2){
            System.out.println("Subtraction : " + (n1 - n2));
        }else if (select == 3){
            System.out.println("Multiplication : " + (n1 * n2));
        }else if (select == 4){
            if (n2 != 0) {
                System.out.println("Division : " + (n1 / n2));
            }else {
                System.out.println("A number can not be divided 0 ! ");
            }
            } else {
            System.out.println("You made the wrong choice.");
        }
    }
}
