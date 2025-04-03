package vista;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import controlador.MisionNinjas;
import controlador.Ninjas;
import org.example.Main;

public class main {

    public static void tiempoDeEspera(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  static void MenuPrincipal(){
        System.out.println("    ----    ");
        System.out.println("    Menu Ninja  ");
        System.out.println("    ----    ");
        System.out.println("1. Listar todos los ninjas junto con sus habilidades");
        System.out.println("2. Mostrar las misiones disponibles para un ninja específico.");
        System.out.println("3. Mostrar las misiones completadas para un ninja específico.");
        System.out.println("4. Asignar una misión a un ninja, registrando la fecha de inicio.");
        System.out.println("5. Marcar una misión como completada, registrando la fecha de finalización.");
        System.out.println("6. Mostrar todas las misiones completadas");
        System.out.println("7. Salir del programa");
    }

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        boolean salida=true;

        while(salida){

            try {
                MenuPrincipal();
                int opcion= scanner.nextInt();

                if (opcion==1){
                    System.out.println("    Ninjas  ");

                    Ninjas n= new Ninjas();
                    n.mostrarNinjas();

                    // En 5 segundos se ejecuta el menú principal
                    tiempoDeEspera(5);

                } else if (opcion==2){
                    System.out.println("    Misiones disponibles    ");
                    System.out.println("Ingrese el id del ninja: ");
                    int idNinja= scanner.nextInt();

                    Ninjas n= new Ninjas();
                    if (n.verificarNinja(idNinja)==1){
                        n.mostrarMisiones(idNinja);
                    }

                    tiempoDeEspera(5);


                } else if (opcion==3){
                    System.out.println("    Misiones Completadas    ");
                    System.out.println("Ingrese el id del ninja: ");
                    int idNinja= scanner.nextInt();

                    Ninjas n= new Ninjas();
                    n.misionesCompletadas(idNinja);

                    tiempoDeEspera(5);


                } else if(opcion==4){
                    System.out.println("    Asignar misión al ninja   ");
                    System.out.println("Ingrese el id del ninja: ");
                    int idNinja= scanner.nextInt();
                    System.out.println("Ingrese el id de la misión: ");
                    int idMision= scanner.nextInt();
                    System.out.println("Ingrese la fecha de inicio: ");
                    scanner.nextLine();
                    String fecha_inicio= scanner.nextLine();

                    MisionNinjas controlador= new MisionNinjas();
                    controlador.IngresarDatosMision(idNinja,idMision, fecha_inicio);

                    tiempoDeEspera(5);


                } else if (opcion==5){
                    System.out.println("    Completar misión   ");
                    System.out.println("Ingrese el id de la misión ninja: ");
                    int idMision= scanner.nextInt();
                    System.out.println("Ingrese la fecha final: ");
                    scanner.nextLine();
                    String fecha_fin = scanner.nextLine();

                    MisionNinjas controlador = new MisionNinjas();
                    controlador.InsertarMisionCompletada(idMision, fecha_fin);

                    tiempoDeEspera(5);


                } else if (opcion==6){
                    System.out.println("    Todas las misiones completadas   ");

                    MisionNinjas controlador = new MisionNinjas();
                    controlador.MostrarMisionesC();

                    tiempoDeEspera(5);


                } else if (opcion==7) {
                    System.out.println("Saliendo....");
                    tiempoDeEspera(2);
                    salida=false;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
