package Servicios;

import Dao.DaoUsuarios;
import Model.Usuario;

public class ServiciosUsuarios {

    public boolean comprobarUsuario(String user, String pass) {
        DaoUsuarios dao = new DaoUsuarios();
    return  dao.comprobarUsuario(user,pass);
    }
}
