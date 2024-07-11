public class Estudiantes2 {
    String nombre;
    String cedula;
    int bimestreUno;
    int bimestreDos;

    public Estudiantes2(String nombre, String cedula, int bimestreUno, int bimestreDos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.bimestreUno = bimestreUno;
        this.bimestreDos = bimestreDos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getBimestreUno() {
        return bimestreUno;
    }

    public int getBimestreDos() {
        return bimestreDos;
    }

    public int getPromedio() {
        return (bimestreUno + bimestreDos) / 2;
    }
}
