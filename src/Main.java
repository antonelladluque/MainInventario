import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Creación del objeto Scanner para leer desde la consola
        Scanner teclado = new Scanner(System.in);
// Creación de la lista para guardar nuestros productos
        ArrayList<Producto> inventario = new ArrayList<>();


        Producto producto1 = new Producto();
        producto1.codigo = "P-001";
        producto1.nombre = "Teclado mecánico";
        producto1.precio = 45000.0;
        producto1.stock = 12;
        inventario.add(producto1);

        Producto producto2 = new Producto();
        producto2.codigo = "P-002";
        producto2.nombre = "Mouse inalámbrico";
        producto2.precio = 25000.0;
        producto2.stock = 8;
        inventario.add(producto2);

        Producto producto3 = null;

        int opcion = 0;

        // 2. Bucle do-while principal
        do {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Ver stock de un producto");
            System.out.println("2. Ingresar nuevo producto");
            System.out.println("3. Ver precio de un producto");
            System.out.println("4. Mostrar ficha de un producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar Enter

            switch (opcion) {
                case 1:
                    // Ver stock
                    Producto prodStock = buscarProducto(teclado, producto1, producto2, producto3);
                    if (prodStock != null) {
                        System.out.println("Stock de " + prodStock.nombre + ": " + prodStock.stock + " unidades.");
                    } else {
                        System.out.println("Error: Producto no encontrado.");
                    }
                    break;

                case 2:
                    // Ingresar nuevo producto
                    System.out.println("\n--- INGRESAR NUEVO PRODUCTO ---");
                    producto3 = new Producto();

                    System.out.print("Ingrese codigo: ");
                    producto3.codigo = teclado.nextLine();

                    System.out.print("Ingrese nombre: ");
                    producto3.nombre = teclado.nextLine();

                    System.out.print("Ingrese precio: $");
                    producto3.precio = teclado.nextDouble();

                    System.out.print("Ingrese stock inicial: ");
                    producto3.stock = teclado.nextInt();
                    teclado.nextLine(); // Limpiar Enter

                    System.out.println("¡Producto ingresado con exito!");
                    break;

                case 3:
                    // Ver precio
                    Producto prodPrecio = buscarProducto(teclado, producto1, producto2, producto3);
                    if (prodPrecio != null) {
                        System.out.println("Precio de " + prodPrecio.nombre + ": $" + prodPrecio.precio);
                    } else {
                        System.out.println("Error: Producto no encontrado.");
                    }
                    break;

                case 4:
                    // Mostrar ficha
                    Producto prodFicha = buscarProducto(teclado, producto1, producto2, producto3);
                    if (prodFicha != null) {
                        prodFicha.mostrarFicha();
                    } else {
                        System.out.println("Error: Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 5);

        teclado.close();
    }

    // MÉTODOS DE BÚSQUEDA: pregunta si por Código o por Nombre
    public static Producto buscarProducto(Scanner teclado, Producto producto1, Producto producto2, Producto producto3) {
        System.out.println("\n¿Como desea buscar el producto?");
        System.out.println("1. Por codigo");
        System.out.println("2. Por nombre");
        System.out.print("Elija opcion: ");
        int tipo = teclado.nextInt();
        teclado.nextLine(); // Limpiar Enter

        if (tipo == 1) {
            System.out.print("Ingrese el codigo: ");
            String cod = teclado.nextLine();

            if (producto1 != null && cod.equalsIgnoreCase(producto1.codigo)) return producto1;
            if (producto2 != null && cod.equalsIgnoreCase(producto2.codigo)) return producto2;
            if (producto3 != null && cod.equalsIgnoreCase(producto3.codigo)) return producto3;

        } else if (tipo == 2) {
            System.out.print("Ingrese el nombre: ");
            String nom = teclado.nextLine();

            if (producto1 != null && nom.equalsIgnoreCase(producto1.nombre)) return producto1;
            if (producto2 != null && nom.equalsIgnoreCase(producto2.nombre)) return producto2;
            if (producto3 != null && nom.equalsIgnoreCase(producto3.nombre)) return producto3;

        } else {
            System.out.println("Opcion de busqueda invalida.");
        }

        return null; // Si no lo encontró o la opción fue errónea
    }
}
