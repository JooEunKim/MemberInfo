package kr.co.je.MemberManagement.VO;

public class Member implements Comparable<Member>{
	private String name;
	private int age;
	private int phoneNum;
	
	public Member() {}
	
	public Member(String name, int age, int phoneNum) {
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
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
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + ", getPhoneNum()=" + getPhoneNum() + "]";
	}
	
	@Override
	public int compareTo(Member m) {
		if (this.getName() == m.getName())
			return 0;
		else
			return (this.getName()).compareTo(m.getName());
	}
	
	
	
}
