package kr.co.je.MemberManagement.controller;

import java.util.Scanner;

import kr.co.je.MemberManagement.NotFoundMemberException;
import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.VO.Member;

public class Controller {
	
	
	@SuppressWarnings("resource")
	public void insertMember(Directory directory, Scanner s) {
		
		System.out.println("1. 회원 등록하기");
		System.out.println("'이름,나이,핸드폰번호' 의 순서로 공백없이 입력하세요. 입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
		
		
		while (true) {
			System.out.println(">>");
			
			try {
				String input = s.nextLine().trim();
				
				if (!input.equalsIgnoreCase("q")) {
					Scanner s1 = new Scanner(input).useDelimiter(",");
					directory.insert(s1.next(), s1.nextInt(), s1.nextInt());
					
					System.out.println("잘 입력 되었습니다. 입력을 마치려면 q를 입력하세요.");
				} else {  
					return;      // q 입력하여 메인화면으로 돌아가기
				}
			} catch (Exception e) {
				System.out.println("입력 오류 입니다. 이름,나이,핸드폰번호를 공백없이 입력하세요.");
			}
		}
	}
	
	
	public void lookupMember(Directory directory, Scanner s) {
		System.out.println("2. 회원 조회하기 : 조회할 회원의 이름을 입력하세요.");
		System.out.println(">>");
		Member member;
		try {
			member = directory.lookup(s.next());
			System.out.println(member.toString() + " 가 조회되었습니다. ");
		} catch (Exception e) {
			throw new NotFoundMemberException();
		}
	}
	
	
	public void deleteMember(Directory directory, Scanner s) {
		System.out.println("3. 회원 삭제하기");
		System.out.println("삭제할 회원의 이름을 입력하세요.");
		System.out.println(">>");
		//directory.print();
		directory.delete(s.next());
		//directory.save();
		
	}
	
	
	public void printMembers(Directory directory) {
		System.out.println("4. 파일에 등록된 전체 고객리스트 show");
		directory.print();
	}
	
//	public void saveMemberList(Directory directory) {
//		System.out.println("5. 전체 고객리스트 파일에 저장하기");
//		directory.save();
//		System.out.println("전체 고객리스트를 파일에 저장 완료하였습니다.");
//	}
	
}
