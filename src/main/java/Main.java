import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PlataformaCargas objPla = new PlataformaCargas();
        Scanner scanner = objPla.getScanner();
        int opcion = 0;

        do {
            System.out.println("========== PLATAFORMA DE CARGAS ==========");
            System.out.println("1. Mostrar Asignaturas");
            System.out.println("2. Solicitar Carga");
            System.out.println("3. Gestionar Solicitud");
            System.out.println("4. Salir");
            System.out.println("Selecciona una opcion: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Debes ingresar un numero valido");
                scanner.nextLine();
                continue;
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    objPla.mostrarAsignaturas();
                    break;
                case 2:
                    objPla.solicitarCarga();
                    break;
                case 3:
                    objPla.gestionarSolicitud();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println(" ");
        } while (opcion != 4);

        scanner.close();
    }
}