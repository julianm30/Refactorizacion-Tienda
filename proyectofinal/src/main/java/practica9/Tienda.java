package practica9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * TODO: Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de
 * variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */
public class Tienda {
Scanner sc = new Scanner(System.in);
int opcion = sc.nextInt();

    //He cambiado los nombres de las variables para que sean mas intuitivas.
    public static ArrayList<String> nombres = new ArrayList<>(); 
    public static ArrayList<Double> precios = new ArrayList<>(); 
    public static ArrayList<Integer> stock = new ArrayList<>(); 

    public static void main(String[] args) {

        // Datos de prueba iniciales
        nombres.add("Camiseta");
        precios.add(15.0);
        stock.add(10);
        nombres.add("Pantalón");
        precios.add(30.0);
        stock.add(5);
        nombres.add("Zapatos");
        precios.add(45.0);
        stock.add(2);

        while (true) {
            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            //HAcer switch
            if (opcion == 1) {
                Productos.crearProducto(precio, nombre, stockInicial);
                




                System.out.print("Precio: ");
                double precio = sc.nextDouble();
                System.out.print("Stock inicial: ");
                int stockInicial = sc.nextInt(); //Cambio Stock = StockInicial para no confundirme

                nombres.add(nombre);
                precios.add(precio);
                stock.add(stockInicial);
                System.out.println("Producto añadido correctamente.");

            } else if (opcion == 2) {
                System.out.println("\n--- INVENTARIO ACTUAL ---");
                if (nombres.isEmpty()) {
                    System.out.println("No hay productos.");
                } else {
                    for (int i = 0; i < nombres.size(); i++) {
                        System.out.println(i + ". " + nombres.get(i) + " - " + precios.get(i) + "€ - Stock: " + stock.get(i));
                    }
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
                    System.out.println("Precio: " + precios.get(pos) + "€ | Stock: " + stock.get(pos));
                    System.out.print("Cantidad a comprar: ");
                    int cant = sc.nextInt();

                    if (stock.get(pos) >= cant) {
                        double total = cant * precios.get(pos);

                        // Hay números fijos que se utilizan en el código
                        if (total > 50) {
                            System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                            total = total * 0.90;
                        }

                        stock.set(pos, stock.get(pos) - cant); // Actualizar stock
                        System.out.println("Venta realizada. Total a pagar: " + total + "€");

                        // Debería ser Singleton
                        System.out.println("[LOG SYSTEM]: Venta de " + cant + "x " + nombres.get(pos) + " registrada.");
                        if (stock.get(pos) < 3) {
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
