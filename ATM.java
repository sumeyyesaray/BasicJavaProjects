import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        String userName , password ;
        Scanner inp = new Scanner(System.in);
        int right = 3;
        int balance = 3000;
        int select ;
        while (right > 0){
            System.out.println("Your user name : ");
            userName = inp.nextLine();
            System.out.println("Enter your password : ");
            password = inp.nextLine();

            if (userName.equals("sümeyyesaray") && password.equals("java709070")){
                System.out.println("Welcome to JAVA Bank !");
                do {
                    System.out.println("1- Deposit \n"
                            + "2- Withdraw Money \n" +
                            "3- Query Balance \n" +
                            "Log Out");
                    System.out.println("Please select the action that you want to perform :");
                    select = inp.nextInt();
                    if (select == 1){
                        System.out.println("Amount of money :");
                        int price = inp.nextInt();
                        balance += price;
                        System.out.println("Balance :" + balance);
                    }else if (select == 2){
                        System.out.println("Amount of money : ");
                         int price = inp.nextInt();
                        if (price > balance){
                            System.out.println("Insufficient balance , please try again !");
                        }else{
                            balance -= price ;
                            System.out.println("Balance : " + balance);
                        }
                    }else if (select == 3){
                        System.out.println("Balance : " + balance);
                    }
                }while (select != 4);
                System.out.println("See you later , have a nice day !");
                break ;
            }else {
                right--;
                System.out.println("User name or password is wrong. Please try again !");
                if (right == 0){
                    System.out.println("Your account has been blocked, please contact bank !");
                }else {
                    System.out.println("Your remaining right : " + right );
                }
            }
        }
    }
}
