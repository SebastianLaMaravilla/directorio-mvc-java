package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

import java.util.List;

public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    Producto nuevo = vista.pedirDatosUsuario();
                    Producto existente = baseDatos.buscarProductoSku(nuevo.getSku());
                    if (existente != null) {
                        vista.mostrarMensaje("Error: Ya existe un producto con ese SKU. Operación abortada.");
                    } else {
                        baseDatos.agregarProducto(nuevo);
                        vista.mostrarMensaje("Producto agregado correctamente.");
                    }
                    break;
                case 2:
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                case 3:
                    List<Producto> todos = baseDatos.buscarTodos();
                    vista.mostrarProductos(todos);
                    break;
                case 4:
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.eliminarProducto(skuEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("Producto eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se encontró el producto. No se eliminó nada.");
                    }
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo... ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Por favor ingrese una opción entre 1 y 5.");
                    break;
            }
        }
    }
}
