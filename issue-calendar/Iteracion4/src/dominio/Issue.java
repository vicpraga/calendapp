package dominio;

import java.util.Vector;

import persistencia.AgenteIssues;

public class Issue {

    protected String issue;
    protected String fecha;
    protected String duracion;

    public Issue() {
        this.issue = null;
        this.fecha = null;
        this.duracion = null;
    }

    public Issue(String issue, String fecha, String duracion) {
        this.issue = issue;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getissue() {
        return issue;
    }

    public String getfecha() {
        return fecha;
    }
    
    public String getduracion() {
        return duracion;
    }
    

    public int insert() throws Exception {
        int i = 0;
        String issue = "'" + this.issue + "'";
        String fecha = "'" + this.fecha + "'";
        String duracion = "'" + this.duracion + "'";
        String SQL = "INSERT INTO Issues VALUES (" + fecha + "," + issue + "," + duracion + ")";
        AgenteIssues a = AgenteIssues.getAgente();
        i = a.insert(SQL);
        return i;
    }
    
    
    @SuppressWarnings("unchecked")
	public static Issue retrieve(String issue) throws Exception {
        Issue i = null;
         String SQL_Consulta = "SELECT issue, fecha, duracion FROM Issues WHERE issue = '" + issue.toString() +"';";
        AgenteIssues a = AgenteIssues.getAgente();
        Vector<Object> res = a.select(SQL_Consulta);
        Vector<Object> aux = null;
  
        if (res.size() != 0) {
            aux = (Vector<Object>) res.elementAt(0);
            i = new Issue((String) aux.elementAt(0), (String) aux.elementAt(1),(String) aux.elementAt(2));
        }
        return i;
    }

    
}
