package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgenteDB {

    //Instancia del agente
    protected static AgenteDB mInstancia = null;
    //Conexion con la base de datos
    protected static Connection mBD;
    //Identificador ODBC de la base de datos
    private static String url = "src/main/resources/ISO_DB.sqlite";
    //Constructor
    private AgenteDB() throws Exception {
        conectar();
    }

    public static AgenteDB getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new AgenteDB();
        }
        return mInstancia;
    }

    private void conectar() throws Exception {
        mBD =DriverManager.getConnection("jdbc:sqlite:"+url);
    }

    public void desconectar() throws Exception {
        mBD.close();
    }

    public int insert(String SQL) throws Exception {
        conectar();
        Statement stmt = mBD.createStatement();
        int res = stmt.executeUpdate(SQL);
        stmt.close();
        desconectar();
        return res;
    }
    
    public int delete(String SQL) throws Exception{
    	return insert(SQL);
    }
    
    public int update(String SQL) throws Exception{
    	return insert(SQL);
    }

	public ResultSet select(String SQL) throws Exception{
        conectar();
        Statement sentencia = mBD.createStatement();
        ResultSet resultado = sentencia.executeQuery(SQL);
        return resultado;
    }
	
}
