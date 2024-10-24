public class CentroGalactico extends Planeta{

/*****
* CentroGalactico()
* 
*****/

public CentroGalactico(){}

/*****
* boolean visitar(Jugador jugador)
* retorna true
*****/
    @Override
    public boolean visitar(Jugador jugador){
        return true;
    }
/*****
*int extraerRecursos(int tipo)
* retorna 0
*****/
    @Override
    public int extraerRecursos(int tipo){
        return 0;
    }
/*****
*int extraerRecursos(int tipo, int cantidad, Jugador jugador)
* retorna 0
*****/
    @Override
    public int extraerRecursos(int tipo, int cantidad, Jugador jugador){
        return 0;
    }
/*****
* boolean salir()
* retorna true
*****/
    @Override
    public boolean salir(){
        return true;
    }
}
