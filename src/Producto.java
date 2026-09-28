public class Producto {
   public String nombre;
   public String codigo;
   public double precio;
   public int stock ;


    public void venderUnidades(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor a cero :( ");
        } else
                if (cantidad > this.stock) {
                    System.out.println("Error: stock insuficiente :'( " + cantidad + " unidades de " + this.nombre );
            } else {
                this.stock = this.stock - cantidad;
                System.out.println("Venta realizada: " + cantidad + " unidades de " + this.nombre + ". Stock restante: " + this.stock);
            }
    }
    public void reponerStock(int cantidad) {
        if (cantidad > 0) {
            this.stock = this.stock + cantidad;
            System.out.println("Reposicion es de: +" + cantidad + " unidades. Stock actual: " + this.stock);
        } else {
            System.out.println("La cantidad a reponer debe ser mayor a cero.");
        }
    }
    public void actualizarPrecio(double precio) {
        double precioAnterior = this.precio; // Guardamos el precio viejo para mostrarlo
        this.precio = precio; // 'this.precio' es el atributo,  precio es el parámetro del metodo

        System.out.println("Precio actualizado de " + this.nombre + ": $" + precioAnterior + " -> $" + this.precio); }


    public void mostrarFicha() {
        System.out.println("=== Ficha de producto ===");
        System.out.println("Código:  " + this.codigo);
        System.out.println("Nombre:  " + this.nombre);
        System.out.println("Precio:  $" + this.precio);
        System.out.println("Stock:   " + this.stock);
        System.out.println("==========================");
    }

}

