package h1_T3_Prog;
import java.util.*;

public class Adopcion { // datos de la adopcion
	static HashMap<Integer, String> adopciones = new HashMap<>();
	int chip;
	String personaDNI;
    public static void adoptar(String personaDNI, int chipAdoptar, HashMap<Integer, Animal> animales) {
        // Verificamos si el animal existe
        if (!animales.containsKey(chipAdoptar)) {
            System.out.println("El animal con el chip " + chipAdoptar + " no existe.");
        } else {
        	Animal animal = animales.get(chipAdoptar);
        
        	if (animal.adoptado) {
        		 System.out.println("El animal ya está adoptado.");
        	} else {
        		 animal.adoptado = true; //registramos que ahora esta adptado
        		 System.out.println("El animal ha sido adoptado con exito.");
        	}
        }
    }
 }
