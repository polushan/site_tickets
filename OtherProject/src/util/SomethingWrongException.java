package util;

/**
 * 
 * ��� ����� ������� ��� ����, ����, ��� ��� ����
 *
 */

public class SomethingWrongException extends Exception {
	private static final long serialVersionUID = 1L;
	
	SomethingWrongException(String text) {
		super(text);
	}
	
	SomethingWrongException() {
		super("����� error page, �� ������ ��");
	}

}
