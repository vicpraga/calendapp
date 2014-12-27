package dominio.knowledge;

public class Issue {

    protected String issue;
    protected String fecha;
    protected Integer duracion;

    public Issue(String issue) {
        this.issue = issue;
    }

    public Issue(String issue, String fecha, Integer duracion) {
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
    
    public Integer getduracion() {
        return duracion;
    }
    
}
