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
    
}
