package kr.co.je.MemberManagement;

@SuppressWarnings("serial")
public class NotFoundMemberException extends RuntimeException {
	public NotFoundMemberException() {
		
	}
	
	public NotFoundMemberException(String message) {
		super(message);
	}
}
