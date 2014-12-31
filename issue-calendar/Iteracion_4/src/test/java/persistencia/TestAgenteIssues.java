package persistencia;

import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;
import dominio.Issue;

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
	

	
	public Vector<Object> select_from_issues(AgenteIssues a, String issue){
		String SQL_select = "SELECT * FROM Issues WHERE issue = '" + issue.toString() +"';";
		Vector<Object> res = null;
		try{
			res = a.select(SQL_select);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to select issue.");
		}
		return res;
	}
	
	@Test
	public void test_select_from_issues(){
		//Setup
		AgenteIssues a = get_agenteDB();
		insert_into_issues(a,"topic", "10-10-2010",  "10");
		//Execution
		Vector<Object> res = select_from_issues(a, "topic");
		Vector<Object> aux = null;
		Issue i = null;
		//Oracle
        if (res.size() != 0) {
            aux = (Vector<Object>) res.elementAt(0);
            i = new Issue((String) aux.elementAt(0), (String) aux.elementAt(1),(String) aux.elementAt(2));
        }
		try{
			assertEquals("topic", i.getissue());
			assertEquals("10-10-2010", i.getfecha());
			assertEquals("10", i.getduracion());
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert.");
		}
		//Tear down
		disconnect(a);
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
