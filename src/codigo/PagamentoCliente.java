package codigo;

public class PagamentoCliente extends Pagamentos implements Desconto {
	
	@Override
	public double cartaoFidelidade() {
		super.valor -= (valor * 0.2);
		return super.total = valor;	
	}

	

}
