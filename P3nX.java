import lp2g05.*;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.ArrayList;

public class P3nX 
{
    public static void main(String[] args) 
    {
        Hashtable<Integer,Usuario> cadUsers = new Hashtable<Integer,Usuario>();
        Hashtable<String, Livro> cadLivros = new Hashtable<String, Livro>();
        ArrayList<Livro> livrosCadastrados = new ArrayList<Livro>();
        ArrayList<Usuario> usuariosCadastrados = new ArrayList<Usuario>();
        Biblioteca biblioteca = null;

        Scanner leitor = new Scanner(System.in);
        int opcaoStart = 10;
        int foi = 0;

        System.out.println("__________________________________________________");
        System.out.println("|                                                |");
        System.out.println("|       Olá bibliotecario, como gostaria         |");
        System.out.println("|       de iniciar a biblioteca?                 |");
        System.out.println("|                                                |");
        System.out.println("|  0 - Começar do zero   1- Carregar biblioteca  |");
        System.out.println("|________________________________________________|\n");

        while (foi != 1)
        {
            try
            {
                opcaoStart = Integer.parseInt(leitor.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Parece que algo deu errado, por favor digite apenas os números 0 ou 1.");
            }

            switch(opcaoStart)
            {
                case 0:
                {
                    biblioteca = new Biblioteca();

                    System.out.println("Biblioteca nova inicializada com sucesso.");

                    foi = 1;

                    break;
                }

                case 1:
                {
                    Biblioteca.lerArquivo("BibliotecaCadUsers" , cadUsers);
                    Biblioteca.lerArquivo("BibliotecaCadLivros" , cadLivros);
                    Biblioteca.lerArquivo("BibliotecaCadUsersArray" , livrosCadastrados);
                    Biblioteca.lerArquivo("BibliotecaCadLivrosArray" , usuariosCadastrados);

                    if ((cadUsers != null) && (cadLivros != null) && (livrosCadastrados != null) && (usuariosCadastrados != null))
                    {
                        biblioteca = new Biblioteca(cadUsers, cadLivros, usuariosCadastrados, livrosCadastrados);

                        System.out.println("Biblioteca inicializada com sucesso.");

                        foi = 1;
                    }

                    break;
                }

                default:
                {    
                    System.out.println("Opção inválida.");

                    break;
                }
            }
        }

        int opcaoBiblioteca = 0;
        int opcManutencao = 0;
        int opcCadastro = 0; 
        int opcSave = 0;
        int opcEmprestimo = 0;
        int opcRelatorio = 0;

        biblioteca.cadastraUser(new Usuario("Enzo ", "Costa", 4, 11, 2002, "Rua A", 1));
        biblioteca.cadastraUser(new Usuario("João ", "Paulo", 7, 3, 2002, "Rua B", 2));
        biblioteca.cadastraUser(new Usuario("Gustavo ", "Gomes", 9, 5, 2002, "Rua C", 3));
        biblioteca.cadastraUser(new Usuario("Danilo ", "Luiz", 12, 8, 2002, "Rua D", 4));
        biblioteca.cadastraUser(new Usuario("Gustavo ", "Henrique", 30, 1, 2002, "Rua E", 5));
        biblioteca.cadastraUser(new Usuario("Ana ", "Beatriz", 15, 4, 2002, "Rua F", 6));
        biblioteca.cadastraUser(new Usuario("Julia ", "Silva", 20, 5, 2002, "Rua G", 7));
        biblioteca.cadastraUser(new Usuario("Beatriz ", "Lopes", 3, 12, 2002, "Rua H", 8));
        biblioteca.cadastraUser(new Usuario("Rebecca ", "Vitória", 7, 4, 2002, "Rua I", 9));
        biblioteca.cadastraUser(new Usuario("Yasmin ", "Iglésias", 14, 2, 2002, "Rua J", 10));

        biblioteca.cadastraLivro(new Livro("1", "Rangers", "aventura", 5));
        biblioteca.cadastraLivro(new Livro("2", "Harry Potter", "ficção", 10));
        biblioteca.cadastraLivro(new Livro("3", "Percy Jackson", "aventura", 8));
        biblioteca.cadastraLivro(new Livro("4", "Crônicas dos Kane", "aventura", 1));
        biblioteca.cadastraLivro(new Livro("5", "Aventuras do Caça-feitiço", "ficção", 0));
        biblioteca.cadastraLivro(new Livro("6", "Umbrella Academy - Suíte do Apocalipse", "quadrinho", 17));
        biblioteca.cadastraLivro(new Livro("7", "Umbrella Academy - Dalas", "quadrinho", 20));
        biblioteca.cadastraLivro(new Livro("8", "Umbrella Academy - Hotel Oblívion", "quadrinho", 6));
        biblioteca.cadastraLivro(new Livro("9", "O Iluminado", "suspense", 3));
        biblioteca.cadastraLivro(new Livro("10", "O Chamado do C'thulu", "terror", 12));


        while (opcaoBiblioteca != 5)
        {
            System.out.flush();

            System.out.println("__________________________________________________");
            System.out.println("|                                                |");
            System.out.println("|    Agora por favor escolha o que quer fazer    |");
            System.out.println("|                                                |");
            System.out.println("|  1 - Modo manutenção    2 - Modo Cadastro      |");
            System.out.println("|  3 - Modo empréstimo    4 - Modo relatório     |");
            System.out.println("|           5 - Fechar a biblioteca              |");
            System.out.println("|________________________________________________|\n");

            try
            {
                opcaoBiblioteca = Integer.parseInt(leitor.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Algo deu errado. ");
                System.out.println(e.getMessage());
            }

            switch(opcaoBiblioteca)
            {
                case 1://Manutenção
                {
                     

                    System.out.println("__________________________________________________");
                    System.out.println("|                                                |");
                    System.out.println("| 1 - Salvar alterações         2 - Reiniciar    |");
                    System.out.println("|________________________________________________|\n");

                    try
                    {
                        opcManutencao = Integer.parseInt(leitor.nextLine());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Algo deu errado. ");
                        System.out.println(e.getMessage());
                    }

                    switch(opcManutencao)
                    {
                        case 1:
                        {
                            Biblioteca.salvaArquivo(cadLivros, "BibliotecaCadLivros");
                            Biblioteca.salvaArquivo(cadUsers, "BibliotecaCadUsers");
                            Biblioteca.salvaArquivo(livrosCadastrados, "BibliotecaCadLivrosArray");
                            Biblioteca.salvaArquivo(usuariosCadastrados, "BibliotecaCadUsersArray");
                        }

                        case 2:
                        {
                            biblioteca = new Biblioteca();

                            System.out.println("Biblioteca reiniciada com sucesso.");

                            break;
                        }

                        default:
                        {
                            System.out.println("Opção inválida.");

                            break;
                        }
                    }

                    break;
                }//Fim Manutenção

                case 2: //Cadastro
                {
                    
                    System.out.println("\n");
                    
                    System.out.println("__________________________________________________");
                    System.out.println("|                                                |");
                    System.out.println("| 1 - Cadastrar Livro      2 - Cadastrar Usuário |");
                    System.out.println("|             3 - Salvar alterações              |");
                    System.out.println("|________________________________________________|\n");

                    try
                    {
                        opcCadastro = Integer.parseInt(leitor.nextLine());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Algo deu errado. ");
                        System.out.println(e.getMessage());
                    }

                    switch(opcCadastro)
                    {
                        case 1:
                        {
                            int sucesso = 0;

                            System.out.println("\nInsira o título do livro: ");
                            String titleNew = leitor.nextLine();
                            System.out.println("\nInsira a categoria do livro: ");
                            String categNew = leitor.nextLine();
                            System.out.println("\nInsira o código do livro: ");
                            String codNew = leitor.nextLine();
                            try
                            {
                                System.out.println("\nInsira a quantidade de livros: ");
                                int newQtde = Integer.parseInt(leitor.nextLine());

                                Livro newLivro = new Livro(codNew, titleNew, categNew, newQtde);
                                biblioteca.cadastraLivro(newLivro);

                                sucesso = 1;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Algo deu errado, favor digitar tudo dentro dos parâmetros corretos.");
                                System.out.println(e.getMessage());

                                sucesso = 0;
                            }

                            if(sucesso == 1)
                            {
                                System.out.println("Livro cadastrado com sucesso.");
                            }
                            else
                            {
                                System.out.println("O livro não pôde ser cadastrado.");
                            }

                        }

                        case 2:
                        {
                            int sucesso = 0;

                            System.out.println("\nInsira nome do usuário: ");
                            String nomeNew = leitor.nextLine();
                            System.out.println("\nInsira o sobrenome do usuário: ");
                            String sobreNomeNew = leitor.nextLine();
                            System.out.println("\nInsira o endereço do usuário: ");
                            String enderecoNew = leitor.nextLine();
                            try
                            {
                                System.out.println("\nInsira o dia de nascimento do usuário: ");
                                int newDia = leitor.nextInt();
                                System.out.println("\nInsira o mês de nascimento do usuário: ");
                                int newMes = leitor.nextInt();
                                System.out.println("\nInsira o Ano de nascimento do usuário: ");
                                int newAno = leitor.nextInt();
                                System.out.println("\nInsira o código do usuário: ");
                                int codNew= leitor.nextInt();

                                biblioteca.cadastraUser(new Usuario(nomeNew, sobreNomeNew, newDia, newMes, newAno, enderecoNew, codNew));

                                sucesso = 1;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Algo deu errado, favor digitar tudo dentro dos parâmetros corretos.");
                                System.out.println(e.getMessage());

                                sucesso = 0;
                            }

                            if(sucesso == 1)
                            {
                                System.out.println("Usuário cadastrado com sucesso.");
                            }
                            else
                            {
                                System.out.println("O usuário não pôde ser cadastrado.");
                            }

                            break;

                        }
                        case 3:
                        {       
                            System.out.println("\n");   
                            System.out.println("__________________________________________________");
                            System.out.println("|                                                |");
                            System.out.println("| 1 - Salvar livros        2 - Salvar Usuários   |");
                            System.out.println("|________________________________________________|\n");

                            try
                            {
                                opcSave = Integer.parseInt(leitor.nextLine());
                            }
                            catch (Exception e)
                            {
                                System.out.println("Algo deu errado. ");
                                System.out.println(e.getMessage());
                            }

                            switch(opcSave)
                            {
                                case 1:
                                {
                                    System.out.println("Digite o nome do arquivo alvo hash: ");
                                    String arqAlvo = leitor.nextLine();

                                    Biblioteca.salvaArquivo(cadLivros, arqAlvo);

                                    System.out.println("Digite o nome do arquivo alvo array: ");
                                    String arqAlvoArray = leitor.nextLine();

                                    Biblioteca.salvaArquivo(livrosCadastrados, arqAlvoArray);

                                    break;

                                }
                                case 2:
                                {
                                    System.out.println("Digite o nome do arquivo alvo hash: ");
                                    String arqAlvo = leitor.nextLine();

                                    Biblioteca.salvaArquivo(cadUsers, arqAlvo);

                                    System.out.println("Digite o nome do arquivo alvo array: ");
                                    String arqAlvoArray = leitor.nextLine();

                                    Biblioteca.salvaArquivo(usuariosCadastrados, arqAlvoArray);

                                    break;

                                }
                                default:
                                {
                                    System.out.println("Opção inválida.");

                                    break;
                                }
                            }

                            break;
                        }
                        default:
                        {
                            System.out.println("Opção inválida.");

                            break;
                        }
                    }

                }//Fim Cadastro

                case 3: //Empréstimo
                {  
                    System.out.println("\n");

                    int codUsuarioEmprestimo = 0;
                    String codLivroEmprestimo = null;
                    
                    System.out.println("__________________________________________________");
                    System.out.println("|                                                |");
                    System.out.println("|            1 - Realizar Empréstimo             |");
                    System.out.println("|            2 - Realizar Devolução              |");
                    System.out.println("|          3 - Exibir livros cadastrados         |");
                    System.out.println("|________________________________________________|\n");

                    try
                    {
                        opcEmprestimo = Integer.parseInt(leitor.nextLine());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Algo deu errado. ");
                        System.out.println(e.getMessage());
                    }

                    switch(opcEmprestimo)
                    {
                        case 1:
                        {
                            try
                            {
                                System.out.println("Insira o código do usuário que vai pegar o livro: ");
                                codUsuarioEmprestimo = Integer.parseInt(leitor.nextLine());
                                System.out.println("Insira o código do livro a ser emprestado: ");
                                codLivroEmprestimo = leitor.nextLine();

                                biblioteca.emprestaLivro(biblioteca.getUserByCode(codUsuarioEmprestimo), biblioteca.getBookByCode(codLivroEmprestimo));
                                System.out.println("Empréstimo realizado com sucesso.\n");
                            }
                            catch(UsuarioNaoCadastradoEx uncex)
                            {
                                //A mensagem será impressa no construtor da exceção
                            }
                            catch(LivroNaoCadastradoEx lncex)
                            {
                                //A mensagem será impressa no construtor da exceção
                            }
                            catch(CopiaNaoDisponivelEx cndex)
                            {
                                //A mensagem será impressa no construtor da exceção
                            }
                            catch(Exception e)
                            {
                                System.out.println("Algo deu errado. ");
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 2: //A mensagem do status da devolução é impressa pelo própiro método devolveLivro
                        {
                            try
                            {
                                System.out.println("Insira o código do usuário que vai pegar o livro: ");
                                codUsuarioEmprestimo = leitor.nextInt();
                                System.out.println("Insira o código do livro a ser emprestado: ");
                                codLivroEmprestimo = leitor.nextLine();

                                biblioteca.devolveLivro(biblioteca.getUserByCode(codUsuarioEmprestimo), biblioteca.getBookByCode(codLivroEmprestimo));

                                break;
                            }
                            catch(UsuarioNaoCadastradoEx uncex)
                            {
                                //A mensagem será impressa no construtor da exceção
                                break;
                            }
                            catch(LivroNaoCadastradoEx lncex)
                            {
                                //A mensagem será impressa no construtor da exceção
                                break;
                            }
                            catch(NenhumaCopiaEmprestadaEx nceex)
                            {
                                //A mensagem será impressa no construtor da exceção
                                break;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Algo deu errado. ");
                                System.out.println(e.getMessage());
                                break;
                            }
                        }
                        case 3:
                        {
                            biblioteca.imprimeLivros();

                            break;
                        }
                        default:
                        {
                            System.out.println("Opção inválida.");

                            break;
                        }
                    }
                }//Fim Empréstimo

                case 4: //Relatório
                {
                    System.out.println("\n");

                    int codUserListagem = 0;
                    String codLivroListagem = null;
                    
                    System.out.println("__________________________________________________");
                    System.out.println("|                                                |");
                    System.out.println("|          1 - Listar o acervo de livros         |");
                    System.out.println("|         2 - Listar usuários cadastrados        |");
                    System.out.println("|        3 - Exibir histórico de um usuário      |");
                    System.out.println("|         4 - Exibir histórico de um livro       |");
                    System.out.println("|________________________________________________|\n");

                    try
                    {
                        opcRelatorio = Integer.parseInt(leitor.nextLine());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Algo deu errado. ");
                        System.out.println(e.getMessage());
                    }

                    switch(opcRelatorio)
                    {
                        case 1:
                        {
                            biblioteca.imprimeLivros();

                            break;
                        }
                        case 2:
                        {
                            biblioteca.imprimeUsuarios();

                            break;
                        }
                        case 3:
                        {
                            try
                            {
                                System.out.println("Digite o código do usuário a ser listado: ");
                                codUserListagem = Integer.parseInt(leitor.nextLine());

                                if(biblioteca.getUserByCode(codUserListagem).historicoUsuario.isEmpty())
                                {
                                    System.out.println("Esse usuário ainda não realizou nenhum empréstimo.");
                                }
                                else
                                {
                                    for(int x = 0; x < biblioteca.getUserByCode(codUserListagem).historicoUsuario.size(); x++)
                                    {
                                        System.out.println(biblioteca.getUserByCode(codUserListagem).historicoUsuario.get(x));
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println("Algo deu errado. ");
                                System.out.println(e.getMessage());
                            }

                            break;
                        }
                        case 4:
                        {
                            try
                            {
                                System.out.println("Digite o código do livro a ser listado: ");
                                codLivroListagem = leitor.nextLine();

                                if(biblioteca.getBookByCode(codLivroListagem).historicoLivro.isEmpty())
                                {
                                    System.out.println("Esse livro ainda não foi emprestado.");
                                }
                                else
                                {
                                    for(int x = 0; x < biblioteca.getBookByCode(codLivroListagem).historicoLivro.size(); x++)
                                    {
                                        System.out.println(biblioteca.getBookByCode(codLivroListagem).historicoLivro.get(x));
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println("Algo deu errado. ");
                                System.out.println(e.getMessage());
                            }

                            break;
                        }
                        default:
                        {
                            System.out.println("Opção inválida.");

                            break;
                        }
                    }

                }//Fim Relatório

                case 5://Fechar
                {

                    break;
                }//Fim Fechar

                default:
                {
                    System.out.println("Opção inválida.");

                    break;
                }
            }
        }
        System.out.println("Biblioteca fechada com sucesso. ");

        leitor.close();
    }
}