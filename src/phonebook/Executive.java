package phonebook;

import java.util.*;

//	https://docs.google.com/document/d/1EVRzwlyxzhlAgko6NICkMpigJnDeX2Qk/edit?usp=sharing&ouid=110400127471324653037&rtpof=true&sd=true

public class Executive 
{
	private static Person selected;
	
	public static void main(String[] args) 
	{
		Phonebook t1 = new Phonebook();
		menu(t1);
	}

	public static void menu(Phonebook pb)
	{
		Scanner in = new Scanner(System.in);
		boolean sentinel = true;
		
		try
		{
			while (sentinel)
			{
				System.out.println("*****PHONEBOOK*****\n\n1) Add new record\n2) Delete a record"
						+ "\n3) Search for an existing entry\n4) Update an existing entry"
						+ "\n5) Show all records in ascending order\n6) Exit\n");
				
				switch (in.nextInt())
				{
//					add new record
					case 1 : 
						addEntry(pb);
						break;
					
//					delete a record
					case 2 : ;
						break;
					
//					search
					case 3 : 
						search(pb);
						break;
					
//					update entry
					case 4 : ;
						break;
						
//					show all
					case 5: ;
						break;
						
//					exit
					case 6: sentinel = false;
						break;
						
					default : throw new java.util.InputMismatchException();	
				}
			}
		}
		catch(java.util.InputMismatchException e)
		{
			
		}
		
		in.close();
	}
	
//	ADD ENTRY	
	public static void addEntry(Phonebook pb)
	{
		Scanner in = new Scanner(System.in);
		Person n = new Person();
		System.out.println("enter first name : ");
			n.setFirstName(in.next());
		System.out.println("enter last name : ");
			n.setLastName(in.next());
		System.out.println("enter phone number : ");
			n.setPhoneNumber(in.next());
		
		n.setAddress(); //POSSIBLY MOVE USER IN TO CONSTRUCTOR
		System.out.println("enter street : ");
			n.getAddress().setStreet(in.next());
		System.out.println("enter city : ");
			n.getAddress().setCity(in.next());
		System.out.println("enter state : ");
			n.getAddress().setState(in.next());
		System.out.println("enter zip code : ");
			n.getAddress().setZipCode(in.nextInt());
		
		pb = new Phonebook(pb, n);
		selected = n;
		in.close();
	}
	
	public static void search(Phonebook pb)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Search using...\n1) First name\n2) Last name\n3) Full name\n4) Phone number\n5) City\n6) State\n");
		int choice = in.nextInt();
		System.out.println("enter term to search by : ");
		String str = in.nextLine();
		Person[] arr = pb.search(choice, str);
		
		System.out.println("Showing results for " + str + "...");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println((i + 1) + ") " + arr[i]);
		}
		System.out.println("Select an entry by inputting its corresponding number, or enter 0 to return to main menu");
		choice = in.nextInt() - 1;
		
		if ((choice > -1) && (choice < arr.length))
		{
			selected = arr[choice];
			System.out.println("User has selected " + selected.getFullName() + 
					"\nwould you like to...1) Update Entry\n2) Delete Entry\n3) Return to main menu");
			choice = in.nextInt();
			if (choice == 1)
			{
				pb.updateEntry(selected);
			}
			else if (choice == 2)
			{
				pb = pb.removeEntry(selected);
				System.out.println(selected + " has been removed from phone book");
			}
		}
		
		in.close();
	}
}
