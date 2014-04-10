package zad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {
	
	public static void main(String[]s) {
	
		Package p1 = new Package(30, 20, 10, 10);
		Package p2 = new Package(50, 40, 5,  100);
		Package p3 = new Package(10, 10, 10, 400);
		
		System.out.println("Porownanie paczek\n\t" + p1 + "\n\t" + p2);
		System.out.println( "Wieksza paczka\n\t" + (p1.compareTo(p2) > 0?  p1: p2) );
		
		List<Package> list = new ArrayList<Package>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		Collections.sort(list);
		System.out.println("Posortowana:\t" + list);
		
		System.out.println("Najmniejsza:\t" + Collections.min(list));
	}
		
}
