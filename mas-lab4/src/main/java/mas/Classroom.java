package mas;

import mas.tools.Printable;

import java.util.HashMap;
import java.util.Map;

public class Classroom implements Printable {

	private String id;
	private Map<String, Integer> equipments = new HashMap<>();

    private final Building building;

	private Classroom(Building building, String id) {
        verifyId(id);
		this.building = building;
        this.id = id;
	}

    private void verifyId(String id) {
        if(id.contains(","))
            throw new IllegalArgumentException("id = " + id + " is incorrect");
    }

    public static Classroom createClassroom(Building building, String id) {
        if (building == null || id == null)
            throw new NullPointerException();
        if (building.hasClassroom(id))
            throw new IllegalArgumentException("Classroom with id = " + id + " exists in building");
        Classroom newClassroom = new Classroom(building, id);
        building.addClassroom(newClassroom);
        return newClassroom;
    }

    public int addEquipment(String equipment) {
        return addEquipment(equipment, 1);
    }

	public int addEquipment(String equipment, int quantity) {
		if(equipment == null || quantity <= 0)
			throw new IllegalArgumentException();
		int prevQuantity = 0;
		if(equipments.containsKey(equipment)) {
			prevQuantity = equipments.get(equipment);
		}
		equipments.put(equipment, quantity + prevQuantity);
		return quantity + prevQuantity;
	}

    public int getQuantityOfEquipment(String equipmentName) {
        Integer q = equipments.get(equipmentName);
        return q == null? 0 : q;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "building=" + building.getName() +
                ", id=" + id +
                ", equipments=" + equipments +
                '}';
    }

    public static void main(String[] s) {
        Building building = new Building(new Address("Warsaw", "Koszykowa 1", "02-111"), "Budynek A");

        Classroom c1 = Classroom.createClassroom(building, "c101");
        c1.addEquipment("computer", 5);
		c1.addEquipment("computer", 4);
        c1.addEquipment("keyboard", 5);

        Classroom c2 = Classroom.createClassroom(building, "c102");
        c2.addEquipment("video projector");

        System.out.println(c1);
        System.out.println(c2);
    }

}
