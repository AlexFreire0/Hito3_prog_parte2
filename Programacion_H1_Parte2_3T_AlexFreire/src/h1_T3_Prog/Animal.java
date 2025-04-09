package h1_T3_Prog;

public abstract class Animal {
	//Ponemos los atributos pedidos.s
	int numeroChip;
	String nombre;
	int edad;
	String raza;
	boolean adoptado;
	public Animal(int numeroChip, String nombre, int edad, String raza, boolean adoptado) {
		this.numeroChip = numeroChip;
		this.nombre = nombre;
		this.raza = raza;
		this.adoptado = adoptado;
	}
	public abstract void mostrar();
}