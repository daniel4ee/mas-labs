package mas;

import mas.tools.Extension;
import mas.tools.Printable;

import java.util.*;

import static mas.tools.MyPrinter.cNl;
import static mas.tools.MyPrinter.nl;

public class Building extends Extension implements Printable {
	
	private Address address;
	private String name;

    private List<Academy> academies = new ArrayList<>();

    private Set<Classroom> classrooms = new HashSet<>();
    private static  Set<Object> allClassrooms = new HashSet<>();

	public Building(Address address, String name) {
		if(address == null || name == null)
			throw new NullPointerException();
		this.address = address;
		this.name = name;
	}

    public void addAcademy(Academy newAcademy) {
        if (newAcademy == null) throw new NullPointerException();
        if(! academies.contains(newAcademy)) {
            academies.add(newAcademy);
            newAcademy.addBuilding(this);
        }
    }

    public void addClassroom(Classroom c) {
        if (c == null) throw new NullPointerException();
        if(classrooms.contains(c) || allClassrooms.contains(c))
            throw new IllegalArgumentException("class was added to this or another building");
        allClassrooms.add(c);
        classrooms.add(c);
    }

    public boolean hasClassroom(String id) {
        for(Iterator<Classroom> i = classrooms.iterator(); i.hasNext();)
            if(i.next().getId().equals(id))
                return true;
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String academiesStr = "";
        String classroomsStr = "";
        for(Iterator<Academy> i = academies.iterator(); i.hasNext();)
            academiesStr += i.next().getName();
        for(Iterator<Classroom> i = classrooms.iterator(); i.hasNext();)
            classroomsStr += i.next().getId() + ", ";

        return "Building{"+ nl +
                "address=" + address + cNl +
                "name='" + name + '\'' + cNl +
                "academies=" + academiesStr + cNl +
                "classrooms=" + classroomsStr +
                '}';
    }

    public static void main(String[] args) {
        Building b = new Building(
                new Address("Warsaw", "Koszykowa 33", "02-88"),
                "Polsko Japońska Wyższa Szkoła Technik Komputerowych");

        Classroom c1 = Classroom.createClassroom(b, "101");
        Classroom c2 = Classroom.createClassroom(b, "102");

        System.out.println(b);
    }
}
