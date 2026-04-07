import java.util.Scanner;

public class MiniPrograma {

    static Scanner sc = new Scanner(System.in);

    static int edad;
    static String nombre;

    public static void main(String[] args) {

        leerDatos();

        // Validar nombre
        while (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            System.out.print("Introduce su nombre: ");
            nombre = sc.nextLine();
        }

        // Obtener recomendación
        String sistema = recomendarSistema();

        // Obtener explicación
        String explicacion = obtenerExplicacionSistema(sistema);

        // Mostrar resultado final
        System.out.println("\n--- RESULTADO ---");
        System.out.println("Usuario: " + nombre);
        System.out.println("Sistema recomendado: " + sistema);
        System.out.println("Explicación: " + explicacion);
    }

    // ===============================
    // MÉTODO preguntarSiNo
    // ===============================
    static boolean preguntarSiNo(String pregunta) {

        String opcion;

        System.out.print(pregunta + " (Sí/No): ");
        opcion = sc.nextLine().trim().toUpperCase();

        switch (opcion) {
            case "SÍ", "SI", "S" -> {
                return true;
            }
            case "NO", "N" -> {
                return false;
            }
            default -> {
                System.out.println("Respuesta no válida.");
                return false;
            }
        }
    }

    // ===============================
    // MÉTODO leerDatos
    // ===============================
    static void leerDatos() {

        System.out.print("Introduce su nombre: ");
        nombre = sc.nextLine();

        System.out.print("Introduce edad: ");
        edad = sc.nextInt();

        sc.nextLine(); // limpiar buffer
    }

    // ===============================
    // MÉTODO recomendarSistema (IF)
    // ===============================
    static String recomendarSistema() {

        if (preguntarSiNo("¿Te da miedo la tecnología?")) {

            if (preguntarSiNo("¿Tu padre es rico?")) {
                return "MacOS";
            } else {
                return "ChromeOS";
            }

        } else {

            if (!preguntarSiNo("¿Te importa la privacidad?")) {
                return "Windows";
            } else {

                if (preguntarSiNo("¿Tienes vida?")) {
                    return menuLinuxFacil();
                } else {
                    return menuLinuxAvanzado();
                }
            }
        }
    }

    // ===============================
    // SUBMENÚ LINUX FÁCIL (SWITCH ->)
    // ===============================
    static String menuLinuxFacil() {

        System.out.println("\nElige distribución Linux fácil:");
        System.out.println("1. Ubuntu");
        System.out.println("2. Debian");
        System.out.println("3. Fedora");

        int opcion = sc.nextInt();
        sc.nextLine();

        return switch (opcion) {
            case 1 -> "Ubuntu";
            case 2 -> "Debian";
            case 3 -> "Fedora";
            default -> {
                System.out.println("Opción inválida. Se asigna Ubuntu por defecto.");
                yield "Ubuntu";
            }
        };
    }

    // ===============================
    // SUBMENÚ LINUX AVANZADO (SWITCH ->)
    // ===============================
    static String menuLinuxAvanzado() {

        System.out.println("\nElige distribución Linux avanzada:");
        System.out.println("1. Arch");
        System.out.println("2. Gentoo");
        System.out.println("3. Kali");

        int opcion = sc.nextInt();
        sc.nextLine();

        return switch (opcion) {
            case 1 -> "Arch";
            case 2 -> "Gentoo";
            case 3 -> "Kali";
            default -> {
                System.out.println("Opción inválida. Se asigna Arch por defecto.");
                yield "Arch";
            }
        };
    }

    // ===============================
    // MÉTODO EXPLICACIÓN (SWITCH)
    // ===============================
    static String obtenerExplicacionSistema(String sistema) {

        return switch (sistema) {

            case "MacOS" -> "Sistema elegante y fácil, pero caro.";
            case "ChromeOS" -> "Sistema sencillo basado en la nube.";
            case "Windows" -> "Sistema popular pero menos privado.";
            case "Ubuntu" -> "Linux fácil para principiantes.";
            case "Debian" -> "Linux estable y robusto.";
            case "Fedora" -> "Linux moderno con tecnologías nuevas.";
            case "Arch" -> "Sistema avanzado altamente configurable.";
            case "Gentoo" -> "Sistema complejo optimizado al máximo.";
            case "Kali" -> "Sistema para hacking y ciberseguridad.";
            default -> "Sistema desconocido.";
        };
    }
}