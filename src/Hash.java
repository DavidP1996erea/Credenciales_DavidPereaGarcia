import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
     public static byte[] getDigest(byte[] passwordRecogida,String metodoEncrip){

        MessageDigest encriptar = null;
        byte[] mensajeEncriptado = null;
        try {
            encriptar = MessageDigest.getInstance(metodoEncrip);
            encriptar.reset();
            encriptar.update(passwordRecogida); // mensaje es un array de bytes
            mensajeEncriptado = encriptar.digest();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return  mensajeEncriptado;
    }

    public static boolean compararClaves(byte[] array1, byte[] array2){
        boolean iguales= false;
        if (MessageDigest.isEqual(array1, array2)){
            iguales = true;
        }
        return iguales;
    }
}
