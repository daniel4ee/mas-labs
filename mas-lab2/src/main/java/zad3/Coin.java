package zad3;

public enum Coin {
	
	_1zl(1),
	_2zl(2),
	_5zl(5);
	
	private int value;

	private Coin(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		switch(value) {
		case 1 : return value + " zloty";
		case 2 : return value + " zlote";
		case 5 : return value + " zlotych";
		default : return "nieznana wartosc";
		}
	}
}
