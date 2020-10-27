package Dao;

import Model.Producto;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsuarios {



    public boolean guardarClienteJDBC(Usuario cliente) {
        boolean ok = false;
        DBConnection db = new DBConnection();
        ResultSet resultSet = null;
        Connection con = null;
        PreparedStatement stmt = null;
        PasswordHash daoPass = new PasswordHash();
        try {

            con = db.getConnection();

            String selectSql = "INSERT INTO Clientes (Usuario,Pass) values (?,?);";
            stmt = (con.prepareStatement(selectSql, Statement.RETURN_GENERATED_KEYS));
            stmt.setString(1, "root");
            stmt.setString(2, daoPass.hashPassword("quevedo2020"));

            int numeroFilas = -1;
            numeroFilas = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {

                if (numeroFilas > 0) {
                    ok = true;


                    int numeroFilas2 = -1;
                    numeroFilas2 = stmt.executeUpdate();
                    ResultSet rss = stmt.getGeneratedKeys();
                    if (numeroFilas > 0) {
                        ok = true;
                    }
                }
                //ok = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarResultSet(resultSet);
            db.cerrarStatement(stmt);
            db.cerrarConexion(con);
        }
        return ok;
    }


    public Usuario comprobarUsuario(String user, String pass){
            DBConnection db = new DBConnection();
            ResultSet resultSet = null;
            Connection con = null;
            PreparedStatement stmt = null;
            Usuario aux = new Usuario(user, pass);
            try {

                con = db.getConnection();
                String selectSql = "SELECT * FROM Clientes";

                stmt = con.prepareStatement(selectSql);

                resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    aux = new Usuario(resultSet.getString(1),
                            resultSet.getString(2));

                }
            } catch (Exception ex) {
                Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                db.cerrarResultSet(resultSet);
                db.cerrarStatement(stmt);
                db.cerrarConexion(con);

            }

            return aux;

    }
    }

