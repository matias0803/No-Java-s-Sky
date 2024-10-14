import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGalactico {

    private List<Planeta> planetas;
    private int posicion;
    private boolean centroGalacticoGenerado;

    public MapaGalactico() {
        this.planetas = new ArrayList<>(); // Inicializar la lista de planetas
        this.posicion = 0;
        this.centroGalacticoGenerado = false;
    }

    public Planeta generadorPlaneta() {
        Random random = new Random();
        int probabilidad = random.nextInt(100); // Genera un número entre 0 y 99

        

        if (probabilidad < 30) {
            Helado nuevoPlaneta = new Helado(); // 30% de probabilidad
            planetas.add(nuevoPlaneta);
            return nuevoPlaneta; 
        } else if (probabilidad < 60) {
            Oceanico nuevoPlaneta = new Oceanico(); // 30% de probabilidad
            planetas.add(nuevoPlaneta);
            return nuevoPlaneta; 
        } else if (probabilidad < 80) {
            Radioactivo nuevoPlaneta = new Radioactivo(); // 20% de probabilidad
            planetas.add(nuevoPlaneta);
            return nuevoPlaneta;
        } else if (probabilidad < 99) {
            Volcanico nuevoPlaneta = new Volcanico(); // 19% de probabilidad
            planetas.add(nuevoPlaneta);
            return nuevoPlaneta;
        } else if (!centroGalacticoGenerado) {
            CentroGalactico nuevoPlaneta = new CentroGalactico(); // 1% de probabilidad
            centroGalacticoGenerado = true; // Marcar que se ha generado el centro galáctico
            planetas.add(nuevoPlaneta);
            return nuevoPlaneta;
        } else {
            // Si ya se generó el centro galáctico, generamos otro planeta
            return generadorPlaneta();
        }

        
    }

    public void viajarSiguiente(int pos) {
        if (pos < planetas.size() - 1) {
            setPosicion(pos);
        } else {
            System.out.println("No hay más planetas para explorar.");
        }
    }

    public Planeta obtenerPlanetaActual() {
        if (posicion >= 0 && posicion < planetas.size()) {
            return planetas.get(posicion);
        }
        return null; // Retorna null si no hay planeta en la posición actual
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
        sb.append("Posición actual: ").append(posicion+1).append("\n");
        sb.append("Planetas:\n");

        for (int i = 0; i < planetas.size(); i++) {
            sb.append(" - Planeta ").append(i + 1).append(": ").append(planetas.get(i).getClass().getSimpleName()).append("\n");
        }

        return sb.toString();
    }
}
