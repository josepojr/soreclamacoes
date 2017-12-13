package com.josepojr.soreclamacoes.repositorio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.josepojr.soreclamacoes.dominio.Empresa;
import com.josepojr.soreclamacoes.dominio.Localidade;
import com.josepojr.soreclamacoes.dominio.Reclamacao;

@Component
public class TesteRepositorio implements ApplicationRunner {
	
	@Autowired
	private ReclamacaoRepositorio reclamacaoRepositorio;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Iniciando carga de dados");
		
		final List<Reclamacao> reclamacoes = new ArrayList<>();
		
		final Localidade loc1 = buildLocalidade("São Paulo", BigDecimal.valueOf(-23.550496), BigDecimal.valueOf(-46.6334481));
		final Localidade loc2 = buildLocalidade("Minas Gerais", BigDecimal.valueOf(-22.8744545), BigDecimal.valueOf(-43.1115577));
		final Localidade loc3 = buildLocalidade("Rio de Janeiro", BigDecimal.valueOf(-22.9070293), BigDecimal.valueOf(-43.1807216));
		
		final Empresa emp1 = buildEmpresa("Global S&A", "Especializada em Refrigeradores");
		final Empresa emp2 = buildEmpresa("Tecno Ltda", "Fabricante de Eletrodomésticos");
		final Empresa emp3 = buildEmpresa("Super Star S&A", "Site de itens diversos");
		
		reclamacoes.add(buildReclamacao(
			"O refrigerador não funciona", 
			"O refrigerador adquirido na Global S&A parou de funcionar no primeiro dia sem causa aparente.", 
			loc1, 
			emp1));
		
		reclamacoes.add(buildReclamacao(
			"O refrigerador esquenta muito", 
			"O refrigerador está esquentando muito.", 
			loc2, 
			emp1));
		
		reclamacoes.add(buildReclamacao(
			"O refrigerador não congela.", 
			"O refrigerador adquirido parou de congelar depois de 7 dias de uso.", 
			loc3, 
			emp1));
		
		reclamacoes.add(buildReclamacao(
			"O forno do fogão não funciona.", 
			"O forno do fogão adquirido não esquenta, precisa colocar fosforo para acender, a vela não funciona.", 
			loc1, 
			emp2));
		
		reclamacoes.add(buildReclamacao(
			"A torradeira não esquenta", 
			"A torradeira não esquenta, mesmo ligando diversas vezes na tomada.", 
			loc2, 
			emp2));
		
		reclamacoes.add(buildReclamacao(
				"A cafeteira não esquenta água do café", 
				"A cafeteira não está esquentando a água para fazer o café.", 
				loc3, 
				emp2));
		
		reclamacoes.add(buildReclamacao(
				"Comprei um produto pela internet por essa empresa e não foi entregue.", 
				"Comprei um produto pela internet, a empresa responsável diz ter entregue a transportadora, mas o produto não veio.", 
				loc1, 
				emp3));
		
		reclamacoes.add(buildReclamacao(
				"Comprei o produto na promoção, paguei e não recebi", 
				"Comprei um produto na promoção, o site diz que esgotou mas na hora do pagamento, estava tudo OK.", 
				loc1, 
				emp3));
		
		reclamacoes.add(buildReclamacao(
				"Comprei o produto na internet e veio com defeito", 
				"Comprei um produto na internet e veio com defeito e estou tentando trocar, mas a empresa não realiza os procedimentos para a troca.", 
				loc1, 
				emp3));
		
		reclamacoes.add(buildReclamacao(
				"Comprei o produto na internet, mas veio outro produto.", 
				"Comprei um produto na internet, mas eles enviaram outro produto, solicitei o estorno e devolução do produto.", 
				loc1, 
				emp3));
		
		reclamacaoRepositorio.deleteAll();
		
		reclamacaoRepositorio.save(reclamacoes);
		
		System.out.println("Finalizada carga de dados.");
	}

	private Reclamacao buildReclamacao(final String titulo, final String descricao, final Localidade localidade, final Empresa empresa) {
		final Reclamacao reclamacao = new Reclamacao();
		reclamacao.setTitulo(titulo);
		reclamacao.setDescricao(descricao);
		reclamacao.setLocalidade(localidade);
		reclamacao.setEmpresa(empresa);
		
		return reclamacao;
	}
	
	private Localidade buildLocalidade(final String nome, final BigDecimal latitude, final BigDecimal longitude) {
		final Localidade localidade = new Localidade();
		localidade.setNome(nome);
		localidade.setLatitude(latitude);
		localidade.setLongitude(longitude);
		
		return localidade;
	}
	
	private Empresa buildEmpresa(final String nome, final String descricao) {
		final Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDescricao(descricao);
		
		return empresa;
	}
	
}
