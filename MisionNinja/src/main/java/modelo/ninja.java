package modelo;

public class ninja {
    private int id;
    private String name;
    private String rango;
    private String aldea;

    public ninja(){};

    public ninja(int id, String name, String rango, String aldea) {
        this.id = id;
        this.name = name;
        this.rango = rango;
        this.aldea = aldea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }
}
