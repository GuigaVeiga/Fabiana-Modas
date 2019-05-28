package codigo;

import java.util.Locale;

public abstract class Pagamentos {
	
	protected double valor;
	protected double total;
	protected double totalParcela;
	protected int qtdParcelas;
	protected double troco;
	protected double dinheiroAvista;
	
	public double somar(double x){
		
		this.valor += x;
		return this.valor;
	}	
	
	
	public Double avista(){
		this.valor -= (valor * 0.1);
		return this.total = Double.valueOf(String.format(Locale.US, "%.2f", this.valor));
	}
	
	public void parcelado(int qtdParcelas){
		if(qtdParcelas <= 5){
			this.qtdParcelas = qtdParcelas;
			this.totalParcela = Double.valueOf(String.format(Locale.US, "%.2f", this.valor / qtdParcelas));
			this.total = this.valor;
		} else {
			this.qtdParcelas = qtdParcelas;
			this.total = valor + 2*(valor * 0.04);
			this.totalParcela = Double.valueOf(String.format(Locale.US, "%.2f", this.total / qtdParcelas));
		}
	}
	
	public Double troco(){
		this.troco = Double.valueOf(String.format(Locale.US, "%.2f", dinheiroAvista - valor));
		return this.troco;
	}
	
	public double getValor() {
		return Double.valueOf(String.format(Locale.US, "%.2f", this.valor));
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	public void setDinheiroAvista(double dinheiroAvista){
		this.dinheiroAvista = dinheiroAvista;
	}
	
	public double getDinheiroAvista(){
		return dinheiroAvista;
	}


	public void setTotalParcela(double totalParcela) {
		this.totalParcela = totalParcela;
	}


	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
	public Double getTotal(){
		return this.total = Double.valueOf(String.format(Locale.US, "%.2f", this.total));
	}
	
	public Double getTotalParcela(){
		return this.totalParcela;
	}
	
	public int getQtdParcelas(){
		return this.qtdParcelas;
	}
}
