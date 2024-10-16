import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGalactico {

    private List<Planeta> planetas;
    private int posicion;
    private boolean centroGalacticoGenerado;

    public MapaGalactico() {
        this.planetas = new ArrayList<>(); 
        this.posicion = 0;
        this.centroGalacticoGenerado = false;
    }

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

    public void viajarSiguiente(int pos) {
        if (pos < planetas.size()) {
            setPosicion(pos);
        } else {
            generadorPlaneta();
            setPosicion(pos);
        }
    }

    public Planeta obtenerPlanetaActual() {
        if (posicion >= 0 && posicion < planetas.size()) {
            return planetas.get(posicion);
        }
        return null; 
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int pos){
        this.posicion = pos;
    }


    @Override
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
