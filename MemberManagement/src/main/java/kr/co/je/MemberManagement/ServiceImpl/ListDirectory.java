package kr.co.je.MemberManagement.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import kr.co.je.MemberManagement.NotFoundMemberException;
import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.VO.Member;

public class ListDirectory implements Directory {

	private List<Member> members = new ArrayList<>();
	FileManager fileManager = new FileManager();
	
	public Member lookup(String name) throws NotFoundMemberException {
		
		boolean memberFound = false;

		show();
		for (Member member : members) {
			if (member.getName().equals(name)) {
				memberFound = true;
				System.out.println(member.toString() + " 가 조회되었습니다. ");
				return member;
				
			}
		} // end of for
		
		if (!memberFound) {
			throw new NotFoundMemberException("해당 이름을 가진 회원을 찾을 수 없습니다. ");   // checked, unchecked...
		}
		return null;
	}

	public void insert(String name, int age, int phoneNum) {
		show();
		Member member = new Member(name, age, phoneNum);
		members.add(member);
		save(members);
		System.out.println(member.toString() + " 생성하였습니다. ");
		
	}

	public Member delete(String name) {
		show();
		Member member = lookup(name);
		members.remove(member);
		save(members);
		System.out.println(member.toString() + " 삭제하였습니다. ");
		return member;
	}

	public int save(List<Member> members) {

		fileManager.fileLoad(members);
		return members.size();
		
	}
	
	public void show() {
		// 파일에 저장된 회원정보 list에 저장하기
		members = fileManager.fileUnload();    
//		System.out.println("members.size() after fileManager : " + members.size());
	}
	
	// 파일에 등록된 회원들을 member list 에  등록하기
	public void print() {
		show();
		for (Member member : members) {
			System.out.println(member.toString());
		}
	}
}
