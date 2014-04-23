package mas;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static mas.tools.MyPrinter.*;

public class Professor extends Person {

	private AcademicTitle academicTitle;

    private List<Academy> academies = new ArrayList<>();

	public Professor(String firstName, String surname, Address address,
			Date birthdate, AcademicTitle academicTitle) {
		super(firstName, surname, address, birthdate);
		if (academicTitle == null)
			throw new NullPointerException();
		this.academicTitle = academicTitle;
	}

    public void addToAcademy(Academy newAcademy) {
        if (! academies.contains(newAcademy)) {
            academies.add(newAcademy);
            newAcademy.addProfessor(this);
        }
    }

    public void removeFromAcademy(Academy academyToRemove) {
        if (academyToRemove == null) throw new NullPointerException();
        if(academies.contains(academyToRemove)) {
            academies.remove(academyToRemove);
            academyToRemove.removeProfessor(this);
        }
    }

	@Override
	public String toString() {
        String academiesStr = "";
        for (Iterator<Academy> iter = academies.iterator(); iter.hasNext(); ) {
            academiesStr += iter.next().getName() + ", ";
        }
        return super.toString() + "\n\tProfesor [academiTitle=" + academicTitle + cNl
				+ "academies=" + academiesStr +"]";
	}

    public AcademicTitle getAcademicTitle() {
        return academicTitle;
    }

}
