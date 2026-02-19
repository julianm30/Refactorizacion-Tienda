package practica9;

import java.util.ArrayList;
import java.util.Scanner;

public class Productos {
    private double precio;
    private String nombre;
    private int stock;

        private static ArrayList<Productos> listaProductos = new ArrayList<>();


    public Productos(double precio, String nombre, int stock) {
        this.precio = precio;
        this.nombre = nombre;
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Productos = Nombre: " + nombre + " | Precio: " + precio + " euros | Stock: " + stock;
    }


        public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    // Método para añadir productos nuevos
    public static void anadirProducto(Scanner sc) {

        System.out.println("Nombre del artículo:");
        String nombreNewArt = sc.nextLine();

        System.out.println("Precio del artículo:");
        double precioNewArt = sc.nextDouble();

        System.out.println("Stock:");
        int stockNewArt = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Crear nuevo objeto Producto
        Productos nuevoProducto = new Productos(precioNewArt, nombreNewArt, stockNewArt);

        // Añadir a la lista
        listaProductos.add(nuevoProducto);

        System.out.println("El producto se ha añadido correctamente.");
    }

    // Método para mostrar todos los productos
    public static void mostrarProductos() {
        for (Productos p : listaProductos) {
            System.out.println(p);
        }
    }
}
