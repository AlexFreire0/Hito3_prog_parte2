package h1_T3_Prog;
//importamos la libreria util
import java.util.*;

public class Principal {
	//creamos el hasmap
    static HashMap<Integer, Animal> animales = new HashMap<>();
    //lamamos a menu
    public static void main(String[] args) {
        menu();
    }
    //declaramos el menu con sus opciones
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int eleccion1;
//ostramos menu con bucle para aun si terminamos la accion nos deje elegir seguir haciendo algo
        do {
            System.out.println("\n¿Qué opcion ejecutar?");
            System.out.println("1. Dar de alta animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal");
            System.out.println("4. Realizar adopción");
            System.out.println("5. Dar de baja");
            System.out.println("6 – Mostrar estadísticas de gatos");
            System.out.println("7. Salir\n");
            	//con scanner elegimos la opcion
            eleccion1 = scanner.nextInt();
            scanner.nextLine(); 
            //empezamos el switch
            switch (eleccion1) {
            case 1:
            	//en caso de crear un animal elegimos cual y le mandamos a la funcion que los crea
                System.out.println("Elige qué animal:");
                System.out.println("1. Perro");
                System.out.println("2. Gato\n");
                int eleccion2 = scanner.nextInt();
                scanner.nextLine(); 
                darDeAlta(eleccion2, scanner);
                break;
            case 2: // mostramos lista con la funcion mostrarAnimales
            	System.out.println("Lista de animales: ");
            	System.out.println("----------------------------");
            	mostrarAnimales();
            	break;
            case 3:
            	//en caso de buscar un animal le pedimos el numero de chip
                System.out.print("Introduce el número de chip del animal: ");
                int numeroChip = scanner.nextInt();
                buscarAnimal(numeroChip);
                break;
            case 4: //Pedimos que introduzca el dni y el chip del animal a adoptar para llevar a cabo la adopcion con la funcion adjuntada en la clase de adopcion
                System.out.print("Introduce el DNI de la persona: ");
                String dni = scanner.nextLine();
                System.out.print("Introduce el número de chip del animal a adoptar: ");
                int chipAdoptar = scanner.nextInt();
                scanner.nextLine();
                Adopcion.adoptar(dni, chipAdoptar, animales);
                break;
            case 5: //para eliminar pedimos el chip y lo eliminamos del hasmap y asi el objeto deja de existir.
                System.out.print("Introduce el número de chip del animal a eliminar: ");
                int chipBaja = scanner.nextInt();
                if (animales.containsKey(chipBaja)) {
                    animales.remove(chipBaja);
                    System.out.println("Animal eliminado de forma correcta.");
                } else {
                    System.out.println("No existe un animal con ese número de chip.");
                }
                break;
            case 6:
                estadisticasGatos(); //mostramos los datos de los gatos
                break;
            case 7: // mostramos mensaje de salir del programa y terminamos el bucle
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida.");
        }

    } while (eleccion1 != 7);	//repetimos hasta que sea 7

    scanner.close();
}
    //funcion para dar de alta
    public static void darDeAlta(int tipo, Scanner scanner) {
        System.out.print("Introduce el número de chip: "); //pedimos numero de chip
        int chip = scanner.nextInt();
        scanner.nextLine();

        if (animales.containsKey(chip)) { // si ya existe le mandamos mensaje de que ya existe
            System.out.println("Ya existe un animal con ese número de chip.");
            return;
        }
        //pedimos datos generales de animal
        System.out.print("Introduce el nombre del animal: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce la raza: ");
        String raza = scanner.nextLine();

        System.out.print("¿Está adoptado? \n1 - Si  \n2 - No : ");
        boolean adoptado;
        int elegido = scanner.nextInt();
        if (elegido == 1) {
        	adoptado = true;
        }
        else {
        	adoptado = false;
        }
        scanner.nextLine();

        Animal nuevoAnimal;	//creamos un objeto animal vacio por ahora
        //pedimos las opciones especiales de perro y gato y los introducimos en el objeto
        if (tipo == 1) { // Perro
            System.out.print("Introduce el tamaño entre pequeño, mediano o grande: ");
            String tamano = scanner.nextLine();
            nuevoAnimal = new Perro(chip, nombre, edad, raza, adoptado, tamano);
        } else if (tipo == 2) { // Gato
            System.out.print("¿Tiene test de leucemia? \n1 - Si  \n2 - No\n eLIGE: ");
            boolean testLeucemia;
            int elegido2 = scanner.nextInt();
            if (elegido2 == 1) {
            	testLeucemia = true;
            }
            else {
            	testLeucemia = false;
            }
            scanner.nextLine();
            nuevoAnimal = new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);
        } else {
            System.out.println("Tipo de animal no válido."); //error si es invalido
            return;
        }

        animales.put(chip, nuevoAnimal);
        System.out.println("Animal dado de alta"); // mensaje de hecho 
    }

    public static void buscarAnimal(int chip) {
        Animal animal = animales.get(chip);	//buscamos por chip el animal
        // si no encontramso lo mostramos y si si lo encontramos igual.
        if (animal != null) {
            System.out.println("\nAnimal encontrado:");
            animal.mostrar();
        } else {
            System.out.println("Animal no encontrado.");
        }
    }
    
    public static void mostrarAnimales() {
    	if(animales.isEmpty()) { // nos metemos en el hasmap y mediante isEmpty que verifica si esta vacio o no mostramos un mensaje u otro
    		System.out.println("No hay animales registrados.");
    	} else {
    		for (Map.Entry<Integer, Animal> entry : animales.entrySet()) { //bucle for que recorre el HasMap y nos muestra la informacion de cada animal
    		    Animal value = entry.getValue();     // animal
    		    value.mostrar();	//mostramos con la funcion del 
    		    System.out.println("----------------------------"); //separamos
    		}
    		
    	}
    	
    }
    public static void estadisticasGatos() {
    	//iniciamos en cero:
    	 int totalGatos = 0;
    	    int leucemia = 0;

    		for (Map.Entry<Integer, Animal> entry : animales.entrySet()) {
    			Animal animal = entry.getValue(); 
    			if (animal instanceof Gato) { //vemos si el animal es un gato
    	            totalGatos++; //añadimos totalgatos + 1
    	            Gato gato = (Gato) animal; //definimos gato
    	            if (gato.testLeucemia) { // vemos si tiene el test hecho
    	            	leucemia++;
    	            } 
    	        }
    		}
    			//mostramos datos
    	    System.out.println("Estadísticas de gatos:");
    	    System.out.println("Total de gatos: " + totalGatos);
    	    System.out.println("Gatos con test de leucemia: " + leucemia);
    }
}
