package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGestorUsuario {


	
	public Boolean send_usuario(String login, String password){
		Boolean test=false;
		try {
			test=GestorUsuario.nuevoUsuario(login, password);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to send usuario.");
		}
		return test;
	}
	
	@Test
	public void test() {
		//Setup
		Boolean test=false;
		//Execution
		test=send_usuario( "newUser", "newPass");
		//Oracle
		assertTrue(test);	
	}

}
