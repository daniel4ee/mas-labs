package mas;
public enum AcademicTitle {

	BSc("bachelor of science"), 
	BA("bachelor of art"),
	Eng("engineer"),
	MSc("master of science"),
	MA("master of arts"),
	PhD("philosophiae doctor"),
	Prof("Professor");
	
	private String fullName; 
	
	AcademicTitle(String t) {
		fullName = t;
	}
	
	@Override
	public String toString() {
		return fullName;
	}
}
