package dominio;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestGestorIssues {

	public Boolean send_issue(String issue,String fecha,String duracion){
		Boolean sended=false;
		try {
			sended=GestorIssues.send( issue, fecha, duracion);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to send issue.");
		}
		return sended;
	}
	

	
	@Test
	public void test() {
		Boolean test=false;
		//Execution
		test=send_issue( "topic", "12-12-2012", "10");
		//Oracle
		assertTrue(test);	
	}
}
