package br.com.organicxpto.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ProdutoConsumer {

	private final ProdutoService produtoService;

	@Autowired
	ProdutoConsumer(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@Bean(name = "remova-estoque")
	Consumer<ProdutoRequested> consumer() {
		return produtoRequested ->
			this.produtoService.removerEstoque(produtoRequested.getIdProduto(), produtoRequested.getQuantidade());
	}

}
