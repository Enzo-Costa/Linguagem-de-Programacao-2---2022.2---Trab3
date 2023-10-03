package lp2g05;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class Livro 
{
    private String codLivro;
    private String titulo;
    private String categoria;
    private int qtde;
    private int emprestados = 0;
    public Hashtable<Integer,EmprestPara> historicoLivro = new Hashtable<Integer,EmprestPara>();
    public ArrayList<EmprestPara> historicoGeral = new ArrayList<EmprestPara>();



    public Livro(String cod, String titulo, String cat, int qtd)
    {  
        setCodLivro(cod);
        setTitulo(titulo);
        setCategoria(cat);
        setQtde(qtd);
    }

    private void setCodLivro(String cdl)
    {
        this.codLivro = cdl;
    }

    private void setTitulo(String title)
    {
        this.titulo = title;
    }

    private void setCategoria(String categ)
    {
        this.categoria = categ;
    }

    private void setQtde(int q)
    {
        this.qtde = q;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public String getCodLivro()
    {
        return this.codLivro;
    }

    public int getQtde()
    {
        return this.qtde;
    }

    public int getEmprestados()
    {
        return this.emprestados;
    }

    public String getCategoria()
    {
        return this.categoria;
    }

    public void Empresta() throws CopiaNaoDisponivelEx
    {   
        if(this.qtde <= 0)
        {
            throw new CopiaNaoDisponivelEx(this.titulo);
        }
        else
        {
            this.qtde--;
            this.emprestados++;
        }

    }

    public void Devolve() throws NenhumaCopiaEmprestadaEx
    {
        if(this.emprestados <= 0)
        {
            throw new NenhumaCopiaEmprestadaEx(this.titulo);
        }
        else
        {
            this.qtde++;
            this.emprestados--;
        }
    }

    public void addUsuarioHist(GregorianCalendar dataAloc,GregorianCalendar dataDev,int userCode)
    {
        historicoLivro.put( userCode , new EmprestPara(dataAloc,dataDev,userCode));

        historicoGeral.add( new EmprestPara(dataAloc,dataDev,userCode));
    }

    public String toString()
    {
        return "\n O livro de título " + this.getTitulo() + ", da categoria " + this.getCategoria() + ", que possui o código " + this.getCodLivro() +", atualmente com uma quantidade de " + this.getQtde() + " na biblioteca e " + this.getEmprestados() + " cópias emprestadas, que possui o histórico de empréstimos: " + this.historicoLivro;
    }

}
