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
	
	@Autowired
	private LocalidadeRepositorio localidadeRepositorio;
	
	@Autowired
	private EmpresaRepositorio empresaRepositorio;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Iniciando carga de dados");
		
		reclamacaoRepositorio.deleteAll();
		
		final List<Reclamacao> reclamacoes = new ArrayList<>();
		
		final Localidade loc1 = buildSaveLocalidade("São Paulo", BigDecimal.valueOf(-23.550496), BigDecimal.valueOf(-46.6334481));
		System.out.println(loc1);
		
		final Localidade loc2 = buildSaveLocalidade("Minas Gerais", BigDecimal.valueOf(-22.8744545), BigDecimal.valueOf(-43.1115577));
		System.out.println(loc2);
		
		final Localidade loc3 = buildSaveLocalidade("Rio de Janeiro", BigDecimal.valueOf(-22.9070293), BigDecimal.valueOf(-43.1807216));
		System.out.println(loc3);
		
		final Localidade loc4 = buildSaveLocalidade("Brasilia", BigDecimal.valueOf(-15.8042876), BigDecimal.valueOf(-47.8781534));
		System.out.println(loc4);
				
		final Empresa emp1 = buildSaveEmpresa("Global S&A", "Especializada em Refrigeradores");
		System.out.println(emp1);
		
		final Empresa emp2 = buildSaveEmpresa("Tecno Ltda", "Fabricante de Eletrodomésticos");
		System.out.println(emp2);
		
		final Empresa emp3 = buildSaveEmpresa("Super Star S&A", "Site de itens diversos");
		System.out.println(emp3);
		
		
		reclamacoes.add(buildSaveReclamacao(
			"O refrigerador não funciona", 
			"O refrigerador adquirido na Global S&A parou de funcionar no primeiro dia sem causa aparente.", 
			loc1, 
			emp1));
		
		reclamacoes.add(buildSaveReclamacao(
			"O refrigerador esquenta muito", 
			"O refrigerador está esquentando muito.", 
			loc2, 
			emp1));
		
		reclamacoes.add(buildSaveReclamacao(
			"O refrigerador não congela.", 
			"O refrigerador adquirido parou de congelar depois de 7 dias de uso.", 
			loc3, 
			emp1));
		
		reclamacoes.add(buildSaveReclamacao(
			"O forno do fogão não funciona.", 
			"O forno do fogão adquirido não esquenta, precisa colocar fosforo para acender, a vela não funciona.", 
			loc1, 
			emp2));
		
		reclamacoes.add(buildSaveReclamacao(
			"A torradeira não esquenta", 
			"A torradeira não esquenta, mesmo ligando diversas vezes na tomada.", 
			loc2, 
			emp2));
		
		reclamacoes.add(buildSaveReclamacao(
				"A cafeteira não esquenta água do café", 
				"A cafeteira não está esquentando a água para fazer o café.", 
				loc3, 
				emp2));
		
		reclamacoes.add(buildSaveReclamacao(
				"Comprei um produto pela internet por essa empresa e não foi entregue.", 
				"Comprei um produto pela internet, a empresa responsável diz ter entregue a transportadora, mas o produto não veio.", 
				loc1, 
				emp3));
		
		reclamacoes.add(buildSaveReclamacao(
				"Comprei o produto na promoção, paguei e não recebi", 
				"Comprei um produto na promoção, o site diz que esgotou mas na hora do pagamento, estava tudo OK.", 
				loc1, 
				emp3));
		
		reclamacoes.add(buildSaveReclamacao(
				"Comprei o produto na internet e veio com defeito", 
				"Comprei um produto na internet e veio com defeito e estou tentando trocar, mas a empresa não realiza os procedimentos para a troca.", 
				loc1, 
				emp3));
		
		reclamacoes.add(buildSaveReclamacao(
				"Comprei o produto na internet, mas veio outro produto.", 
				"Comprei um produto na internet, mas eles enviaram outro produto, solicitei o estorno e devolução do produto.", 
				loc1, 
				emp3));
		
		for(final Reclamacao reclamacao: reclamacoes) {
			System.out.println(reclamacao);
		}
		
		System.out.println("Finalizada carga de dados.");
	}

	private Reclamacao buildSaveReclamacao(final String titulo, final String descricao, final Localidade localidade, final Empresa empresa) {
		final Reclamacao reclamacao = new Reclamacao();
		reclamacao.setTitulo(titulo);
		reclamacao.setDescricao(descricao);
		reclamacao.setLocalidade(localidade);
		reclamacao.setEmpresa(empresa);
		
		return reclamacaoRepositorio.save(reclamacao);
	}
	
	private Localidade buildSaveLocalidade(final String nome, final BigDecimal latitude, final BigDecimal longitude) {
		final Localidade localidade = new Localidade();
		localidade.setNome(nome);
		localidade.setLatitude(latitude);
		localidade.setLongitude(longitude);
		
		return localidadeRepositorio.save(localidade);
	}
	
	private Empresa buildSaveEmpresa(final String nome, final String descricao) {
		final Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDescricao(descricao);
		
		return empresaRepositorio.save(empresa);
	}
}
