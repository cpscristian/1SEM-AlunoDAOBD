package Principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Aluno> listasimples = new ArrayList<>();
        Aluno objetoaluno = new Aluno();

        int opcao = -1;
        while (opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("## Cadastro de Aluno ##\n"
                    + "1 - Inserir (Create)\n"
                    + "2 - Consultar (Retrieve)\n"
                    + "3 - Atualizar (Update)\n"
                    + "4 - Apagar pelo id (Delete)\n"
                    + "5 - Classificar (Sort)\n"
                    + "6 - Listar tudo\n"
                    + "9 - Sair"));
            switch (opcao) {
                case 1:
                    Aluno novo = new Aluno();
                    novo.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:")));
                    novo.setNome(JOptionPane.showInputDialog("Digite o nome do aluno:"));
                    novo.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno:")));
                    novo.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno:"));
                    novo.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno:")));
                    //listasimples.add(novo);
                    objetoaluno.insertAlunoBD(novo);
                    JOptionPane.showMessageDialog(null,"Aluno inserido");
                    break;
                    
                case 2:
                    int idConsultar = Integer.parseInt(JOptionPane.showInputDialog("Digite um id de um aluno"));
                    int posicaoConsulta = -1;
                    for(int i = 0; i < objetoaluno.getMinhaLista().size();i++){
                        if (listasimples.get(i).getId() == idConsultar){
                            posicaoConsulta = i;
                        }
                    }
                    if (posicaoConsulta != -1){
                        System.out.println("Aluno encontrado com sucesso!");
                        System.out.println(" id: " + objetoaluno.getMinhaLista().get(posicaoConsulta).getId());
                        System.out.println(" nome: " + objetoaluno.getMinhaLista().get(posicaoConsulta).getNome());
                        System.out.println(" idade: " + objetoaluno.getMinhaLista().get(posicaoConsulta).getIdade());
                        System.out.println(" curso: " + objetoaluno.getMinhaLista().get(posicaoConsulta).getCurso());
                        System.out.println(" fase:" + objetoaluno.getMinhaLista().get(posicaoConsulta).getFase());
                    } else {
                        JOptionPane.showMessageDialog(null,"Id de aluno não encontrado!");
                    }
                    break;
                    
                case 3:
                    int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("Digite um id de um aluno"));
                    int posicaoAtualizar = -1;
                    for(int i = 0; i < listasimples.size();i++){
                        if (listasimples.get(i).getId() == idAlterar){
                            posicaoAtualizar = i;
                        }
                    }
                    if (posicaoAtualizar != -1){
                    Aluno novoAtualizado = new Aluno();
                    novoAtualizado.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:")));
                    novoAtualizado.setNome(JOptionPane.showInputDialog("Digite o nome do aluno:"));
                    novoAtualizado.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno:")));
                    novoAtualizado.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno:"));
                    novoAtualizado.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno:")));
                    
                    objetoaluno.UpdateAlunoBD(posicaoAtualizar, novoAtualizado);
                    
                    JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null,"Id de aluno não encontrado!");
                    }
                    break;
                   
                case 4:
                    int idApagar = Integer.parseInt(JOptionPane.showInputDialog("Digite um id de um aluno"));
                    int posicaoExcluir = -1;
                    for(int i = 0; i < listasimples.size();i++){
                        if (listasimples.get(i).getId() == idApagar){
                            posicaoExcluir = i;
                        }
                    }
                    if (posicaoExcluir != -1){
                        listasimples.remove(posicaoExcluir);
                        JOptionPane.showMessageDialog(null,"Aluno excluido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null,"Id de aluno não encontrado!");
                    }
                    break;
                    
                case 5:
                    break;
                    
                case 6:
                    for(int i = 0;i < listasimples.size();i++){
                        System.out.println("i: " + i);
                        System.out.println(" id: " + listasimples.get(i).getId());
                        System.out.println(" nome: " + listasimples.get(i).getNome());
                        System.out.println(" idade: " + listasimples.get(i).getIdade());
                        System.out.println(" curso: " + listasimples.get(i).getCurso());
                        System.out.println(" fase:" + listasimples.get(i).getFase());
                        
                    }
                    break;
                    
                case 9:
                    System.out.println("Saindo do programa");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }///Fim while
    }///Fim do main
}///Fim do Principal
