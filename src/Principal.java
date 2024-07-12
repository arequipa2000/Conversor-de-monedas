import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        String urlApi = "https://v6.exchangerate-api.com/v6/d0454350dab160f560d1f0b3/pair/";
        String menu2 =  "|---------------------------------| \n" +
                "Elige la cantidad que deseas convertir:  ";
        Scanner opt = new Scanner(System.in);

        Conversor convierte = new Conversor("", 0, "", "");
        boolean continuar = true;
        String menu = "-----------------------" +
                "Conversor de Monedas------------------ \n" +
                "1.- Sol Peru ==> Dolar USD\n" +
                "2.- Dolar USD ==> Sol Peru\n" +
                "3.- Peso Chile ==> Sol Peru\n" +
                "4.- Sol Peru ==> Peso Chile\n" +
                "9.- Salir\n" +
                "--------------------------------------\n"+
                "Elije una Opcion";

        Scanner opcion = new Scanner(System.in);



        while (continuar) {
            System.out.println(menu);
            try {
                int option = opt.nextInt();
                if (option == 9) {
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                    break;
                }
                if ((option >4) || (option < 1)){
                    continuar = true;
                    System.out.println("Numero no valido");
                    continue;
                }
                    Scanner teclado = new Scanner(System.in);
                    System.out.println(menu2);
                    int qt = teclado.nextInt();

                switch (option) {
                    case 1: {
                        // Sol Peru =>> Dolar USD
                        convierte.setcantidad(qt);
                        convierte.setUrlApi(urlApi);
                        convierte.setpais1("PEN");
                        convierte.setpais2("USD");
                        System.out.println(convierte.conversion());
                        break;
                    }
                    case 2: {
                        // Dolar USD =>> Sol Peru
                        convierte.setcantidad(qt);
                        convierte.setUrlApi(urlApi);
                        convierte.setpais1("USD");
                        convierte.setpais2("PEN");
                        System.out.println(convierte.conversion());
                        break;
                    }
                    case 3: {
                        // Peso Chile =>> Sol Peru
                        convierte.setcantidad(qt);
                        convierte.setUrlApi(urlApi);
                        convierte.setpais1("CLP");
                        convierte.setpais2("PEN");
                        System.out.println(convierte.conversion());
                        break;
                    }
                    case 4: {
                        // Sol Peru =>> Dólar Peso Chile
                        convierte.setcantidad(qt);
                        convierte.setUrlApi(urlApi);
                        convierte.setpais1("PEN");
                        convierte.setpais2("CLP");
                        System.out.println(convierte.conversion());
                        break;
                    }
                    default: {
                        System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 4.");
                        break;
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("ingresar un número entero.");
                opcion.next();
            }

        }
    }
}