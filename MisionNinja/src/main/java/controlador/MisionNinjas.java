package controlador;

import modelo.ninja_misionDAO;

public class MisionNinjas {

    public void IngresarDatosMision(int idNinja, int idMision, String fecha_inicio){
        ninja_misionDAO dao = new ninja_misionDAO();
        dao.insertarMision(idNinja,idMision,fecha_inicio);
    }

    public void InsertarMisionCompletada(int idMision, String fecha_fin){
        ninja_misionDAO dao = new ninja_misionDAO();
        dao.misionCompletada(idMision,fecha_fin);
    }

    public void MostrarMisionesC(){
        ninja_misionDAO dao = new ninja_misionDAO();
        dao.misionesCompletadas();
    }
}
