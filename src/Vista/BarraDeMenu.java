package Vista;

import javax.swing.*;

public class BarraDeMenu extends JMenuBar {
    private JMenu menuJuego;
    private JMenuItem nuevoJuego;
    private JRadioButtonMenuItem dificultadIntermedio;
    private JRadioButtonMenuItem dificultadDificil;
    private JRadioButtonMenuItem dificultadExperto;
    private ButtonGroup grupoDificultad;
    private JMenuItem cerrar;
    private JMenu menuOpciones;
    private JCheckBoxMenuItem campoAbierto;
    private JMenu menuAyuda;
    JMenuItem instrucciones;
    public BarraDeMenu() {
        //Crear menu de ajustes
        menuJuego = new JMenu("Juego");
        nuevoJuego = new JMenuItem("Nuevo Juego");
        nuevoJuego.setActionCommand("nuevoJuego");

        // Crear los elementos de radio button para la dificultad
        dificultadIntermedio = new JRadioButtonMenuItem("Intermedio");
        dificultadIntermedio.setActionCommand("intermedio");

        dificultadDificil = new JRadioButtonMenuItem("Dificil");
        dificultadDificil.setActionCommand("dificil");

        dificultadExperto = new JRadioButtonMenuItem("Experto");
        dificultadExperto.setActionCommand("experto");

        // Agrupar los elementos de radio button
        grupoDificultad = new ButtonGroup();
        grupoDificultad.add(dificultadIntermedio);
        grupoDificultad.add(dificultadDificil);
        grupoDificultad.add(dificultadExperto);

        cerrar = new JMenuItem("Cerrar");
        menuJuego.add(nuevoJuego);
        menuJuego.add(dificultadIntermedio);
        menuJuego.add(dificultadDificil);
        menuJuego.add(dificultadExperto);
        menuJuego.add(cerrar);

        //Crear menu Opciones
        menuOpciones = new JMenu("Opciones");
        campoAbierto = new JCheckBoxMenuItem("Campo abierto");
        campoAbierto.setActionCommand("campo abierto");
        menuOpciones.add(campoAbierto);

        //Crear menu Ayuda
        menuAyuda = new JMenu("Ayuda");
        instrucciones = new JMenuItem("Instrucciones");
        instrucciones.setActionCommand("instrucciones");
        menuAyuda.add(instrucciones);

        //Agregar menus a la barra de menu
        this.add(menuJuego);
        this.add(menuOpciones);
        this.add(menuAyuda);

    }

    public JMenu getMenuJuego() {
        return menuJuego;
    }

    public void setMenuJuego(JMenu menuJuego) {
        this.menuJuego = menuJuego;
    }

    public JMenuItem getNuevoJuego() {
        return nuevoJuego;
    }

    public void setNuevoJuego(JMenuItem nuevoJuego) {
        this.nuevoJuego = nuevoJuego;
    }

    public ButtonGroup getGrupoDificultad() {
        return grupoDificultad;
    }

    public void setGrupoDificultad(ButtonGroup grupoDificultad) {
        this.grupoDificultad = grupoDificultad;
    }

    public JMenuItem getCerrar() {
        return cerrar;
    }

    public void setCerrar(JMenuItem cerrar) {
        this.cerrar = cerrar;
    }

    public JMenu getMenuOpciones() {
        return menuOpciones;
    }

    public void setMenuOpciones(JMenu menuOpciones) {
        this.menuOpciones = menuOpciones;
    }

    public JCheckBoxMenuItem getCampoAbierto() {
        return campoAbierto;
    }

    public void setCampoAbierto(JCheckBoxMenuItem campoAbierto) {
        this.campoAbierto = campoAbierto;
    }

    public JMenu getMenuAyuda() {
        return menuAyuda;
    }

    public void setMenuAyuda(JMenu menuAyuda) {
        this.menuAyuda = menuAyuda;
    }

    public JMenuItem getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(JMenuItem instrucciones) {
        this.instrucciones = instrucciones;
    }

    public JRadioButtonMenuItem getDificultadIntermedio() {
        return dificultadIntermedio;
    }

    public void setDificultadIntermedio(JRadioButtonMenuItem dificultadIntermedio) {
        this.dificultadIntermedio = dificultadIntermedio;
    }

    public JRadioButtonMenuItem getDificultadDificil() {
        return dificultadDificil;
    }

    public void setDificultadDificil(JRadioButtonMenuItem dificultadDificil) {
        this.dificultadDificil = dificultadDificil;
    }

    public JRadioButtonMenuItem getDificultadExperto() {
        return dificultadExperto;
    }

    public void setDificultadExperto(JRadioButtonMenuItem dificultadExperto) {
        this.dificultadExperto = dificultadExperto;
    }
}
