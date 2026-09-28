
public abstract class Bicicleta {

    protected String codigo;
    protected int anioFabricacion;
    protected double peso;


    public Bicicleta(String codigo, int anioFabricacion, double peso) {
        setCodigo(codigo);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    //-------- Getters / Setters -------------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de bicicleta no puede ser nulo ni vacío.");
        }
        this.codigo = codigo.trim();
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException(
                    "El año de fabricación debe encontrarse en el rango entre 2000 y 2026.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor mayor que cero.");
        }
        this.peso = peso;
    }

    // --------------------------- Métodos abstractos ---------------------------


    public abstract double calcularCostoMantencion();

    public abstract String getTipo();


    public abstract String getDetalleEspecifico();

    // ------------------------------- toString -------------------------------

    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anioFabricacion;
    }
}
