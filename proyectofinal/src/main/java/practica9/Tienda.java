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

    //Método para enseñar el inventario
    private static void mostrarInventario() {
        if (nombres.isEmpty()) {
            System.out.println("No hay productos.");
        }

        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(i + ". " + nombres.get(i) + " - " +
            precios.get(i) + "€ - Stock: " + stock1.get(i));
        }
    }


    private static void gestionarVenta(){
        System.out.print("Introduzca nombre del producto a vender: ");
                String prod = sc.next();

                int pos = -1;
                for (int i = 0; i < nombres.size(); i++) {
                    if (nombres.get(i).equalsIgnoreCase(prod)) {
                        pos = i;
                        break;
                    }
                }
    }

    private static void buscarProducto(){
        
    }

    public static void main(String[] args) {

        boolean salir = false;
        // añado el boolean para que sea mucho mas facil
        // el control del bucle

        while (!salir) {
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

                default:
                    break;
            }

        
            

            } else if (opcion == 3) {
                System.out.println("\n--- VENTA ---");
                System.out.print("Introduzca nombre del producto a vender: ");
                String prod = sc.next();

                int pos = -1;
                for (int i = 0; i < nombres.size(); i++) {
                    if (nombres.get(i).equalsIgnoreCase(prod)) {
                        pos = i;
                        break;
                    }
                }

                if (pos != -1) {
                    System.out.println("Producto encontrado: " + nombres.get(pos));
                    System.out.println("Precio: " + precios.get(pos) + "€ | Stock: " + stock1.get(pos));
                    System.out.print("Cantidad a comprar: ");
                    int cant = sc.nextInt();

                    if (stock1.get(pos) >= cant) {
                        double total = cant * precios.get(pos);

                        // Hay números fijos que se utilizan en el código
                        if (total > 50) {
                            System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                            total = total * 0.90;
                        }

                        stock1.set(pos, stock1.get(pos) - cant); // Actualizar stock
                        System.out.println("Venta realizada. Total a pagar: " + total + "€");

                        // Debería ser Singleton
                        System.out.println("[LOG SYSTEM]: Venta de " + cant + "x " + nombres.get(pos) + " registrada.");
                        if (stock1.get(pos) < 3) {
                            System.out.println("[LOG SYSTEM]: ALERTA DE STOCK BAJO para " + nombres.get(pos));
                        }

                    } else {
                        System.out.println("Error: No hay suficiente stock.");
                    }
                } else {
                    System.out.println("Error: Producto no encontrado.");
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
