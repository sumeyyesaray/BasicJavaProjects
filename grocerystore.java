import java.util.Scanner;
public class grocerystore {
    public static void main(String[] args){
        double apple , banana, broccoli , strawberry;
        double costApple = 2.14 , costBanana = 3.67 , costBroccoli = 5.00 , costStrawberry = 4.5 ;

        Scanner inp = new Scanner(System.in);
        System.out.println("Enter how many kilos of apples you bought : ");
        apple = inp.nextDouble();
        System.out.println("Enter how many kilos of bananas you bought : ");
        banana = inp.nextDouble();
        System.out.println("Enter how many kilos of broccoli you bought : ");
        broccoli = inp.nextDouble();
        System.out.println("Enter how many kilos of strawberries you bought : ");
        strawberry = inp.nextDouble();

        double total = (apple * costApple) + (banana * costBanana) + (broccoli * costBroccoli) + (strawberry * costStrawberry);
        System.out.println("Total amount : " + total);

    }
}
