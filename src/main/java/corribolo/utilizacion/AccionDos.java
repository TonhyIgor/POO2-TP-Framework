package corribolo.utilizacion;

import corribolo.framework.Accion;

public class AccionDos implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Acción Dos ejecutada");
    }

    @Override
    public String nombreItemMenu() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String descripcionItemMenu() {
        return "Se pone mas interesante";
    }
}
