import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args){

        int a, b;
        double c;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first side : ");
        a = input.nextInt();
        System.out.println("Enter the second side : ");
        b = input.nextInt();

        c = Math.sqrt((a*a) + (b*b));
        System.out.println("Hyptenuse : " + c);
        
    }
}
