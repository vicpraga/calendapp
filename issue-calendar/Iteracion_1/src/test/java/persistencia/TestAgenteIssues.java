package persistencia;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAgenteIssues {
	
	public AgenteIssues get_agenteDB(){
		AgenteIssues a = null;
		try{
			a = AgenteIssues.getAgente();			
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to obtain an instance.");
		}
		return a;
	}
	
	public void disconnect(AgenteIssues a){
		try{
			a.desconectar();
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to disconnect.");
		}
	}
		
	
	public int insert_into_issues(AgenteIssues a,  String issue, String fecha, String duracion){
		String SQL_insert = "INSERT INTO Issues VALUES( '"+fecha+"','"+issue+"', '"+duracion+"');";
		int res=0;
		try{
			res=a.insert(SQL_insert);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to insert issue.");
		}
		return res;
	}
	

	@Test
	public void test_insert_issue(){
		//Setup
		AgenteIssues a = get_agenteDB();
		//Execution
		int res=insert_into_issues(a,"topic", "12-12-2012",  "23");
		//Oracle
		try{
			assertEquals(res, 1);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert in update issues.");
		}
		//Tear down
		disconnect(a);
	}
	

}
