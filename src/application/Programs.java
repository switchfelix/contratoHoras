package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import endities.DadosFuncionario;
import endities.Departamento;
import endities.HorasTrabalhadas;
import endities.enums.LevelTrabalho;

public class Programs {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Departamento: ");
		String departamento = sc.nextLine();
		System.out.println();
		System.out.println("Entre com os dados: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Level: ");
		String level =  sc.nextLine();
		System.out.print("Base Salarial: ");
		Double base = sc.nextDouble();
		DadosFuncionario dadosFuncionario = new DadosFuncionario (nome, LevelTrabalho.valueOf(level), base, new Departamento(departamento));
		
		System.out.println("-------------------------------------");
		
		System.out.println("Quantos contratos você tem? ");
		int quantContrato = sc.nextInt(); 
		for (int i = 0; i < quantContrato; i++) {
			System.out.println("Contrato #" + (1+i) + " :");
			System.out.print("Data (dd/mm/yyyy): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Doração (horas): ");
			Integer horas = sc.nextInt();
			HorasTrabalhadas horasTrabalhadas = new HorasTrabalhadas(data, valorPorHora, horas);
			dadosFuncionario.addContratos(horasTrabalhadas);
		}
		
		System.out.println();
		System.out.print("Entre com o mes e o ano que quer calcular a renda (mm/yyyy): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + dadosFuncionario.getNome());
		System.out.println("Departamento: " + dadosFuncionario.getDepartamento().getDepartamento());
		System.out.println("denda de " + mesAno +" :" + String.format("%.2f", dadosFuncionario.renda(ano, mes)));
		
		
		sc.close();
	}

}
