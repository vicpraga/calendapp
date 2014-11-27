package persistencia;

import java.sql.*;
import java.util.Vector;

public class AgenteIssues{
    //instancia del agente

    protected static AgenteIssues mInstancia = null;
    //Conexion con la base de datos
    protected static Connection mBD;
    //Identificador ODBC de la base de datos
    private static String url = "src/BBDD/Issues.accdb";
    //Constructor
    private AgenteIssues() throws Exception {
        conectar();
    }

    public static AgenteIssues getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new AgenteIssues();
        }
        return mInstancia;
    }

    private void conectar() throws Exception {
        mBD =DriverManager.getConnection("jdbc:ucanaccess://"+url);
    }

    public void desconectar() throws Exception {
        mBD.close();
    }

    public int insert(String SQL) throws SQLException, Exception {
        conectar();
        Statement stmt = mBD.createStatement();
        int res = stmt.executeUpdate(SQL);
        stmt.close();
        desconectar();
        return res;
    }

}