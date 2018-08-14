package kr.co.je.MemberManagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.timeout;
//import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.ServiceImpl.ListDirectory;
import kr.co.je.MemberManagement.VO.Member;

@RunWith(MockitoJUnitRunner.class)
public class DirectoryTest_temp {
	
	
	@Mock Directory listDirectory;
	@Mock private Member member;
	@Mock BufferedReader bufferedReader;
	List<Member> members;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		members = Arrays.asList(
				new Member("y", 30, 103030),
				new Member("u", 40, 104040),
				new Member("i", 50, 105050)
				);
		listDirectory = new ListDirectory();
		
		//when(loader.load()).andthen(member);
		
		MockitoAnnotations.initMocks(this);
//		MockitoAnnotations.initMocks(listDirectory);
//		MockitoAnnotations.initMocks(Member);
//		listDirectory = new ListDirectory();
		
		when(listDirectory.lookup(anyString())).thenThrow(new NotFoundMemberException("Error occurred"));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void memberTest() {
//		Member m = mock(Member.class);
		assertTrue(member != null);
	}
	
	@Test(expected = NotFoundMemberException.class)
	public void notFoundMemberTest() {
		// when() : 특정 mock 객체 생성 후 , 이 객체로부터 특정조건 지정하는 메소드  
		// thenThrow : 예외 던지기
		
		listDirectory.lookup("i");    // lookup(anyString()) 조건에 대해 exception 발생하는 상황 true
//		when(listDirectory.lookup("j")).thenThrow(new NotFoundMemberException("Error occurred"));
//		listDirectory.lookup("i");  // lookup("j") 조건에 exception 발생하는 상황, lookup("i") 
	}
	
	
	@Test
	public void listDirectoryTest() {
//		ListDirectory mockedList = mock(ListDirectory.class);
		assertTrue(listDirectory != null);
	}
	
	
	
	@Test
	public void lookupTest() {
		//given
		when(listDirectory.lookup("H")).thenReturn(new Member("H", 20, 200));
		//when
		final Member member = listDirectory.lookup("H");
		//then
		verify(listDirectory, atLeastOnce()).lookup(anyString());    // atLeastOnece() : 한번이라도 실행되어야 함
		assertThat(member.getName(), is("H"));
		assertThat(member.getAge(), is(20));
		assertThat(member.getPhoneNum(), is(200));
		// assertSame() : 두 객체가 같은 개체인지 확인 (listDirectory.lookup("H") 메소드를 통해 리턴된 member 가 같은 객체 인지 확인
		assertSame(member, listDirectory.lookup("H"));      
		System.out.println("lookupTest() : " + member.toString());
	}
	
	@Test
	public void insertTest() {
		
		// doNothing() : void 로 선언된 메소드에 when() 특정조건 지정하고자 할 경우
		doNothing().when(listDirectory).insert(anyString(), anyInt(), anyInt());
		listDirectory.insert("w", 40, 104040);
		verify(listDirectory).insert(anyString(), anyInt(), anyInt());
		verify(listDirectory, times(1)).insert(anyString(), anyInt(), anyInt());  // 1번 호출했는지 체크

	}
	
	@Test
	public void deleteTest() {
		doNothing().when(listDirectory).delete("w");
		listDirectory.delete("w");
		verify(listDirectory).delete(anyString());
	}
	
	@Test
	public void saveTest() {
		doNothing().when(listDirectory).save(members);
		listDirectory.save(members);
		verify(listDirectory).save(members);
		
//		verify(listDirectory, never()).save();  // 호출 안했는지 체크
//		verify(listDirectory, times(3)).save();  // 3번 호출했는지 체크
//		verify(listDirectory, atLeastOnce()).save();  // 최소한 1번 이상 호출 했는지 체크
//		verify(listDirectory, atMost(2)).save();  // 2번 이하 호출 했는지 체크
//		verify(listDirectory, atLeast(2)).save();  // 최소 2번이상 호출 했는지 체크
//		verify(listDirectory, timeout(100)).save();  // 지정된 시간(millis)안으로 메소드 호출 했는지 체크
//		verify(listDirectory, timeout(100).atLeast(1)).save();  // 지정된 시간(millis)안으로 최소 1번 이상 메소드 호출 했는지 체크
	}
	
	
	
	
	@Test
	public void printTest() throws IOException {
		when(bufferedReader.readLine()).thenReturn(members.toString());
		bufferedReader.readLine();
		assertEquals(3, members.size());  // line 개수와 members 리스트의 원소 개수 동일함
		assertEquals(members.toString(), bufferedReader.readLine());  // line 을 통한 string과 members.toString()의 값이 같음
		System.out.println("printTest() : " + members.toString());
	}
	

}
