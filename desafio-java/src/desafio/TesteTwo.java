package desafio;

import javax.swing.JOptionPane;

/**
 * 
 * @author felipe.silva (felipe.silva@unigranrio.br)
 * @date 01/08/2020
 */

public class TesteTwo {

	private final static String MESG_ERROR_001 = "Valor de entrada não pode ser nulo!";
	private final static String MESG_ERROR_002 = "Valor de entrada não pode ser letra!";
	private final static String MESG_ERROR_003 = "Valor de entrada precisa ser um número inteiro maior que zero!";
	
	public static void main(String[] args) {
				
		getSpiralMatrix();

	}

	public static void getSpiralMatrix() {
		int n = 0;

		while (true) {
			String inputValue = JOptionPane.showInputDialog("Digite um número inteiro ou digite 0 para encerrar:");
			
			if(inputValue == null)
				break;
			
			if (isValid(inputValue)) {
				n = Integer.parseInt(inputValue);
				break;
			}			
		}
		
		if (n > 0) {
			int[][] array = getArray(n);

			for (int column = 0; column < n; column++) {
				for (int line = 0; line < n; line++) {
					System.out.printf("%2d ", array[column][line]);
				}
				System.out.println("");
			}
		}
	}
	/**
	 * 
	 * @param inputValue
	 * @return boolean
	 */
	
	private static boolean isValid (String inputValue) {
		
		if (inputValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, MESG_ERROR_001, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			
			if(inputValue.matches("[a-zA-Z]*")) {
				JOptionPane.showMessageDialog(null, MESG_ERROR_002, "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
				int i;
				
				try {
					i = Integer.parseInt(inputValue);
					if(i < 0) {
						JOptionPane.showMessageDialog(null, MESG_ERROR_003, "Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, MESG_ERROR_003, "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param n
	 * @return int[][]
	 */

	private static int[][] getArray(int n) {

		int i = 0, j = 0, left = 0, right = n - 1, top = 1, down = n - 1, count = 1;
		int[][] array = new int[n][n];

		while (count <= n * n) {
			while (j <= right) {
				array[i][j++] = count++;
			}
			
			right--;
			j--;
			i++;
			
			while (i <= down) {
				array[i++][j] = count++;
			}
			
			down--;
			i--;
			j--;
			
			while (j >= left) {
				array[i][j--] = count++;
			}
			
			left++;
			j++;
			i--;
			
			while (i >= top) {
				array[i--][j] = count++;
			}
			
			top++;
			i++;
			j++;
		}
		
		return array;
	}
}
