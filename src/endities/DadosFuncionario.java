package endities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import endities.enums.LevelTrabalho;

public class DadosFuncionario {
	private String nome;
	private LevelTrabalho level;
	private Double base;
	
	private Departamento departamento;
	
	private List<HorasTrabalhadas> contrato = new ArrayList<>();

	public DadosFuncionario() {
	}

	public DadosFuncionario(String nome, LevelTrabalho level, Double base, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.base = base;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LevelTrabalho getLevel() {
		return level;
	}

	public void setLevel(LevelTrabalho level) {
		this.level = level;
	}

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Departamento getDepartamento() {
		return departamento;
	}


	public List<HorasTrabalhadas> getContratos() {
		return contrato;
	}

	
	public void addContratos(HorasTrabalhadas contratos) {
		contrato.add(contratos);
	}
	
	public void removeContratos(HorasTrabalhadas contratos) {
		contrato.remove(contratos);
	}
	
	public double renda(int ano, int mes) {
		double sum = base;
		Calendar cal = Calendar.getInstance();
		for (HorasTrabalhadas c: contrato) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes ==c_mes) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}
	

}
