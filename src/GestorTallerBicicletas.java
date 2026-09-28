import java.util.ArrayList;
import java.util.List;


public class GestorTallerBicicletas {

    private final List<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        this.bicicletas = new ArrayList<>();
    }


    public void registrarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
        System.out.println(bicicleta.getCodigo() + " (" + bicicleta.getClass().getSimpleName()
                + ") registrada correctamente.");
    }

    public List<Bicicleta> buscarporCodigo (String criterio) {
        return buscarPorCodigo(criterio, false);
    }


    public List<Bicicleta> buscarPorCodigo(String criterio, boolean coincidenciaExacta) {
        List<Bicicleta> resultado = new ArrayList<>();
        if (criterio == null || criterio.trim().isEmpty()) {
            return resultado;
        }
        String criterioNormalizado = criterio.trim().toUpperCase();

        for (Bicicleta bicicleta : bicicletas) {
            String codigoActual = bicicleta.getCodigo().toUpperCase();
            boolean coincide = coincidenciaExacta
                    ? codigoActual.equals(criterioNormalizado)
                    : codigoActual.contains(criterioNormalizado);
            if (coincide) {
                resultado.add(bicicleta);
            }
        }
        return resultado;
    }


    public List<Bicicleta> obtenerBicicletas() {
        return bicicletas;
    }
}
