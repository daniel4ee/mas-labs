package zad2;

public class MainApp {

	public static void main(String[] args) {

		Account k1 = new Account(1, 85);
		try {
			k1.withdraw(12.);
		
			String propAccountNumber = "10103421";
			String wrngAccountNumber = "10103422";
			k1.setNumeber(wrngAccountNumber);
			k1.setNumeber(propAccountNumber);

			k1.setBalance(112);
			System.out.println(k1);
			
		} catch (NoSuchMoneyException e) {
			e.printStackTrace();
		}
	}

}
