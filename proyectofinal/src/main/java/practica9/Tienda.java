package practica9;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    private ArrayList<Productos> productos;
    private static final double PRECIO_DESCUENTO = 50.0;
    private static final double DESCUENTO = 0.9;
    private static final int STOCK_BAJO = 3;

    public Tienda() {
        productos = new ArrayList<>();
        productosPrueba();
    }

    private void productosPrueba() {
        productos.add(new Productos(15.00, "Camiseta", 10));
        productos.add(new Productos(30.00, "Pantalón",  5));
        productos.add(new Productos(45.00,"Zapatos", 2));
    }

    public void anadirProducto(Scanner sc) {
        sc.nextLine();

        System.out.println("Nombre del artículo:");
        String nombre = sc.nextLine();

        System.out.println("Precio del artículo:");
        double precio = sc.nextDouble();

        System.out.println("Stock:");
        int stock = sc.nextInt();

        productos.add(new Producto(nombre, precio, stock));

        Singleton.getInstance().log("Producto añadido: " + nombre);
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        for (int i = 0; i < productos.size(); i++) {
            System.out.println(i + ". " + productos.get(i));
        }
    }

    public void realizarVenta(Scanner sc) {
        sc.nextLine();
        System.out.print("Introduzca nombre del producto a vender: ");
        String nombre = sc.nextLine();

        Productos producto = buscarProducto(nombre);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Cantidad a comprar: ");
        int cantidad = sc.nextInt();

        if (cantidad > producto.getStock()) {
            System.out.println("No hay suficiente stock.");
            return;
        }

        double total = cantidad * producto.getPrecio();

        if (total > PRECIO_DESCUENTO) {
            total *= DESCUENTO;
            System.out.println("Descuento aplicado.");
        }

        producto.reducirStock(cantidad);

        System.out.println("Venta realizada. Total: " + total + "euros");

        Singleton.getInstance().log("Venta realizada de " + producto.getNombre());

        if (producto.getStock() < STOCK_BAJO) {
            Singleton.getInstance().log("ALERTA: Stock bajo de " + producto.getNombre());
        }
    }

    private Productos buscarProducto(String nombre) {
        for (Productos p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    tienda.anadirProducto(sc);
                    break;
                case 2:
                    tienda.mostrarInventario();
                    break;
                case 3:
                    tienda.realizarVenta(sc);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
