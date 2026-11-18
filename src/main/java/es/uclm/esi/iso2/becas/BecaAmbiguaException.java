package es.uclm.esi.iso2.becas;

import java.util.List;

public class BecaAmbiguaException extends Exception {
    private final List<TipoBeca> becasCompatibles;

    public BecaAmbiguaException(List<TipoBeca> becasCompatibles) {
        super("Ambigüedad detectada: el estudiante cumple requisitos para múltiples becas: " + becasCompatibles);
        this.becasCompatibles = List.copyOf(becasCompatibles);
    }

    public List<TipoBeca> getBecasCompatibles() {
        return becasCompatibles;
    }
}