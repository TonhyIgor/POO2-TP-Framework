package corribolo.utilizacion;

import corribolo.framework.Accion;

public class AccionTres implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Acción Tres ejecutada");
    }

    @Override
    public String nombreItemMenu() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String descripcionItemMenu() {
        return "Aca ya no tanto";
    }
}
