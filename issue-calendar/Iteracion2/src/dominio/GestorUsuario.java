package dominio;

public class GestorUsuario {

    public static boolean nuevoUsuario(String login, String password) throws Exception {
        boolean insertado = false;

        Usuario u = new Usuario(login, password);
        if (u.insert() == 1) {
            insertado = true;
        }
        return insertado;
    }
}
