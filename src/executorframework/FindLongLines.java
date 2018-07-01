package executorframework;

import java.util.concurrent.Callable;

public class FindLongLines implements Callable<String> {
	
	private String s;

	public FindLongLines(String s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		if (s.length()>35) {
			return s;
		}
		return null;
	}

}
