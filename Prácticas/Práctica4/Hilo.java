import java.util.*;

public class Hilo implements Runnable
{
	String cadena;
	String ultimaLetra;
	int n;

	public void obtenerCadena ()
	{
		Scanner sc = new Scanner (System.in);						//Inicializamos un objeto de tipo Scanner
		System.out.print ("\n\nIngresa cadena: ");
		cadena = sc.nextLine ();									//Leemos la cadena ingresada por el usuario
		System.out.println ("\n");
		n = cadena.length () - 1;									//Ultima letra
	}

	public void run ()
	{
		while (true)
		{
			ultimaLetra = cadena.substring (n);						//Obtenemos la ultima letra y la guardamos en un String auxiliar
			cadena = cadena.substring (0, n);						//Recortamos la cadena y le quitamos la ultima letra
			cadena = ultimaLetra.concat (cadena);					//Pegamos la ultima letra al inicio del String
			System.out.println ("\t" + cadena);
			try
			{
				Thread.sleep (800);									//Dormimos al hilo durante 800 milisegundos
			}catch (Exception e)
			{
				return;
			}
		}
	}

	public static void main(String[] args)
	{
		new Hilo ();
	}

	public Hilo ()
	{
		obtenerCadena ();
		Thread hilo = new Thread (this);
		hilo.start ();
	}
}
