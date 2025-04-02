package modelo;

import java.sql.*;

public class ninja_misionDAO {

    private String url="jdbc:mysql://ucc2go05yqdabxxv:koFiUzDL0hfr1jYg6OlG@bjtpm3mps8sawjsrbzsv-mysql.services.clever-cloud.com:3306/bjtpm3mps8sawjsrbzsv";
    private String userName= "ucc2go05yqdabxxv";
    private String password="koFiUzDL0hfr1jYg6OlG";

    Connection connect() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    public void insertarMision(int idNinja, int idMision, String fechaInicio){
        String sql="insert into mision_ninja (id_ninja,id_mision,fecha_inicio, fecha_fin) values (?,?,?,?)";

        try(Connection connection= connect();
            PreparedStatement request= connection.prepareStatement(sql)){

            request.setInt(1, idNinja);
            request.setInt(2, idMision);
            request.setString(3, fechaInicio);
            request.setNull(4, 0);

            if (request.executeUpdate()==1){
                System.out.println("Mision guardada con éxito");
            } else {
                System.out.println("ERROR: la misión no fue guardada");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void misionCompletada(int idMision, String fechaFin){
        String sql= "update mision_ninja set fecha_fin=? where id_mision=?";

        try(Connection connection= connect();
            PreparedStatement request = connection.prepareStatement(sql)){

            request.setInt(2, idMision);
            request.setString(1, fechaFin);

            if (request.executeUpdate()==1){
                System.out.println("Fecha actualizada");
            } else {
                System.out.println("fecha no actualizada");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void misionesCompletadas(){
        String sql= "select * from mision_ninja";
        try(Connection connection= connect();
            PreparedStatement request = connection.prepareStatement(sql)){

            ResultSet r= request.executeQuery();
            int count= 1;
            if (r.next()){

                int id= r.getInt("id");
                String fecha_inicio= r.getString("fecha_inicio");
                String fecha_fin= r.getString("fecha_fin");

                if (fecha_fin!=null){
                    System.out.println(count + "-----");
                    System.out.println("Id de la mision ninja completada: " + id);
                    System.out.println("Fecha de inicio: " + fecha_inicio);
                    System.out.println("Fecha fin: " + fecha_fin);
                    System.out.println("-----");
                } else {
                    System.out.println("No hay misiones completadas :)");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
