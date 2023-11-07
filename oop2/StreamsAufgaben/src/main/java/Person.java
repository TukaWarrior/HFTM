public class Person {
	private String vorname;
	private int alter;

	public Person(String vorname, int alter) {
		this.vorname = vorname;
		this.alter = alter;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	@Override
	public String toString() {
		return this.vorname + ": " + this.alter + " Jahre";
	}
}
