package persistencia;

import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;
import dominio.Usuario;

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
	

	
	public Vector<Object> select_from_users(AgenteUsuarios a, String login, String pass){
		String SQL_select = "SELECT * FROM Usuario WHERE login = '" + login + "' AND password = '" + pass + "';";
		Vector<Object> res = null;
		try{
			res = a.select(SQL_select);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to select user.");
		}
		return res;
	}
	
	@Test
	public void test_select_from_users(){
		//Setup
		AgenteUsuarios a = get_agenteDB();
		insert_into_users(a,"newUser", "newPass");
        String resLogin=null;
        String resPass=null;
		//Execution
		Vector<Object> res = select_from_users(a,"newUser", "newPass");
		Vector<Object> aux = null;
		Usuario u = null;
		//Oracle
        if (res.size() != 0) {
            aux = (Vector<Object>) res.elementAt(0);
            resLogin=(String) aux.elementAt(0);
            resPass=(String) aux.elementAt(1);
        }
		try{
			assertEquals("newUser",resLogin);
			assertEquals("newPass",resPass);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert.");
		}
		//Tear down
		disconnect(a);
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
