package persistencia;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestAgenteDB {
	
	public AgenteDB get_agenteDB(){
		AgenteDB a = null;
		try{
			a = AgenteDB.getAgente();			
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to obtain an instance.");
		}
		return a;
	}
	
	public void disconnect(AgenteDB a){
		try{
			a.desconectar();
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to disconnect.");
		}
	}
	
	
	
	public void insert_into_usuario(AgenteDB a, String login, String password){
		String SQL_insert = "INSERT INTO Usuario VALUES('"+login+"', '"+password+"');";
		try{
			a.insert(SQL_insert);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to insert usuario.");
		}
	}
	
	public void delete_from_usuario(AgenteDB a, String login, String password){
		String SQL_delete = "DELETE FROM Usuario WHERE login='"+login+"' AND password='"+password+"';";
		try{
			a.delete(SQL_delete);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to delete usuario.");
		}
	}
	
	public ResultSet select_from_usuario(AgenteDB a, String login, String password){
		String SQL_select = "SELECT * FROM Usuario WHERE login='"+login+"' AND password='"+password+"';";
		ResultSet rs = null;
		try{
			rs = a.select(SQL_select);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to select usuario.");
		}
		return rs;
	}
	
	public void update_usuario(AgenteDB a, String newLogin, String password){
		String SQL_update = "UPDATE Usuario SET login='"+newLogin+"' WHERE password='"+password+"'";
		try{
			a.update(SQL_update);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to update usuario.");
		}
	}
	
	
	
	public void insert_into_issues(AgenteDB a, String fecha, String issue, Integer duracion){
		String SQL_insert = "INSERT INTO Issues VALUES('"+fecha+"', '"+issue+"', "+duracion+");";
		try{
			a.insert(SQL_insert);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to insert issue.");
		}
	}
	
	public void delete_from_issues(AgenteDB a, String fecha, String issue, Integer duracion){
		String SQL_delete = "DELETE FROM Issues WHERE fecha='"+fecha+"' AND issue='"+issue+"' AND "+
				"duración="+duracion+";";
		try{
			a.delete(SQL_delete);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to delete issue.");
		}
	}
	
	public ResultSet select_from_issues(AgenteDB a, String fecha, String issue, Integer duracion){
		String SQL_select = "SELECT * FROM Issues WHERE fecha='"+fecha+"' AND issue='"+issue+"' AND "+
				"duración="+duracion+";";
		ResultSet rs = null;
		try{
			rs = a.select(SQL_select);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to select issue.");
		}
		return rs;
	}
	
	public void update_issues(AgenteDB a, String newFecha, String issue, Integer duracion){
		String SQL_update = "UPDATE Issues SET fecha='"+newFecha+"' WHERE issue='"+issue+"' AND "+
				"duración="+duracion+";";
		try{
			a.update(SQL_update);
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to update issue.");
		}
	}
	
	
	
	@Test
	public void test_select_from_issues(){
		/*This test includes the select, insert and delete sql operations from the same table.
		 * also includes getAgente() and desconectar() operations.*/
		//Setup
		AgenteDB a = get_agenteDB();
		insert_into_issues(a, "12-12-2012", "myIssue", 30);
		//Execution
		ResultSet rs = select_from_issues(a, "12-12-2012", "myIssue", 30);
		//Oracle
		try{
			assertEquals("12-12-2012", rs.getString("fecha"));
			assertEquals("myIssue", rs.getString("issue"));
			assertEquals(30, rs.getInt("duración"));
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert.");
		}
		//Tear down
		disconnect(a);
		delete_from_issues(a, "12-12-2012", "myIssue", 30);
	}
	
	@Test
	public void test_select_from_usuario(){
		/*This test includes the insert and delete sql operations from the same table.
		 * also includes getAgente() and desconectar() operations.*/
		//Setup
		AgenteDB a = get_agenteDB();
		insert_into_usuario(a, "myLogin", "myPassword");
		//Execution
		ResultSet rs = select_from_usuario(a, "myLogin", "myPassword");
		//Oracle
		try{
			assertEquals("myLogin", rs.getString("login"));
			assertEquals("myPassword", rs.getString("password"));
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert.");
		}
		//Tear down
		disconnect(a);
		delete_from_usuario(a, "myLogin", "myPassword");
	}

	@Test
	public void test_update_issue(){
		/*This test includes the insert and delete sql operations from the same table.
		 * also includes getAgente() and desconectar() operations.*/
		//Setup
		AgenteDB a = get_agenteDB();
		insert_into_issues(a, "12-12-2012", "topic", 23);
		//Execution
		update_issues(a, "9-9-2009", "topic", 23);
		ResultSet rs = select_from_issues(a, "9-9-2009", "topic", 23);
		//Oracle
		try{
			assertEquals("9-9-2009", rs.getString("fecha"));
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert in update issues.");
		}
		//Tear down
		disconnect(a);
		delete_from_issues(a, "9-9-2009", "topic", 23);
	}
	
	@Test
	public void test_update_usuario(){
		/*This test includes the insert and delete sql operations from the same table.
		 * also includes getAgente() and desconectar() operations.*/
		//Setup
		AgenteDB a = get_agenteDB();
		insert_into_usuario(a, "myLogin", "myPassword");
		//Execution
		update_usuario(a, "newLogin", "myPassword");
		ResultSet rs = select_from_usuario(a, "newLogin", "myPassword");
		//Oracle
		try{
			assertEquals("newLogin", rs.getString("login"));
		}catch(Exception e){
			e.printStackTrace();
			fail("Fail trying to assert in update usuario.");
		}
		//Tear down
		disconnect(a);
		delete_from_usuario(a, "newLogin", "myPassword");
	}
}
