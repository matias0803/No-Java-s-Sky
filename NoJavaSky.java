import java.util.Scanner;


// Decorar con  arte ascii tienda, extraccionde recursos, centro galactico
// Verificar  y  ordenar las los objetos y clases



public class NoJavaSky {



    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int Iniciar;


        System.out.println("============================================================================================================================");
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
        System.out.println("============================================================================================================================");
        System.out.println("        1. Iniciar  2. Salir         ");
        System.out.print("Opción: ");
        Iniciar = entrada.nextInt();

        
        if (Iniciar == 2) {
            System.out.println("\nSaliendo del juego...");
            entrada.close();
            System.exit(0);
        }
        System.out.println("\n");
        System.out.println("\n====================================");
        
        
        System.out.println("""
            ¡Bienvenido, valiente explorador!
            Te encuentras en el vasto universo de NoJavaSky, donde los secretos de los planetas esperan ser descubiertos.
            Tu misión es viajar entre mundos, recolectar recursos, puedes encontrar civilazion en algunos planetas y enfrentar
            desafíos en tu camino hacia el centro galáctico donde por fin podras descansar.
            
            Empezaras con 10 planetas iniciales en tu mapa, pero si quieres viajar al 11, se desbloqueara un nuevo planeta y asi sucesivamente
            
            Prepárate para una aventura épica, llena de decisiones que afectarán tu viaje.
            ¡La galaxia es tuya para explorar!

            escribe el 1 para Continuar...
            """);
            System.out.print("Opción: ");
            Iniciar = entrada.nextInt();
        System.out.println("====================================");
        
        
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
        
        

        
        bucle_principal(mapa,nave,jugador,PlanetaActual);
    }

    public static void bucle_principal(MapaGalactico mapa, Nave nave, Jugador jugador, Planeta planeta){

        if (mapa.obtenerPlanetaActual() instanceof CentroGalactico) {
            System.out.println("\n------------------------------------");

            System.out.println("""
                                       _..-,--.._
                                 ,`. ,',','      `.
                                 `. `,/`/          \\
                                   :'.`:            :
        ____ _          _ __       | |`|            |
      _(    `.)        ( (  )`.    : `-'            ;     _
     ( (    ) ))      ( (    ))    ,\\_            _/.  (`','
    ( (   )  _)        `-(__.'    '.  ```------'''  .`
     '.__)--'       .-..           |``-...____...-''|
                   (_)_))          |                |
              ,'`.        ___...---|                |--..._
  ,'`. ,'`. ,'   _`.---'''         |                | "
-'..._`.   `.   /`-._  "      "    |    _           |
       ```-..`./:::::)             `-...||______...-'    "
              /:::_.'     "        "                "
           _.:.'''   "                       "          
""");


            System.out.println("\"Has llegado al Centro Galáctico, el fin de tu épico viaje.\n" + //
                                "La galaxia te reconoce como un verdadero explorador estelar.\n" + //
                                "Tu nombre será recordado entre las estrellas por siempre....\"");
            System.exit(0);
        }

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

        System.out.println("Has llegado a la órbita del planeta " + (mapa.getPosicion()) + " : " + planeta.getClass().getSimpleName());
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n------------------------------------");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Visitar la superficie del planeta");
            System.out.println("2. Realizar un salto hacia otro planeta");
            System.out.println("3. Ver combustible");
            System.out.println("4. Ver inventario del jugador");
            System.out.println("5. Mostrar mapa");
            System.out.println("6. Mecanico y enfermeria");
            System.out.println("7. Salir del juego");
            System.out.print("Opción: ");

            
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
                        mecanico_y_enfermeria(jugador, nave);
                        break;
                    case 7:
                        System.out.println("\nSaliendo del juego...");
                        entrada.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOpción no válida, elige otra.");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada no válida, intenta nuevamente.");
                entrada.nextLine(); 
            }
           
        }
        
    }

    
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
            System.out.println("5. Mecanico y enfermeria");
            System.out.println("6. Mostrar mapa");
            
            if (mapa.obtenerPlanetaActual() instanceof Oceanico || mapa.obtenerPlanetaActual() instanceof Helado) {
                System.out.println("7. Visitar asentamientos");
                System.out.println("8. Salir del juego");
            }
            else{
                System.out.println("7. Salir del juego");
                
            }
            System.out.print("Opción: ");


            try {
                int opcion = entrada.nextInt();

               
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
                        mecanico_y_enfermeria(jugador, nave);
                        break;
                    case 6:
                        System.out.println("\n------------------------------------");
                        System.out.println(mapa.toString());
                        break;
                    case 7:
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
                            planeta.visitarAsentamientos(jugador, nave);
                        }
                        else {
                            System.out.println("\nSaliendo del juego...");
                            entrada.close();
                            System.exit(0);
                        }
                        break;
                    case 8:
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
                entrada.nextLine(); 
            }


        }

    }

    
    public static void barra_de_carga(int longitud, int tiempoDePausa) {
        System.out.print("[");
        for (int i = 0; i < longitud; i++) {
            try {
                Thread.sleep(tiempoDePausa); 
                System.out.print("=");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("]");
    }


    
    public static void salto_de_planeta(MapaGalactico mapa, Planeta planeta, Nave nave, Jugador jugador) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n------------------------------------");
        System.out.println("¿A que planeta vas a viajar?");
        System.out.print("Opción: ");
        int opcion = entrada.nextInt();
        int num_planeta_actual = mapa.getPosicion();
        System.out.println("numero planeta actual " + num_planeta_actual);
        int num_planeta_viaje = opcion;
        int salto = num_planeta_viaje - num_planeta_actual;

        int centrogalactico_verif = verificar_centrogalactico(mapa, nave, salto, num_planeta_actual);
        if (centrogalactico_verif == 2) {
            System.out.println("\n------------------------------------");
            System.err.println("No puedes viajar al CentroGalactico");
            System.err.println("tu eficiencia de propulsor es: " + (nave.getEficienciaPropulsor()*100) + "%");
            System.err.println("Necesitas superar el 50%");
            System.err.println("Tip: donde hace mucho frio existen artesanos que pueden ayudarte");
            return;
        }

        System.out.println("------------------------------------");
        System.out.println("\nViajando....");
        barra_de_carga(20, 200);




        boolean perdiste = verificar_combustible(mapa, nave, salto);
        

        if(perdiste){
            game_over(mapa, jugador, nave);
            return;
        }

        mapa.viajarSiguiente(opcion);
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

               
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        if (check(mapa, jugador, cantidad)) {
                            break;
                        }
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
                        if (check(mapa, jugador, cantidad2)) {
                            break;
                        }
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

               
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        if (check(mapa, jugador, cantidad)) {
                            break;
                        }
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
                        if (check(mapa, jugador, cantidad2)) {
                            break;
                        }
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
                    if (check(mapa, jugador, cantidad3)) {
                        break;
                    }
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

                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        if (check(mapa, jugador, cantidad)) {
                            break;
                        }
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
                        if (check(mapa, jugador, cantidad2)) {
                            break;
                        }
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
                        if (check(mapa, jugador, cantidad3)) {
                            break;
                        }
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

                
                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        if (check(mapa, jugador, cantidad)) {
                            break;
                        }
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
                        if (check(mapa, jugador, cantidad2)) {
                            break;
                        }
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

                switch (opcion) {
                    case 1:
                        System.out.println("\n------------------------------------");
                        System.out.println("¿Cuantas Flores de sodio vas a extraer?");
                        int cantidad = entrada.nextInt();
                        if (check(mapa, jugador, cantidad)) {
                            break;
                        }
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
                        if (check(mapa, jugador, cantidad2)) {
                            break;
                        }
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
        
        

        
        if (jugador.getUnidadesEnergiaProteccion() <= 0) {
            
            return true;
        }
        return false;
    }

    public static boolean check(MapaGalactico mapa, Jugador jugador, int cantidad){
        Scanner entrada = new Scanner(System.in);
        Planeta planeta = mapa.obtenerPlanetaActual();
        float energia = planeta.getConsumoEnergia();
        float eficiencia = jugador.getEficienciaEnergiaProteccion();

        float unidadesConsumidas =  0.5f * cantidad * (energia/100) * (1-eficiencia);
        System.out.println("\n------------------------------------");
        System.out.println("Vas a recibir " + unidadesConsumidas + " de dano, estas seguro? 1. Si 2. No");
        System.out.print("Opción: ");
        int opcion = entrada.nextInt();
        if (opcion == 2) {
            return true;
        }
        barra_de_carga(20, 100);
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
                                    
                                    float combusitble = unidadesRecargadas + nave.getUnidadesCombustible();
                                    jugador.eliminarDelInventario("CristalesDeHidrogeno", unidadesHidrogeno);
                                    nave.setUnidadesCombustible(combusitble);
                                    flag = false;
                                    break;
                                case 2:
                                    flag = false;
                                    return;
                                    
                            }
                        }
                        

                
                    case 2:
                       
                        break;
                }



                break;

            case 2:
                System.out.println("\n------------------------------------");
                System.out.println("Bienvenido a la enfermeria");
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. curarte");
                System.out.println("2. Atras");
                System.out.println("------------------------------------");
                System.out.println("Vida restante: " + jugador.getUnidadesEnergiaProteccion());
                System.out.println("FloresDeSodio: " + jugador.obtenerCantidadDe("FloresDeSodio"));
                System.out.print("Opción: ");
                int opcion3 = entrada.nextInt();
                switch (opcion3) {
                    case 1:
                    switch (opcion3) {
                        case 1:
                            boolean flag = true;
                            while(flag){
                                System.out.println("\n------------------------------------");
                                System.out.println("¿Cuantas flores de sodio vas a usar?");
                                System.out.print("Unidades: ");
                                int unidadesSodio = entrada.nextInt();
                                float unidadesRecargadas = 0.65f * unidadesSodio * (1 + jugador.getEficienciaEnergiaProteccion()); 
                                System.out.print("Se recargara " + unidadesRecargadas + " de vida");
                                System.out.println("¿Estas seguro? 1. Si 2. No");
                                System.out.print("Opción: ");
                                int opcion4 = entrada.nextInt();
                                switch (opcion4) {
                                    case 1:
                                       
                                        jugador.eliminarDelInventario("FloresDeSodio", unidadesSodio);
                                        float vida = unidadesRecargadas + jugador.getUnidadesEnergiaProteccion();
                                        jugador.setUnidadesEnergiaProteccion(vida);
                                        flag = false;
                                        break;
                                    case 2:
                                        
                                        return;
                                        
                                }
                            }
                            
    
                    
                        case 2:
                           
                            break;
                    }
                        
                        break;
                
                    default:
                        break;
                }
            
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

    public static int verificar_centrogalactico(MapaGalactico mapa, Nave nave, int salto, int actual){
        salto = Math.abs(salto);
        
        mapa.viajarSiguiente(salto);
        if (mapa.obtenerPlanetaActual() instanceof CentroGalactico) {
            if (nave.getEficienciaPropulsor() > 0.5f) {
                mapa.viajarSiguiente(actual);
                return 1;
            }
            else {
                mapa.viajarSiguiente(actual);
                return 2;
            }
        }
        else{
            mapa.viajarSiguiente(actual);
            return 3;
        }

    }

}


