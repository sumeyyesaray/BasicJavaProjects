import java.util.Scanner;

public class Taximeter {
    public static void  main(String[] args){
        int km;
        double perKm = 2.20 , startPrice = 10 , total;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the distance in kilometers: ");
        km = input.nextInt();
        total = (km*perKm);
        total += startPrice ;
        System.out.println("Total amount : " + total);


    }
}
