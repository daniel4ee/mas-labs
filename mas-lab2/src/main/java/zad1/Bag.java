package zad1;

public class Bag implements Comparable<Bag>, Stackable{

	private int weight;
	private int height;
	private int diameter;	// srednica
	
	public Bag(int weight, int height, int diameter) {
		this.weight = weight;
		this.height = height;
		this.diameter = diameter;
	}

	@Override
	public int compareTo(Bag o) {
		if(getLoad() > o.getLoad()) return 1;
		if(getLoad() < o.getLoad()) return -1;
		return 0;
	}
	
	private double getLoad() {
		return (Math.PI * Math.pow(diameter/2, 2.) * height) / (double) weight;
	}

	@Override
	public String toString() {
		return "Worek [waga=" + weight + ", srednica=" + diameter + ", wysokosc="
				+ height + ", laod=" + getLoad() +"]";
	}

	@Override
	public boolean stack(Package p) {
		return diameter >= p.getWidth() && diameter >= p.getLength() ?
				true : false;
	}
	
}
