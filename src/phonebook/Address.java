package phonebook;

//import java.util.*;

public class Address extends Person
{
	private String street;
	private String city;
	private String state;
	private int zipCode;
	
//	CONSTRUCTORS	
	public Address()
	{
		this.street = "";
		this.city = "";
		this.state = "";
		this.zipCode = 0;
	}
	
	public Address(String street, String city, String state, int zipCode)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
//	SETTERS
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}
	
//	GETTERS
	public String getStreet()
	{
		return this.street;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getState()
	{
		return this.state;
	}
	
	public int getZipCode()
	{
		return this.zipCode;
	}
	
	@Override
	public String toString()
	{
		return this.street + ", " + this.city + ", " + this.state + ", " + this.zipCode;
	}
}
