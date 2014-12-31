package dominio;

import static org.junit.Assert.*;


import org.junit.Test;
import dominio.Issue;

public class TestGestorIssues {

	public void send_issue(String issue,String fecha,String duracion){
		try {
			GestorIssues.send( issue, fecha, duracion);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to send issue.");
		}
	}
	
	public Issue retrieve_issue(String i){
		Issue x = null;
		try {
			x = GestorIssues.recuperar(i);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to retrieve issue.");
		}
		return x;
	}
	
	@Test
	public void test() {
		/*This test includes send and retrieve operations from GestorIssues*/
		//Setup
		send_issue( "topic", "12-12-2012", "10");
		//Execution
		Issue res = retrieve_issue("topic");
		//Oracle
		assertEquals("12-12-2012", res.getfecha());
		assertEquals("topic", res.getissue());
		assertEquals("10", res.getduracion());	
	}
}
