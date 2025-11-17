package vista;

import modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println();
        System.out.println("====== Inventario DevSolutions ======");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar un producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción (1-5): ");

        int opcion = 0;
        try {
            String line = scanner.nextLine().trim();
            opcion = Integer.parseInt(line);
        } catch (Exception e) {
            opcion = -1;
        }
        return opcion;
    }

    public Producto pedirDatosUsuario() {
        System.out.println("\n--- Agregar nuevo producto ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("SKU: ");
        String sku = scanner.nextLine().trim();

        int cantidad = 0;
        while (true) {
            System.out.print("Cantidad (entero): ");
            String line = scanner.nextLine().trim();
            try {
                cantidad = Integer.parseInt(line);
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa. Intente nuevamente.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido. Ingrese un número entero.");
            }
        }

        double precio = 0.0;
        while (true) {
            System.out.print("Precio unitario (ej. 12.50): ");
            String line = scanner.nextLine().trim();
            try {
                precio = Double.parseDouble(line);
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo. Intente nuevamente.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido. Ingrese un número válido con o sin decimales.");
            }
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        System.out.print("Ingrese SKU: ");
        return scanner.nextLine().trim();
    }

    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("\nProducto encontrado:");
            System.out.println(producto.toString());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println();
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("=== Productos registrados ===");
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
