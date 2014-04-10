package mas.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/** Klasa zapewnia dost�p do ekstensji oraz utrwalenie ekstensji */
@SuppressWarnings("serial")
public abstract class Extension implements Serializable {

	private static HashMap<Class<?>, List<Extension>> map = new HashMap<>();

	public static final File filePath = new File("mas-lab3/src/main/resources/ekstensja.dat");

	public Extension() {

		List<Extension> list =  map.get(this.getClass());
		if (list == null) {
			list = new ArrayList<>(); // create new list
			map.put(this.getClass(), list);
		}
		list.add(this);
	}

	/**
	 * Zwraca list� wszystkich wyst�pie� klasy c
	 */
	public static List<Extension> getExtensionOf(Class<?> c) {
		if (!map.containsKey(c))
			throw new NoSuchElementException("Unknown class");
		return Collections.unmodifiableList(map.get(c));
	}

	/**
	 * Zwraca zbi�r klas, kt�rych wyst�pienia s� zapisane w ekstensji
	 */
	public static Set<Class<?>> getSavedClass() {
		return Collections.unmodifiableSet(map.keySet());
	}

	/**
	 * Zapisuje ekstensj� do pliku
	 */
	public static void writeExtension(File out) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				out));
		oos.writeObject(map);
		oos.close();
	}

	/**
	 * Odczytuje ekstensj� z pliku. Je�eli powoduje nadpisanie dotychczasowej
	 * ekstensji zg�asza wyj�tek.
	 */
	@SuppressWarnings("unchecked")
	public static void readExtension(File in) throws Exception {
		if (!map.isEmpty())
			throw new Exception("Extension contains objects. Can't overwrite.");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(in));
		map = (HashMap<Class<?>, List<Extension>>) ois.readObject();
		ois.close();
	}

}
