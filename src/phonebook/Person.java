package phonebook;

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
		this.adr = new Address();
	}
	
	public Person(String firstName, String lastName, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.adr = new Address();
	}
	
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
	
	public void setAddress()
	{
		this.adr = new Address();
	}
	
	public void setAddress(String street, String city, String state, int zipCode)
	{
		Address t = new Address(street, city, state, zipCode);
		this.adr = t;
	}
	
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
