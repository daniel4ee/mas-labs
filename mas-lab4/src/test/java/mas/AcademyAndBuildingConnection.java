package mas;

import mas.tools.MyCalendar;
import org.junit.Test;

public class AcademyAndBuildingConnection {


    @Test
    public void testConnections() {
        Building buildingA = new Building(
                new Address("Warsaw", "Koszykowa 86", "02-008"),
                "Budynek A");
        Building buildingB = new Building(
                new Address("Warsaw", "Koszykowa 86", "02-008"),
                "Budynek B");

        Building buildingBytom = new Building(
                new Address("Bytom", "Aleja Legionów 2", "41-902"),
                "Wydział zamiejscowy informatyki w Bytomiu");

        Professor p1 = new Professor("Jan", "Kowalski",
                new Address("Warsaw", "Jerozolimkie 2", "11-009"),
                MyCalendar.getBirthDate(12, 1, 1970),
                AcademicTitle.BSc);

        Academy academy = new Academy("Pjwstk", buildingA);
        academy.addBuilding(buildingB);
        academy.addBuilding(buildingBytom);
        academy.addProfessor(p1);

        System.out.println(academy);
    }
}
