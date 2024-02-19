import java.util.Scanner;
public class CombinationCalculate {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the number of elements in the set (n) : ");
        int n = inp.nextInt();
        System.out.println("Enter the number of elements in the group (r) : ");
        int r = inp.nextInt();

        int numerator = 1 , denominator = 1;
        for (int i = n ; i > n - r ; i--){
            numerator *= i;
        }
        for (int i = r ; i >0 ; i --){
            denominator *= i;
        }

        int result = numerator / denominator ;
        System.out.println("C(" + n + ", " + r + ") = " + result);
    }
}
