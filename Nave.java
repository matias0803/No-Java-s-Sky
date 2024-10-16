public class Nave {
    
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float maxUnidadesCombustible;


    public Nave(){
        this.unidadesCombustible = 100;
        this.eficienciaPropulsor = 0;
        this.maxUnidadesCombustible  = 100;

    }
    
    public void setUnidadesCombustible(float unidades){
        if (unidades > maxUnidadesCombustible) {
            System.out.println("Combustible maximo ya alcanzado");
            return;
        }
        this.unidadesCombustible = unidades;
    }

    public float getUnidadesCombustible(){
        return unidadesCombustible;
    }

    public void setEficienciaPropulsor(float eficiencia){
        this.eficienciaPropulsor = eficiencia;
    }

    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    public void setMaxUnidadesCombustible(float unidades){
        this.maxUnidadesCombustible = unidades;
    }

    public float getMaxUnidadesCombustible(){
        return maxUnidadesCombustible;
    }

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        return true;
    }

    public void recargarPropulsores(int hidrogeno){

    }
}
