import java.util.Scanner;
public class passgrade {
    public static void main(String[] args) {
        int calculus , physics , programming , computerscience , linearalgebra ;

        Scanner inp = new Scanner(System.in);

        System.out.println("Your calculus grade : ");
        calculus = inp.nextInt();
        if (calculus < 0 || calculus > 100){
            System.out.println("Grade note should be between 0 and 100.This grade will not be included in the average calculation.");
            calculus = 0;
        }

        System.out.println("Your physics grade : ");
        physics = inp.nextInt();
        if (physics < 0 || physics > 100){
            System.out.println("Grade note should be between 0 and 100.This grade will not be included in the average calculation.");
            physics = 0;
        }

        System.out.println("Your programming grade :");
        programming = inp.nextInt();
        if (programming < 0 || programming > 100){
            System.out.println("Grade note should be between 0 and 100.This grade will not be included in the average calculation.");
            programming = 0;
        }

        System.out.println("Your computer science grade : ");
        computerscience = inp.nextInt();
        if (computerscience < 0 || computerscience > 100){
            System.out.println("Grade note should be between 0 and 100.This grade will not be included in the average calculation.");
            computerscience = 0;
        }

        System.out.println("Your linear algebra grade :");
        linearalgebra = inp.nextInt();
        if (linearalgebra < 0 || linearalgebra > 100){
            System.out.println("Grade note should be between 0 and 100.This grade will not be included in the average calculation.");
            linearalgebra = 0;
        }

        double average = (calculus + physics + programming + computerscience + linearalgebra) / 5;
        if (average <= 55){
            System.out.println("You failed the class , see you next year !");
            System.out.println("Your average grade note :" + average);
        }else{
            System.out.println("Congratulations , you passed the class !");
        }
        System.out.println("Your average grade note : " + average);

    }
}
