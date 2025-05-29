import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Cajera implements Runnable {
    private final String nombre;
    private final BlockingQueue<Cliente> colaClientes;

    public Cajera(String nombre, BlockingQueue<Cliente> colaClientes) {
        this.nombre = nombre;
        this.colaClientes = colaClientes;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Cliente cliente = colaClientes.poll(2, TimeUnit.SECONDS);
                if (cliente == null) {
                    System.out.println(nombre + " no tiene más clientes. Cerrando caja.");
                    break;
                }
                procesarCompra(cliente);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void procesarCompra(Cliente cliente) {
        System.out.println(nombre + " comienza a atender a " + cliente.getNombre());
        double total = 0;
        long inicio = System.currentTimeMillis();

        for (Producto producto : cliente.getProductos()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(nombre + " procesando " + producto.getNombre() + " ($" + String.format("%.2f", producto.getPrecio()) + ")");
            total += producto.getPrecio();
        }

        long fin = System.currentTimeMillis();
        System.out.println(nombre + " terminó con " + cliente.getNombre() + ". Total: $" + String.format("%.2f", total)
                + " | Tiempo: " + (fin - inicio) / 1000 + " segundos\n");
    }
}
