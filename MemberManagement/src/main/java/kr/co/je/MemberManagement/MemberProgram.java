package kr.co.je.MemberManagement;

import java.util.Scanner;

import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.controller.Controller;

public class MemberProgram {

	static Scanner s = new Scanner(System.in);
	static String type= "";
	
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		Directory directory = null;
		while (true) {
			while (type.equals("")) {
				int collection = selectCollection();
				type = s.nextLine().trim();
				directory = DirectoryFactory.createDirectory(collection);
				break;
			}
			
			switch(displayMenu()) {
			case 1 :
				controller.insertMember(directory, s);
				break;
			case 2 :
				controller.lookupMember(directory, s);
				break;
			case 3 :
				controller.deleteMember(directory, s);
				break;
			case 4 :
				controller.printMembers(directory);
				break;
//			case 5 :
//				controller.saveMemberList(directory);
//				break;
			case 6 :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
		}
		}
	}  // end of main
		

	


	static int displayMenu() {
		System.out.println("*******************************************************************");
		System.out.println("                                  회원 관리 프로그램                                                  ");
		System.out.println("*******************************************************************");
		System.out.println();
		
		System.out.println();
		System.out.println("1. 회원 등록하기");
		System.out.println();
		System.out.println("2. 회원 이름으로 조회하기");
		System.out.println();
		System.out.println("3. 회원 삭제하기");
		System.out.println();
		System.out.println("4. 전체회원 조회하기");
		System.out.println();
		System.out.println("6. 시스템 종료");
		System.out.println();
		System.out.println("원하는 메뉴를 선택하세요. (1~6) : ");
		
		int menu = 0;
		
		do {
			try {
				menu = Integer.parseInt(s.nextLine().trim());
				
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println(menu + " : 메뉴를 잘못 선택했습니다. 다시 입력해 주세요.");
			}
		} while (true);
		
		return menu;
	}
	
	static int selectCollection() {
		System.out.println("*************************************************************");
		System.out.println("-- 먼저 data collection을 선택해 주세요. (1~2)");
		System.out.println("1. Array     2. ArrayList");
		
		int collectionNum = 0;
		do {
			try {
				collectionNum = Integer.parseInt(s.nextLine().trim());
				
				if (0 < collectionNum && collectionNum < 3) {
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("1 (array) 또는 2 (ArrayList) 를 선택해 주세요");
			}
		} while (true);


		
		return collectionNum;
	}

}
