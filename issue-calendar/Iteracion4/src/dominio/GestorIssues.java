package dominio;

public class GestorIssues {

    public static boolean send(String issue,String fecha,String duracion) throws Exception {
        boolean insertado = false;

        Issue i = new Issue(issue, fecha,duracion);
        if (i.insert() == 1) {
            insertado = true;
        }
        return insertado;
    }
    public static Issue recuperar(String issue) throws Exception {
        return Issue.retrieve(issue);
    }
}
