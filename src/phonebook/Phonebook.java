package phonebook;

import java.util.*;

public class Phonebook extends Executive
{
	private int length;
	private Person[] parr;
	
	public Phonebook()
	{
		this.length = 0;
		this.parr = new Person[0];
	}
	
	public Phonebook(Phonebook pb, Person add)
	{
		this.length = pb.length + 1;
		this.parr = new Person[this.length];
		if (pb.length >= 0) System.arraycopy(pb.parr, 0, this.parr, 0, pb.length);
		this.parr[this.length - 1] = add;
	}
	
	public void addEntry(Scanner in)
	{
		Person n = new Person();
		Person[] arr = new Person[this.length + 1];
		in.nextLine();

		System.out.println("enter first name : ");
		n.setFirstName(in.nextLine());
		System.out.println("enter last name : ");
		n.setLastName(in.nextLine());
		System.out.println("enter phone number : ");
		String pn = "";
		do
		{
			try
			{
				pn = in.nextLine();
				if (pn.length() == 10)
				{
					n.setPhoneNumber(pn);
				}
				else
				{
					throw new java.util.InputMismatchException();
				}
			}
			catch (java.util.InputMismatchException k)
			{
				System.out.println("please enter a valid 10 digit phone number");
			}
		}while (pn.length() != 10);

		n.setAddress(in);

		if (this.length >= 0) System.arraycopy(this.parr, 0, arr, 0, this.length);
		arr[this.length++] = n;
		this.parr = arr;
		System.out.println(n + " has been added to the phone book");
	}

	public void removeEntry(String phoneNumber)
	{
		Person[] arr = new Person[this.length - 1];
		int i = 0, j = 0;
		while (j < this.parr.length)
		{
			if (this.parr[j].getPhoneNumber().equals(phoneNumber))
			{
				j++;
			}
			else
			{
				arr[i++] = this.parr[j++];
			}
		}
		System.out.println(this.getEntry(phoneNumber).getFullName() + " has been removed from the phonebook");
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
					case 1 :
						for (int i = 0; i < this.parr.length; i++)
						{
							if (this.parr[i].getFirstName().toLowerCase().contains(str))
							{
								searched.append(i).append(", ");
								count++;
							}
						}

						break;
					case 2 :
						for (int i = 0; i < this.length; i++)
						{
							if (this.parr[i].getLastName().toLowerCase().contains(str))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
					case 3 :
						for (int i = 0; i < this.length; i++)
						{
							if (((this.parr[i].getFirstName() + " " + this.parr[i].getLastName()).toLowerCase()).contains(str))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
					case 4 :
						for (int i = 0; i < this.length; i++)
						{
							if ((this.parr[i].getPhoneNumber().toLowerCase()).contains(str))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
					case 5 :
						for (int i = 0; i < this.length; i++)
						{
							if ((this.parr[i].getAddress().getCity().toLowerCase()).contains(str))
							{
								searched.append(i).append(", ");
								count++;
							}
						}
						break;
					case 6 :
						for (int i = 0; i < this.length; i++)
						{
							if ((this.parr[i].getAddress().getState().toLowerCase()).contains(str))
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
					String pn = "";
					do
					{
						try
						{
							pn = in.nextLine();
							if (pn.length() == 10)
							{
								this.getEntry(phoneNumber).setPhoneNumber(pn);
							}
							else
							{
								throw new java.util.InputMismatchException();
							}
						}
						catch (java.util.InputMismatchException h)
						{
							System.out.println("please enter a valid 10 digit phone number");
						}
					}while (pn.length() != 10);
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
							in.nextLine();
							System.out.println("Please enter desired zip code : ");
							this.getEntry(phoneNumber).getAddress().setZipCode(in.nextLine());
						}
					}
				}
			}
			System.out.println("Entry has been successfully updated, and now reads :\n\t" + this.getEntry(phoneNumber));
		}
	}

	public void sortPhoneBook()
	{
		String[] strArr = new String[this.length];
		for (int i = 0; i < this.length; i++)
		{
			strArr[i] = this.parr[i].getFullName().toLowerCase();
		}

		Arrays.sort(strArr);
		for (int i = 0; i < this.length; i++)
		{
			for (int j = 0; j < this.length; j++)
			{
				if (strArr[i].equals(this.parr[j].getFullName().toLowerCase()))
				{
					Person tmp = this.parr[i];
					this.parr[i] = this.parr[j];
					this.parr[j] = tmp;
				}
			}
		}
	}
	
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
