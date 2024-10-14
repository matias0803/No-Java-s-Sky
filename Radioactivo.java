public class Radioactivo extends Planeta {
    
    private int uranio;
    private int radiacion;

    

    public Radioactivo(){

        this.radio = (int) (Math.random() * (Math.pow(10, 5) - Math.pow(10, 4) + 1)) + (int) Math.pow(10, 4);
        this.cristalesHidrogeno = (int) (0.2 * 4 * Math.PI * Math.pow(radio, 2));
        this.floresDeSodio = (int) (0.2 * 4 * Math.PI * Math.pow(radio, 2));
        this.radiacion = (int) (Math.random() * (50 - 10 + 1)) + 10;
        this.uranio = (int) (0.25 * 4 * Math.PI * Math.pow(radio, 2) * radiacion);
        this.consumoEnergia = (float) (0.3 * radiacion);
        

    }


    public int getUranio() {
        return uranio;
    }

    public void setUranio(int uranio) {
        this.uranio = uranio;
    }

    public int getRadiacion() {
        return radiacion;
    }

    public void setRadiacion(int radiacion) {
        this.radiacion = radiacion;
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
            int uranio = getUranio();
            int nueva_cantidad_uranio = uranio - cantidad;
            if (nueva_cantidad_uranio < 0) {
                System.out.println("Numero no valido");
                return 0;
            }
            setUranio(nueva_cantidad_uranio);
            jugador.agregarAlInventario("Uranio", cantidad);
            System.out.println("Se agregaron " + cantidad + " Uranio al inventario");
            
            return cantidad;
        }
        return 0;
    }

    @Override
    public boolean salir(){
        return true;
    }
}
