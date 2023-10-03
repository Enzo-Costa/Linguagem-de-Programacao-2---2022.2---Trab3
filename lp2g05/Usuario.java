package lp2g05;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario extends Pessoa
{
    private String endereco;
    private int codUsuario;
    public Hashtable<String,Emprest> historicoUsuario = new Hashtable<String,Emprest>();
    public ArrayList<Emprest> HistoricoGeral = new ArrayList<Emprest>();

    public Usuario(String n, String sN, int diaNasc, int mesNasc, int anoNasc, String end, int cod) 
    {
        super(n, sN, diaNasc, mesNasc, anoNasc);
        setEnd(end);
        setCodUser(cod);    
    }

    public void addLivroHist(GregorianCalendar dataEmprestimo,GregorianCalendar dataDevolucao,String codigoLivro)
    {
        historicoUsuario.put(codigoLivro,new Emprest(dataEmprestimo,dataDevolucao,codigoLivro));
        HistoricoGeral.add(new Emprest(dataEmprestimo,dataDevolucao,codigoLivro));
    }

    public Usuario(String n, String sN, int diaNasc, int mesNasc, int anoNasc) 
    {
        super(n, sN, diaNasc, mesNasc, anoNasc);  
    }

    private void setEnd(String e)
    {
        this.endereco = e;
    }

    private void setCodUser(int c)
    {
        this.codUsuario = c;
    }

    public String getEnd()
    {
        return this.endereco;
    }

    public int getCodUSer()
    {
        return this.codUsuario;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getSobreNome()
    {
        return this.sobreNome;
    }

    public String toString()
    {
        return super.toString() + ", mora no endereço " + this.getEnd() + " e possui o código " + this.getCodUSer() + ".";
    }
    
}
