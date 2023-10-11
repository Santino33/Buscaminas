package Vista;

import Modelo.Casilla;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SwingVista extends JFrame {

    private int botonSize = 70;
    private int numRows = 10;
    int numCols = 10;
    int boardWidth = numRows * botonSize;
    int boardHeight = numCols * botonSize;
    private JLabel textLabel;
    private JPanel textPanel;
    private JPanel boardPanel;
    private ArrayList<Boton> botonesBomba;
    private Boton[][] tablero;

    public SwingVista(){
        tablero = new Boton[numRows][numCols];
        this.setSize(boardWidth, boardHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Buscaminas");
        textLabel.setOpaque(true);

        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        this.add(textPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(numRows, numCols));
        //boardPanel.setBackground(Color.green);
        this.add(boardPanel);

        crearBotones();
        this.setVisible(true);
        botonesBomba = new ArrayList<>();
    }

    public void crearBotones(){
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                Boton boton = new Boton(i, j);
                boton.setSize(botonSize, botonSize);
                tablero[i][j] = boton;

                boardPanel.add(boton);
            }
        }
    }

    public void revelarCasilla(Casilla casilla){
        Boton boton = tablero[casilla.getPosicionX()][casilla.getPosicionY()];
        if (casilla.getBomba()){
            boton.setText("💣");
            boton.setBackground(Color.RED);
            revelarBombas();
        }
        else if (!casilla.getBomba()){
            boton.setText(""+casilla.getRadar());
            boton.setBackground(Color.lightGray);
        }
    }

    public void revelarBoton(int posX, int posY, int radar){
        Boton botonPresionado = tablero[posX][posY];
        botonPresionado.setText(""+radar);
        botonPresionado.setBackground(Color.lightGray);
        botonPresionado.setEnabled(false);
    }

    public void revelarBomba(int posX, int posY){
        Boton botonPresionado = tablero[posX][posY];
        botonPresionado.setText("💣");
        botonPresionado.setBackground(Color.RED);
        botonPresionado.setEnabled(false);
        revelarBombas();
    }

    public void revelarBombas(){
        for (Boton boton : botonesBomba){
            boton.setText("💣");
            boton.setEnabled(false);
        }
    }

    public void agregarBotonBomba(int posX, int posY){
        Boton botonBomba = tablero[posX][posY];
        botonesBomba.add(botonBomba);
    }

    public int getBotonSize() {
        return botonSize;
    }

    public void setBotonSize(int botonSize) {
        this.botonSize = botonSize;
    }

    public ArrayList<Boton> getBotonesBomba() {
        return botonesBomba;
    }

    public void setBotonesBomba(ArrayList<Boton> botonesBomba) {
        this.botonesBomba = botonesBomba;
    }

    public Boton[][] getTablero() {
        return tablero;
    }

    public void setTablero(Boton[][] tablero) {
        this.tablero = tablero;
    }

}
