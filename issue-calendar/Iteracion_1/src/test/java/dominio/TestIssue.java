package dominio;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestIssue {


	public int insert_issues(Issue i){
		int res=0;
		try{
			res=i.insert();
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to insert issue.");
		}
		return res;
	}
	

	@Test
	public void test_insert_issue(){
		//Setup
		Issue test=new Issue( "topic","12-12-2012", "23");
		//Execution
		int res=insert_issues(test);
		//Oracle
		try{
			assertEquals(res, 1);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert in update issues.");
		}
		//Tear down
	}
	
}
