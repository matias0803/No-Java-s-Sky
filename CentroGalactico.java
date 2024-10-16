public class CentroGalactico extends Planeta{
    
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
        return 0;
    }

    @Override
    public boolean salir(){
        return true;
    }
}
