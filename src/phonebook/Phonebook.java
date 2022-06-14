package phonebook;

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
	
	public Phonebook(int length)
	{
		this.length = length;
		this.parr = new Person[this.length];
	}
	
	public Phonebook(Phonebook pb, Person add)
	{
		this.length = pb.length + 1;
		this.parr = new Person[this.length];
		for (int i = 0; i < pb.length; i++)
		{
			this.parr[i] = pb.parr[i];
		}
		this.parr[this.length - 1] = add;
		
		/*for (int i = 0; i < this.length; i++)
		{
			System.out.println(this.parr[i] + "\n");
		}
		System.out.println("\n");*/
	}
	
//	METHODS
	public static Phonebook addEntry(Phonebook pb, Scanner in)
	{
		Person n = new Person();
		
		System.out.println("enter first name : ");
			n.setFirstName(in.next());
		System.out.println("enter last name : ");
			n.setLastName(in.next());
		System.out.println("enter phone number : ");
			n.setPhoneNumber(in.next());
		
		n.setAddress(in);
		
		pb = new Phonebook(pb, n);
		
		System.out.println(n + " has been added to the phone book");
		return pb;
	}
	
	public void updateEntry(String phoneNumber)
	{
		Scanner in = new Scanner(System.in);
		
		if (this.getEntry(phoneNumber) == null)
		{
			System.out.println("There is not an entry with this phone number in this phonebook");
		}
		else
		{
			System.out.println("Input number corresponding to what you would like to change\n"
					+ "1) First Name\n2) Last Name\n3) Phone Number\n4) Address");
			switch (in.nextInt())
			{
				case 1 : 
					System.out.println("Please input desired first name : ");
					this.getEntry(phoneNumber).setFirstName(in.next());
					break;
					
				case 2 :
					System.out.println("Please input desired last name : ");
					this.getEntry(phoneNumber).setLastName(in.next());
					break;
					
				case 3 :
					System.out.println("Please input desired phone number : ");
					this.getEntry(phoneNumber).setPhoneNumber(in.next());
					break;
					
				case 4 :
					System.out.println("Please input desired last name : ");
					this.getEntry(phoneNumber).setLastName(in.next());
					break;
			}
		}
		in.close();
	}
	
	public Phonebook removeEntry(String phoneNumber)
	{
		Phonebook tpb = new Phonebook(this.length - 1);
		int i = 0, j = 0;
		while (j < this.parr.length)
		{
			if (this.parr[j].getPhoneNumber().equals(phoneNumber))
			{
				i++;
			}
			else
			{
				tpb.parr[j++] = this.parr[i++];
			}
		}
		return tpb;
	}
	
	public Person[] search(int mode, String str)
	{
		try
		{
			if((mode >= 1) && (mode <= 6))
			{
				String searched = "";
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
								searched += (i + ", ");
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
								searched += (i + ", ");
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
								searched += (i + ", ");
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
								searched += (i + ", ");
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
								searched += (i + ", ");
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
								searched += (i + ", ");
								count++;
							}
						}
						break;
				}
				Person[] arr = new Person[count];
				for (int i = 0; i < count; i++)
				{
					arr[i] = this.parr[Integer.valueOf(searched.substring(0, searched.indexOf(',')))];
					searched = searched.substring(searched.indexOf(',') + 2);
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
