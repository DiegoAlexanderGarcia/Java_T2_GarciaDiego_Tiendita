package java_t2_garciadiego_tiendita;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author GarciaDiego
 */

class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para mostrar los detalles del producto
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + stock;
    }
}

public class Java_T2_GarciaDiego_Tiendita {
    public static void main(String[] args) {
        // Crear una lista para almacenar los productos
        ArrayList<Producto> productos = new ArrayList<>();

        // Agregar productos iniciales a la lista
        productos.add(new Producto("001", "Leche", 25.50, 50));
        productos.add(new Producto("002", "Pan", 10.00, 30));
        productos.add(new Producto("003", "Huevos", 35.00, 100));
        productos.add(new Producto("004", "Arroz", 15.75, 200));
        productos.add(new Producto("005", "Aceite", 40.00, 40));

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                // Menú principal
                System.out.println("\n--- CRUD DE PRODUCTOS DE SUPERMERCADO ---");
                System.out.println("1. Crear producto");
                System.out.println("2. Leer productos");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1 -> {
                        // Crear un nuevo producto
                        System.out.print("Ingrese el ID del producto: ");
                        String id = scanner.nextLine();
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        double precio = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese el stock del producto: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        Producto nuevoProducto = new Producto(id, nombre, precio, stock);
                        productos.add(nuevoProducto);
                        System.out.println("Producto agregado: " + nombre);
                    }

                    case 2 -> {
                        // Leer todos los productos
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos disponibles.");
                        } else {
                            System.out.println("Lista de productos:");
                            for (int i = 0; i < productos.size(); i++) {
                                System.out.println((i + 1) + ". " + productos.get(i));
                            }
                        }
                    }

                    case 3 -> {
                        // Actualizar un producto existente
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos para actualizar.");
                        } else {
                            System.out.println("Lista de productos:");
                            for (Producto producto : productos) {
                                System.out.println(producto);
                            }
                            System.out.print("Ingrese el ID del producto a actualizar: ");
                            String idActualizar = scanner.nextLine(); // Leer el ID como cadena

                            // Buscar el producto por su ID
                            Producto productoActualizar = null;
                            for (Producto producto : productos) {
                                if (producto.getId().equalsIgnoreCase(idActualizar)) {
                                    productoActualizar = producto;
                                    break;
                                }
                            }

                            if (productoActualizar != null) {
                                // Solicitar los nuevos datos del producto
                                System.out.print("Ingrese el nuevo nombre del producto: ");
                                String nuevoNombre = scanner.nextLine();
                                productoActualizar.setNombre(nuevoNombre);

                                System.out.print("Ingrese el nuevo precio del producto: ");
                                double nuevoPrecio = scanner.nextDouble();
                                productoActualizar.setPrecio(nuevoPrecio);

                                System.out.print("Ingrese el nuevo stock del producto: ");
                                int nuevoStock = scanner.nextInt();
                                scanner.nextLine(); // Limpiar el buffer
                                productoActualizar.setStock(nuevoStock);

                                System.out.println("Producto actualizado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún producto con el ID: " + idActualizar);
                            }
                        }
                    }

                    case 4 -> {
                        // Eliminar un producto
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos para eliminar.");
                        } else {
                            System.out.println("Lista de productos:");
                            for (Producto producto : productos) {
                                System.out.println(producto);
                            }
                            System.out.print("Ingrese el ID del producto a eliminar: ");
                            String idEliminar = scanner.nextLine(); // Leer el ID como cadena

                            // Buscar el producto por su ID
                            Producto productoEliminar = null;
                            for (Producto producto : productos) {
                                if (producto.getId().equalsIgnoreCase(idEliminar)) {
                                    productoEliminar = producto;
                                    break;
                                }
                            }

                            if (productoEliminar != null) {
                                // Eliminar el producto de la lista
                                productos.remove(productoEliminar);
                                System.out.println("Producto eliminado: " + productoEliminar.getNombre());
                            } else {
                                System.out.println("No se encontró ningún producto con el ID: " + idEliminar);
                            }
                        }
                    }

                    case 5 -> // Salir del programa
                        System.out.println("Saliendo del sistema...");

                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }

            } while (opcion != 5);
        }
    }
}