package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {
	public SystemErrorException(String Message, Exception e) {
		super(Message, e);
	}
}
