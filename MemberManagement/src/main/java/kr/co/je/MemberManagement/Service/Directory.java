package kr.co.je.MemberManagement.Service;

import java.util.List;

import kr.co.je.MemberManagement.NotFoundMemberException;
import kr.co.je.MemberManagement.VO.Member;

public interface Directory {

	// 이름으로 회원조회
	public Member lookup(String name) throws NotFoundMemberException;
	
	// 회원 등록하기
	public void insert(String name, int age, int phoneNum);
	
	// 회원 삭제하기
	public Member delete(String name) throws NotFoundMemberException;
	
	// 회원 정보 파일에 저장하기
	public int save(List<Member> members);
	
	// 회원 정보 파일에서 읽어와 dataCollection 에 넣기
	public void print();
	
	// dataCollection 에 저장된 회원정보 화면에 출력하기
	public void show();
}
