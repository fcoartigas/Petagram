package artigas.com.petagram;

public class Mascota {
    private int foto;
    private int btnLikevote;
    private String nombre;
    private int numeroLikes;
    private int btnLikecount;

    public Mascota(int foto, int btnLikevote, String nombre, int numeroLikes, int btnLikecount) {
        this.foto = foto;
        this.btnLikevote = btnLikevote;
        this.nombre = nombre;
        this.numeroLikes = numeroLikes;
        this.btnLikecount = btnLikecount;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getBtnLikevote() {
        return btnLikevote;
    }

    public void setBtnLikevote(int btnLikevote) {
        this.btnLikevote = btnLikevote;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(int numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public int getBtnLikecount() {
        return btnLikecount;
    }

    public void setBtnLikecount(int btnLikecount) {
        this.btnLikecount = btnLikecount;
    }
}
