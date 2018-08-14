package kr.co.je.MemberManagement.ServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import kr.co.je.MemberManagement.NotFoundMemberException;
import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.VO.Member;

public class ArrayDirectory implements Directory {

	final static int ARRAY_INITIAL_LENGTH = 10;
	static Member[] members = new Member[ARRAY_INITIAL_LENGTH];
	
	public Member lookup(String name) {
		
		boolean memberFound = false;
		
		for (Member member : members) {
			if (member.getName().equals(name)) {
				memberFound = true;
				return member;
			}
		} // end of for
		if (!memberFound) {
			try {
				throw new NotFoundMemberException("해당 이름을 가진 회원을 찾을 수 없습니다. ");
			} catch (NotFoundMemberException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void insert(String name, int age, int phoneNum) {
		
//		System.out.println(members.length + " = members.length");
//		System.out.println(Arrays.toString(members));
//		System.out.println(members[2]);
//		System.out.println(members[3]);
//		System.out.println("******");

		int cnt = 0;
		while (members[cnt] != null) {
			cnt++;
		}
		System.out.println(cnt + " = members.cnt");
		
		members[cnt] = new Member(name, age, phoneNum);
		
		//members.add(member);
		System.out.println(members[cnt].toString() + " 생성하였습니다. (Array["+cnt+"])");
		
	}
	
	public int find(String name) {
		for (int i = 0; i < members.length; i++) {
			if (members[i].getName() == name)
				return i;
		}
		return -1;
	}
	

	public Member delete(String name) {
		Member member = lookup(name);
		
		int Memberidx = find(name);
		members[Memberidx] = null;
		System.out.println(member.toString() + " 삭제하였습니다. ");

		return member;
	}

	public int save(Member[] members) {
		System.out.println("************** save() 함수를 통한 정렬 확인");
		System.out.println(Arrays.toString(members));
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
		return members.length;
	}

	// 파일에 등록된 회원들을 member Array 에  등록하기
	public void print() {
		
		File file = new File("Memberlist.txt");
		// BufferedReader 자원을 Finally 구문에서 닫는 역할 => try-with-resources 구문으로 사용 함 ( Java SE 7 이후 ) 
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			if (file.exists()) {
				
				//FileReader fReader = new FileReader("Memberlist.txt");
				//BufferedReader bufferedReader = new BufferedReader(fReader);
				
				String line;
				int cnt = 0;
				while ((line = br.readLine()) != null) {
					String[] broken_text = line.split("=");
					String[] name = broken_text[1].split(", ");
					String[] age = broken_text[2].split(", ");
					String[] phoneNum = broken_text[3].split(", ");
					
//					System.out.println( Arrays.toString(name));
//					System.out.println(name[0]);
//					System.out.println("***************************");
					members[cnt] = new Member(name[0], Integer.parseInt(age[0]), Integer.parseInt(phoneNum[0]));
					cnt++;
				}
				System.out.println(Arrays.toString(members));
				save(members);
				//fReader.close();
			}
		} catch (IOException e) {
				e.printStackTrace();
		} 
		//try-resource - 
	}

	public void show() {
		// TODO Auto-generated method stub

	}

	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compare(Member o1, Member o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(List<Member> members) {
		// TODO Auto-generated method stub
		return 0;
	}

}
