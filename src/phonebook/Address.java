package phonebook;

public class Address extends Person
{
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address()
	{
		this.street = "";
		this.city = "";
		this.state = "";
		this.zipCode = "";
	}
	
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
	
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
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
	
	public String getZipCode()
	{
		return this.zipCode;
	}
	
	@Override
	public String toString()
	{
		return this.street + ", " + this.city + ", " + this.state + ", " + this.zipCode;
	}
}
