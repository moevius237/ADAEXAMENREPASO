public class Ejemplar {
    private String estado;
    private int libroId;

    public Ejemplar(String estado, int libroId) {
        this.estado = estado;
        this.libroId = libroId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }
}
