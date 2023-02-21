import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Login {
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
        leerFichero(resumenHexadecimal);
    }

    public static String leerFichero(String mensajeEncriptado) {
        BufferedReader br = null;

        String mensaje = "";
        byte[] arrayMensaje1 = mensajeEncriptado.getBytes();
        byte[] arrayMensaje2 = null;
        boolean existe = false;

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\dperea\\Downloads\\David_Perea_Garcia_HibernateCrud\\Credenciales_DavidPereaGarcia\\src\\cifrados.cre"));
            Scanner sc = new Scanner(br);

            while (sc.hasNext()) {
                mensaje = sc.nextLine();
                arrayMensaje2 = mensaje.getBytes();
                if (Hash.compararClaves(arrayMensaje1, arrayMensaje2)){
                    existe = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (existe){
            System.out.println("Ha podido entrar");
        }else {
            System.out.println("Usuario inexistente");
        }

        return mensaje;
    }
}
