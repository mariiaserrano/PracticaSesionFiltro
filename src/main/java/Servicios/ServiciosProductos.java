package Servicios;

import Dao.DaoProductos;
import Model.Producto;

import java.util.List;

public class ServiciosProductos {
    DaoProductos dao = new DaoProductos();

    public List<Producto> dameProductos() {
        return dao.dameProductos();
    }

    public List<Producto> anadirArticulo(String[] nombre) {
        return dao.anadirArticulo(nombre);
    }
}
