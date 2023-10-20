package Vista;

public interface IVista {
    public void crearBotones();
    public void revelarBoton(int posX, int posY, int radar);
    public void ponerBandera(int posX, int posY);
    public void quitarBandera(int posX, int posY);
    public void revelarBomba(int posX, int posY);
    public void revelarBombas();
    public void deshabilitarBotones();
    public void agregarBotonBomba(int posX, int posY);
}
