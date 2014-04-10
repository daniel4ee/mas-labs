package mas;
import java.io.Serializable;


/** Klasa reprezentuje adres - ATRYBUT Z�O�ONY */
@SuppressWarnings("serial")
public class Address implements Serializable {

	private String country;
	private String city;
	private String street;
	private String zipCode;

	public Address(String country, String city, String street, String zipCode) {
		if (country == null || city == null || street == null
				|| zipCode == null)
			throw new NullPointerException();
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "\n\t\tcountry=" + country
				+ ",\n\t\tcity=" + city + ",\n\t\tstreet=" + street + ",\n\t\tzipCode="
				+ zipCode;
	}
	
}
