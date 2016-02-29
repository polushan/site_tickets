package util;

/**
 * 
 * Это чтобы закрыть все дыры, знаю, что так незя
 *
 */

public class SomethingWrongException extends Exception {
	private static final long serialVersionUID = 1L;
	
	SomethingWrongException(String text) {
		super(text);
	}
	
	SomethingWrongException() {
		super("Делай error page, чё думать то");
	}

}
