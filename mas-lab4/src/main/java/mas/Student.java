package mas;
import java.util.Date;

/** Klasa dziedzicz�ca po klasie Person - do pokazania PRZES�ONI�CIA */
@SuppressWarnings("serial")
public class Student extends Person {
	
	private String index;

	public Student(String firstName, String surname, Address address,
			Date birthdate, String index) {
		super(firstName, surname, address, birthdate);
		if(index == null) throw new NullPointerException();
		this.index = index;
	}
	
	/** Przes�oni�ta metoda przedstawiania si� */
	@Override
	public void introduceYourself() {
		System.out.println("Dzien dobry nazywam sie " + getFirstName() 
				+ " i  jestem studentem");
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tStudent [index=" + index + "]";
	}
	
}
