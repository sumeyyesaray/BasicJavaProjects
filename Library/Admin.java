package Library;

import java.util.Scanner;

public class Admin extends User{
	public Admin(String name){
		super(name);
		this.operations = new IOOperation[] {
				new ViewBooks(),
				new AddBook(),
				new DeleteBook(),
				new Search(),
				new DeleteAllData(),
				new ViewOrders(),
				new Exit()
		};
		/*
		Bu nedenle, Admin sınıfının yapıcı metodunda this.operations dizisinin başlatılması, super() anahtar kelimesiyle üst sınıfın yapıcı metodunu çağırmadan önce
		 gerçekleşir. Bu, Admin sınıfına ait özel işlemleri başlatmak için kullanılır ve User sınıfının yapıcı metodunun çağrılmasından sonra gerçekleşir. Bu durumda,
		 this.operations dizisi, Admin sınıfına özgü bir özellik olduğu için Admin sınıfının yapıcı metodunda başlatılır.
		 */
	}
	
	public Admin(String name, String email, String phoneNumber) {
		super(name,email,phoneNumber);
		this.operations = new IOOperation[] {
				new ViewBooks(),
				new AddBook(),
				new DeleteBook(),
				new Search(),
				new DeleteAllData(),
				new ViewOrders(),
				new Exit()
		};
	}
	
	@Override
	public void menu(Database database, User user) {
		System.out.println("1. View Books");
		System.out.println("2. Add Book");
		System.out.println("3. Delete Book");
		System.out.println("4. Search");
		System.out.println("5. Delete all data");
		System.out.println("6. View Orders");
		System.out.println("7. Exit");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		this.operations[choice-1].oper(database, user);
		scanner.close();
	}
	
	@Override
	public String toString() {
		return name + "<N/>" + email + "<N/>" + phoneNumber+ "<N/>" + "Admin";
		
	}
	
}
