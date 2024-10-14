import java.util.Scanner;

// Crear un espacio para recargar vida combustible
// Hacerrlos asentamientos y intercambiar con los aldeanos
// Generador de planeta
// Hacer centro galactico
// Decorar con  arte ascii tienda, extraccionde recursos, centro galactico
// Verificar  y  ordenar las los objetos y clases



public class NoJavaSky {



    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int Iniciar;

        // Menú inicial
        System.out.println("============================================================================================================================");
        mostrar_titulo();
        System.out.println("============================================================================================================================");
        System.out.println("        1. Iniciar  2. Salir         ");
        System.out.print("Opción: ");
        Iniciar = entrada.nextInt();

        // Opción para salir
        if (Iniciar == 2) {
            System.out.println("\nSaliendo del juego...");
            entrada.close();
            System.exit(0);
        }
        System.out.println("\n");
        System.out.println("\n====================================");
        // Bienvenida al jugador
        System.out.println("\nBienvenido, jugador.");
        System.out.println("====================================");
        
        // Inicializar jugador y mapa
        Nave nave = new Nave();
        Jugador jugador = new Jugador();
        MapaGalactico mapa = new MapaGalactico();
        Planeta PlanetaActual = mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        mapa.generadorPlaneta();
        

        // Bucle principal del juego
        bucle_principal(mapa,nave,jugador,PlanetaActual);
    }

    public static void bucle_principal(MapaGalactico mapa, Nave nave, Jugador jugador, Planeta planeta){

        
        System.out.println("        ~+\n" +
                   "                 *       +\n" +
                   "           '                  |\n" +
                   "       ()    .-.,=\"`\"=.    - o -\n" +
                   "             '=/_       \\     |\n" +
                   "          *   |  '=._    |\n" +
                   "               \\     =./,        '\n" +
                   "            .   '=.__.=' ='      *\n" +
                   "   +                         +\n" +
                   "        O      *        '       .\n" +
                   "");

        System.out.println("Has llegado a la órbita del planeta " + (mapa.getPosicion() +1) + " : " + planeta.getClass().getSimpleName());
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Visitar la superficie del planeta");
            System.out.println("2. Realizar un salto hacia otro planeta");
            System.out.println("3. Ver combustible");
            System.out.println("4. Ver inventario del jugador");
            System.out.println("5. Mostrar mapa");
            System.out.println("6. Salir del juego");
            System.out.print("Opción: ");

            // Manejo de excepciones para la entrada
            try {
                int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        estar_en_el_planeta(mapa,jugador, nave);
                        break;
                    case 2:
                        salto_de_planeta(mapa, planeta, nave, jugador);
                        break;
                    case 3:
                        System.out.println("\n------------------------------------");
                        System.out.println("Combustible restante: " + nave.getUnidadesCombustible());
                        break;
                    case 4:
                        System.out.println("\n------------------------------------");
                        jugador.mostrarInventario();
                        break;
                    case 5:
                        System.out.println("\n------------------------------------");
                        System.out.println(mapa.toString());
                        break;
                    case 6:
                        System.out.println("\nSaliendo del juego...");
                        entrada.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOpción no válida, elige otra.");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada no válida, intenta nuevamente.");
                entrada.nextLine(); // Limpiar el buffer
            }
           
        }
        
    }

    // Método para simular estar en el planeta
    public static void estar_en_el_planeta(MapaGalactico mapa, Jugador jugador, Nave nave) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n------------------------------------");
        System.out.println("Aterrizando en el planeta " + mapa.obtenerPlanetaActual() + "....");
        barra_de_carga(20, 100);
        System.out.println("\nHas llegado a la superficie del planeta " + mapa.obtenerPlanetaActual());
        System.out.println("------------------------------------");
        while (true){
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Extraer recursos");
            System.out.println("2. Realizar un salto hacia otro planeta");
            System.out.println("3. Ver inventario del jugador");
            System.out.println("4. Ver energıa de proteccion del exotraje");
            if (mapa.obtenerPlanetaActual() instanceof Oceanico) {
                System.out.println("5. Visitar asentamientos");
                System.out.println("6. Salir del juego");
            }
            else{
                System.out.println("5. Salir del juego");
                
            }
            System.out.print("Opción: ");


            try {
                int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("extrayendo recursos");
                        extraccion_recursos(mapa, jugador, nave);
                        break;
                    case 2:
                        salto_de_planeta(mapa, mapa.obtenerPlanetaActual(), nave, jugador);
                        return;
                    case 3:
                        barra_de_carga(20, 2);
                        jugador.mostrarInventario();
                        break;
                    case 4:
                        System.out.println("\n------------------------------------");
                        System.out.println("Energia restante: " + jugador.getUnidadesEnergiaProteccion());
                        break;
                    case 5:
                        if (mapa.obtenerPlanetaActual() instanceof Oceanico) {
                            Oceanico planeta = (Oceanico) mapa.obtenerPlanetaActual();
                            System.out.println("------------------------------------");
                            System.out.println("\nViajando....");
                            barra_de_carga(20, 100);
                            planeta.visitarAsentamientos(jugador);
                        }
                        else if (mapa.obtenerPlanetaActual() instanceof Helado){
                            Helado planeta = (Helado) mapa.obtenerPlanetaActual();
                            System.out.println("------------------------------------");
                            System.out.println("\nViajando....");
                            barra_de_carga(20, 100);
                            planeta.visitarAsentamientos(jugador);
                        }
                        else {
                            System.out.println("\nSaliendo del juego...");
                            entrada.close();
                            System.exit(0);
                        }
                        break;
                    case 6:
                        if (mapa.obtenerPlanetaActual() instanceof Oceanico || mapa.obtenerPlanetaActual() instanceof Helado) {
                            System.out.println("\nSaliendo del juego...");
                            entrada.close();
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("\nOpción no válida, elige otra.");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada no válida, intenta nuevamente.");
                entrada.nextLine(); // Limpiar el buffer
            }


        }

    }

    // Método que simula la barra de carga
    public static void barra_de_carga(int longitud, int tiempoDePausa) {
        System.out.print("[");
        for (int i = 0; i < longitud; i++) {
            try {
                Thread.sleep(tiempoDePausa); // Pausa en milisegundos
                System.out.print("=");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("]");
    }

    public static void mostrar_titulo(){
        String titulo = """
        ::::    :::  ::::::::       ::::::::::: :::     :::     :::     :::    ::: ::::::::        ::::::::  :::    ::: :::   ::: 
        :+:+:   :+: :+:    :+:          :+:   :+: :+:   :+:     :+:   :+: :+:  :+ :+:    :+:      :+:    :+: :+:   :+:  :+:   :+: 
        :+:+:+  +:+ +:+    +:+          +:+  +:+   +:+  +:+     +:+  +:+   +:+    +:+             +:+        +:+  +:+    +:+ +:+  
        +#+ +:+ +#+ +#+    +:+          +#+ +#++:++#++: +#+     +:+ +#++:++#++:   +#++:++#++      +#++:++#++ +#++:++      +#++:   
        +#+  +#+#+# +#+    +#+          +#+ +#+     +#+  +#+   +#+  +#+     +#+          +#+             +#+ +#+  +#+      +#+    
        #+#   #+#+# #+#    #+#      #+# #+# #+#     #+#   #+#+#+#   #+#     #+#   #+#    #+#      #+#    #+# #+#   #+#     #+#    
        ###    ####  ########        #####  ###     ###     ###     ###     ###    ########        ########  ###    ###    ###    
                """;
        System.out.println( titulo );
    }

    // Método para simular el salto entre planetas
    public static void salto_de_planeta(MapaGalactico mapa, Planeta planeta, Nave nave, Jugador jugador) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n------------------------------------");
        System.out.println("¿A que planeta vas a viajar?");
        System.out.print("Opción: ");
        int opcion = entrada.nextInt();
        int num_planeta_actual = mapa.getPosicion() + 1;
        int num_planeta_viaje = opcion;
        int salto = num_planeta_viaje - num_planeta_actual;

        System.out.println("------------------------------------");
        System.out.println("\nViajando....");
        barra_de_carga(20, 200);
        boolean perdiste = verificar_combustible(mapa, nave, salto);
        

        if(perdiste){
            game_over(mapa, jugador, nave);
            return;
        }

        mapa.viajarSiguiente(opcion-1);
        planeta = mapa.obtenerPlanetaActual();
        bucle_principal(mapa, nave, jugador, planeta);

    }

    public static void extraccion_recursos(MapaGalactico mapa, Jugador jugador, Nave nave){
        Planeta planeta = mapa.obtenerPlanetaActual();
        Scanner entrada = new Scanner(System.in);
        if (planeta instanceof Oceanico) {
            
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué recurso vas a extraer?");
            System.out.println("1. Extraer Flores de sodio: " + planeta.getFloresDeSodio());
            System.out.println("2. Extraer Cristales de hidrogeno: " + planeta.getCristalesHidrogeno());
            System.out.print("Opción: ");
            int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        boolean perdiste = veifivar_salud(mapa, jugador, cantidad);
                        if (perdiste){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(1, cantidad, jugador);
                        break;
                    case 2:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantos Cristalles de hidrogeno vas a extraer?");
                        int cantidad2 = entrada.nextInt();
                        boolean perdiste2 = veifivar_salud(mapa, jugador, cantidad2);
                        if (perdiste2){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(2, cantidad2, jugador);
                        break;
                }
        
            
        }
            

        else if (planeta instanceof Radioactivo) {
            Radioactivo radioactivo = (Radioactivo) planeta;
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué recurso vas a extraer?");
            System.out.println("1. Extraer Flores de sodio: " + radioactivo.getFloresDeSodio());
            System.out.println("2. Extraer Cristales de hidrogeno: " + radioactivo.getCristalesHidrogeno());
            System.out.println("3. Extraer Uranio: " + radioactivo.getUranio());
            System.out.print("Opción: ");
            int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        boolean perdiste = veifivar_salud(mapa, jugador, cantidad);
                        if (perdiste){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(1, cantidad, jugador);
                        break;
                    case 2:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantos Cristalles de hidrogeno vas a extraer?");
                        int cantidad2 = entrada.nextInt();
                        boolean perdiste2 = veifivar_salud(mapa, jugador, cantidad2);
                        if (perdiste2){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(2, cantidad2, jugador);
                        break;
                    case 3:
                    System.out.println("\n------------------------------------");
                    System.out.println("¿Cuanto uranio vas a extraer?");
                    int cantidad3 = entrada.nextInt();
                    boolean perdiste3 = veifivar_salud(mapa, jugador, cantidad3);
                        if (perdiste3){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                    planeta.extraerRecursos(3, cantidad3, jugador);
                    break;
                }
        }

        else if (planeta instanceof Volcanico) {
            Volcanico volcanico = (Volcanico) planeta;
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué recurso vas a extraer?");
            System.out.println("1. Extraer Flores de sodio: " + volcanico.getFloresDeSodio());
            System.out.println("2. Extraer Cristales de hidrogeno: " + volcanico.getCristalesHidrogeno());
            System.out.println("3. Extraer Platino: " + volcanico.getPlatino());
            System.out.print("Opción: ");
            int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        boolean perdiste = veifivar_salud(mapa, jugador, cantidad);
                        if (perdiste){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(1, cantidad, jugador);
                        break;
                    case 2:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantos Cristalles de hidrogeno vas a extraer?");
                        int cantidad2 = entrada.nextInt();
                        boolean perdiste2 = veifivar_salud(mapa, jugador, cantidad2);
                        if (perdiste2){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(2, cantidad2, jugador);
                        break;
                    case 3:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuanto platino vas a extraer?");
                        int cantidad3 = entrada.nextInt();
                        boolean perdiste3 = veifivar_salud(mapa, jugador, cantidad3);
                        if (perdiste3){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(3, cantidad3, jugador);
                        break;
                }
        }

        else if (planeta instanceof Helado) {
                
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué recurso vas a extraer?");
            System.out.println("1. Extraer Flores de sodio: " + planeta.getFloresDeSodio());
            System.out.println("2. Extraer Cristales de hidrogeno: " + planeta.getCristalesHidrogeno());
            System.out.print("Opción: ");
            int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        boolean perdiste = veifivar_salud(mapa, jugador, cantidad);
                        if (perdiste){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(1, cantidad, jugador);
                        break;
                    case 2:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantos Cristalles de hidrogeno vas a extraer?");
                        int cantidad2 = entrada.nextInt();
                        boolean perdiste2 = veifivar_salud(mapa, jugador, cantidad2);
                        if (perdiste2){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(2, cantidad2, jugador);
                        break;
                }
        }

        else if (planeta instanceof CentroGalactico) {
                
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué recurso vas a extraer?");
            System.out.println("1. Extraer Flores de sodio: " + planeta.getFloresDeSodio());
            System.out.println("2. Extraer Cristales de hidrogeno: " + planeta.getCristalesHidrogeno());
            System.out.print("Opción: ");
            int opcion = entrada.nextInt();

                // Opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        boolean perdiste = veifivar_salud(mapa, jugador, cantidad);
                        if (perdiste){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(1, cantidad, jugador);
                        break;
                    case 2:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantos Cristalles de hidrogeno vas a extraer?");
                        int cantidad2 = entrada.nextInt();
                        boolean perdiste2 = veifivar_salud(mapa, jugador, cantidad2);
                        if (perdiste2){
                            game_over(mapa, jugador, nave);
                            break;   
                        }
                        planeta.extraerRecursos(2, cantidad2, jugador);
                        break;
                }
        }
    }



    public static boolean veifivar_salud(MapaGalactico mapa, Jugador jugador, int cantidad){
        Planeta planeta = mapa.obtenerPlanetaActual();
        float energia = planeta.getConsumoEnergia();
        float energia_jugador = jugador.getUnidadesEnergiaProteccion();
        float eficiencia = jugador.getEficienciaEnergiaProteccion();

        float unidadesConsumidas =  0.5f * cantidad * (energia/100) * (1-eficiencia);

        float vida = energia_jugador - unidadesConsumidas;
        jugador.setUnidadesEnergiaProteccion(vida);
        System.out.println("energia jugador = " + energia_jugador);
        System.out.println("energia consumido segun lo sacado = " + unidadesConsumidas);

        
        if (jugador.getUnidadesEnergiaProteccion() <= 0) {
            
            return true;
        }
        return false;
    }

    public static boolean verificar_combustible(MapaGalactico mapa, Nave nave, int valor_salto){
        float combustible = nave.getUnidadesCombustible();
        int salto = Math.abs(valor_salto);
        float eficiencia = nave.getEficienciaPropulsor();
        float combustible_gastado =  0.75f * salto * salto * (1-eficiencia);


        float vida_combustible = combustible - combustible_gastado;
        if (vida_combustible <= 0) {
            System.out.println("La nave se quedo sin combusitble");
            return true;
        }

        nave.setUnidadesCombustible(vida_combustible);
        return false;




    }

    public static void game_over(MapaGalactico mapa, Jugador jugador, Nave nave){

        mapa.setPosicion(0);
        Planeta planeta = mapa.obtenerPlanetaActual();
        jugador.setUnidadesEnergiaProteccion(100);
        nave.setUnidadesCombustible(100);
        jugador.limpiar_inventario();

        String over = """
                
        :::    :::     :::      ::::::::       ::::    ::::  :::    ::: :::::::::: ::::::::: ::::::::::: ::::::::              
        :+:    :+:   :+: :+:   :+:    :+:      +:+:+: :+:+:+ :+:    :+: :+:        :+:    :+:    :+:    :+:    :+:             
        +:+    +:+  +:+   +:+  +:+             +:+ +:+:+ +:+ +:+    +:+ +:+        +:+    +:+    +:+    +:+    +:+             
        +#++:++#++ +#++:++#++: +#++:++#++      +#+  +:+  +#+ +#+    +:+ +#++:++#   +#++:++#:     +#+    +#+    +:+             
        +#+    +#+ +#+     +#+        +#+      +#+       +#+ +#+    +#+ +#+        +#+    +#+    +#+    +#+    +#+             
        #+#    #+# #+#     #+# #+#    #+#      #+#       #+# #+#    #+# #+#        #+#    #+#    #+#    #+#    #+# #+# #+# #+# 
        ###    ### ###     ###  ########       ###       ###  ########  ########## ###    ###    ###     ########  ### ### ### 

                """;

        System.out.println(over);
        System.out.println("¿Deseas Continuar?: 1. Si  2. No");
        Scanner entrada = new Scanner(System.in);
        int opcion = entrada.nextInt();

        if (opcion == 2) {
            System.out.println("\nSaliendo del juego...");
            entrada.close();
            System.exit(0);
        }


        System.out.println("\n------------------------------------");
        System.out.println("Has muerto, pero no te preocupes, ¡No es el final!");
        System.out.println("Has sido devuelto a la orbita del planeta 1");
        System.out.println("Tus niveles de combustible, vida e inventario han sido restaurados");
        System.out.println("Es hora de recargar fuerzas y prepararte para nuevas aventuras. ¡El espacio te espera!");
        System.out.println("\n------------------------------------");

        bucle_principal(mapa, nave, jugador, planeta);




    }


    public static void mecanico_y_enfermeria(Jugador jugador, Nave nave){
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n------------------------------------");
        System.out.println("Bienvenido al Mecanico y enfermeria");
        System.out.println("------------------------------------");
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Mecanico");
        System.out.println("2. Enfermeria");
        System.out.println("3. Atras");
        System.out.println("4. Salir del juego");
        System.out.print("Opción: ");
        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\n------------------------------------");
                System.out.println("Bienvenido al Mecanico");
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. Recargar Combustible");
                System.out.println("2. Atras");
                System.out.println("------------------------------------");
                System.out.println("Combustible restante: " + nave.getUnidadesCombustible());
                System.out.println("CristalesDeHidrogeno: " + jugador.obtenerCantidadDe("CristalesDeHidrogeno"));
                System.out.print("Opción: ");
                int opcion2 = entrada.nextInt();

                switch (opcion2) {
                    case 1:
                        boolean flag = true;
                        while(flag){
                            System.out.println("\n------------------------------------");
                            System.out.println("¿Cuantos cristales de hidrogeno vas a usar?");
                            System.out.print("Unidades: ");
                            int unidadesHidrogeno = entrada.nextInt();
                            float unidadesRecargadas = 0.6f * unidadesHidrogeno * (1 + nave.getEficienciaPropulsor()); 
                            System.out.print("Se recargara " + unidadesRecargadas + " de combustible");
                            System.out.println("¿Estas seguro? 1. Si 2. No");
                            System.out.print("Opción: ");
                            int opcion3 = entrada.nextInt();
                            switch (opcion3) {
                                case 1:
                                    // establecer limite para no superar el maximo
                                    float combusitble = unidadesRecargadas + nave.getUnidadesCombustible();
                                    nave.setUnidadesCombustible(combusitble);
                                    break;
                                case 2:
                                    
                                    return;
                                    
                            }
                        }
                        

                
                    case 2:
                        break;
                }



                break;

            case 2:
                break;
            
            case 3:
                break;
            case 4:
                System.out.println("\nSaliendo del juego...");
                entrada.close();
                System.exit(0);
                break;
        
            default:
                break;
        }


    }



}


