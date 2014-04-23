package mas;

import mas.tools.Printable;

import java.io.Serializable;

/** Klasa reprezentuje adres - ATRYBUT Z�O�ONY */
@SuppressWarnings("serial")
public class Address implements Serializable, Printable {

	private String city;
	private String street;
	private String zipCode;

	public Address(String city, String street, String zipCode) {
		if (city == null || street == null || zipCode == null)
			throw new NullPointerException();
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    //    public String toString(int offset) {
//        StringBuilder sb = new StringBuilder();
//        Formatter formatter = new Formatter(sb);
//        String templateForHeader = MyFormatter.countTemplateForHeader(offset + 1);
//        String template = MyFormatter.countTemplate(offset + 1);
//
//        formatter.format(templateForHeader, "", getClass().getSimpleName());
//        formatter.format(template, "", city);
//        formatter.format(template, "", street);
//        formatter.format(template, "", zipCode);
//        return sb.toString();
//    }

    public String toPaddedString(int padsize) {
        return "";
    }

    public static void main(String[] args) {
        Address a1 = new Address("Warszawa", "Koszykowa", "02-884");
        System.out.println(a1);
    }

}
