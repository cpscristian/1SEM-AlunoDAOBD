package model;

import DAO.AlunoDAO;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    
    // Atributos
    private String curso;
    private int fase;
    AlunoDAO dao;
    
    public Aluno(){
        this("",0,0,"",0);
    }

    public Aluno(String curso, int fase, int id, String nome, int idade) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
            + "\n Nome: " + this.getNome()
            + "\n Idade: " + this.getIdade()
            + "\n Curso: " + this.getCurso()
            + "\n Fase:" + this.getFase()
            + "\n -----------";
    }
    
    public ArrayList<Aluno> getMinhaLista(){
        return dao.minhaLista;
    }
    
    public boolean insertAlunoBD(Aluno objeto){
        dao.minhaLista.add(objeto);
        return true;
    }
    
    public boolean DeleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        dao.minhaLista.remove(indice);
        return true;
    }
    
    public boolean UpdateAlunoBD(int id, Aluno objeto) {
        int indice = this.procuraIndice(id);
        dao.minhaLista.set(indice, objeto);
        return true;
    }
    
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < dao.minhaLista.size(); i++) {
            if (dao.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
}
