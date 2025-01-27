import java.util.Scanner;
public class Fibonacci {
    static int fib(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        System.out.println("How many elements of the Fibonacci series do you want to find ? ");
        int n = inp.nextInt();
        inp.close();
        System.out.println("Fibonacci Series :");
        for (int i = 1 ; i <= n; i++){
            System.out.println(fib(i) + " ");
        }
    }


    // f(n) = f(n-1) + f(n-2)

}
