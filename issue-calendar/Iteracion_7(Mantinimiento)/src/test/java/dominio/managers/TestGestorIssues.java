package dominio.managers;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import dominio.knowledge.Issue;

public class TestGestorIssues {

	public void send_issue(Issue i){
		try {
			GestorIssues.send(i);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to send issue.");
		}
	}
	
	public Vector<Issue> retrieve_issue(Issue i){
		Vector<Issue> v = null;
		try {
			v = GestorIssues.retrieve(i);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to retrieve issue.");
		}
		return v;
	}
	
	@Test
	public void test() {
		/*This test includes send and retrieve operations from GestorIssues*/
		//Setup
		Issue i = new Issue("topic", "12-12-2012", 10);
		send_issue(i);
		//Execution
		Vector<Issue> res = retrieve_issue(i);
		Issue issue_res = res.elementAt(0);
		//Oracle
		assertTrue(res.size()==1);
		assertEquals("12-12-2012", issue_res.getfecha());
		assertEquals("topic", issue_res.getissue());
		assertEquals((Integer)10, issue_res.getduracion());	
	}
}
