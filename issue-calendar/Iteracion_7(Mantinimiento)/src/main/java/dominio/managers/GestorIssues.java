package dominio.managers;

import java.sql.ResultSet;
import java.util.Vector;

import persistencia.AgenteDB;
import dominio.knowledge.Issue;

public class GestorIssues {


    public static Vector<Issue> retrieve(Issue i) throws Exception {
       String SQL_Select = "SELECT * FROM Issues WHERE issue = '" + i.getissue() +"';";
       AgenteDB a = AgenteDB.getAgente();
       ResultSet res = a.select(SQL_Select);
       Vector<Issue> returned = new Vector<Issue>();
 
       while (res.next()) {
           String issue = res.getString("issue");
           String fecha = res.getString("fecha");
           Integer duracion = res.getInt("duracion");
           
           Issue current = new Issue(issue, fecha, duracion);
           returned.addElement(current);
       }
       
       a.desconectar();
       return returned;
    }
    
    public static boolean send(Issue i) throws Exception {
        String SQL_Insert = "INSERT INTO Issues VALUES ('" + i.getfecha() + "','" + i.getissue() +
        		"','" + i.getduracion() + "');";
        AgenteDB a = AgenteDB.getAgente();
        return a.insert(SQL_Insert) > 0;
        
    }
}
