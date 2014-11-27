package dominio;

import java.util.Vector;

import persistencia.AgenteUsuarios;

public class Usuario {

    protected String mLogin;
    protected String mPassword;

    //Constructor para la creacion de un objeto Usuario vacio
    public Usuario() {
        this.mLogin = null;
        this.mPassword = null;
    }

    //Constructor para la creacion de un Usuario
    public Usuario(String login, String password) {
        this.mLogin = login;
        this.mPassword = password;
    }

    //Seleccion de un usuario de la base de datos a partir del login y el password
    @SuppressWarnings("unchecked")
	public static Usuario read(String login, String password) throws Exception {
        Usuario u = null;
        Vector<Object> aux = null;
        String SQL_Consulta = "SELECT login, password FROM Usuario WHERE login = '" + login + "' AND password = '" + password + "';";

        AgenteUsuarios a = AgenteUsuarios.getAgente();

        Vector<Object> res = a.select(SQL_Consulta);

        if (res.size() == 1) {
            aux = (Vector<Object>) res.elementAt(0);
            u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1));
        }

        return u;
    }

    //Insercion de un nuevo usuario en la base de datos
    public int insert() throws Exception {
        int i = 0;
        String log = "'" + this.mLogin + "'";
        String pass = "'" + this.mPassword + "'";
        String SQL = "INSERT INTO Usuario VALUES (" + log + "," + pass + ")";
        AgenteUsuarios a = AgenteUsuarios.getAgente();
        i = a.insert(SQL);
        return i;
    }

   
}

