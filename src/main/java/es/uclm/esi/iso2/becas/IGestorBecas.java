package es.uclm.esi.iso2.becas;

public interface IGestorBecas {
    TipoBeca determinarBeca(Estudiante estudiante) throws BecaAmbiguaException;
}