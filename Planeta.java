public abstract class Planeta {
    
    protected int radio;
    protected int cristalesHidrogeno;
    protected int floresDeSodio;
    protected float consumoEnergia;
    


    public abstract boolean visitar(Jugador jugador);
    public abstract int extraerRecursos(int tipo);
    public abstract boolean salir();
    public abstract int extraerRecursos(int tipo, int cantidad, Jugador jugador);

    
    public float getConsumoEnergia(){
        return consumoEnergia;
    }

    public void setConsumoEnergia(float energia){
        this.consumoEnergia = energia;
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }


    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

}
