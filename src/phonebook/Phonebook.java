package phonebook;

import java.util.Arrays;
import java.util.Scanner;

public class Phonebook extends Executive
{
	private int length;
	private Person[] parr;
	
//	CONSTRUCTORS
	public Phonebook()
	{
		this.length = 0;
		this.parr = new Person[0];
	}
	
	/*public Phonebook(int length)
	{
		this.length = length;
		this.parr = new Person[this.length];
	}*/
	
	public Phonebook(Phonebook pb, Person add)
	{
		this.length = pb.length + 1;
		this.parr = new Person[this.length];
		for (int i = 0; i < pb.length; i++)
		{
			this.parr[i] = pb.parr[i];
		}
		this.parr[this.length - 1] = add;
	}
	
//	METHODS
	public void addEntry(Scanner in)
	{
		Person n = new Person();
		Person[] arr = new Person[this.length + 1];

		System.out.println("enter first name : ");
			n.setFirstName(in.next());
		System.out.println("enter last name : ");
			n.setLastName(in.next());
		System.out.println("enter phone number : ");
			n.setPhoneNumber(in.next());
			n.setAddress(in);

		for (int i = 0; i < this.length; i++)
		{
			arr[i] = this.parr[i];
		}
		arr[this.length++] = n;
		this.parr = arr;
		System.out.println(n + " has been added to the phone book");
	}

	public void sortPhoneBook()
	{
		Arrays.sort(this.parr);
	}
	
	public void updateEntry(String phoneNumber, Scanner in)
	{
		if (this.getEntry(phoneNumber) == null)
		{
			System.out.println("There is not an entry with this phone number in this phonebook");
		}
		else
		{
			System.out.println("Input number corresponding to what you would like to change\n"
					+ "1) First Name\n2) Last Name\n3) Phone Number\n4) Address");
			switch (in.nextInt()) {
				case 1 ->
				{
					System.out.println("Please input desired first name : ");
					this.getEntry(phoneNumber).setFirstName(in.next());
				}
				case 2 ->
				{
					System.out.println("Please input desired last name : ");
					this.getEntry(phoneNumber).setLastName(in.next());
				}
				case 3 ->
				{
					System.out.println("Please input desired phone number : ");
					String pn = in.next();
					this.getEntry(phoneNumber).setPhoneNumber(pn);
					phoneNumber = pn;
				}
				case 4 ->
				{
					System.out.println("Which part of this entry's address would you like to update? : ");
					System.out.println("\t1) Street\n\t2) City\n\t3) State\n\t4) Zip Code");
					switch (in.nextInt())
					{
						case 1 ->
						{
							in.nextLine();
							System.out.println("Please enter desired street address : ");
							this.getEntry(phoneNumber).getAddress().setStreet(in.nextLine());
						}
						case 2 ->
						{
							in.nextLine();
							System.out.println("Please enter desired city : ");
							this.getEntry(phoneNumber).getAddress().setCity(in.nextLine());
						}
						case 3 ->
						{
							in.nextLine();
							System.out.println("Please enter desired state : ");
							this.getEntry(phoneNumber).getAddress().setState(in.nextLine());
						}
						case 4 ->
						{
							System.out.println("Please enter desired zip code : ");
							this.getEntry(phoneNumber).getAddress().setZipCode(in.nextInt());
						}
					}
				}
			}
			System.out.println("Entry has been successfully updated, and now reads :\n\t" + this.getEntry(phoneNumber));
		}
	}
	
	public void removeEntry(String phoneNumber)
	{
		Person[] arr = new Person[this.length - 1];
		int i = 0, j = 0;
		while (j < this.parr.length)
		{
			if (this.parr[j].getPhoneNumber().equals(phoneNumber))
			{
				i++;
			}
			else
			{
				arr[j++] = this.parr[i++];
			}
		}
		System.out.println(this.getEntry(phoneNumber) + " has been removed from the phonebook");
		this.parr = arr;
		this.length--;
	}
	
	public Person[] search(int mode, String str)
	{
		try
		{
			if((mode >= 1) && (mode <= 6))
			{
				StringBuilder searched = new StringBuilder();
				int count = 0;
				str = str.toLowerCase();
				switch (mode)
				{
//					FIRST NAME
					case 1 : 
						for (int i = 0; i < this.parr.length; i++)
						{
							System.out.println(this.parr[i].getFirstName());
							if (str.equals(this.parr[i].getFirstName().toLowerCase()))
							{
								searched.append(i).append(", ");
								System.out.println(i + ", " + this.parr[i]);
								count++;
							}
						}
						
						break;
//					LAST NAME
					case 2 :
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals(this.parr[i].getLastName().toLowerCase()))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
//					FULL NAME
					case 3 :
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals((this.parr[i].getFirstName() + " " + this.parr[i].getLastName()).toLowerCase()))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
//					PHONE NUMBER
					case 4 : 
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals(this.parr[i].getPhoneNumber().toLowerCase()))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
//					CITY
					case 5 :
						for (int i = 0; i < this.length; i++)
						{
							if(str.equals(this.parr[i].getAddress().getCity().toLowerCase()))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
//					STATE
					case 6 :
						for (int i = 0; i < this.length; i++)
						{
							if(str.equals(this.parr[i].getAddress().getState().toLowerCase()))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
				}
				Person[] arr = new Person[count];
				for (int i = 0; i < count; i++)
				{
					arr[i] = this.parr[Integer.parseInt(searched.substring(0, searched.toString().indexOf(',')))];
					searched = new StringBuilder(searched.substring(searched.toString().indexOf(',') + 2));
				}
				return arr;
			}
			else
			{
				throw new java.util.InputMismatchException();
			}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("search function not reached");
			return null;
		}
	}
	
//	GETTERS
	public int getLength()
	{
		return this.length;
	}
	
	public Person getEntry(int i)
	{
		return this.parr[i];
	}
	
	public Person getEntry(String phoneNumber)
	{
		for (int i = 0; i < this.getLength(); i++)
		{
			if (this.parr[i].getPhoneNumber().equals(phoneNumber))
			{
				return this.parr[i];
			}
		}
		return null;
	}
}
