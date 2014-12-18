package persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAgenteIssues {

	//Caso general
	@Test
	public void test_insert() throws Exception {
		AgenteIssues a = AgenteIssues.getAgente();
		String sql_insert = "INSERT INTO Issues VALUES ('12-3-2014','Descripción','130 minutos')";
	
		a.insert(sql_insert);
		
		String sql_select = "SELECT * FROM Issues WHERE Issue = 'Descripcion'";
		Vector<Object> res = a.
		
	}

}
