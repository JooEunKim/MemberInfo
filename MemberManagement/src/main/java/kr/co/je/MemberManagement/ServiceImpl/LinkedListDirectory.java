package kr.co.je.MemberManagement.ServiceImpl;

import java.util.LinkedList;
import java.util.List;

import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.VO.Member;

public class LinkedListDirectory implements Directory {

	static List<Member> members = new LinkedList<Member>();
	
	
	public Member lookup(String name) {
		int cnt = members.size();
		System.out.println("전체 회원 수 : " + cnt);
		for (Member member : members) {
			if (member.getName() == name) {
				return member;
			} else {
				throw new IllegalStateException();
			}
		}
		return null;
	}

	public void insert(String name, int age, int phoneNum) {
		Member member = new Member(name, age, phoneNum);
		members.add(member);

	}

	public Member delete(String name) {
		Member member = lookup(name);
		if (member == null) {
			System.out.println("회원이 존재하지 않습니다. ");
			return null;
			
		}
		members.remove(member);
		return member;
	}

	public int save(List<Member> members) {
		return members.size();
		// TODO Auto-generated method stub

	}

	public void print() {
		// TODO Auto-generated method stub

	}

	public void show() {
		// TODO Auto-generated method stub
		
	}

}
