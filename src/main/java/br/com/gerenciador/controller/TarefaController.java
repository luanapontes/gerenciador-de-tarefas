package br.com.gerenciador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.dao.DaoGeneric;
import br.com.gerenciador.model.Tarefa;

@ViewScoped
@ManagedBean(name = "tarefaController")
public class TarefaController {

	private Tarefa tarefa = new Tarefa();

	private DaoGeneric<Tarefa> daoGeneric = new DaoGeneric<Tarefa>();

	private List<Tarefa> tarefas = new ArrayList<Tarefa>();

	@PostConstruct
	public void carregarTarefas() {
		tarefas = daoGeneric.getListEntity(Tarefa.class);
	}

	public String salvar() {
		tarefa = daoGeneric.merge(tarefa);
		carregarTarefas();
		return "";
	}

	public String excluir() {
		daoGeneric.excluirPorId(tarefa);
		carregarTarefas();
		return "";
	}

	public String novo() {
		tarefa = new Tarefa();
		return "";
	}

	public String editar() {
		tarefa = daoGeneric.merge(tarefa);
		carregarTarefas();
		return "";
	}
	
	public void concluida() {
	 tarefa.setStatus("CONCLUÍDA");
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public DaoGeneric<Tarefa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Tarefa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
