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
