package modelo;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;

public class ninjaDAO {

    private String url="jdbc:mysql://ucc2go05yqdabxxv:koFiUzDL0hfr1jYg6OlG@bjtpm3mps8sawjsrbzsv-mysql.services.clever-cloud.com:3306/bjtpm3mps8sawjsrbzsv";
    private String userName= "ucc2go05yqdabxxv";
    private String password="koFiUzDL0hfr1jYg6OlG";

    Connection connect() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    public void listarNinjas(){
        String sql="select * from ninja";

        try(Connection connection= connect();
            PreparedStatement request= connection.prepareStatement(sql)){
            ResultSet r= request.executeQuery();

            int count=1;


            while (r.next()){
                int id= r.getInt("id");

                String nombre= r.getString("nombre");
                String rango= r.getString("rango");
                String aldea= r.getString("aldea");

                System.out.println("Ninja " + count + " ---");
                System.out.println("Nombre: " + nombre);
                System.out.println("Rango: " + rango);
                System.out.println("Aldea: " + aldea);

                System.out.println("-----");
                count++;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void misionesNinja(int idNinja){
        String sql="select * from mision_ninja where id_ninja=?";
        String sql2="select * from mision where id=?";
        try(Connection connection= connect();
            PreparedStatement request= connection.prepareStatement(sql)){
            request.setInt(1, idNinja);

            ResultSet r= request.executeQuery();
            if (r.next()){

                String fechaInicio= r.getString("fecha_inicio");
                String fechaFin= r.getString("fecha_fin");
                int idMision= r.getInt("id_mision");

                try(Connection connection1= connect();
                    PreparedStatement request1= connection1.prepareStatement(sql2)){
                    request1.setInt(1, idMision);

                    ResultSet r2= request1.executeQuery();

                    if (r2.next()){
                        String descripcion= r2.getString("descripcion");
                        System.out.println(fechaFin);
                        if (fechaFin==null){
                            System.out.println("id Ninja: " + idNinja);
                            System.out.println("Nombre de la misión: " + descripcion);
                            System.out.println("Fecha de inicio: " + fechaInicio);
                        } else {
                            System.out.println("No hay misiones disponibles para el ninja " + idNinja);
                        }
                    }

                } catch (SQLException e){
                    e.printStackTrace();
                }

            } else {
                System.out.println("No hay ninguna misión asignada a este ninja");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void misionesCompletadas(int idNinja){
        String sql="select * from mision_ninja where id_ninja=?";
        String sql2="select * from mision where id=?";

        try(Connection connection= connect();
            PreparedStatement request= connection.prepareStatement(sql)){
            request.setInt(1, idNinja);

            ResultSet r= request.executeQuery();
            if (r.next()){

                String fechaInicio= r.getString("fecha_inicio");
                String fechaFin= r.getString("fecha_fin");
                int idMision= r.getInt("id_mision");

                try(Connection connection1= connect();
                    PreparedStatement request1= connection1.prepareStatement(sql2)){
                    request1.setInt(1, idMision);

                    ResultSet r2= request1.executeQuery();

                    if (r2.next()){
                        String descripcion= r2.getString("descripcion");
                        System.out.println(fechaFin);

                        if (fechaFin!=null){
                            System.out.println("id Ninja: " + idNinja);
                            System.out.println("Nombre de la misión: " + descripcion);
                            System.out.println("Fecha de inicio: " + fechaInicio);
                        } else {
                            System.out.println("No hay misiones completadas del ninja " + idNinja);
                        }
                    }

                } catch (SQLException e){
                    e.printStackTrace();
                }

            } else {
                System.out.println("No hay ninguna misión completada del ninja " + idNinja);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int verificarId(int idNinja){
        String sql="select id from ninja where id=?";

        try (Connection connection= connect();
            PreparedStatement request= connection.prepareStatement(sql)){
            request.setInt(1, 1);

            ResultSet r= request.executeQuery();

            if (r.next()){
                System.out.println("Espere nos segundos...");
            } else {
                System.out.println("El id " + idNinja + " del ninja no existe :c");
                return 0;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 1;
    }
}
