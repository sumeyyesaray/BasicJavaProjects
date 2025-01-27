import java.util.Scanner;

public class KDV {
    public static void main(String[] args){
        double amount, vatRaise = 0.24;

        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the fee amount : ");

        amount = inp.nextDouble();

        double vat = amount * vatRaise ;
        double amountWithVat = amount * vat;

        System.out.println("Amount without VAT: " + amount);
        System.out.println("Vat rate : " + vatRaise);
        System.out.println("Vat : " + vat);
        System.out.println("Amount with vat : " + amountWithVat);
    }

}
