package corribolo.utilizacion;
import corribolo.framework.Accion;

public class AccionUno implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Acción Uno ejecutada");
    }

    @Override
    public String nombreItemMenu() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String descripcionItemMenu() {
        return "Esto es interesante";
    }
}
