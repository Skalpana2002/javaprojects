package contact;

import java.util.Scanner;

public class Contact {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag=false;
		for( ; !flag; )
		{
			System.out.println("1.Add Contacts");
			System.out.println("2.Delete Contact based on name ");
			System.out.println("3.Display contact based on email");
			System.out.println("4.Display All Contacts");
			System.out.println("5.Update email, phonenumber, name based on id");
			System.out.println("6.Exit");
			int choose = sc.nextInt();
			switch(choose)
			{
				case 1:
				{
					ContactOperations.addContact();
					break;
				}
				case 2:
				{
					ContactOperations.delete();
					break;
				}
				case 3:
				{
					ContactOperations.display_Email();
					break;
				}
				case 4:
				{
					ContactOperations.display();
					break;
				}
				case 5:
				{
					ContactOperations.update();
					break;
				}
				case 6:
				{
					flag= true;
					break;
				}
				default :
				{
					System.out.println("choose correct option");
				}
			}
		}
		System.out.println("thank you");
	}
}
