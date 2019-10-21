package cn.lv.model;

public class Student {
	private int id;
	private String name;
	private int ageID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgeID() {
		return ageID;
	}

	public void setAgeID(int ageID) {
		this.ageID = ageID;
	}

	public Student(int id, String name, int ageID) {
		this.id = id;
		this.name = name;
		this.ageID = ageID;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", ageID=" + ageID +
				'}';
	}
}
