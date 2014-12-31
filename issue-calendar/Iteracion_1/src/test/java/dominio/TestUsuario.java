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
