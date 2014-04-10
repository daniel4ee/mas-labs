package zad2;

public class Account {

	private int number;
	private double balance;
	
	public Account(int number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	public void withdraw(double amount) throws NoSuchMoneyException {
		if(amount > balance) 
			throw new NoSuchMoneyException(getLackAmount(amount));
		balance -= amount;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setNumeber(String str) {
		try {
			if(str.length()!=8)
				throw new NumberFormatException();
			
			String checksumStr = str.substring(7);
			int obtainedChecksum = Integer.decode(checksumStr);
			
			String numberStr = str.substring(0, 7);
			int newNumber = Integer.decode(numberStr);
			
			int countedChecksum = 0;
			int[] weights = new int [] {7, 1, 3, 9, 7, 11, 3 };
			char[] numertoChar = numberStr.toCharArray();
			for (int i = 0; i < numertoChar.length; i++) {
				countedChecksum += (numertoChar[i]-'0') * weights[i];
			}
			countedChecksum %= 10;
			if(countedChecksum != obtainedChecksum)
				throw new ChecksumException(numberStr, countedChecksum, obtainedChecksum);
			
			number = newNumber;
			
		} catch (ChecksumException e) {
			e.printStackTrace();
		} finally {
			balance = 0;
		}
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}

	private double getLackAmount(double amount) {
		return Math.abs(balance-amount);
	}
	
}
