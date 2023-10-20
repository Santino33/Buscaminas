package Modelo;

import javax.swing.*;
import java.util.ArrayList;

public interface ITablero{
    public void llenarTablero();
    public ArrayList<Modelo.Casilla> crearMinas();
    public boolean validarMina(Object casillaBomba);
    public void crearRadar();
    public void reducirCasillasPorDescubrir();
    public int getCasillasPorDescubrir();

}