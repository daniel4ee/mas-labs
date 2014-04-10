package mas;
import java.util.HashMap;
import java.util.Map;

public class Classroom {

	private String id;
	private Map<String, Integer> equipments = new HashMap<>();

	public Classroom(String id) {
		if (id == null)
			throw new NullPointerException();
		this.id = id;
	}
	
	public int addEquipment(String equipment, int quantity) {
		if(equipment == null || quantity <= 0)
			throw new IllegalArgumentException();
		int prevQuantity = 0;
		if(equipments.containsKey(equipment)) {
			prevQuantity = equipments.get(equipment);
		}
		equipments.put(equipment, quantity + prevQuantity);
		return equipments.get(equipment);
	}
	
	
	
	@Override
	public String toString() {
		return "Class [id=" + id + ", equipments=" + equipments + "]";
	}

	public static void main(String[] s) {
		Classroom c = new Classroom("113");
		c.addEquipment("computer", 5);
		System.out.println(c);
		c.addEquipment("computer", 4);
		System.out.println(c);
		
	}

}
