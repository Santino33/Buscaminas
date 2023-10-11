package Modelo;

public class Buscaminas {

    private Tablero tablero;
    int dificultad;


    public Buscaminas(int dificultad) {
        if (dificultad == 1){
            this.tablero = new Tablero(8, 6);
        }
        if (dificultad == 2){
            this.tablero = new Tablero(10, 10);
        }
        if (dificultad == 3){
            this.tablero = new Tablero(12, 15);
        }
        this.dificultad = dificultad;
    }


    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
