package Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;


public class Database {
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<String> booknames = new ArrayList<String>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Borrowing> borrowings = new ArrayList<Borrowing>();
	
	// Main.class.getClassLoader()
		// runtimeda Sınıfların stack'e yüklenmesi işlemi sırasında Java sanal makinesi(JVM),ClassLoader adı verilen bir mekanizmayı kullanır.
		// main sınıfının yükleyicisini (ClassLoader) alır. Bu, Main sınıfının Java sanal makinesi tarafından yüklenmesini sağlayan mekanizmadır.
	//.getResource("Users")
		// Yükleyiciyi kullanarak "Users" adında bir kaynak dosyasını bulur.
	//.getFile()
		// Kaynak dosyasının dosya yolunu döndürür. Bu yol, dosyanın konumunu belirtir.
	//new File(...)
	//Bu dosya yolunu kullanarak bir File nesnesi oluşturur. File sınıfı, bir dosyayı veya dizini temsil eder ve dosya yolunu alarak dosyanın işlemlerini yapmanızı sağlar.
	/*
	private File usersfile = new File(Main.class.getClassLoader().getResource("Users").getFile());
	private File booksfile = new File(Main.class.getClassLoader().getResource("Books").getFile());
	*/
	private File usersfile = new File("C:\\OOP\\SelfPractise\\data\\Users");
	private File booksfile = new File("C:\\OOP\\SelfPractise\\data\\Books");
	private File ordersfile = new File("C:\\OOP\\SelfPractise\\data\\Orders");
	private File borrowingsfile = new File("C:\\OOP\\SelfPractise\\data\\Borrowings");
	private File folder =  new File("C:\\OOP\\SelfPractise\\Data");
	
	
	public Database() {
		if(!folder.exists()) {
			folder.mkdirs();
		}
		if (!usersfile.exists()) {
			try {
				//usersfile.mkdirs();
				usersfile.createNewFile();
			} catch (Exception e) {}
		}
		if (!booksfile.exists()) {
			try {
				//booksfile.mkdirs();
				booksfile.createNewFile();
			} catch (Exception e) {}
		}
		if (!ordersfile.exists()) {
			try {
				//booksfile.mkdirs();
				ordersfile.createNewFile();
			} catch (Exception e) {}
		}
		if (!borrowingsfile.exists()) {
			try {
				//booksfile.mkdirs();
				borrowingsfile.createNewFile();
			} catch (Exception e) {}
		}
		getUsers();
		getBooks();
		getOrders();
		getBorrowings();
		
	}

	public void AddUser(User s) {
		users.add(s);
		usernames.add(s.getName());
		saveUsers();
	}
	
	public int login(String phonenumber, String email) {
		int n = -1; // eşleşme bulamazsa -1
		for(User s: users) {
			if (s.getPhoneNumber().matches(phonenumber) && s.getEmail().matches(email)) {
				n = users.indexOf(s);// userları tutan arraylistte kaçıncı userda eşleşme buldu
				break;
			}
		}
		return n;// n. indekste eşleşme buldu bulamazsa -1
	}
	
	public User getUser(int n) {
		return users.get(n); // eşleşen userı döndürcek
	}
	
	public void addBook(Book book) {
		books.add(book);
		booknames.add(book.getName());
		saveBooks();
	}
	
	private void getUsers() {
		String text1 = "";
		try {
			
			//usersfile adındaki dosyayı okumak için bir BufferedReader nesnesi oluşturur.
			//Ardından bu nesne, br1 adında bir değişkene atanır 
			BufferedReader br1 = new BufferedReader(new FileReader(usersfile));
			String s1;
			while ((s1 = br1.readLine())!= null) {// dosyadan bir satır okumak için readLine() yöntemi kullanılır.
				text1= text1 + s1;
			}
			br1.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1  = text1.split("<NewUser/>");
			for (String s : a1) {
				String[] a2 = s.split("<N/>");
				if (a2[3].matches("Admin")) {
					User user= new Admin(a2[0], a2[1], a2[2]);
					users.add(user);
					usernames.add(user.getName());
				}else {
					User user= new NormalUser(a2[0], a2[1], a2[2]);
					users.add(user);
					usernames.add(user.getName());
				}
			}
		}
	}
	
	private void saveUsers() {
		String text1 = "";
		for (User user : users) {
			text1 = text1 + user.toString() + "<NewUser/>\n"; 
		}
		try {
			//PrintWriter sınıfı, metin tabanlı çıktıları yazmak için kullanılır ve genellikle dosyalara yazmak için de kullanılır. 
			//PrintWriter kullanarak text1 adlı metni usersfile dosyasına yazacaktır. print() yöntemi, dosyaya metin yazmak için kullanılır 
			PrintWriter pw = new PrintWriter(usersfile);
			pw.print(text1);
			pw.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void saveBooks() {
		String text1 = "";
		for (Book book : books) {
			text1 = text1 + book.toString2() + "<NewBook/>\n"; 
		}
		try {
			//PrintWriter sınıfı, metin tabanlı çıktıları yazmak için kullanılır ve genellikle dosyalara yazmak için de kullanılır. 
			//PrintWriter kullanarak text1 adlı metni usersfile dosyasına yazacaktır. print() yöntemi, dosyaya metin yazmak için kullanılır 
			PrintWriter pw = new PrintWriter(booksfile);
			pw.print(text1);
			pw.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void getBooks() {
		String text1 = "";
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(booksfile));
			String s1;
			while ((s1 = br1.readLine())!= null) {
				text1= text1 + s1;
			}
			br1.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1  = text1.split("<NewBook/>");
			for (String s : a1) {
				Book book = parseBook(s);
				books.add(book);
				booknames.add(book.getName());
				}
			}
		}
	
	public Book parseBook(String s) {
		String[] a = s.split("<N/>");
		Book book = new Book();
		//Book book2 = new Book(a[0], a[1], a[2], a[3],null, Integer.parseInt(a[4]), Double.parseDouble(a[5]), Integer.parseInt(a[6]));
		//da yapabilirdik. status u null yaptım kullanmadık hiç.
		book.setName(a[0]);
		book.setAuthor(a[1]);
		book.setPublisher(a[2]);
		book.setAdress(a[3]);
		book.setQty(Integer.parseInt(a[4]));
		book.setPrice(Double.parseDouble(a[5]));
		book.setBrwcopies(Integer.parseInt(a[6]));
		return book;
	}
	
	public ArrayList<Book> getAllBooks(){
		return books;
	}
	
	public int getBook(String bookName) {
		int i = -1;
		for (Book book : books) {
			if (book.getName().matches(bookName)) {
				i = books.indexOf(book);
			}
		}
		return i;
	}
	
	public Book getBook(int ind) {
		return books.get(ind);
	}
	
	public void deleteBook(int i ) {
		books.remove(i);
		booknames.remove(i);
		saveBooks();
	}
	
	public void deleteAllData() {
		if (usersfile.exists()) {
			try {
				usersfile.delete();
			} catch (Exception e) {}
		}
		if (booksfile.exists()) {
			try {
				booksfile.delete();
			} catch (Exception e) {}
		}
		if (ordersfile.exists()) {
			try {
				ordersfile.delete();
			} catch (Exception e) {}
		}
		if (borrowingsfile.exists()) {
			try {
				borrowingsfile.delete();
			} catch (Exception e) {}
		}
	}
	
	public void addOrder(Order order, Book book, int bookIndex) {
		orders.add(order);
		books.set(bookIndex, book);//books.set(bookIndex, book); ifadesi, books adlı ArrayList içindeki bookIndex indeksindeki Book nesnesini book ile değiştirir.
		saveOrders();
		saveBooks();
	}

	private void saveOrders() {
		String text1 = "";
		for (Order order : orders) {
			text1 = text1 + order.toString2() + "<NewOrder/>\n"; 
		}
		try {
			PrintWriter pw = new PrintWriter(ordersfile);
			pw.print(text1);
			pw.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void getOrders() {
		String text1 = "";
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(ordersfile));
			String s1;
			while ((s1 = br1.readLine())!= null) {
				text1= text1 + s1;
			}
			br1.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1  = text1.split("<NewOrder/>");
			for (String s : a1) {
				Order order = parseOrder(s);
				orders.add(order);
			}
		}
	}
	
	public boolean userExists(String name) {
		boolean f = false;
		for (User user : users) {
			if (user.getName().toLowerCase().matches(name.toLowerCase())) {
				f = true;
				break;
			}
		}
		return f;
	}
	
	
	private User getUserByName(String name) {
		User u = new NormalUser("");
		for (User user : users) {
			if (user.getName().matches(name)) {
				u = user;
				break;
			}
		}
		return u;
	}
	private Order parseOrder(String s) {
		String[] a = s.split("<N/>");
		Order order = new Order(books.get(getBook(a[0])), getUserByName(a[1]), Double.parseDouble(a[2]), Integer.parseInt(a[3]));
		return order;
	}
	
	public ArrayList<Order> getAllOrders(){
		return orders;
	}
	
	private void saveBorrowings() {
		String text1 = "";
		for (Borrowing borrow : borrowings) {
			text1 = text1 + borrow.toString2() + "<NewBorrowing/>\n"; 
		}
		try {
			//PrintWriter sınıfı, metin tabanlı çıktıları yazmak için kullanılır ve genellikle dosyalara yazmak için de kullanılır. 
			//PrintWriter kullanarak text1 adlı metni usersfile dosyasına yazacaktır. print() yöntemi, dosyaya metin yazmak için kullanılır 
			PrintWriter pw = new PrintWriter(borrowingsfile);
			pw.print(text1);
			pw.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void getBorrowings() {
		String text1 = "";
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(borrowingsfile));
			String s1;
			while ((s1 = br1.readLine())!= null) {
				text1= text1 + s1;
			}
			br1.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1  = text1.split("<NewBorrowing/>");
			for (String s : a1) {
				Borrowing borrowing = parseBorrowing(s);
				borrowings.add(borrowing);
			}
		}
	}
	
	private Borrowing parseBorrowing(String s) {
		String[] a = s.split("<N/>");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start = LocalDate.parse(a[0], formatter);// start tarihini yukarda belirtilen formatta yazar
		LocalDate finish = LocalDate.parse(a[1], formatter); // finish tarihini yukarda belirtilen formatta yazar
		Book book = getBook(getBook(a[3]));
		User user = getUserByName(a[4]);
		Borrowing borrowing = new Borrowing(start, finish, book, user);
		return borrowing;
	}

	public void borrowBook(Borrowing borrowing, Book book, int bookIndex) {
		borrowings.add(borrowing);//ödünç alınanlara ekle
		books.set(bookIndex, book);// bilgileri güncelle.
		saveBorrowings();//değişiklikleri kaydet
		saveBooks(); // değişiklikleri kaydet
	}
	
	public ArrayList<Borrowing> getBrws(){
		return borrowings;
	}

	public void returnBook(Borrowing b, Book book, int bookIndex) {
		borrowings.remove(b);
		books.set(bookIndex, book);
		saveBorrowings();
		saveBooks();
	}
	
	
}
