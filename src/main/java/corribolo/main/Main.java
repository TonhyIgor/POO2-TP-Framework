package corribolo.main;

import corribolo.framework.Start;
import corribolo.utilizacion.AccionDos;
import corribolo.utilizacion.AccionTres;
import corribolo.utilizacion.AccionUno;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var accionUno = new AccionUno();
        var accionDos = new AccionDos();
        var accionTres = new AccionTres();

        var acciones = List.of(accionUno, accionDos, accionTres);
        var start = new Start(acciones);
        start.iniciar();
    }
}
