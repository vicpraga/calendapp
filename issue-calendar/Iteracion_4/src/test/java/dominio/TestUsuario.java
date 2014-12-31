package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsuario {


	public int insert_user(Usuario u){
		int res=0;
		try{
			res=u.insert();
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to insert issue.");
		}
		return res;
	}
	

	
	public Usuario read_user(String login, String password){
		Usuario u = null;
		try{
			u = Usuario.read(login, password);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to select issue.");
		}
		return u;
	}
	
	@Test
	public void test_read_user(){
		//Setup
		Usuario test=new Usuario("newUser","newPass");
		insert_user(test);
		Usuario res=null;
		//Execution
		res=read_user("newUser","newPass");
		//Oracle
		try{
			assertEquals(res.mLogin, "newUser");
			assertEquals(res.mPassword, "newPass");
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert.");
		}
		//Tear down
	}
	

	@Test
	public void test_insert_user(){
		//Setup
		Usuario test=new Usuario("newUser","newPass");
		//Execution
		int res=insert_user(test);
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
