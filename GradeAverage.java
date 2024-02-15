import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //create variables:
        int calculus, physics, programming, computerscience;
        Scanner inp = new Scanner(System.in);
        // get values from user:
        System.out.println("Your calculus grade: ");
        calculus = inp.nextInt();

        System.out.println("Your physics grade: ");
        physics = inp.nextInt();

        System.out.println("Your programming grade: ");
        programming = inp.nextInt();

        System.out.println("Your computer science grade: ");
        computerscience = inp.nextInt();

        int toplam = (calculus + physics + programming + computerscience);
        double sonuc = toplam / 4.0;
        System.out.println("Your average: " + sonuc);




    }
}
