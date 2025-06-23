package corribolo.framework;

public class Start {
    private Menu menu;

    public Start() {
        this.menu = new Menu("/config.properties");
    }

    public void iniciar() {
        menu.mostrar();
    }
}
