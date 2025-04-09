package h1_T3_Prog;

public class Gato extends Animal {
	//Añadimos la propiedad de el gato
	boolean testLeucemia;
	//adaptamos el constructor
	public Gato(int numeroChip, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia ) {
		super(numeroChip, nombre, edad, raza, adoptado);
		this.testLeucemia = testLeucemia;
	}
	//sobrescribimos la funcion de mostrar la informacion
	@Override
	public void mostrar() {
	System.out.println("Numero animal: "+numeroChip);
	System.out.println("Animal: Gato");
	System.out.println("Nombre: "+nombre);	
	System.out.println("Edad: "+edad);	
	System.out.println("Raza: "+raza);	
		if (adoptado) {
			System.out.println("Estado: Adoptado");	}
		else {
			System.out.println("Estado: No adoptado");
		}
		if (testLeucemia)
			System.out.println("Test de Leucemia: Efectuado");	
		else {
			System.out.println("Test de Leucemia: No efectuado");
		}
	}
	
}