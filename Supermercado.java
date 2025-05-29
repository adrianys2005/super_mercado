import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Supermercado {
    public static void main(String[] args) {
        BlockingQueue<Cliente> colaClientes = new LinkedBlockingQueue<>();

        // Generar clientes con productos aleatorios
        for (int i = 1; i <= 10; i++) {
            colaClientes.add(new Cliente("Cliente " + i, generarProductos()));
        }

        // Crear ejecutor con 3 cajeras
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            executor.execute(new Cajera("Cajera " + i, colaClientes));
        }

        executor.shutdown();
    }

    private static List<Producto> generarProductos() {
        List<Producto> productos = new ArrayList<>();
        Random rand = new Random();
        int cantidad = rand.nextInt(5) + 1;

        for (int i = 0; i < cantidad; i++) {
            productos.add(new Producto("Producto " + (i + 1), 1 + rand.nextDouble() * 20));
        }

        return productos;
    }
}
