package persistencia;

import java.sql.*;
import java.util.Vector;


public class AgenteUsuarios {
    //instancia del agente

    protected static AgenteUsuarios mInstancia = null;
    //Conexion con la base de datos
    protected static Connection mBD;
    //Identificador ODBC de la base de datos
    private static String url = "src/main/java/BBDD/Usuarios.accdb";

    //Constructor
    private AgenteUsuarios() throws Exception {
        conectar();
    }

    public static AgenteUsuarios getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new AgenteUsuarios();
        }
        return mInstancia;
    }

    //Metodo para realizar la conexion a la base de datos 
    private void conectar() throws Exception {
        mBD =DriverManager.getConnection("jdbc:ucanaccess://"+url);
    }

    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception {
        mBD.close();
    }

    //Metodo para realizar una insercion en la base de datos
    public int insert(String SQL) throws SQLException, Exception {
    	conectar();
        Statement stmt = mBD.createStatement();
        int res = stmt.executeUpdate(SQL);
        stmt.close();
        desconectar();
        return res;
    }

    public Vector<Object> select(String SQL) throws Exception, SQLException {
        conectar();
        Statement sentencia = mBD.createStatement();
        ResultSet resultado = sentencia.executeQuery(SQL);
        Vector<Object> resu = new Vector<Object>();
        Vector<String> datos = new Vector<String>(2);
 
        while (resultado.next()) {
            String nombre = resultado.getString("login");
            String pass = resultado.getString("password");
            datos.addElement(nombre);
            datos.addElement(pass);
            resu.addElement(datos);
        }
        desconectar();
        return resu;
 
    }
}