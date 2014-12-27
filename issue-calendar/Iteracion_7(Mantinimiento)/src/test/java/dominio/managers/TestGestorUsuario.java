package dominio.managers;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.knowledge.Usuario;

public class TestGestorUsuario {

	public Boolean check_usuario(Usuario u){
		Boolean res = false;
		try {
			res = GestorUsuario.check(u);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to check usuario.");
		}
		return res;
	}
	
	public void send_usuario(Usuario u){
		try {
			GestorUsuario.send(u);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fail trying to send usuario.");
		}
	}
	
	@Test
	public void test() {
		//Setup
		Usuario u = new Usuario("newLogin", "newPassword");
		send_usuario(u);
		//Execution
		Boolean res = check_usuario(u);
		//Oracle
		assertTrue(res);
	}

}
