package Vista;

import javax.swing.*;

public class BarraDeMenu extends JMenuBar {
    JMenu menuJuego;
    JMenuItem nuevoJuego;
    JMenuItem pausa;
    JRadioButtonMenuItem dificultadIntermedio;
    public BarraDeMenu() {
        //Crear menu de ajustes
        menuJuego = new JMenu("Juego");
        nuevoJuego = new JMenuItem("Nuevo Juego");
        pausa = new JMenuItem("Pausa");

        // Crear los elementos de radio button para la dificultad
        dificultadIntermedio = new JRadioButtonMenuItem("Intermedio");
        dificultadIntermedio.setActionCommand("intermedio");
        JRadioButtonMenuItem dificultadDificil = new JRadioButtonMenuItem("Dificil");
        JRadioButtonMenuItem dificultadExperto = new JRadioButtonMenuItem("Experto");

        // Agrupar los elementos de radio button
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(dificultadIntermedio);
        grupoDificultad.add(dificultadDificil);
        grupoDificultad.add(dificultadExperto);

        JMenuItem cerrar = new JMenuItem("Cerrar");
        menuJuego.add(nuevoJuego);
        menuJuego.add(pausa);
        menuJuego.add(dificultadIntermedio);
        menuJuego.add(dificultadDificil);
        menuJuego.add(dificultadExperto);
        menuJuego.add(cerrar);

        //Crear menu Opciones
        JMenu menuOpciones = new JMenu("Opciones");
        JMenuItem aumentar = new JMenuItem("Aumentar");
        JMenuItem reducir = new JMenuItem("Reducir");
        JCheckBoxMenuItem campoAbierto = new JCheckBoxMenuItem("Campo abierto");
        menuOpciones.add(aumentar);
        menuOpciones.add(reducir);
        menuOpciones.add(campoAbierto);

        //Crear menu Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem instrucciones = new JMenuItem("Instrucciones");
        menuAyuda.add(instrucciones);

        //Agregar menus a la barra de menu
        this.add(menuJuego);
        this.add(menuOpciones);
        this.add(menuAyuda);

    }


}
