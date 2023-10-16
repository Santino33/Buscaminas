package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    private int numeroMinas;
    private int casillasPorDescubrir;
    private int rows;
    private int cols;
    private ArrayList<Casilla> casillasBomba;

    public Tablero(int rows,int cols, int numeroMinas) {
        this.tablero = new Casilla[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.numeroMinas = numeroMinas;
        this.casillasPorDescubrir = rows*cols;
        llenarTablero();
    }

    public void llenarTablero(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
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
        while(casillasBomba.size() < numeroMinas){
            int posX = valor.nextInt(rows);
            int posY = valor.nextInt(cols);
            Casilla casilla = tablero[posX][posY];
            if (validarMina(casilla)){
                casilla.setBomba(true);
                casilla.setPosicionX(posX);
                casilla.setPosicionY(posY);
                casillasBomba.add(casilla);
            }
        }
        return casillasBomba;
    }

    private boolean validarMina(Casilla casillaBomba){
        return !casillasBomba.contains(casillaBomba);
    }

    //Metodo que asigna la etiqueta de cada casilla segun la cantidad de minas cerca
    public void crearRadar(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int minasCerca = 0;
                //Verificaciones por cada casilla posible
                if (i - 1 >= 0 && j - 1 >= 0 ){
                    if (tablero[i -1][j -1].getBomba()) minasCerca++;
                }

                if (i + 1 < rows && j - 1 >= 0 ){
                    if (tablero[i+1][j-1].getBomba()) minasCerca++;
                }

                if (i - 1 >= 0 && j + 1 < cols){
                    if (tablero[i-1][j+1].getBomba()) minasCerca++;
                }

                if (i + 1 < rows && j + 1 < cols ){
                    if (tablero[i+1][j+1].getBomba()) minasCerca++;
                }

                if (i - 1 >= 0 ){
                    if (tablero[i-1][j].getBomba()) minasCerca++;
                }

                if (i + 1 < rows){
                    if (tablero[i+1][j].getBomba()) minasCerca++;
                }
                if (j - 1 >= 0 ){
                    if (tablero[i][j-1].getBomba()) minasCerca++;
                }
                if (j + 1 < cols ){
                    if (tablero[i][j+1].getBomba()) minasCerca++;
                }
                tablero[i][j].setRadar(minasCerca);
            }
        }
    }



    public void reducirCasillasPorDescubrir(){
        casillasPorDescubrir -= 1;
    }
    public int getCasillasPorDescubrir() {
        return casillasPorDescubrir;
    }

    public void setCasillasPorDescubrir(int casillasPorDescubrir) {
        this.casillasPorDescubrir = casillasPorDescubrir;
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
