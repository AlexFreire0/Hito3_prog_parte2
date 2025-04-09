package h1_T3_Prog;

public class Perro extends Animal {
	//añadimos el tamaño
	String tamano;
	//hacemos el constructor a partir de la clase padre.
	public Perro(int numeroChip, String nombre, int edad, String raza, boolean adoptado, String tamano) {
		super(numeroChip, nombre, edad, raza, adoptado);
		this.tamano = tamano;
	}
	//sobrescribimos la funcion mostrar para adaptarla a la del perro
	@Override
	public void mostrar() {
	System.out.println("Numero animal: "+numeroChip);	
	System.out.println("Animal: Perro");
	System.out.println("Nombre: "+nombre);	
	System.out.println("Edad: "+edad);	
	System.out.println("Raza: "+raza);	
		if (adoptado) {
			System.out.println("Estado: Adoptado");	}
		else {
			System.out.println("Estado: No adoptado");
		}
	System.out.println("Tamaño: "+tamano);	
	}
	
}