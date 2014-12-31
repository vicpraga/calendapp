package dominio;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestGestorUsuario {

	public Boolean check_usuario(String login, String password){
		Boolean res = false;
		try {
			res = GestorUsuario.autenticar(login,password);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to check usuario.");
		}
		return res;
	}
	
	public void send_usuario(String login, String password){
		try {
			GestorUsuario.nuevoUsuario(login, password);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to send usuario.");
		}
	}
	
	@Test
	public void test() {
		//Setup
		send_usuario("newLogin", "newPassword");
		//Execution
		Boolean res = check_usuario("newLogin", "newPassword");
		//Oracle
		assertTrue(res);
	}

}
