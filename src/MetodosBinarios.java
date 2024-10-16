class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.edad, otraPersona.getEdad());
    }
}

public class MetodosBinarios {

    public int busquedaBinaria(Persona[] personas, int edad) {
        int izquierda = 0;
        int derecha = personas.length - 1;
        int resultado = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (personas[medio].getEdad() == edad) {
                resultado = medio;
                derecha = medio - 1;
            } else if (personas[medio].getEdad() < edad) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return resultado;
    }

    public void ordenarPersonasPorEdadBurbuja(Persona[] personas) {
        int n = personas.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (personas[j].getEdad() > personas[j + 1].getEdad()) {
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                    intercambio = true;
                }
            }

            if (!intercambio)
                break;
        }
    }

    public void imprimirEdades(Persona[] personas) {
        for (int i = 0; i < personas.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(personas[i].getEdad());
        }
        System.out.println();
    }
}
