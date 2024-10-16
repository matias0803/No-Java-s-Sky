public class Volcanico extends Planeta{
    
    private int platino;
    private int temperatura;

    public Volcanico() {

        this.radio = (int) (Math.random() * (Math.pow(10, 5) - Math.pow(10, 3) + 1)) + (int) Math.pow(10, 3);
        this.temperatura = (int) (Math.random() * (256 - 120 + 1)) + 120;
        this.platino = (int) (0.25 * 4 * Math.PI * Math.pow(radio, 2) - 20.5 * Math.pow(temperatura, 2));
        this.floresDeSodio = 0;
        this.cristalesHidrogeno = (int) (0.3 * 4 * Math.PI * Math.pow(radio, 2));
        this.consumoEnergia = (float) (0.08 * temperatura);
        
    }

    public int getPlatino() {
        return platino;
    }

    public void setPlatino(int platino) {
        this.platino = platino;
    }

    
    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }


    @Override
    public boolean visitar(Jugador jugador){
        return true;
    }

    @Override
    public int extraerRecursos(int tipo){
        return 0;
    }

    @Override
    public int extraerRecursos(int tipo, int cantidad, Jugador jugador){
        if (tipo == 1) {
            int flores = getFloresDeSodio();
            int nueva_canidad_flores = flores - cantidad;
            if (nueva_canidad_flores < 0) {
                System.out.println("Numero no valido");
                return 0;
            }
            setFloresDeSodio(nueva_canidad_flores);
            jugador.agregarAlInventario("FloresDeSodio", cantidad);
            System.out.println("Se agregaron " + cantidad + " FloresDeSodio al inventario");
            return cantidad;
        }
        if (tipo == 2) {
            int cristales = getCristalesHidrogeno();
            int nueva_cantidad_cristales = cristales - cantidad;
            if (nueva_cantidad_cristales < 0) {
                System.out.println("Numero no valido");
                return 0;
            }
            setCristalesHidrogeno(nueva_cantidad_cristales);
            jugador.agregarAlInventario("CristalesDeHidrogeno", cantidad);
            System.out.println("Se agregaron " + cantidad + " CristalesDeHidrogeno al inventario");
            
            return cantidad;
        }
        if (tipo == 3) {
            int Platino =getPlatino();
            int nueva_cantidad_platino = Platino - cantidad;
            if (nueva_cantidad_platino < 0) {
                System.out.println("Numero no valido");
                return 0;
            }
            setPlatino(nueva_cantidad_platino);
            jugador.agregarAlInventario("Platino", cantidad);
            System.out.println("Se agregaron " + cantidad + " Platino al inventario");
            
            return cantidad;
        }
        return 0;
    }

    @Override
    public boolean salir(){
        return true;
    }

}
