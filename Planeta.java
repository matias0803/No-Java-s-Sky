public abstract class Planeta {
    
    protected int radio;
    protected int cristalesHidrogeno;
    protected int floresDeSodio;
    protected float consumoEnergia;
    


    public abstract boolean visitar(Jugador jugador);
    public abstract int extraerRecursos(int tipo);
    public abstract boolean salir();
    public abstract int extraerRecursos(int tipo, int cantidad, Jugador jugador);

/*****
* float getConsumoEnergia()
* retorna el consumoEnergia
*****/ 

    public float getConsumoEnergia(){
        return consumoEnergia;
    }

/*****
* void setConsumoEnergia(float energia)
* actualiza el consumoEnergia
*****/ 

    public void setConsumoEnergia(float energia){
        this.consumoEnergia = energia;
    }
    
/*****
* int getradio()
* retorna el radio
*****/ 

    public int getRadio() {
        return radio;
    }

/*****
* int setradio()
* actualiza el radio
*****/ 

    public void setRadio(int radio) {
        this.radio = radio;
    }

/*****
* int getFloresDeSodio()
* retorna las floresDeSodio
*****/ 

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

/*****
* void setFloresDeSodio(int floresDeSodio)
* actualiza las floresDeSodio
*****/ 

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

/*****
* int getCristalesHidrogeno()
* retorna los cristalesHidrogeno
*****/ 

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

/*****
* void setCristalesHidrogeno()
* actualiza los cristalesHidrogeno
*****/ 

    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

}
