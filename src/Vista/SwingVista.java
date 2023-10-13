package Vista;

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
    private JMenuBar barraDeMenu;
    private ArrayList<Boton> botonesBomba;
    private Boton[][] tablero;

    public SwingVista(){
        tablero = new Boton[numRows][numCols];
        this.setSize(boardWidth, boardHeight);
        this.setJMenuBar(barraDeMenu = new BarraDeMenu());
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

    public void revelarBoton(int posX, int posY, int radar){
        Boton botonPresionado = tablero[posX][posY];
        botonPresionado.setText(""+radar);
        botonPresionado.setBackground(Color.lightGray);
        botonPresionado.setEnabled(false);
    }
    public void ponerBandera(int posX, int posY){
        Boton botonPresionado = tablero[posX][posY];
        botonPresionado.setText("🚩");
        botonPresionado.setBackground(Color.lightGray);
    }
    public void quitarBandera(int posX, int posY){
        Boton botonPresionado = tablero[posX][posY];
        botonPresionado.setText("❓");
        botonPresionado.setBackground(Color.lightGray);

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

    public void deshabilitarBotones(){
        for (int i =0; i<tablero.length; i++){
            for (int j =0; j<tablero[i].length; j++){
                tablero[i][j].setEnabled(false);
            }
        }
    }

    public void agregarBotonBomba(int posX, int posY){
        Boton botonBomba = tablero[posX][posY];
        botonesBomba.add(botonBomba);
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public JMenuBar getBarraDeMenu() {
        return barraDeMenu;
    }

    public void setBarraDeMenu(JMenuBar barraDeMenu) {
        this.barraDeMenu = barraDeMenu;
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
