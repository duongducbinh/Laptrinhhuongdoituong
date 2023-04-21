package Student;

public class Student{
	private int MSSV;
	private String name;
	private int age, gender;
	private String Major;
	private float score;
	
	public Student() {
	}
	
	public Student(int MSSV, String name, int age, int gender, String Major, float score) {
		this.MSSV = MSSV;
		this.name = name;
		this.age = age;
		this.gender =gender;
		this.Major = Major;
		this.score = score;
		
	}

	public int getMSSV() {
		return MSSV;
	}

	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	
	
}