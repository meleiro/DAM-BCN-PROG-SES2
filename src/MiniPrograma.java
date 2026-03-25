import java.util.Scanner;

/**
 * ============================================================
 * MINI PROGRAMA — ENTRADA DE DATOS + SWITCH + MÉTODOS
 * ============================================================
 *
 * OBJETIVO:
 * Este programa sencillo sirve para practicar:
 *
 * 1) Uso de Scanner para leer datos por teclado
 * 2) Variables globales (atributos static)
 * 3) Métodos con retorno (boolean)
 * 4) Métodos sin retorno (void)
 * 5) Uso de switch moderno (con ->)
 * 6) Tratamiento de Strings (trim, toUpperCase)
 * 7) Limpieza de buffer tras nextInt()
 *
 * IDEA GENERAL:
 * - Se pide al usuario su nombre y edad
 * - Se dispone de un método reutilizable para preguntas tipo "sí/no"
 */

public class MiniPrograma {

    /* =========================================================
       ATRIBUTOS DE CLASE
       ---------------------------------------------------------
       Estas variables están fuera de los métodos y son static,
       por lo que:
       - pertenecen a la clase
       - pueden usarse desde cualquier método static
       ========================================================= */

    // Scanner para leer datos desde teclado
    static Scanner sc = new Scanner(System.in);

    // Variables donde guardaremos los datos del usuario
    static int edad;
    static String nombre;

    /* =========================================================
       MÉTODO MAIN
       ---------------------------------------------------------
       Punto de entrada del programa.
       La JVM empieza a ejecutar desde aquí.
       ========================================================= */
    public static void main(String[] args) {

        // Llamamos al método que recoge los datos del usuario
        leerDatos();

        // Ejemplo de uso del método preguntarSiNo (opcional)
        // boolean respuesta = preguntarSiNo("¿Te gusta Java?");
        // System.out.println("Respuesta: " + respuesta);
    }

    /* =========================================================
       preguntarSiNo(String pregunta)
       ---------------------------------------------------------
       OBJETIVO:
       - Mostrar una pregunta al usuario
       - Interpretar la respuesta como SI o NO
       - Devolver true o false

       TIPO DE MÉTODO:
       - Devuelve boolean (true/false)

       PARÁMETRO:
       - pregunta: texto que se mostrará al usuario

       CONCEPTOS:
       - String
       - Scanner
       - switch moderno
       - return
       ========================================================= */
    static boolean preguntarSiNo(String pregunta) {

        String opcion;

        // Mostramos la pregunta al usuario
        // print() no añade salto de línea
        System.out.print(pregunta + " (Sí/No): ");

        /* -------------------------------------------------
           Lectura y transformación del texto
           -------------------------------------------------
           nextLine() -> lee toda la línea
           trim()     -> elimina espacios al inicio y final
           toUpperCase() -> convierte todo a mayúsculas

           Esto nos permite aceptar:
           " sí ", "Si", "SI", "s", etc.
           ------------------------------------------------- */
        opcion = sc.nextLine().trim().toUpperCase();

        /* -------------------------------------------------
           SWITCH MODERNO (Java 14+)
           -------------------------------------------------
           Ventajas:
           - Sintaxis más limpia
           - No necesita break
           - Permite múltiples valores por case
           ------------------------------------------------- */
        switch (opcion) {

            // Si el usuario escribe cualquier variante de "sí"
            case "SÍ", "SI", "S" -> {
                return true; // devolvemos true
            }

            // Si el usuario escribe cualquier variante de "no"
            case "NO", "N" -> {
                return false; // devolvemos false
            }

            // Si la respuesta no coincide con nada anterior
            default -> {
                System.out.println("Respuesta no válida.");
                return false; // valor por defecto
            }
        }
    }

    /* =========================================================
       leerDatos()
       ---------------------------------------------------------
       OBJETIVO:
       - Pedir al usuario su nombre y edad
       - Guardar los valores en variables globales

       TIPO DE MÉTODO:
       - void (no devuelve nada)

       CONCEPTOS:
       - Scanner
       - nextLine()
       - nextInt()
       - buffer de entrada
       ========================================================= */
    static void leerDatos() {

        /* ---------------------------
           1) NOMBRE
           ---------------------------
           nextLine() permite leer texto completo
           incluyendo espacios.
        */
        System.out.print("Introduce su nombre: ");
        nombre = sc.nextLine();

        /* ---------------------------
           2) EDAD
           ---------------------------
           nextInt() lee un número entero.
        */
        System.out.print("Introduce edad: ");
        edad = sc.nextInt();

        /* -------------------------------------------------
           IMPORTANTE: LIMPIAR BUFFER
           -------------------------------------------------
           Problema:
           - nextInt() NO consume el salto de línea (Enter)
           - Si después usamos nextLine(), leería vacío

           Solución:
           - Llamar a nextLine() para limpiar ese salto
        */
        sc.nextLine(); // LIMPIAR BUFFER
    }
}