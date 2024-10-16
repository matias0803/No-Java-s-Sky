import java.util.Scanner;

public class Oceanico extends Planeta implements tieneAsentamientos{
    
    private int profundidad;
    

 

    public Oceanico(){
        
        this.radio = (int) (Math.random() * (Math.pow(10, 6) - Math.pow(10, 3) + 1)) + (int) Math.pow(10, 3);
        this.profundidad = (int) (Math.random() * (1000 - 30 + 1)) + 30;
        this.cristalesHidrogeno = (int) (0.2 * 4 * Math.PI * Math.pow(radio, 2));
        this.floresDeSodio = (int) (0.65 * 4 * Math.PI * Math.pow(radio, 2));
        this.consumoEnergia =  0.002f * profundidad * profundidad;
        

    }



    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
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
        return 0;
    }

    @Override
    public boolean salir(){
        return true;
    }

    public void visitarAsentamientos(Jugador jugador){

        Scanner entrada = new Scanner(System.in);
        System.out.println("\n------------------------------------");
        System.out.println("Has llegado a los Asentamientos Oceanicos");
        
        System.out.println("\n------------------------------------");
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Visitar los Asentamientos");
        System.out.println("2. Ver inventario del jugador");
        System.out.println("3. Volver");
        System.out.println("4. Salir del juego");
        System.out.print("Opción: ");
        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\n------------------------------------");
                System.out.println("¡Viajero del cielo! Nuestros océanos están llenos de riquezas. Si tienes algo de valor, estoy dispuesto a hacer un intercambio justo.");
                System.out.println("¿Qué traes contigo?");
                System.out.println("------------------------------------");
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. intercambiar");
                System.out.println("2. Volver");
                System.out.print("Opción: ");
                int opcion2 = entrada.nextInt();
                switch (opcion2) {
                    case 1:

                        System.out.println("\n------------------------------------");
                        System.out.println("¿Qué deseas intercambiar?");
                        System.out.println("1. Mejorar vida maxima (+ 50 unidades): 1600 Platino");
                        System.out.println("2. Mejorar eficiencia de traje en un 10%: 2200 Uranio");
                        System.out.println("------------------------------------");
                        System.out.println("Uranio: " + jugador.obtenerCantidadDe("Uranio"));
                        System.out.println("Platino: " + jugador.obtenerCantidadDe("Platino"));
                        System.out.print("Opción: ");

                        int opcion3 = entrada.nextInt();
                        switch (opcion3) {
                            case 1:
                                if (jugador.obtenerCantidadDe("Uranio") < 1600) {
                                    System.out.println("No tienes la cantidad suficiente...");
                                    break;
                                }
                                float unidades = jugador.getUnidadesEnergiaProteccion();
                                jugador.eliminarDelInventario("Uranio", 1600);
                                jugador.setMaxUnidadesEnergiaProteccion(unidades + 50);
                                System.out.println("Vida maxima mejorarada, nueva cantidad: " + jugador.getMaxUnidadesEnergiaProteccion());
                                
                                break;
                            case 2:
                                if (jugador.obtenerCantidadDe("Platino") < 2200) {
                                    System.out.println("No tienes la cantidad suficiente...");
                                    break;
                                }
                                jugador.eliminarDelInventario("Platino", 2200);
                                jugador.setEficienciaEnergiaProteccion(jugador.getEficienciaEnergiaProteccion() + 0.1f);
                                System.out.println("Eficiencia de traje mejorada, nueva cantidad: " + jugador.getEficienciaEnergiaProteccion());
                                break;
                        
                            default:
                                break;
                        }

                        

                        break;
                    case 2:
                        break;
                
                    default:
                        break;
                }







                break;
            case 2:
                System.out.println("\n------------------------------------");
                jugador.mostrarInventario();
                break;
            case 3:

                break;
            case 4:
                System.out.println("\nSaliendo del juego...");
                entrada.close();
                System.exit(0);
                break;


        
            
        }



    }

    public void visitarAsentamientos(Jugador jugador, Nave nave){
        
    };

}
