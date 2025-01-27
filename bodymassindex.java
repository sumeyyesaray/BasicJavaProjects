import java.util.Scanner;
public class bodymassindex {
    public static void main(String[] args){
        double weight, height ;
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the your mass : ");
        weight = inp.nextDouble();
        System.out.println("Enter your height : ");
        height = inp.nextDouble();
        double index = weight/(height*height);
        System.out.println("Your body mass index : " + index);

    }
}
