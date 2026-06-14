package com.ulp;

/**
 *
 * @author juanj
 */
public class Bateria {
    double carga;
    
    public double cargar(int metros, double voltaje) {
    // SI EL VOLTAJE ES NEGATIVO, LANZAMOS LA EXCEPCIÓN ESPERADA
    if (voltaje < 0) {
        throw new IllegalArgumentException("El voltaje no puede ser negativo");
    }

    for (int i = 0; i < metros; i++) {
        carga += voltaje;
    }
    return carga; 
}
    
    // Método de descarga
    public double descargar(int metros) {
        carga -= metros - 1.5;
        return carga; // Debería ser: return metros - 1.5v;
    }
    
}