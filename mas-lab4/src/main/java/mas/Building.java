package mas;
import mas.Address;
import mas.tools.Extension;


@SuppressWarnings("serial")
public class Building extends Extension {
	
	private Address address;
	private String name;

	public Building(Address address, String name) {
		if(address == null || name == null)
			throw new NullPointerException();
		this.address = address;
		this.name = name;
	}
	

}
