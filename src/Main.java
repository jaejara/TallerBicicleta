import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        GestorTallerBicicletas gestor = new GestorTallerBicicletas();


        BicicletaElectrica electrica1 = null;
        try {
            electrica1 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible crear la bicicleta BIC-E01: " + e.getMessage());
        }

        BicicletaElectrica electrica2 = null;
        try {
            electrica2 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible crear la bicicleta BIC-E02: " + e.getMessage());
        }

        BicicletaMontana montana1 = null;
        try {
            montana1 = new BicicletaMontana("BIC-M01", 2021, 13.5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible crear la bicicleta BIC-M01: " + e.getMessage());
        }

        BicicletaMontana montana2 = null;
        try {
            montana2 = new BicicletaMontana("BIC-M02", 2020, 12.0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible crear la bicicleta BIC-M02: " + e.getMessage());
        }


        if (electrica1 != null) {
            electrica1.activarGarantiaExtendida();
        }


        if (electrica1 != null) gestor.registrarBicicleta(electrica1);
        if (electrica2 != null) gestor.registrarBicicleta(electrica2);
        if (montana1 != null) gestor.registrarBicicleta(montana1);
        if (montana2 != null) gestor.registrarBicicleta(montana2);


        Scanner scanner = new Scanner(System.in);
        String criterioBusqueda = null;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("\nIngrese el código de bicicleta a buscar (ej: BIC-E01): ");
                String entrada = scanner.nextLine();
                criterioBusqueda = validarCriterioBusqueda(entrada);
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida: " + e.getMessage() + " Intente nuevamente.");
            }
        }


        System.out.println("\n=== BUSQUEDA POR CODIGO: \"" + criterioBusqueda + "\" ===");
        List<Bicicleta> encontradas = gestor.buscarPorCodigo(criterioBusqueda, true);

        if (encontradas.isEmpty()) {
            System.out.println("No se encontraron bicicletas con el código \"" + criterioBusqueda + "\".");
        } else {
            for (Bicicleta bicicleta : encontradas) {
                mostrarDetalle(bicicleta);
            }
        }
        System.out.println("---");


        System.out.println("\n=== LISTADO DE BICICLETAS ===");
        for (Bicicleta bicicleta : gestor.obtenerBicicletas()) {
            System.out.println(bicicleta.toString());
        }

        scanner.close();
    }


    private static void mostrarDetalle(Bicicleta bicicleta) {
        mostrarDetalle(bicicleta, "$");
    }


    private static void mostrarDetalle(Bicicleta bicicleta, String simboloMoneda) {
        System.out.println(
                "Tipo: " + bicicleta.getTipo()
                        + " | Código: " + bicicleta.getCodigo()
                        + " | Año: " + bicicleta.getAnioFabricacion()
                        + " | Peso: " + bicicleta.getPeso() + " kg"
                        + " | " + bicicleta.getDetalleEspecifico()
                        + " | Costo mantención: " + simboloMoneda + (int) bicicleta.calcularCostoMantencion());
    }



    private static String validarCriterioBusqueda(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de búsqueda no puede estar vacío.");
        }
        return entrada.trim();
    }
}
