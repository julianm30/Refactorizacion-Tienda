package practica9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de
 * variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */
public class Tienda {

    // Renombro los atributos de clase para que sean mas legibles
    public static ArrayList<String> nombres = new ArrayList<>(); // Nombres
    public static ArrayList<Double> precios = new ArrayList<>(); // Precios
    public static ArrayList<Integer> stock1 = new ArrayList<>(); // Stock

    // hago constantes con los numeros fijos
    private static final double precioParaDescuento = 50.0;
    private static final double descuentoDiezPorCiento = 0.9;
    private static final int pocoStock = 3;

    private static Scanner sc = new Scanner(System.in);

    // Productos iniciales
    public static void productosPrueba() {
        // Camisetas
        nombres.add("Camiseta");
        precios.add(15.00);
        stock1.add(10);

        // Pantalones
        nombres.add("Pantalón");
        precios.add(30.00);
        stock1.add(5);

        // Zapatos
        nombres.add("Zapatos");
        precios.add(45.00);
        stock1.add(2);
    }

    // Metodo para subir productor nuevos
    public static void anadirProducto() {
        System.out.println("Nombre del artículo:");
        String nombreNewArt = sc.nextLine();

        System.out.println("Precio del artículo: ");
        double precioNewArt = sc.nextDouble();

        System.out.println("Stock: ");
        int stockNewArt = sc.nextInt();

        nombres.add(nombreNewArt);
        precios.add(precioNewArt);
        stock1.add(stockNewArt);

        System.out.println("El producto se ha añadido correctamente");
    }

    // Método para enseñar el inventario
    private static void mostrarInventario() {
        if (nombres.isEmpty()) {
            System.out.println("No hay productos.");
        }

        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(i + ". " + nombres.get(i) + " - " +
                    precios.get(i) + "€ - Stock: " + stock1.get(i));
        }
    }

    // Método para hacer una venta
    private static void gestionarVenta() {
        System.out.print("Introduzca nombre del producto a vender: ");
        String productoVenta = sc.next();

        int indice = buscarProducto(productoVenta);
        if (indice == -1) {
            System.out.println("Error: Producto no encontrado.");
        }

    }

    // Método para buscar el producto en stock
    private static int buscarProducto(String nombre) {
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Hace el calculo del precio, aplica los descuentos y actualiza el stock.
     * @param indice   Es la posicion del producto en las lsitas
     */
    private static void gestionarStock(int indice) {
        System.out.println("Producto encontrado: " + nombres.get(indice));
        System.out.println("Precio: " + precios.get(indice) + "€ | Stock: " + stock1.get(indice));
        System.out.print("Cantidad a comprar: ");

        int cantidad = sc.nextInt();
        int stockVenta = stock1.get(indice);

        if (cantidad > stockVenta) {
            System.out.println("Error: No hay suficiente stock.");
        }

        // calculo el precio total
        double precioTotal = cantidad * precios.get(indice);

        //Descuento
        if (precioTotal > precioParaDescuento) {
            System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
            precioTotal = precioTotal * descuentoDiezPorCiento;
        }

        //Actualizo el stock
        stock1.set(indice, stockVenta - cantidad);
            System.out.println("Venta realizada. Total a pagar: " + precioTotal + "€");

        System.out.println("[LOG]: Venta registrada.");
            if (stock1.get(indice) < 3) {
                System.out.println("[LOG SYSTEM]: ALERTA DE STOCK BAJO para " + nombres.get(indice));
                }
    }

    public static void main(String[] args) {

        boolean salir = false;
        // añado el boolean para que sea mucho mas facil
        // el control del bucle

        while (!salir) {

            productosPrueba();

            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

            //cambio todo el If por un switch para que sea mas legible
            switch (opcion) {
                case 1:
                    anadirProducto();

                case 2:
                    mostrarInventario();

                case 3:
                    gestionarVenta();

                case 4:
                    System.out.println("Saliendo...");

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
