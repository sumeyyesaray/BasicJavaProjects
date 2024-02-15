import java.util.Scanner;
public class circle {
    public static void main(String [] args){
        int r , a;
        double pi = 3.14;
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the radius of the circle : ");
        r = inp.nextInt();
        System.out.println("Enter the measure of the center angle: ");
        a = inp.nextInt();
        double area = (pi * r * r*a)/360;
        double perimeter = (2 * pi * r * a) / 360 ;
        System.out.println("Area of circle slice : " + area);
        System.out.println("Perimeter of circle slice : " + perimeter);
    }
}
