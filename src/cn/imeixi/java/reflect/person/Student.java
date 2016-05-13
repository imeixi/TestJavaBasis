package cn.imeixi.java.reflect.person;

public class Student extends Person{
	
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student() {
		super();
	}

	public Student(String name, int age) {
		super(name, age);
	}

	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}

	
	
	
	
}
