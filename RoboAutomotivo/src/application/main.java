package application;

import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int totalCarros;
		double tempoTotalTurno = 0;
		int totalSoldasEfetuadas = 0;

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantos Carros o robo irá produzir hoje?");
		totalCarros = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < totalCarros; i++) {
			System.out.println("Digite o modelo do carro " + (i + 1) + ": ");
			String carro = sc.next();
			for (int j = 0; j < 5; j++) {
				System.out.println("quanto tempo levou a " + (j + 1 + "°") + " solda desse carro? (em segundos)");
				double tempoSolda = sc.nextDouble();
				while (tempoSolda <= 0) {
					System.out.println("Valor irregular, digite o valor novamente!");
					tempoSolda = sc.nextDouble();
				}
				if (tempoSolda > 8) {
					System.out.println("⚠️ [ALERTA] Lentidão detectada no braço mecânico durante o ciclo!\n");
				}
				tempoTotalTurno += tempoSolda;
				totalSoldasEfetuadas++; 	

			}
		}
		
		double MediaTempSolda = tempoTotalTurno / totalSoldasEfetuadas;
		
		System.out.println("============== Solda Finalizada =============");
		System.out.println("===== RELATÓRIO ========== ");
		System.out.printf("- Total de carros produzidos: %d",totalCarros);
		System.out.printf("\n- Total de soldas realizadas: %d" ,totalSoldasEfetuadas);
		System.out.printf("\n- Tempo total da solda foi: %.2f segundos",tempoTotalTurno);
		System.out.printf("\n- A média do tempo por solda foi: %.2f segundos", MediaTempSolda);

		sc.close();

	}

}
