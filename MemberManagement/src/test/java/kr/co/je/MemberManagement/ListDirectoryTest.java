package kr.co.je.MemberManagement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertSame;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.atLeast;
//import static org.mockito.Mockito.atLeast;
//import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.atMost;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.timeout;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
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
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import kr.co.je.MemberManagement.Service.Directory;
import kr.co.je.MemberManagement.ServiceImpl.FileManager;
import kr.co.je.MemberManagement.ServiceImpl.ListDirectory;
import kr.co.je.MemberManagement.VO.Member;

@RunWith(MockitoJUnitRunner.class)
public class ListDirectoryTest {
	
	
	Directory listDirectory;
	@Mock private List<Member> members;
	@Mock FileManager fileManager;
	@Mock Member member;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		listDirectory = new ListDirectory();

		members = Arrays.asList(
				new Member("y", 30, 103030),
				new Member("u", 40, 104040),
				new Member("s", 50, 105050)
				);
		
		when(fileManager.fileUnload()).thenReturn(members);
		fileManager.fileUnload();
//		System.out.println(" @Before : members.toString() : " + members.toString());
		
		
		
		/* void method : insert() 검증   */
		doAnswer(new Answer<Member>() {
			public Member answer(InvocationOnMock invocation) throws Throwable {
				 assertTrue("s".equals(invocation.getArguments()[0]));
				 assertThat(invocation.getArguments()[0],is(equalTo("s")));
				return null;
			}
		}).when(member).setName(anyString());
		
	}

	@After
	public void tearDown() throws Exception {
//		FileManager fileManager = new FileManager();
//		fileManager.fileLoad(members);     // 리스트에 저장되어 있는 members 정보 파일에 저장
		
		
	}

	@Test
	public void memberTest() {
		assertTrue(member != null);
	}
	@Test
	public void setNameTest() {
		member.setName("s");
	}
	
	@Test(expected = NotFoundMemberException.class)
	public void notFoundMemberTest() {
		listDirectory.lookup("i");    // lookup(anyString()) 조건에 대해 exception 발생하는 상황 true
		assertThat(listDirectory.lookup("i"), is(equalTo(new NotFoundMemberException())));
	}
	
	@Test
	public void saveTest() {
		System.out.println("======================= saveTest() ============================");
		System.out.println("members.size() in saveTest() : " + members.size());
		
		int savedcount = listDirectory.save(members);
		
		assertThat(savedcount,is(equalTo(3)));
	}

	@Test
	public void lookupTest() {
		System.out.println("======================= lookupTest() ============================");
		System.out.println("members.size() in lookupTest() : " + members.size());
//		System.out.println("lookupTest() : " + listDirectory.lookup("y").toString());
		
		final Member member = listDirectory.lookup("y");
		//then
		assertThat(member.getName(), is("y"));
		assertThat(member.getAge(), is(30));
		assertThat(member.getPhoneNum(), is(103030));
		assertThat(member.toString(), is(equalTo(new Member("y", 30, 103030).toString())));      
//		System.out.println("lookupTest() : " + member.toString());
	}
	
	@Test
	public void deleteTest() {
		System.out.println("======================= deleteTest() ============================");
		System.out.println("members.size() in deleteTest() : " + members.size());
		Member member = listDirectory.delete("u");
		assertThat(member.toString(),is(equalTo(new Member("u", 40, 104040).toString())));
	}
	
	@Test
	public void insertTest() {
		System.out.println("======================= insertTest() ============================");
		System.out.println("members.size() in insertTest() : " + members.size());
		
		
		// doNothing() : void 로 선언된 메소드에 when() 특정조건 지정하고자 할 경우
//		doNothing().when(listDirectory).insert(anyString(), anyInt(), anyInt());
		ListDirectory dr = mock(ListDirectory.class);
//		listDirectory.insert("w", 40, 104040);
		dr.insert("w", 40, 104040);
		verify(dr).insert("w", 40, 104040);
		
//		verify(listDirectory).insert(anyString(), anyInt(), anyInt());
//		verify(listDirectory, times(1)).insert(anyString(), anyInt(), anyInt());  // 1번 호출했는지 체크

//		assertThat(actual, matcher);
	}
	
	
	@Test
	public void showTest() {
		System.out.println("======================= showTest() ============================");
		System.out.println("members.size() in showTest() : " + members.size());
		listDirectory.show();
		assertThat(members.size(), is(equalTo(3)));
		
	}
	
	
	@Test
	public void printTest() throws IOException {
		System.out.println("======================= printTest() ============================");
		System.out.println("members.size() in printTest() : " + members.size());
		listDirectory.print();
		assertEquals(3, members.size());  // line 개수와 members 리스트의 원소 개수 동일함
//		System.out.println("printTest() : " + members.toString());
	}
	

}
