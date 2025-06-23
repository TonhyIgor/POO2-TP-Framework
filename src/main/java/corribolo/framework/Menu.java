package corribolo.framework;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.*;

public class Menu {
    private static final String CLASS_NAME_PROPERTY = "acciones";
    private static final String CONFIG_FILE_NAME_DEFAULT = "/config.properties";
    private List<Accion> acciones = new ArrayList<>();

    public Menu() {
        this(CONFIG_FILE_NAME_DEFAULT);
    }

    public Menu(String pathConfig) {
        Properties prop = new Properties();
        try (InputStream configFile = getClass().getResourceAsStream(pathConfig)) {
            prop.load(configFile);

            String clasesStr = prop.getProperty(CLASS_NAME_PROPERTY);
            if (clasesStr == null || clasesStr.isEmpty()) {
                throw new RuntimeException("No se definió la clave 'acciones' en el archivo de propiedades");
            }

            String[] nombresClases = clasesStr.split(";");
            for (String nombreClase : nombresClases) {
                Class<?> clazz = Class.forName(nombreClase.trim());
                Accion instancia = (Accion) clazz.getDeclaredConstructor().newInstance();
                acciones.add(instancia);
            }
        } catch (Exception e) {
            throw new RuntimeException("No pude crear las instancias de TextoAImprimir... ", e);
        }
    }

    public void mostrar() {
        eleeccionMenu(obtenerMenu());
    }

    private String obtenerMenu() {
        StringBuilder menu = new StringBuilder("----------Menú de Acciones----------" + lineSeparator());
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
                    out.println("----------Opción inválida. Intente nuevamente----------");
                    out.println(menu);
                }
            } catch (Exception e) {
                out.println("Entrada no válida. Por favor, ingrese un número del menu");
                scan.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
}
