package controlador;

import modelo.ninjaDAO;

public class Ninjas {
    public void mostrarNinjas(){
        ninjaDAO dao= new ninjaDAO();
        dao.listarNinjas();
    }

    public void mostrarMisiones(int idNinja){
        ninjaDAO dao= new ninjaDAO();
        dao.misionesNinja(idNinja);
    }

    public void misionesCompletadas(int idNinja){
        ninjaDAO dao= new ninjaDAO();
        dao.misionesCompletadas(idNinja);
    }

    public int verificarNinja(int idNinja){
        ninjaDAO dao = new ninjaDAO();
        if (dao.verificarId(idNinja)==1){
            return 1;
        }
        return 0;
    }
}
