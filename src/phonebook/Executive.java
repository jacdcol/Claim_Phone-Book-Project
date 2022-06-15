package phonebook;

import java.util.*;

public class Executive 
{
	public static Phonebook t1;
	
	public static void main(String[] args) 
	{
		t1 = new Phonebook();
		Scanner in = new Scanner(System.in);
		menu(in);
		in.close();
	}

	public static void menu(Scanner in)
	{
		boolean sentinel = true;
		int choice = 0;
		
		while (sentinel)
		{
			try
			{
				System.out.println("******** PHONEBOOK ********\n\t1) Add new record\n\t2) Delete a record"
						+ "\n\t3) Search for an existing entry\n\t4) Update an existing entry"
						+ "\n\t5) Show all records in ascending order\n\t6) Exit");
				try
				{
					choice = in.nextInt();
				}
				catch(java.util.InputMismatchException j)
				{
					in.nextLine();
				}

				switch (choice)
				{
					case 1 -> t1.addEntry(in);

					case 2 -> removeEntry(in);

					case 3 -> search(in);

					case 4 -> updateEntry(in);

					case 5 -> printAscending();

					case 6 -> sentinel = false;

					default -> throw new InputMismatchException();
				}

				if (choice != 6)
				{
					System.out.println("\nContinue using phone book? (true / false) : ");
					try
					{
						sentinel = in.nextBoolean();
					}
					catch(java.util.InputMismatchException f)
					{
						System.exit(0);
					}
				}
				choice = 0;
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("Please make a valid choice from the menu\n");
				choice = 0;
			}
		}
	}

	public static void removeEntry(Scanner in)
	{
		if (t1.getLength() < 2)
		{
			if (t1.getLength() == 0) System.out.println("Phonebook is empty, and entries cannot be removed");
			if (t1.getLength() == 1) System.out.println("cannot remove only entry in phonebook");
		}
		else
		{
			System.out.println("Input phone number to delete record of : ");
			String phoneNumber = in.nextLine();
			t1.removeEntry(phoneNumber);
		}
	}
	
	public static void search(Scanner in)
	{
		if (t1.getLength() < 1)
		{
			System.out.println("Cannot search an empty phone book");
		}
		else
		{
			System.out.println("Search using...\n1) First name\n2) Last name\n3) Full name\n4) Phone number\n5) City\n6) State\n");
			int choice = in.nextInt();
			in.nextLine();
			System.out.println("enter term to search by : ");
			String str = in.nextLine();
			Person[] arr = t1.search(choice, str);

			if (arr.length > 0)
			{
				System.out.println("Showing results for " + str + "...");
				for (int i = 0; i < arr.length; i++)
				{
					System.out.println("\t" + (i + 1) + ") " + arr[i]);
				}
				System.out.println("Select an entry by inputting its corresponding number, or enter 0 to return to main menu");
				choice = in.nextInt() - 1;

				if ((choice > -1) && (choice < arr.length))
				{
					Person selected = arr[choice];
					System.out.println("User has selected " + selected.getFullName() +
							"\nwould you like to...\n\t1) Update Entry\n\t2) Delete Entry\n\t3) Return to main menu");
					try
					{
						choice = in.nextInt();
					}
					catch (java.util.InputMismatchException g)
					{
						choice = 0;
					}
					if (choice == 1)
					{
						t1.updateEntry(selected.getPhoneNumber(), in);
					}
					else if (choice == 2)
					{
						t1.removeEntry(selected.getPhoneNumber());
					}
				}
			}
			else
			{
				System.out.println("No results found for " + str);
			}
		}
	}

	public static void updateEntry(Scanner in)
	{
		if (t1.getLength() < 1)
		{
			System.out.println("Phonebook does not contain any entries that can be updated");
		}
		else
		{
			in.nextLine();
			System.out.println("Enter the phone number of the entry you would like to update");
			String phoneNumber = in.nextLine();
			t1.updateEntry(phoneNumber, in);
		}
	}

	public static void printAscending()
	{
		if (t1.getLength() < 1)
		{
			System.out.println("There are no entries in the phonebook to print");
		}
		else
		{
			t1.sortPhoneBook();
			for (int i = 0; i < t1.getLength(); i++)
			{
				System.out.println(t1.getEntry(i));
			}
		}
	}
}
