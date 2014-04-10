package zad1;

public class Package implements Comparable<Package>, Stackable {

	private int width;
	private int length;
	private int height;
	private int weight;

	public Package(int width, int length, int height, int weight) {
		this.width = width;
		this.length = length;
		this.height = height;
		this.weight = weight;
	}
	
	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	@Override
	public int compareTo(Package o) {
		if (getLoad() > o.getLoad()) return 1;
		if (getLoad() < o.getLoad()) return -1;
		return 0;
	}

	private double getLoad() {
		return (width * length * height) / (double) weight;
	}

	@Override
	public boolean stack(Package p) {
		return width >= p.width && length >= p.length ? 
				true : false;
	}

	@Override
	public String toString() {
		return "Package [width=" + width + ", length=" + length + ", height="
				+ height + ", weight=" + weight + ", load=" + getLoad() +"]";
	}
}
