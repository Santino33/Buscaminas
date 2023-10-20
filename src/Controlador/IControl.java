package Controlador;

public interface IControl{
    public void agregarListenerBarra();
    public void agregarListenerVentanaFin();
    public void agregarListenersBotones();
    public  void asignarCasillasBomba();
    public void revelarCampoAbierto(boolean isCampo);
    public boolean evaluarVictoria();
    public boolean evaluarDerrota();
    public void reiniciarPrograma(int dificultad);
}
