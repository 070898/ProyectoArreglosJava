import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Este metodo combina el arreglo izquierda y derecha de una manera ordenada.
 */

/**
 * @author Alison Juliana López C.
 *
 * 15/04/2018
 */
public class MergeSort {
	/**
	 * Pasa la línea ingresada de números separados por comas, a un arreglo de enteros.
	 * @param line = String con números separados por comas.
	 * @return = Arreglo de enteros con números.
	 */
	public static int [] llenar (String line) {
		String [] arreglo = line.split(",");
		int array [] = new int [arreglo.length];
		for (int i= 0; i< arreglo.length; i++) {
			array [i] = Integer.parseInt(arreglo[i]);
		}
		return array;
	}
	/**
	 * Función que imprime arreglos de tipo entero.
	 * @param array = Arreglo de enteros.
	 */
	public static void print (int [] array) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			for (int i= 0; i<array.length; i++) {
				if (i == array.length -1)
					bw.write(array[i] + "\n");
				else
					bw.write(array[i] + " ");
			}
			bw.flush();
		}
		catch (Exception ex) {}
	}
	/**
	 * Algoritmo de ordenamiento Merge Sort recursivo. Divide el arreglo hasta que esté en tamaño 1.
	 * @param a = Arreglo para ordenar.
	 * @return = Arreglo ordenado.
	 */
	public static int [] mergeSort (int [] A) {
		int left = A.length /2; //Tamaño de la primera mitad del arreglo.
		int right = A.length  - left; //Tamaño de la otra mitad del arreglo.
		//Se crean los dos arreglos del tamaño establecido anteriormente.
		int left_sub_array [] = new int [left];
		int right_sub_array [] = new int [right];	
		if (A.length == 1) //Cuando el arreglo esté ordenado.
			return A;
		else {
			//Llenar cada mitad del arreglo.
			for (int i =0; i<left; i++) 
				left_sub_array[i] =  A[i];
			for (int i= left; i< A.length; i++)
				right_sub_array [i - left] = A[i];
			//Ordenar cada una de las partes.
			int [] sortedL = mergeSort (left_sub_array);
			int [] sortedR = mergeSort (right_sub_array);
			// Dividir arreglo.
			return merge (sortedL, sortedR);		
		}
	}
	/**
	 * Ordena las soluciones.
	 * @param a = Mitad del arreglo.
	 * @param b = Mitad faltante del arreglo.
	 * @return = Arreglo ordenado.
	 */
	public static int [] merge (int[] a, int [] b) {
		int l = a.length + b.length;
		//Crear arreglo 'C'
		int [] c = new int [l];
		int indexA = 0, indexB = 0, indexC = 0;
		while (a.length > indexA && b.length > indexB) {
			if (a[indexA] < b[indexB]) {
				//Añadir elemento del arreglo 'a'.
				c [indexC] = a[indexA];
				indexA ++;
				indexC ++;
			}
			else {
				//Añadir elemento del arreglo 'b'.
				c[indexC] = b[indexB];
				indexB ++;
				indexC ++;	
			}
		}
		// Uno del 'a' o 'b' tiene aún algunos elementos.
		while (a.length > indexA) {
			c[indexC] = a[indexA];
			indexA ++;
			indexC ++;
		}
		while (b.length > indexB) {
			c[indexC] = b[indexB];
			indexB ++;
			indexC ++;
		}
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
			bw.write("Ingrese números separados por comas : \n");
			bw.flush();
			String line = br.readLine(); 
			int [] arreglo = llenar(line); //Se llama a la función para crear el arreglo de enteros.
			int [] ordenado = mergeSort (arreglo); //Se guarda el arreglo creado por el algoritmo.
			bw.write("Arreglo ordenado : \n");
			bw.flush();
			print(ordenado);
		}
		catch (Exception ex) {}

	}

}
