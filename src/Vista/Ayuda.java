package Vista;

import javax.swing.*;
import java.awt.*;

public class Ayuda extends JFrame {
    private JPanel tituloPanel;
    private JLabel tituloTexto;
    private JPanel contenidoPanel;
    private JLabel contenidoTexto1;
    private JLabel contenidoTexto2;
    private JLabel contenidoTexto3;
    private JButton cerrar;

    public Ayuda() {
        this.setSize(600, 250);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        tituloTexto = new JLabel();
        tituloTexto.setText("INSTRUCCIONES");

        tituloPanel = new JPanel();
        tituloPanel.add(tituloTexto);
        this.add(tituloPanel, BorderLayout.NORTH);

        contenidoTexto1 = new JLabel();
        contenidoTexto2 = new JLabel();
        contenidoTexto3 = new JLabel();
        contenidoTexto1.setText("Se te presenta un tablero de cuadrados, cada uno con una cubierta.");
        contenidoTexto2.setText("Abrir un cuadrado que no tiene una bomba revela el número de cuadrados vecinos que contienen bombas");
        contenidoTexto3.setText("Si abres todas las casillas sin bombas, ganas.");

        contenidoPanel = new JPanel();
        contenidoPanel.setLayout(new BorderLayout());
        contenidoPanel.add(contenidoTexto1, BorderLayout.NORTH);
        contenidoPanel.add(contenidoTexto2, BorderLayout.CENTER);
        contenidoPanel.add(contenidoTexto3, BorderLayout.SOUTH);
        this.add(contenidoPanel, BorderLayout.CENTER);

        cerrar = new JButton("Cerrar");
        cerrar.setBackground(Color.RED);
        cerrar.setFont(new Font("Arial", Font.BOLD, 15));
        cerrar.setSize(40, 30);
        cerrar.setActionCommand("cerrar-instrucciones");
        this.add(cerrar, BorderLayout.SOUTH);
    }

    public void setVisible(){
        this.setVisible(true);
    }

    public JButton getCerrar() {
        return cerrar;
    }

    public void setCerrar(JButton cerrar) {
        this.cerrar = cerrar;
    }
}
