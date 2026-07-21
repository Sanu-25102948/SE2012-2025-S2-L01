import java.util.Scanner;

public class activity1 {

	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		System.out.print("Enter your first name: ");
		String firstName = input.nextLine();

		System.out.print("Enter your Last name: ");
                String lastName = input.nextLine();

		System.out.printf("Welcome to the second year %s %s", firstName, lastName);

		}
}


