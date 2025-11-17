import controlador.ControladorInventario;
import modelo.BaseDeDatos;
import vista.InventarioVista;

public class App {
    public static void main(String[] args) {
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        InventarioVista vista = new InventarioVista();
        ControladorInventario controlador = new ControladorInventario(baseDeDatos, vista);

        controlador.iniciar();
    }
}
