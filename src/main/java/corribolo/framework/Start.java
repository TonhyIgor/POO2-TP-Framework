package corribolo.framework;

import java.util.List;

public class Start {
    private Menu menu;

    public Start(List<Accion> acciones) {
        this.menu = new Menu(acciones);
    }

    public void iniciar() {
        menu.mostrar();
    }
}
