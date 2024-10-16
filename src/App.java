import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas personas ingresara?: ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        Persona[] personas = new Persona[cantidadPersonas];

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese los datos de la persona " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            personas[i] = new Persona(nombre, edad);
        }

        MetodosBinarios metodos = new MetodosBinarios();

        System.out.print("\nEdades ingresadas (sin ordenar): ");
        metodos.imprimirEdades(personas);

        metodos.ordenarPersonasPorEdadBurbuja(personas);

        System.out.print("\nEdades ordenadas (Metodo Burbble): ");
        metodos.imprimirEdades(personas);

        System.out.print("\nIngrese la edad que desea buscar: ");
        int edadBuscada = scanner.nextInt();

        int indice = metodos.busquedaBinaria(personas, edadBuscada);

        if (indice != -1) {
            System.out.println("\nLa persona encontrada con " + edadBuscada + " años: " + personas[indice]);
        } else {
            System.out.println("\nNo se encontró ninguna persona con " + edadBuscada + " años.");
        }

        scanner.close();
    }
}