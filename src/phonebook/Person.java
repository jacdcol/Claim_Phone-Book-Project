package phonebook;

import java.util.Scanner;

public class Person extends Phonebook
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address adr;
	
//	CONSTRUCTORS
	public Person() 
	{
		this.firstName = "";
		this.lastName = "";
		this.phoneNumber = "";
		this.adr = null;
	}
	
	public Person(Scanner in) 
	{
		/*
		//Scanner in = new Scanner(System.in);
		//Person n = new Person();
		System.out.println("enter first name : ");
			this.firstName = in.next();
		System.out.println("enter last name : ");
		this.lastName = in.next();
		System.out.println("enter phone number : ");
			this.phoneNumber = in.next();
		//this.adr = new Address();
		this.adr.setAddress(in);
		//in.close();
		 * */
	}

	/*public Person(String firstName, String lastName, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.adr = new Address();
	}*/
	
	public Person(String firstName, String lastName, String phoneNumber, String street, String city, String state, int zipCode)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.adr = new Address(street, city, state, zipCode);
	}
	
//	SETTERS
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(Scanner in)
	{
		Address ad = new Address();
		in.nextLine();
		
		System.out.println("enter street : ");
		ad.setStreet(in.nextLine());
		System.out.println("enter city : ");
		ad.setCity(in.nextLine());
		System.out.println("enter state : ");
		ad.setState(in.nextLine());
		System.out.println("enter zip code : ");
		ad.setZipCode(in.nextInt());
		this.adr = ad;
	}
	
	/*public void setAddress(String street, String city, String state, int zipCode)
	{
		Address t = new Address(street, city, state, zipCode);
		this.adr = t;
	}*/
	
//	GETTERS
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getFullName()
	{
		return this.firstName + " " + this.lastName;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	public Address getAddress()
	{
		return this.adr;
	}
	
//	TO STRING
	@Override
	public String toString()
	{
		return this.firstName + " " + this.lastName + ", " + this.adr + ", " + this.phoneNumber;
	}
}
