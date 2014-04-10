package mas;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import mas.tools.Extension;

/** Podstawowa klasa logiki biznesowej */
@SuppressWarnings("serial")
public class Person extends Extension {

	private String firstName;

	private String middleName; // atrybut opcjonalny, null

	private String lastName;

	private Address address; // atrybut z�o�ony

	private Set<String> numbers = new HashSet<>(); // atrybut powtarzalny (unikalny)

	private Date birthdate;

	private int age; // atrybut pochodny

	public static final String origin = "Ziemia"; // atrybut klasowy

	public Person(String firstName, String surname, Address address,
			Date birthdate) {
		if (firstName == null || surname == null || address == null
				|| birthdate == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = surname;
		this.address = address;
		this.birthdate = birthdate;
		getAge();
	}

	/** Dodaje numer telefonu, artybut z�o�ony */
	public void addNumber(String num) {
		if (num == null)
			throw new NullPointerException();
		numbers.add(num);
	}

	/** Ustawia drugie imie, dozwolona warto�� null */
	public void setSecondName(String secondName) {
		this.middleName = secondName;
	}

	/** Ustala warto�� atrybutu pochodnego 'age' */
	public int getAge() {
		Calendar nowCal = Calendar.getInstance();
		Calendar birthdayCal = Calendar.getInstance();
		birthdayCal.setTime(birthdate);
		return age = nowCal.get(Calendar.YEAR) - birthdayCal.get(Calendar.YEAR);
	}
	
	/** Metoda do przes�oni�cia */
	public void introduceYourself() {
		System.out.println("Dzie� dobry, jestem " + firstName);
	}
	
	/** Przeci��enie metod */
	public void introduceYourFriend(Person p1) {
		if(p1 == null) throw new NullPointerException();
		if(p1 == this) throw new IllegalArgumentException();
		System.out.println("To jest moj przyjaciel " + p1.getFirstName());
	}
	
	/** Przeci��enie metod */
	public void introduceYourFriend(Person p1, String adj) {
		if(p1 == null) throw new NullPointerException();
		if(p1 == this) throw new IllegalArgumentException();
		System.out.println("To jest moj " + adj + " przyjaciel " + p1.getFirstName());
	}

	/** Zwraca najstarsz� osob� z ca�ej ekstensji */
	public static Person getTheOldest() {

		Person oldest = null;
		Person oldestInClass = null;
		Set<Class<?>> classes = Extension.getSavedClass();
		if (classes.isEmpty())
			throw new RuntimeException("Extension is empty");
		Iterator<Class<?>> iter = classes.iterator();
		while(iter.hasNext()) {
			Class<?> c = iter.next();
			List<?> list = Extension.getExtensionOf(c);
			oldestInClass = (Person) list.get(0);
			for(int i=1; i < list.size() ; i++) {
				Person p = (Person) list.get(i);
				if(p.getAge() > oldestInClass.getAge())
					oldestInClass = p;
			}
			if(oldest == null || oldest.getAge() < oldestInClass.getAge()) 
				oldest = oldestInClass;
		}
		return oldest;
	}

	@Override
	public String toString() {
		return "\n" + getClass().getSimpleName() + "\n\tfirstName=" + firstName
				+ ",\n\tmiddleName=" + middleName + ",\n\tlastName=" + lastName
				+ ",\n\taddress=" + address + ",\n\tnumbers=" + numbers
				+ ",\n\tbirthdate=" + birthdate + ",\n\tage=" + age;
	}

	public String getFirstName() {
		return firstName;
	}

}
