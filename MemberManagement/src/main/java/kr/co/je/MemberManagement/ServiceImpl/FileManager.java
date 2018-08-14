package kr.co.je.MemberManagement.ServiceImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kr.co.je.MemberManagement.VO.Member;

public class FileManager {

	private List<Member> members = new ArrayList<>();

	public List<Member> fileUnload() {    //  파일에서 읽어오기
		
		members.clear();
		
		File file = new File("Memberlist.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] broken_text = line.split("=");
				String[] name = broken_text[1].split(", ");
				String[] age = broken_text[2].split(", ");
				String[] phoneNum = broken_text[3].split(", ");
				members.add(new Member(name[0], Integer.parseInt(age[0]), Integer.parseInt(phoneNum[0])));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return members;
	}
	
	public void fileLoad(List<Member> members) {    //  파일에 저장하기
		File f = new File("Memberlist.txt");
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(f))) {
			if (f.exists()) {
				f.delete();
				f.createNewFile();
			}
			Collections.sort(members);
			
			for (Member member : members) {
				buffer.write(member.toString());
				buffer.write("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
}
