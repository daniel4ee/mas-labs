package mas;
import java.util.Date;

@SuppressWarnings("serial")
public class Professor extends Person {

	private AcademicTitle academicTitle;

	public Professor(String firstName, String surname, Address address,
			Date birthdate, AcademicTitle academicTitle) {
		super(firstName, surname, address, birthdate);
		if (academicTitle == null)
			throw new NullPointerException();
		this.academicTitle = academicTitle;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tProfesor [academiTitle=" + academicTitle
				+ "]";

	}

}
