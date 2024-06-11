import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("Will you survive four days in this neighborhood??");
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your name? ");
		String name = scan.nextLine();
		Person p1 = new Person(name);
		p1.playGame();
		
		
	}
	
}






