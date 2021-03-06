package br.com.regranegocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.FuncionarioDAO;
import br.com.model.Funcionario;

@Repository("funcionarioRN")
@Transactional
public class FuncionarioRN {

private FuncionarioDAO funcionarioDAO;

	@Autowired
	public FuncionarioRN(FuncionarioDAO funcionarioDAO){ 
		this.funcionarioDAO = funcionarioDAO;
	}
	
	public void salvar(Funcionario funcionario) {
		Integer id = funcionario.getId();
		
		if (id == null || id == 0) {
			this.funcionarioDAO.inserir(funcionario);
		} else {
			this.funcionarioDAO.alterar(funcionario);
		}
	}
	
	public List<Funcionario> listar(){
		return funcionarioDAO.listar();
	}
	
	public void excluir(Funcionario funcionario){
		funcionarioDAO.remover(funcionario);
	}
	
	public List<Funcionario> consultarGerentes() {
		return funcionarioDAO.consultarGerentes();
	}
	
	public Funcionario consultarPorId(Integer id) {
		return funcionarioDAO.consultarPorID(id);
	}
	
	public List<Funcionario> funcinarioLogin(String Matricula, String Senha){
		return funcionarioDAO.consultarFuncionarioLogin(Matricula, Senha);
	}
	
	public Funcionario consultaPorCPF(String cpf) {
		return funcionarioDAO.consultaPorCPF(cpf);
	}
	
	public Funcionario consultaPorMatricula(String matricula) {
		return funcionarioDAO.consultaPorMatricula(matricula);
	}
}
