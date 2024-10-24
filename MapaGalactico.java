import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGalactico {

    private List<Planeta> planetas;
    private int posicion;
    private boolean centroGalacticoGenerado;

/*****
* MapaGalactio()
* inicializa los valores correspondientes segun el enunciado
*****/

    public MapaGalactico() {
        this.planetas = new ArrayList<>(); 
        this.posicion = 0;
        this.centroGalacticoGenerado = false;
    }
  
/*****
* List<Planeta> getPlanetas
* retorna la lista de Planeta
*****/  
    
    public List<Planeta> getPlanetas() {
        return planetas;
    }
   
/*****
* void setPlanetas(List<Planeta> planetas)
* actualiza la lista de Planeta
*****/  
    
    
    public void setPlanetas(List<Planeta> planetas){
        this.planetas = planetas;
    }
    
/*****
* int getPosicion()
* retorna la posicion 
*****/ 
    
    public int getPosicion() {
        return posicion;
    }
    
/*****
* void setPosicion(int pos)
* actualiza la posicion 
*****/    
    
    public void setPosicion(int pos){
        this.posicion = pos;
    }
    
/*****
* boolean getCentroGalacticoGenerado()
* retorna centroGalacticoGenerado
*****/  
    
    public boolean getCentroGalacticoGenerado(){
        return centroGalacticoGenerado;
    }
    
/*****
* void setCentroGalacticoGenerado(boolean condicion)
*  actualiza centroGalacticoGenerado
*****/  

    public void setCentroGalacticoGenerado(boolean condicion){
        this.centroGalacticoGenerado = condicion;
    }
    
/*****
* Planeta generadorPlaneta()
* genera un numero random y segun el enucniado genera
* un planeta y lo agrega a planetas
*****/  
    
    public Planeta generadorPlaneta() {
            Random random = new Random();
            int probabilidad = random.nextInt(100); 
    
            
    
            if (probabilidad < 30) {
                Helado nuevoPlaneta = new Helado(); 
                planetas.add(nuevoPlaneta);
                return nuevoPlaneta; 
            } else if (probabilidad < 60) {
                Oceanico nuevoPlaneta = new Oceanico(); 
                planetas.add(nuevoPlaneta);
                return nuevoPlaneta; 
            } else if (probabilidad < 80) {
                Radioactivo nuevoPlaneta = new Radioactivo(); 
                planetas.add(nuevoPlaneta);
                return nuevoPlaneta;
            } else if (probabilidad < 99) {
                Volcanico nuevoPlaneta = new Volcanico(); 
                planetas.add(nuevoPlaneta);
                return nuevoPlaneta;
            } else if (!centroGalacticoGenerado) {
                CentroGalactico nuevoPlaneta = new CentroGalactico(); 
                centroGalacticoGenerado = true; 
                planetas.add(nuevoPlaneta);
                return nuevoPlaneta;
            } else {
                
                return generadorPlaneta();
            }
    
            
        }
    
/*****
* void viajarSiguiente(int pos)
* actualiza la posicion de la lisa planetas y si es mas grande que la lista
* genera un nuevo planeta y actualiza la posicion
*****/     
    
    public void viajarSiguiente(int pos) {
            if (pos < planetas.size()) {
                setPosicion(pos);
            } else {
                generadorPlaneta();
                setPosicion(pos);
            }
        }
    
/*****
* Planeta obtenerPlanetaActual()
* segun la posicion actual retorna el objeto de el planeta guardado en la lista planetas
*****/  
    
    public Planeta obtenerPlanetaActual() {
            if (posicion >= 0 && posicion < planetas.size()) {
                return planetas.get(posicion);
            }
            return null; 
        }
    
/*****
* String toString()
* Muestra por consola la lista Planetas y sus indices
*****/ 

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mapa Galáctico:\n");
        sb.append("Posición actual: ").append(posicion).append("\n");
        sb.append("Planetas:\n");

        for (int i = 0; i < planetas.size(); i++) {
            sb.append(" - Planeta ").append(i).append(": ").append(planetas.get(i).getClass().getSimpleName()).append("\n");
        }

        return sb.toString();
    }
}
