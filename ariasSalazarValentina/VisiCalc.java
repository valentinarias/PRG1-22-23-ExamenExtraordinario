import java.util.Scanner;

public class VisiCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] tabla = new String[16][11];
        String[] comandos = { "W", "A", "S", "D" };

        int currentRow = 1;
        int currentCol = 1;

        tabla[0][0] = "+--------------------------------------------+\n";
        tabla[0][1] = "|   | A | B | C | D | E | F | G | H | I | J |\n";
        tabla[0][2] = "|---+---+---+---+---+---+---+---+---+---+---+|\n";

        for (int fila = 1; fila <= 15; fila++) {
            tabla[fila][0] = "| " + fila + "|   ";
            if (fila >= 10) {
                tabla[fila][0] = "|" + fila + "|   ";
            }
        }

        for (int fila = 1; fila <= 15; fila++) {
            for (int columna = 1; columna <= 10; columna++) {
                tabla[fila][columna] = "|";
            }
        }

        // Imprimir la tabla con indicador de posición
        for (int fila = 0; fila <= 15; fila++) {
            for (int columna = 0; columna <= 10; columna++) {
                if (tabla[fila][columna] == null) {
                    tabla[fila][columna] = "     ";
                }
                if (fila == currentRow && columna == currentCol) {
                    System.out.print(" <" + tabla[fila][columna] + ">");
                } else {
                    System.out.print("  " + tabla[fila][columna] + " ");
                }
            }
            System.out.println();
        }

        while (true) {
            System.out.print("Ingrese un comando (W/A/S/D/F): ");
            System.out.println("CMDs:[W]Arriba,[S]Abajo,[A]izquierda,");
            String comando = scanner.next();

            if (comando.equals("W")) {
                if (currentRow > 1) {
                    currentRow--;
                }
            } else if (comando.equals("A")) {
                if (currentCol > 1) {
                    currentCol--;
                }
            } else if (comando.equals("S")) {
                if (currentRow < 15) {
                    currentRow++;
                }
            } else if (comando.equals("D")) {
                if (currentCol < 10) {
                    currentCol++;
                }
            } else {
                if (comando.equals("F")) {
                    System.out.println("El programa ha finalizado.");
                    break;
                } else {
                    System.out.println("Comando inválido. Intente nuevamente.");
                    continue;
                }
            }
            
            // Imprimir la tabla actualizada con indicador de posición
            for (int fila = 0; fila <= 15; fila++) {
                for (int columna = 0; columna <= 10; columna++) {
                    if (tabla[fila][columna] == null) {
                        tabla[fila][columna] = "     ";
                    }
                    if (fila == currentRow && columna == currentCol) {
                        System.out.print(" <" + tabla[fila][columna] + ">");
                    } else {
                        System.out.print("  " + tabla[fila][columna] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
