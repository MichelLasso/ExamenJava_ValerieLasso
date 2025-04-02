package vista;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import controlador.MisionNinjas;
import controlador.Ninjas;

public class main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try {
            System.out.println("    ----    ");
            System.out.println("    Menu Ninja  ");
            System.out.println("    ----    ");
            System.out.println("1. Listar todos los ninjas junto con sus habilidades");
            System.out.println("2. Mostrar las misiones disponibles para un ninja específico.");
            System.out.println("3. Mostrar las misiones completadas para un ninja específico.");
            System.out.println("4. Asignar una misión a un ninja, registrando la fecha de inicio.");
            System.out.println("5. Marcar una misión como completada, registrando la fecha de finalización.");
            System.out.println("6. Mostrar todas las misiones completadas");

            int opcion= scanner.nextInt();

            if (opcion==1){
                System.out.println("    Ninjas  ");
                Ninjas n= new Ninjas();
                n.mostrarNinjas();

            } else if (opcion==2){
                System.out.println("    Misiones disponibles    ");
                System.out.println("Ingrese el id del ninja: ");
                int idNinja= scanner.nextInt();

                Ninjas n= new Ninjas();
                n.mostrarMisiones(idNinja);

            } else if (opcion==3){
                System.out.println("    Misiones Completadas    ");
                System.out.println("Ingrese el id del ninja: ");
                int idNinja= scanner.nextInt();

                Ninjas n= new Ninjas();
                n.misionesCompletadas(idNinja);

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

            } else if (opcion==5){
                System.out.println("    Completar misión   ");
                System.out.println("Ingrese el id de la misión ninja: ");
                int idMision= scanner.nextInt();
                System.out.println("Ingrese la fecha final: ");
                scanner.nextLine();
                String fecha_fin = scanner.nextLine();

                MisionNinjas controlador = new MisionNinjas();
                controlador.InsertarMisionCompletada(idMision, fecha_fin);
            } else if (opcion==6){
                System.out.println("    Todas las misiones completadas   ");

                MisionNinjas controlador = new MisionNinjas();
                controlador.MostrarMisionesC();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
