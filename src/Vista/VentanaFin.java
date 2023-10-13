package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VentanaFin extends JFrame {

    private JLabel textLabelTitulo;

    private JLabel textLabelText;
    private JPanel textPanelTitulo;
    private JPanel textPanelText;
    private JButton aceptarButton;
    private JButton salirButton;
    private JPanel botonesPanel;
    public VentanaFin() {
        this.setSize(500, 200);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();

        textLabelTitulo = new JLabel();
        textLabelTitulo.setFont(new Font("Arial", Font.PLAIN, 25));
        textLabelTitulo.setHorizontalAlignment(JLabel.CENTER);

        textPanelTitulo = new JPanel();
        textPanelTitulo.add(textLabelTitulo);
        this.add(textPanelTitulo, BorderLayout.NORTH);

        textLabelText = new JLabel();
        textLabelText.setText("El juego se ha acabado ¿deseas jugar de nuevo?");
        textLabelText.setFont(new Font("Arial", Font.PLAIN, 18));
        textLabelText.setHorizontalAlignment(JLabel.CENTER);

        textPanelText = new JPanel();
        textPanelText.add(textLabelText);
        this.add(textLabelText, BorderLayout.CENTER);

        botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridBagLayout());

        aceptarButton = new JButton("Jugar de nuevo");
        aceptarButton.setSize(50, 70);
        aceptarButton.setFont(new Font("Arial", Font.BOLD, 15));
        aceptarButton.setBackground(Color.GREEN);
        aceptarButton.setActionCommand("jugar");
        gbc.gridx = 0; // Posición x
        gbc.gridy = 0; // Posición y
        gbc.weightx = 1; // Espacio horizontal
        gbc.anchor = GridBagConstraints.CENTER; // Alinear al centro
        gbc.insets = new Insets(0, 5, 0, 5);
        botonesPanel.add(aceptarButton, gbc);

        salirButton = new JButton("Salir");
        salirButton.setSize(50, 70);
        salirButton.setFont(new Font("Arial", Font.BOLD, 15));
        salirButton.setBackground(Color.RED);
        salirButton.setActionCommand("salir");
        gbc.gridx = 1; // Posición x
        gbc.gridy = 0; // Posición y
        gbc.weightx = 1; // Espacio horizontal
        gbc.anchor = GridBagConstraints.CENTER; // Alinear al centro
        gbc.insets = new Insets(0, 5, 0, 0);
        botonesPanel.add(salirButton,gbc);

        this.add(botonesPanel, BorderLayout.SOUTH);

    }

    public void setTitle(String resultado){
        textLabelTitulo.setText("Fin del juego: " + resultado);
        this.repaint();
        this.setVisible(true);
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public void setAceptarButton(JButton aceptarButton) {
        this.aceptarButton = aceptarButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }

    public void setSalirButton(JButton salirButton) {
        this.salirButton = salirButton;
    }

}
