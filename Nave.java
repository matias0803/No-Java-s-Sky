public class Nave {
    
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float maxUnidadesCombustible;

/*****
* Nave()
* inicializa los valores correspondientes segun el enunciado
*****/

    public Nave(){
        this.unidadesCombustible = 100;
        this.eficienciaPropulsor = 0;
        this.maxUnidadesCombustible  = 100;

    }

/*****
* void setUnidadesCombustible(float unidades)
* actualiza el valor de UnidadesCombustible dependiendo de el maxUnidadesCombustible
*****/   

    public void setUnidadesCombustible(float unidades){
        if (unidades > maxUnidadesCombustible) {
            System.out.println("Combustible maximo ya alcanzado");
            return;
        }
        this.unidadesCombustible = unidades;
    }

/*****
* float getUnidadesCombustible()
* retorna el valor de UnidadesCombustible
*****/  

    public float getUnidadesCombustible(){
        return unidadesCombustible;
    }

/*****
* void setEficienciaPropulsor(float eficiencia)
* actualiza el valor de EficienciaPropulsor
*****/   

    public void setEficienciaPropulsor(float eficiencia){
        this.eficienciaPropulsor = eficiencia;
    }

/*****
* float getEficienciaPropulsor()
* retorna el valor de EficienciaPropulsor
*****/   

    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

/*****
* void setMaxUnidadesCombustible(float unidades)
* actualiza el valor de MaxUnidadesCombustible
*****/   

    public void setMaxUnidadesCombustible(float unidades){
        this.maxUnidadesCombustible = unidades;
    }

/*****
* void getMaxUnidadesCombustible(float unidades)
* retorna el valor de MaxUnidadesCombustible
*****/   

    public float getMaxUnidadesCombustible(){
        return maxUnidadesCombustible;
    }

/*****
* boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto)
* retorna true
*****/   

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        return true;
    }

/*****
* void recargarPropulsores(int hidrogeno)
* void
*****/
    
    public void recargarPropulsores(int hidrogeno){

    }
}
