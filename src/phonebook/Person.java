package phonebook;

import java.util.Scanner;

public class Person extends Phonebook
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address adr;
	
	public Person() 
	{
		this.firstName = "";
		this.lastName = "";
		this.phoneNumber = "";
		this.adr = null;
	}
	
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
		
		System.out.println("enter street : ");
			ad.setStreet(in.nextLine());
		System.out.println("enter city : ");
			ad.setCity(in.nextLine());
		System.out.println("enter state : ");
			ad.setState(in.nextLine());
		System.out.println("enter zip code : ");
			ad.setZipCode(in.nextLine());
		this.adr = ad;
	}
	
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
	
	@Override
	public String toString()
	{
		return this.firstName + " " + this.lastName + " | " + this.adr + " | (" + this.phoneNumber.substring(0, 3)
				+ ") " + this.phoneNumber.substring(3, 6) + "-" + this.phoneNumber.substring(6, 10);
	}
}
