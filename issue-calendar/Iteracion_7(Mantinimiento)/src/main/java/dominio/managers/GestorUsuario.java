package dominio.managers;

import java.sql.ResultSet;

import persistencia.AgenteDB;
import dominio.knowledge.Usuario;

public class GestorUsuario {

    public static boolean check(Usuario u) throws Exception {
    	String SQL_Select = "SELECT * FROM Usuario WHERE login = '" + u.getLogin() +"' AND password = '"+
    					u.getPassword()+"';";
    	AgenteDB a = AgenteDB.getAgente();
        ResultSet res = a.select(SQL_Select);
        Boolean returned = res.next();
        a.desconectar();
        return returned;
    }

    public static boolean send(Usuario u) throws Exception {
    	String SQL_Insert = "INSERT INTO Usuario VALUES ('" + u.getLogin() + "','" + u.getPassword() + "');";
    	AgenteDB a = AgenteDB.getAgente();
    	return a.insert(SQL_Insert) > 0;
    }
}
