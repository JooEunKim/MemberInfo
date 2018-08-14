package kr.co.je.MemberManagement;

import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.ServiceImpl.ListDirectory;

public class DirectoryFactory {

	public static Directory createDirectory(int type) {
		
		if (type  == 1) {
			System.out.println("ArrayDirectory() 생성");
			return new ListDirectory();
//			return new ArrayDirectory();
		
		} else if (type == 2) {
			System.out.println("ListDirectory() 생성");
			return new ListDirectory();
		}
		return null;
	}
}



