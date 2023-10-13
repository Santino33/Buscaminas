package Modelo;

public class Buscaminas {

    private Tablero tablero;
    private int dificultad;

    private boolean victoria;
    private boolean derrota;

    public Buscaminas(int dificultad) {
        if (dificultad == 1){
            this.tablero = new Tablero(8, 8, 12);
        }
        if (dificultad == 2){
            this.tablero = new Tablero(12, 12, 30);
        }
        if (dificultad == 3){
            this.tablero = new Tablero(18, 15, 80);
        }
        this.dificultad = dificultad;
        this.victoria = false;
        this.derrota = false;
    }


    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isDerrota() {
        return derrota;
    }

    public void setDerrota(boolean derrota) {
        this.derrota = derrota;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }
}
