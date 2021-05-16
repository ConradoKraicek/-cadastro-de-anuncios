package projetoCapgemini;

import java.util.Date;

public class Anuncio {

	private String nome;
	private String cliente;
	private Date dataDeInicio;
	private Date dataDeTermino;
	private int investimentoPorDia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	public int getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public void setInvestimentoPorDia(int investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}
	
	float getNumVisualizacoesPorInvestimento(float valor) {
		final float visualizacoesPorReal = 30;
		return visualizacoesPorReal * valor;
	}

	float getNumClicks(float numVisualizacoes) {
	    final float clicksPorVisualizacao = (float) 12 / 100;
		return clicksPorVisualizacao * numVisualizacoes;
	}

	float getNumCompatilhamentos(float numClicks) {
		final float compartilhamentoPorClick = (float) 3 / 20;
		return compartilhamentoPorClick * numClicks;
	}

	int getNumVisualizacoesPorCompartilhamento(int numCompartilhamentos) {
		final int visualizacoesPorCompartilhamento = 40;
		return visualizacoesPorCompartilhamento * numCompartilhamentos;
	}

	float getVisualizacoesAnucio(float valor) {
		final int numMaxCompartilhamentoSequencial = 4;
		// Visualização referente ao investimento inicial
		final int numVisualizacoesInvestimentoInicial = (int) this.getNumVisualizacoesPorInvestimento(valor);
		// Clicks gerados pela primeira visualização
		final int numClicksEmVisualizacoes = (int) this.getNumClicks(numVisualizacoesInvestimentoInicial);

		int numVisualizacoesPorCompartilhamento = 0;
		int numCompartilhamentosRealizados = 0;
		int numClicksEmCompartilhamentos = numClicksEmVisualizacoes;
		
		while ((numCompartilhamentosRealizados < numMaxCompartilhamentoSequencial) && (numClicksEmCompartilhamentos > 20 / 3)) {
			numCompartilhamentosRealizados++;

			// Compartilhamentos Gerados pelos Clicks
			final int numCompartilhamentos = (int) this.getNumCompatilhamentos(numClicksEmCompartilhamentos);

			numVisualizacoesPorCompartilhamento += this.getNumVisualizacoesPorCompartilhamento(numCompartilhamentos);

			// Visualizações geradas pelo compartilhamento
			numClicksEmCompartilhamentos = (int) this
					.getNumClicks(this.getNumVisualizacoesPorCompartilhamento(numCompartilhamentos));

			System.out.println("Anúncio: " + nome);
			System.out.println("Total investido: " + getInvestimentoPorDia());
			System.out.println("Máximo de click: " + numClicksEmCompartilhamentos);
			System.out.println("Máximo de compartilhamentos: " + this.getNumVisualizacoesPorCompartilhamento(numCompartilhamentos));

		}
		return (numVisualizacoesInvestimentoInicial + numVisualizacoesPorCompartilhamento);
	}

}
