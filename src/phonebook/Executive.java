package phonebook;

import java.util.*;

//	https://docs.google.com/document/d/1EVRzwlyxzhlAgko6NICkMpigJnDeX2Qk/edit?usp=sharing&ouid=110400127471324653037&rtpof=true&sd=true

public class Executive 
{
	private static Person selected;
	public static Phonebook t1;
	
	public static void main(String[] args) 
	{
		t1 = new Phonebook();
		Scanner in = new Scanner(System.in);
		testPop();
		menu(in);
		in.close();
	}
	
	public static void testPop()
	{
		Person p1 = new Person("tyler", "okonma", "3149618432", "125 Donut Road", "Los Angeles", "California", 60132);
		t1 = new Phonebook(t1, p1);
		Person p2 = new Person("travis", "scott", "6368419024", "305 Sweet Street", "Hollywood", "California", 90210);
		t1 = new Phonebook(t1, p2);
		Person p3 = new Person("kanye", "West", "3144789832", "200 Gaming Avenue", "St. Louis", "Illinois", 60032);
		t1 = new Phonebook(t1, p3);
		Person p4 = new Person("Peter", "griffin", "6361035829", "204 Funny Road", "New York", "New York", 84267);
		t1 = new Phonebook(t1, p4);
		Person p5 = new Person("Matt", "Hardy", "1034892012", "1093 Gaming Avenue", "New York", "New York", 84267);
		t1 = new Phonebook(t1, p5);
		Person p6 = new Person("marge", "Simpson", "1003904958", "2908 Morty Lane", "Detroit", "Michigan", 10003);
		t1 = new Phonebook(t1, p6);
	}

	public static void menu(Scanner in)
	{
		boolean sentinel = true;
		int choice = 0;
		
		try
		{
			while (sentinel)
			{
				System.out.println("\n*****PHONEBOOK*****\n\n1) Add new record\n2) Delete a record"
						+ "\n3) Search for an existing entry\n4) Update an existing entry"
						+ "\n5) Show all records in ascending order\n6) Exit\n");
				choice = in.nextInt();
				
				switch (choice)
				{
//					add new record
					case 1 : 
						t1 = Phonebook.addEntry(t1, in);
						break;
					
//					delete a record
					case 2 :
						System.out.println("Input phone number to delete record of : ");
						t1 = t1.removeEntry(in.next());
						break;
					
//					search
					case 3 : 
						search(in);
						break;
					
//					update entry
					case 4 :
						System.out.println("Input phone number to update record of : ");
						t1.updateEntry(in.next());
						break;
						
//					show all
					case 5: ;
						break;
						
//					exit
					case 6: sentinel = false;
						break;
						
					default : throw new java.util.InputMismatchException();	
				}
				in.nextLine();
				choice = 0;
				System.out.println("Continue using phone book? (true / false) : ");
				sentinel = in.nextBoolean();
			}
		}
		catch(java.util.InputMismatchException e)
		{
			
		}
		
		
	}
	
	public static void search(Scanner in)
	{
		System.out.println("Search using...\n1) First name\n2) Last name\n3) Full name\n4) Phone number\n5) City\n6) State\n");
		int choice = in.nextInt();
		in.nextLine();
		System.out.println("enter term to search by : ");
		String str = in.nextLine();
		Person[] arr = t1.search(choice, str);
		
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
				t1.updateEntry(selected.getPhoneNumber());
			}
			else if (choice == 2)
			{
				t1 = t1.removeEntry(selected.getPhoneNumber());
				System.out.println(selected + " has been removed from phone book");
			}
		}
	}
}
