import java.util.HashMap;
import java.util.Map;

public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float maxUnidadesEnergiaProteccion;
    private Map<String, Integer> inventario; 

/*****
* Jugador()
* inicializa los valores correspondientes segun el enunciado
*****/

    public Jugador() {
        this.unidadesEnergiaProteccion = 100;
        this.eficienciaEnergiaProteccion = 0;
        this.inventario = new HashMap<>(); 
        this.maxUnidadesEnergiaProteccion = 100;
    }

/*****
* void setEnergiaProteccion(float unidades)
* actualiza el valor de EnergiaProteccion dependiendo de el maxUnidadesEnergiaProteccion
*****/     

    public void setUnidadesEnergiaProteccion(float unidades) {
        if (unidades > maxUnidadesEnergiaProteccion) {
            System.out.println("Vida maxima ya alcanzada");
            return;
        }
        this.unidadesEnergiaProteccion = unidades;
    }

/*****
* float getUnidadesEnergiaProteccion()
* retorna el valor de EnergiaProteccion 
*****/  

    public float getUnidadesEnergiaProteccion() {
        return unidadesEnergiaProteccion;
    }

/*****
* void setEficienciaEnergiaProteccion(float eficiencia)
* actualiza el valor de EficienciaEnergiaProteccion
*****/   

    public void setEficienciaEnergiaProteccion(float eficiencia) {
        this.eficienciaEnergiaProteccion = eficiencia;
    }

/*****
* float getEficienciaEnergiaProteccion()
* retorna el valor de EficienciaEnergiaProteccion
*****/  

    public float getEficienciaEnergiaProteccion() {
        return eficienciaEnergiaProteccion;
    }
    
/*****
* void setMaxEnergiaProteccion(float unidades)
* actualiza el valor de maxEnergiaProteccion
*****/  

    public void setMaxUnidadesEnergiaProteccion(float unidades){
        this.maxUnidadesEnergiaProteccion = unidades;
    }
    
/*****
* float getMaxEnergiaProteccion()
* actualiza el valor de maxEnergiaProteccion
*****/  

    public float getMaxUnidadesEnergiaProteccion(){
        return maxUnidadesEnergiaProteccion;
    }

/*****
* void setInventario(Map<String, Integer> invent)
* actualiza el valor de Inventario
*****/

    public void setInventario(Map<String, Integer> invent){
        this.inventario = invent;
    }

/*****
* void getInventario(Map<String, Integer> invent)
* retorna el valor de Inventario
*****/

    public Map<String, Integer> getInventario() {
        return inventario;
    }

/*****
* void void recargarEnergiaProteccion(int sodio)
* actualiza el valor de recargarEnergiaProteccion segun la ecuacion dada
*****/

    public void recargarEnergiaProteccion(int sodio) {
        this.unidadesEnergiaProteccion = (float) (0.65 * sodio * (1 + eficienciaEnergiaProteccion));
    }

/*****
* void agregarAlInventario(String objeto, int cantidad)
* Agregar o actualizar la cantidad de un objeto de el inventario
*****/

    public void agregarAlInventario(String objeto, int cantidad) {
        inventario.put(objeto, inventario.getOrDefault(objeto, 0) + cantidad); // 
    }

/*****
* void mostrarInventario()
* muestra elinventario por consola
*****/

    public void mostrarInventario() {
        System.out.println("Inventario del Jugador:");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }

/*****
* void limpiar_inventario()
* restaura el inventario
*****/

    public void limpiar_inventario(){
        this.inventario = new HashMap<>();
    }
  
/*****
* int obtenerCantidadDe(String objeto)
* retorna el la cantidad de un objeto de el inventario
*****/   

    public int obtenerCantidadDe(String objeto) {
        return inventario.getOrDefault(objeto, 0); 
    }

/*****
* void eliminarDelInventario(String objeto, int cantidad)
* elimina una cantiad de un objeto
*****/ 

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
