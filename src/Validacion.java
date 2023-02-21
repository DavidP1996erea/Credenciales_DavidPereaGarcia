import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Validacion {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

          String nameUser;
          String password;
          String concatenarDatos;

          byte[] passwordRecogida;
          byte[] passwordEncriptada;

          String resumenHexadecimal;
        System.out.println("Introduce el nombre de usuario:");
          nameUser=sc.nextLine();
        System.out.println("Introduce la contraseña: ");
          password= sc.nextLine();

          concatenarDatos = nameUser + password;
          passwordRecogida = concatenarDatos.getBytes();

          passwordEncriptada = Hash.getDigest(passwordRecogida, "SHA-256");
        resumenHexadecimal = String.format("%064x", new BigInteger(1, passwordEncriptada));
        escribirFichero(resumenHexadecimal);

    }

    public static void escribirFichero(String mensaje){

        System.out.println(mensaje);
        try {
            String filePath = "C:\\Users\\dperea\\Downloads\\David_Perea_Garcia_HibernateCrud\\Credenciales_DavidPereaGarcia\\src\\cifrados.cre";
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mensaje);
            bw.newLine();
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
