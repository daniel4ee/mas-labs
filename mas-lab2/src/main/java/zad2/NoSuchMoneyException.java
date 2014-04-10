package zad2;

@SuppressWarnings("serial")
public class NoSuchMoneyException extends Exception {

	public NoSuchMoneyException(double value) {
		super("Nie ma tyle srodkow na koncie, zabraklo: " + value);
		
	}

	
}
