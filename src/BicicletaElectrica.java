
public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

    private static final double COSTO_BASE = 45000;
    private static final double RECARGO_BATERIA_NO_CERTIFICADA = 0.25;

    private double autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaExtendidaActiva;


    public BicicletaElectrica(String codigo, int anioFabricacion, double peso,
                               double autonomiaKm, boolean bateriaCertificada) {
        super(codigo, anioFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendidaActiva = false;
    }

    // ------ Getters / Setters ------

    public double getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(double autonomiaKm) {
        if (autonomiaKm <= 0) {
            throw new IllegalArgumentException("La autonomía debe ser un valor mayor que cero.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    // ------- Implementación ConGarantiaExtendida -------

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendidaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaExtendidaActiva = true;
    }

    // ------- Especialización de Bicicleta -------


    @Override
    public double calcularCostoMantencion() {
        double costo = COSTO_BASE;
        if (!bateriaCertificada) {
            costo += costo * RECARGO_BATERIA_NO_CERTIFICADA;
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Bicicleta Eléctrica";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Autonomia: " + autonomiaKm + " km | Batería certificada: " + (bateriaCertificada ? "Si" : "No")
                + " | Garantia extendida: " + (garantiaExtendidaActiva ? "Si" : "No");
    }
}
