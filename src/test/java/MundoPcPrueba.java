import com.sofkau.qa.tiendaproductos.*;

public class MundoPcPrueba {
    public static void main(String[] args) {
        Teclado teclado1 = new Teclado("Cable","Hp");
        Monitor monitor1 = new Monitor("Hp",12);
        Raton raton1 = new Raton("Cable","Hp");
        Producto producto1 = new Producto("Antonio", monitor1,teclado1,raton1);

        Teclado teclado2 = new Teclado("Cable","Ph");
        Monitor monitor2 = new Monitor("Asus",12);
        Raton raton2 = new Raton("Cable","Nose");
        Producto producto2 = new Producto("Antonio", monitor2,teclado2,raton2);

        Orden orden1 = new Orden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);

        orden1.mostrarOrden();
    }
}
