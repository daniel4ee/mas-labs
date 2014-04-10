package zad2;

public class ChecksumException extends Exception {

	private static final long serialVersionUID = -6229705590978903117L;

	public ChecksumException(String number, int calculated, int obtained) {
		super("Dla numeru:'" + number + "', obliczona sumakontrolna to:" + calculated + ", otrzymano:" + obtained);
	}

	
}
