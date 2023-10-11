package Modelo;

import java.util.Random;

public class Casilla {

    Boolean descubierto;
    Boolean bomba;
    int radar;
    int posicionX;
    int posicionY;

    public Casilla(Boolean descubierto, Boolean bomba, int etiqueta, int posicionX, int posicionY) {
        this.descubierto = descubierto;
        this.bomba = bomba;
        this.radar = etiqueta;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void crearMina(){
        bomba = true;
    }

    public Boolean getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(Boolean descubierto) {
        this.descubierto = descubierto;
    }

    public Boolean getBomba() {
        return bomba;
    }

    public void setBomba(Boolean bomba) {
        this.bomba = bomba;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getRadar() {
        return radar;
    }

    public void setRadar(int radar) {
        this.radar = radar;
    }

}
