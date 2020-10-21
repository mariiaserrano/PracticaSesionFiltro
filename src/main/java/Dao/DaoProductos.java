package Dao;

import Model.Producto;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class DaoProductos {



    public List<Producto> dameProductos(){
        DBConnection db = new DBConnection();
        ResultSet resultSet = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Producto> productos = new ArrayList<>();
        try {

            con = db.getConnection();
            String selectSql = "SELECT * FROM Productos";

            stmt = con.prepareStatement(selectSql);

            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Producto aux = new Producto(resultSet.getString(1));
                productos.add(aux);
            }
        } catch (Exception ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarResultSet(resultSet);
            db.cerrarStatement(stmt);
            db.cerrarConexion(con);

        }

        return productos;



    }
}
