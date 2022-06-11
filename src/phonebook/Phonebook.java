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
		this.parr[this.length] = add;
	}
	
//	METHODS
	public void updateEntry(Person p)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Input number corresponding to what you would like to change\n"
				+ "1) First Name\n2) Last Name\n3) Phone Number\n4) Address");
		switch (in.nextInt())
		{
			case 1 : 
				System.out.println("Please input desired first name : ");
				p.setFirstName(in.next());
				break;
				
			case 2 :
				System.out.println("Please input desired last name : ");
				p.setLastName(in.next());
				break;
				
			case 3 :
				System.out.println("Please input desired phone number : ");
				p.setPhoneNumber(in.next());
				break;
				
			case 4 :
				System.out.println("Please input desired last name : ");
				p.setLastName(in.next());
				break;
		}
		
		in.close();
	}
	
	public Phonebook removeEntry(Person p)
	{
		Phonebook tpb = new Phonebook(this.length - 1);
		int i = 0, j = 0;
		while (j < this.parr.length)
		{
			if (this.parr[j] != p)
			{
				tpb.parr[j++] = this.parr[i++];
			}
			else
			{
				i++;
			}
		}
		return tpb;
	}
	
	public Person[] search(int mode, String str)
	{
		try
		{
			if((mode >= 0) && (mode <= 2))
			{
				String searched = "";
				int count = 0;
				switch (mode)
				{
//					FIRST NAME
					case (0) : 
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals(this.parr[i].getFirstName()))
							{
								searched += (i + ", ");
								count++;
							}
						}
						
						break;
//					LAST NAME
					case (1) :
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals(this.parr[i].getLastName()))
							{
								searched += (i + ", ");
								count++;
							}
						}
						break;
//					FULL NAME
					case (2) :
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals(this.parr[i].getFirstName() + " " + this.parr[i].getLastName()))
							{
								searched += (i + ", ");
								count++;
							}
						}
						break;
//					PHONE NUMBER
					case (3) : 
						for (int i = 0; i < this.length; i++)
						{
							if (str.equals(this.parr[i].getPhoneNumber()))
							{
								searched += (i + ", ");
								count++;
							}
						}
						break;
//					CITY
					case 4 :
						for (int i = 0; i < this.length; i++)
						{
							if(str.equals(this.parr[i].getAddress().getCity()))
							{
								searched += (i + ", ");
								count++;
							}
						}
						break;
//					STATE
					case 5 :
						for (int i = 0; i < this.length; i++)
						{
							if(str.equals(this.parr[i].getAddress().getState()))
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
}
