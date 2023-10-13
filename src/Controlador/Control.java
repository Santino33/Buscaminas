package Controlador;

import Modelo.Buscaminas;
import Modelo.Casilla;
import Modelo.Tablero;
import Vista.Boton;
import Vista.SwingVista;
import Vista.VentanaFin;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Control implements ActionListener, MouseListener{

    private SwingVista vista;
    private VentanaFin ventanaFin;
    private Buscaminas modelo;

    public Control() {
        this.vista = new SwingVista();
        this.ventanaFin = new VentanaFin();
        this.modelo = new Buscaminas(2);
    }

    public void inicio(){
        modelo.getTablero().llenarTablero();
        asignarCasillasBomba();
        agregarListenersBotones();
        agregarListenerBarra();
    }


    private void agregarListenerBarra(){
        vista.getBarraDeMenu().addMouseListener(this);
    }
    private void agregarListenerVentanaFin(){
        ventanaFin.getAceptarButton().addActionListener(this);
        ventanaFin.getSalirButton().addActionListener(this);
    }
    private void agregarListenersBotones() {
        for (int i = 0; i < vista.getTablero().length; i++){
            for (int j = 0; j < vista.getTablero()[i].length; j++){
                vista.getTablero()[i][j].addMouseListener(this);
            }
        }
    }

    private void asignarCasillasBomba(){
        for (Casilla casillaBomba : modelo.getTablero().getCasillasBomba()){
            int posX = casillaBomba.getPosicionX();
            int posY = casillaBomba.getPosicionY();
            vista.agregarBotonBomba(posX, posY);
        }
    }

    private boolean evaluarVictoria(){
        int casillasReveladas = 0;
        for (int i = 0; i < modelo.getTablero().getRows();i++){
            for (int j = 0; j < modelo.getTablero().getCols();j++){
                Casilla casilla = modelo.getTablero().getCasilla(i, j);
                if (casilla.getDescubierto()) casillasReveladas++;
            }
        }
        if (casillasReveladas == modelo.getTablero().getNumeroMinas()) modelo.setVictoria(true);
        return modelo.isVictoria();
    }
    private boolean evaluarDerrota(){
        return modelo.isDerrota();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Boton botonPresionado = (Boton) e.getSource();

        int posX = Integer.parseInt(botonPresionado.getActionCommand().split(",")[0]);
        int posY = Integer.parseInt(botonPresionado.getActionCommand().split(",")[1]);

        //Click izquierdo
        if (e.getButton() == MouseEvent.BUTTON1){
            Casilla casillaPresionada = modelo.getTablero().getCasilla(posX, posY);
            casillaPresionada.setDescubierto(true);
            if (vista.getBotonesBomba().contains(botonPresionado)){
                vista.revelarBomba(posX, posY);
                modelo.setDerrota(true);
            }
            else{
                vista.revelarBoton(posX, posY, casillaPresionada.getRadar());
            }
        }

        //Click derecho
        if (e.getButton() == MouseEvent.BUTTON3){
            Casilla casillaPresionada = modelo.getTablero().getCasilla(posX, posY);
            if (casillaPresionada.getBandera()){
                vista.quitarBandera(posX, posY);
                casillaPresionada.setBandera(false);
            }
            else{
                vista.ponerBandera(posX, posY);
                casillaPresionada.setBandera(true);
            }
        }
        //Evaluar fin del juego
        if (evaluarDerrota()){
            ventanaFin.setTitle("Has perdido");
            return;
        }
        if (evaluarVictoria()){
            ventanaFin.setTitle("Felicidades, has ganado");
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
