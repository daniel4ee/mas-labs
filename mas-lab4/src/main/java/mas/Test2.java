package mas;
import mas.tools.MyCalendar;

public class Test2 {

	public static void main(String[] args) {

		Professor p = new Professor("Joseph", "Booch", new Address("Usa", "NY",
				"WallStreet", "323"), MyCalendar.getBirthDate(15, 12, 1962),
				AcademicTitle.Prof);
		System.out.println(p);

	}

}
