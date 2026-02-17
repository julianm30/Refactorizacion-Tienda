package practica9;

public class Productos {
    private double precio;
    private String nombre;
    private int stock;

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

    public static Productos crearProducto() {
        System.out.println("Producto añadido correctamente.");

        return new Productos(precio, nombre, stock);
    }

}
