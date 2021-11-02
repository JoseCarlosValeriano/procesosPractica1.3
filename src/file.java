import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class file {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();

        System.out.printf("Introduzca la ruta del archivo: ");
        String route = inputScanner.nextLine();

        File file = new File(route);
        if (!file.exists()) {
            System.out.println("Error, el fichero no existe");
        } else if (!file.isFile()) {
            System.out.println("Error, la ruta no pertenece a un fichero");
        } else {
            try {
                ProcessBuilder[] builders = {
                        new ProcessBuilder("cat", route),
                        new ProcessBuilder("wc"),};
                List<Process> processes = ProcessBuilder.startPipeline(Arrays.asList(builders));
                Process last = processes.get(processes.size() - 1);
                BufferedReader reader = new BufferedReader(new InputStreamReader(last.getInputStream()));

                System.out.println("-----------------------------------------------------");
                System.out.println(reader.readLine());
                System.out.println("-----------------------------------------------------");

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
