package corribolo.framework;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Menu {
    private List<Accion> acciones;

    public Menu(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public void mostrar() {
        eleeccionMenu(obtenerMenu());
    }

    private String obtenerMenu() {
        StringBuilder menu = new StringBuilder("Menú de Acciones:" + lineSeparator());
        for (int i = 0; i < acciones.size(); i++) {
            menu.append(i + 1)
                    .append(". ")
                    .append(acciones.get(i).nombreItemMenu())
                    .append(" (")
                    .append(acciones.get(i).descripcionItemMenu())
                    .append(")")
                    .append(lineSeparator());
        }
        menu.append((acciones.size() + 1))
                .append(". Salir");
        return menu.toString();
    }

    private void eleeccionMenu(String menu) {
        out.println(menu);
        boolean bucle = true;
        Scanner scan = new Scanner(in);
        while (bucle) {
            try {
                int opcion = scan.nextInt()-1;
                if (opcion >= 0 && opcion < acciones.size()){
                    acciones.get(opcion).ejecutar();
                    out.println(menu);
                } else if (opcion == acciones.size()) {
                    bucle = false;
                    out.println("Saliendo del menú. ¡Hasta luego!");
                } else {
                    out.println("Opción inválida. Intente nuevamente:");
                    out.println(menu);
                }
            } catch (NumberFormatException e) {
                out.println("Entrada no válida. Por favor, ingrese un número:");
            }
        }
    }
}
