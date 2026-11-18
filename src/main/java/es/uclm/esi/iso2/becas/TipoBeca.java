package es.uclm.esi.iso2.becas;

public enum TipoBeca {
    EXCELENCIA("Beca de Excelencia (exención total de tasas + dotación de 1.000 €)"),
    RESIDENCIA("Beca de Residencia (exención total + ayuda de alojamiento)"),
    FAMILIA_NUMEROSA("Beca de Familia Numerosa (exención total de tasas)"),
    INCLUSION("Beca de Inclusión (exención total + dotación de apoyo tecnológico)"),
    SIN_BECA("Sin beca asignada (no cumple los requisitos de ninguna modalidad)");

    private final String descripcion;

    TipoBeca(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}