import lp2g05.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class Biblioteca 
{  
    private Hashtable<Integer,Usuario> cadUser = new Hashtable<Integer,Usuario>();
    private Hashtable<String, Livro> cadLivro = new Hashtable<String, Livro>();
    ArrayList<Livro> livrosCadastrados = new ArrayList<Livro>();
    ArrayList<Usuario> usuariosCadastrados = new ArrayList<Usuario>();

    public Biblioteca() //Estruturando do zero
    {

    }

    public Biblioteca(Hashtable<Integer,Usuario> cadastroDeUsuarios,Hashtable<String,Livro> cadastroDeLivros,ArrayList<Usuario> CadastrodeUsuariosarray,ArrayList<Livro> CadastrodeLivrosarray)
    {
        this.cadUser = cadastroDeUsuarios;
        this.cadLivro = cadastroDeLivros;
        this.livrosCadastrados = CadastrodeLivrosarray;
        this.usuariosCadastrados = CadastrodeUsuariosarray;
    }


    public void cadastraUser(Usuario newUser)
    {
        this.usuariosCadastrados.add(newUser);
        this.cadUser.put(newUser.getCodUSer(), newUser);  
    }


    public void cadastraLivro(Livro l)
    {
        this.livrosCadastrados.add(l);
        this.cadLivro.put(l.getCodLivro(), l);
    }

    public Usuario getUserByCode(int userCode) throws UsuarioNaoCadastradoEx
    {
        Usuario tempUser = null;

        try
        {
            tempUser = this.cadUser.get(userCode);
        }
        catch (Exception e)
        {
            throw new UsuarioNaoCadastradoEx();
        }

        return tempUser;

    }

    public Livro getBookByCode(String bookCode) throws LivroNaoCadastradoEx
    {
        Livro tempLivro = null;
        try
        {
            tempLivro = this.cadLivro.get(bookCode);
        }
        catch (Exception e)
        {
            throw new LivroNaoCadastradoEx();
        }

        return tempLivro;
    }

    static void salvaArquivo(Hashtable cadastro,String arquivo)
    {  
        try
        {
           ObjectOutputStream escreveArquivo = new ObjectOutputStream(new FileOutputStream(arquivo));
           
           escreveArquivo.writeObject(cadastro);
           
           escreveArquivo.flush();

           escreveArquivo.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    static void salvaArquivo(ArrayList cadastro,String arquivo)
    {  
        try
        {
           ObjectOutputStream escreveArquivo = new ObjectOutputStream(new FileOutputStream(arquivo));
           
           escreveArquivo.writeObject(cadastro);
           
           escreveArquivo.flush();

           escreveArquivo.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    static void lerArquivo(String arquivo, Hashtable alvo)
    {
        try
        {
           ObjectInputStream lerArq = new ObjectInputStream(new FileInputStream(arquivo));

           Hashtable cadastroLido = (Hashtable) lerArq.readObject();

           alvo = cadastroLido;

           lerArq.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    static void lerArquivo(String arquivo, ArrayList alvo)
    {
        try
        {
           ObjectInputStream lerArq = new ObjectInputStream(new FileInputStream(arquivo));

           ArrayList cadastroLido = (ArrayList) lerArq.readObject();

           alvo = cadastroLido;

           lerArq.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void emprestaLivro(Usuario u, Livro l) throws CopiaNaoDisponivelEx
    {
        int userExiste = 0;
        int livroExiste = 0;

        if(l.getQtde() == 0)
        {
            throw new CopiaNaoDisponivelEx(l.getTitulo());
        }

        try
        {
            getBookByCode(l.getCodLivro());
            livroExiste  = 1;
            getUserByCode(u.getCodUSer());
            userExiste = 1;
        }
        catch (LivroNaoCadastradoEx lncex)
        {
            //A mensagem está no próprio construtor da Exceção
        }
        catch (UsuarioNaoCadastradoEx uncex)
        {
            //A mensagem está no próprio construtor da Exceção
        }

        if ( (userExiste == 1) && ( livroExiste == 1) )
        {
            try
            {
                l.Empresta();

                Calendar dataEmprestimo = Calendar.getInstance();

                int dia= dataEmprestimo.get(Calendar.DAY_OF_MONTH);
                int mes= 1 + dataEmprestimo.get(Calendar.MONTH);
                int ano=dataEmprestimo.get(Calendar.YEAR);

                GregorianCalendar dataAlocacao = new GregorianCalendar(ano,mes,dia);
                GregorianCalendar dataDevolucao = new GregorianCalendar(ano,mes,dia);
                dataDevolucao.add(2,1); //Considerando o tempo padrão de 1 mês de empréstimo

                u.addLivroHist(dataAlocacao , dataDevolucao , l.getCodLivro());
                l.addUsuarioHist(dataAlocacao , dataDevolucao , u.getCodUSer());

                this.cadUser.remove(u.getCodUSer());
                this.cadUser.put(u.getCodUSer() , u);
                this.cadLivro.remove(l.getCodLivro());
                this.cadLivro.put(l.getCodLivro(), l);

                this.usuariosCadastrados.removeIf(filter->filter.getCodUSer() == u.getCodUSer());
                this.usuariosCadastrados.add(u);
                this.livrosCadastrados.removeIf(filter->filter.getCodLivro().equals(l.getCodLivro()));
                this.livrosCadastrados.add(l);
            }
            catch (CopiaNaoDisponivelEx cndex)
            {

            }
        }
    }

    public void devolveLivro(Usuario u, Livro l) throws NenhumaCopiaEmprestadaEx
    {
        int userExiste = 0;
        int livroExiste = 0;

        if(l.getEmprestados() == 0)
        {
            throw new NenhumaCopiaEmprestadaEx(l.getTitulo());
        }

        try
        {
            getBookByCode(l.getCodLivro());
            livroExiste  = 1;
            getUserByCode(u.getCodUSer());
            userExiste = 1;
        }
        catch (LivroNaoCadastradoEx lncex)
        {
            //A mensagem está no próprio construtor da Exceção
        }
        catch (UsuarioNaoCadastradoEx uncex)
        {
            //A mensagem está no próprio construtor da Exceção
        }

        if( (userExiste == 1) && (livroExiste == 1) )
        {
            Calendar dataDia = Calendar.getInstance();
            int dia= dataDia.get(Calendar.DAY_OF_MONTH);
            int mes=1 + dataDia.get(Calendar.MONTH);
            int ano=dataDia.get(Calendar.YEAR);

            GregorianCalendar dataDevolucao = new GregorianCalendar(ano,mes,dia);

            EmprestPara emprestimo = l.historicoGeral.get(u.getCodUSer());

            if(emprestimo.getDataDevolucao().compareTo(dataDevolucao)>0) //Devolveu amtes da hora
            {
                System.out.println("Livro devolvido com folga, parabéns! \n");
            }

            else if(emprestimo.getDataDevolucao().compareTo(dataDevolucao) ==0 ) //Devolveu na hora certa
            {
                System.out.println("Livro devolvido no prazo limite. "); 
            }

            else //Devolveu com atraso
            {
                System.out.println("Livro devolvido com atraso, uma penalidade será aplicada.");
            }
        }

    }

    public void imprimeLivros()
    {
        ArrayList<Livro> livros = this.livrosCadastrados;

        livros.sort(porTitulo);

        for (int i = 0; i < livros.size(); i++)
        {
            System.out.println(livros.get(i).toString());
        }

    }

    public void imprimeUsuarios()
    {
        ArrayList<Usuario> usuarios = this.usuariosCadastrados;

        usuarios.sort(porNome);

        for (int i = 0; i < usuarios.size(); i++)
        {
            System.out.println(usuarios.get(i).toString());
        }

    }

    public static Comparator<Livro> porTitulo = new Comparator<Livro>() 
    {
        public int compare(Livro l1, Livro l2) 
        {
            int tamanho = 0;

            String titulo1 = (l1.getTitulo());
            String titulo2 = (l2.getTitulo());

            if (titulo1.length() > titulo1.length())
            {
                tamanho = titulo1.length();
            }
            else
            {
                tamanho = titulo2.length();
            }

            char[] title1 = titulo1.toCharArray();
            char[] title2 = titulo2.toCharArray();

            for(int x = 0; x < tamanho ; x++) 
            {
				if (Character.toLowerCase(title1[x]) > Character.toLowerCase(title2[x]))
                {
                    return 1;
                }

                if (Character.toLowerCase(title1[x]) < Character.toLowerCase(title2[x]))
                {
                    return -1;
                }
			}

            return 0;

        }    
    };

    public static Comparator<Usuario> porNome = new Comparator<Usuario>() 
    {
        public int compare(Usuario u1, Usuario u2) 
        {
            int tamanho = 0;

            String nome1 = (u1.getNome() + " " + u1.getSobreNome());
            String nome2 = (u2.getNome() + " " + u2.getSobreNome());

            if (nome1.length() > nome2.length())
            {
                tamanho = nome1.length();
            }
            else
            {
                tamanho = nome2.length();
            }

            char[] nom1 = nome1.toCharArray();
            char[] nom2 = nome2.toCharArray();

            for(int x = 0; x < tamanho ; x++) 
            {
				if (Character.toLowerCase(nom1[x]) > Character.toLowerCase(nom2[x]))
                {
                    return 1;
                }

                if (Character.toLowerCase(nom1[x]) < Character.toLowerCase(nom2[x]))
                {
                    return -1;
                }
			}

            return 0;

        }    
    };


}
