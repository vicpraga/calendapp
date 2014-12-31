package persistencia;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestAgenteUsuarios {

	
	public AgenteUsuarios get_agenteDB(){
		AgenteUsuarios a = null;
		try{
			a = AgenteUsuarios.getAgente();			
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to obtain an instance.");
		}
		return a;
	}
	
	public void disconnect(AgenteUsuarios a){
		try{
			a.desconectar();
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to disconnect.");
		}
	}
		
	
	public int insert_into_users(AgenteUsuarios a,  String user, String pass){
		String SQL_insert = "INSERT INTO Usuario VALUES( '"+user+"','"+pass+"');";
		int res=0;
		try{
			res=a.insert(SQL_insert);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to insert user.");
		}
		return res;
	}
	
	@Test
	public void test_insert_user(){
		//Setup
		AgenteUsuarios a = get_agenteDB();
		//Execution
		int res=insert_into_users(a,"newUser", "newPass");
		//Oracle
		try{
			assertEquals(res, 1);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert in update users.");
		}
		//Tear down
		disconnect(a);
	}
	

}
