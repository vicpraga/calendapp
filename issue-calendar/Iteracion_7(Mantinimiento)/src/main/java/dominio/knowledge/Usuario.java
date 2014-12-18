package dominio.knowledge;

public class Usuario {

    private String login;
    private String password;

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    //Constructor para la creacion de un Usuario
    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }
   
}

