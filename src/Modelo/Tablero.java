package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    int numeroMinas;
    int tamanoTablero;
    ArrayList<Casilla> casillasBomba;

    public Tablero(int tamanoTablero, int numeroMinas) {
        this.tablero = new Casilla[tamanoTablero][tamanoTablero];
        this.tamanoTablero = tamanoTablero;
        this.numeroMinas = numeroMinas;
        llenarTablero();
    }

    public void llenarTablero(){
        for (int i = 0; i < tamanoTablero; i++){
            for (int j = 0; j < tamanoTablero; j++){
                Casilla casilla = new Casilla(false, false, 0, i, j);
                tablero[i][j] = casilla;
            }
        }
        crearMinas();
        crearRadar();
    }


    public ArrayList<Casilla> crearMinas(){
        casillasBomba = new ArrayList<Casilla>();
        Random valor = new Random();
        for (int i = 0; i < numeroMinas; i++){
            int posX = valor.nextInt(tamanoTablero);
            int posY = valor.nextInt(tamanoTablero);
            Casilla casilla = tablero[posX][posY];
            casilla.setBomba(true);
            casilla.setPosicionX(posX);
            casilla.setPosicionY(posY);
            casilla.setRadar(0);
            casillasBomba.add(casilla);
        }
        return casillasBomba;
    }

    //Metodo que asigna la etiqueta de cada casilla segun la cantidad de minas cerca
    public void crearRadar(){
        for (int i = 0; i < tamanoTablero; i++){
            for (int j = 0; j < tamanoTablero; j++){
                int minasCerca = 0;
                //Verificaciones por cada casilla posible
                if (i - 1 >= 0 && j - 1 >= 0 ){
                    if (tablero[i -1][j -1].getBomba()) minasCerca++;
                }

                if (i + 1 < tamanoTablero && j - 1 >= 0 ){
                    if (tablero[i+1][j-1].getBomba()) minasCerca++;
                }

                if (i - 1 >= 0 && j + 1 < tamanoTablero){
                    if (tablero[i-1][j+1].getBomba()) minasCerca++;
                }

                if (i + 1 < tamanoTablero && j + 1 < tamanoTablero ){
                    if (tablero[i+1][j+1].getBomba()) minasCerca++;
                }

                if (i - 1 >= 0 ){
                    if (tablero[i-1][j].getBomba()) minasCerca++;
                }

                if (i + 1 < tamanoTablero){
                    if (tablero[i+1][j].getBomba()) minasCerca++;
                }
                if (j - 1 >= 0 ){
                    if (tablero[i][j-1].getBomba()) minasCerca++;
                }
                if (j + 1 < tamanoTablero ){
                    if (tablero[i][j+1].getBomba()) minasCerca++;
                }
                tablero[i][j].setRadar(minasCerca);
            }
        }
    }

    public boolean getBombaCasilla(int posX, int posY){
        Casilla casilla = tablero[posX][posY];
        return  casilla.getBomba();
    }

    public Casilla getCasilla(int posX, int posY){
        return tablero[posX][posY];
    }

    public ArrayList<Casilla> getCasillasBomba() {
        return casillasBomba;
    }

    public void setCasillasBomba(ArrayList<Casilla> casillasBomba) {
        this.casillasBomba = casillasBomba;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }

    public int getNumeroMinas() {
        return numeroMinas;
    }

    public void setNumeroMinas(int numeroMinas) {
        this.numeroMinas = numeroMinas;
    }

    public int getTamanoTablero() {
        return tamanoTablero;
    }

    public void setTamanoTablero(int tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
    }
}
