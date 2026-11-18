package es.uclm.esi.iso2.becas;

import java.util.ArrayList;
import java.util.List;

public class GestorBecasImpl implements IGestorBecas {

    @Override
    public TipoBeca determinarBeca(Estudiante estudiante) throws BecaAmbiguaException {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        }

        List<TipoBeca> candidatas = new ArrayList<>();

        if (estudiante.getNotaMedia() >= 8.5 && estudiante.getRentaFamiliar() < 30000.0) {
            candidatas.add(TipoBeca.EXCELENCIA);
        }

        if (estudiante.getNotaMedia() >= 6.5 && estudiante.getNotaMedia() <= 8.4
                && estudiante.getRentaFamiliar() < 20000.0 && estudiante.getDistanciaKm() > 50.0) {
            candidatas.add(TipoBeca.RESIDENCIA);
        }

        if (estudiante.getNotaMedia() >= 5.0 && estudiante.getRentaFamiliar() < 15000.0
                && estudiante.getNumeroHermanos() >= 3) {
            candidatas.add(TipoBeca.FAMILIA_NUMEROSA);
        }

        if (estudiante.getGradoDiscapacidad() >= 33.0 && estudiante.getNotaMedia() >= 5.0) {
            candidatas.add(TipoBeca.INCLUSION);
        }

        if (candidatas.isEmpty()) {
            return TipoBeca.SIN_BECA;
        }
        if (candidatas.size() > 1) {
            throw new BecaAmbiguaException(candidatas);
        }
        return candidatas.get(0);
    }
}