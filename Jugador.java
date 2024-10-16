import java.util.HashMap;
import java.util.Map;

public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float maxUnidadesEnergiaProteccion;
    private Map<String, Integer> inventario; // Mapa para almacenar objetos y cantidades

    public Jugador() {
        this.unidadesEnergiaProteccion = 100;
        this.eficienciaEnergiaProteccion = 0;
        this.inventario = new HashMap<>(); // Inicializar el mapa
        this.maxUnidadesEnergiaProteccion = 100;
    }

    // Métodos de protección de energía
    public void setUnidadesEnergiaProteccion(float unidades) {
        if (unidades > maxUnidadesEnergiaProteccion) {
            System.out.println("Vida maxima ya alcanzada");
            return;
        }
        this.unidadesEnergiaProteccion = unidades;
    }

    public float getUnidadesEnergiaProteccion() {
        return unidadesEnergiaProteccion;
    }

    public void setEficienciaEnergiaProteccion(float eficiencia) {
        this.eficienciaEnergiaProteccion = eficiencia;
    }

    public float getEficienciaEnergiaProteccion() {
        return eficienciaEnergiaProteccion;
    }
    public void setMaxUnidadesEnergiaProteccion(float unidades){
        this.maxUnidadesEnergiaProteccion = unidades;
    }
    public float getMaxUnidadesEnergiaProteccion(){
        return maxUnidadesEnergiaProteccion;
    }

    public void recargarEnergiaProteccion(int sodio) {
        this.unidadesEnergiaProteccion = (float) (0.65 * sodio * (1 + eficienciaEnergiaProteccion));
    }

    // Métodos del inventario
    public void agregarAlInventario(String objeto, int cantidad) {
        inventario.put(objeto, inventario.getOrDefault(objeto, 0) + cantidad); // Agregar o actualizar la cantidad
    }

    public void mostrarInventario() {
        System.out.println("Inventario del Jugador:");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> getInventario() {
        return inventario;
    }

    public void limpiar_inventario(){
        this.inventario = new HashMap<>();
    }
    public int obtenerCantidadDe(String objeto) {
        return inventario.getOrDefault(objeto, 0); 
    }

    public void eliminarDelInventario(String objeto, int cantidad) {
        if (inventario.containsKey(objeto)) {
            int cantidadActual = inventario.get(objeto);
            if (cantidad >= cantidadActual) {
                inventario.remove(objeto); // Elimina el objeto del inventario si la cantidad es mayor o igual
                System.out.println(objeto + " ha sido eliminado del inventario.");
            } else {
                inventario.put(objeto, cantidadActual - cantidad); // Resta la cantidad
                System.out.println("Se han eliminado " + cantidad + " de " + objeto + ". Restan " + (cantidadActual - cantidad) + ".");
            }
        } else {
            System.out.println(objeto + " no está en el inventario.");
        }
    }
    
}
