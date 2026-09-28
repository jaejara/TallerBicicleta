
public class BicicletaMontana extends Bicicleta {

    private static final double COSTO_BASE = 30000;
    private static final double RECARGO_MAS_DE_UNA_SUSPENSION = 0.15;

    private int cantidadSuspensiones;

    public BicicletaMontana(String codigo, int anioFabricacion, double peso, int cantidadSuspensiones) {
        super(codigo, anioFabricacion, peso);
        setCantidadSuspensiones(cantidadSuspensiones);
    }

    // --------- Getters / Setters ------------

    public int getCantidadSuspensiones() {
        return cantidadSuspensiones;
    }

    public void setCantidadSuspensiones(int cantidadSuspensiones) {
        if (cantidadSuspensiones < 0) {
            throw new IllegalArgumentException("La cantidad de suspensiones no puede ser negativa.");
        }
        this.cantidadSuspensiones = cantidadSuspensiones;
    }

    // ------- Especialización de Bicicleta --------


    @Override
    public double calcularCostoMantencion() {
        double costo = COSTO_BASE;
        if (cantidadSuspensiones > 1) {
            costo += costo * RECARGO_MAS_DE_UNA_SUSPENSION;
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Bicicleta de Montaña";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Suspensiones: " + cantidadSuspensiones;
    }
}
