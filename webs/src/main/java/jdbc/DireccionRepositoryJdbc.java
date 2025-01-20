package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.ascender.biblioteca.negocio.Direccion;
import repositories.DireccionRepositories;

public class DireccionRepositoryJdbc implements DireccionRepositories {
    static final String DB_URL = "jdbc:mysql://localhost:3306/biblioteca";
    static final String USER = "root";
    static final String PASS = "";

    public List<Direccion> buscartodos() {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<Direccion> lista = new ArrayList<Direccion>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery("SELECT * FROM direcciones");

            while (rs.next()) {
                Direccion d = new Direccion(rs.getString("dni"), rs.getString("calle"), rs.getInt("numero"), rs.getInt("codigopostal"));
                lista.add(d);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para buscar direcciones ordenadas
    public List<Direccion> buscarTodosOrdenados(String orden) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<Direccion> lista = new ArrayList<Direccion>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            sentencia = conexion.createStatement();
            
            // Evitar la inyección SQL asegurando que 'orden' sea un campo válido
            List<String> camposValidos = List.of("dni", "calle", "numero", "codigopostal");
            if (!camposValidos.contains(orden)) {
                orden = "dni";  // Si el parámetro de orden no es válido, usar 'dni' por defecto
            }

            // Construir la consulta SQL con el campo de orden
            String query = "SELECT * FROM direcciones ORDER BY " + orden;
            rs = sentencia.executeQuery(query);

            while (rs.next()) {
                Direccion d = new Direccion(rs.getString("dni"), rs.getString("calle"), rs.getInt("numero"), rs.getInt("codigopostal"));
                lista.add(d);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void insertar(Direccion direccion) {
        Connection conexion = null;
        Statement sentencia = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            sentencia = conexion.createStatement();
            String insertarSql = "INSERT INTO direcciones VALUES ('" + direccion.getDni() + "', '" + direccion.getCalle() + "', " + direccion.getNumero() + ", " + direccion.getCodigopostal() + ")";
            sentencia.executeUpdate(insertarSql);
            System.out.println(insertarSql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(Direccion direccion) {
        Connection conexion = null;
        Statement sentencia = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            sentencia = conexion.createStatement();
            String borrarSql = "DELETE FROM direcciones WHERE dni = '" + direccion.getDni() + "' AND calle = '" + direccion.getCalle() + "' AND numero = " + direccion.getNumero();
            sentencia.executeUpdate(borrarSql);
            System.out.println(borrarSql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
