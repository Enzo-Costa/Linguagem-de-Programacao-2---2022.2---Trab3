package lp2g05;
import java.util.GregorianCalendar;

public class Pessoa 
{
    protected int contpessoas = 0;

    protected String nome;
    protected String sobreNome;
    protected GregorianCalendar dataNasc;
    protected int dia = 0;
    protected int mes = 0;
    protected int ano = 0;

    public Pessoa(String n, String sN, int diaNasc, int mesNasc, int anoNasc)
    {
        nome = n;
        sobreNome = sN;
        dataNasc = setDataNasc(diaNasc, mesNasc, anoNasc);
    }

    private GregorianCalendar setDataNasc(int diaNasc, int mesNasc, int anoNasc) 
    {
        dia = diaNasc;
        mes = mesNasc;
        ano = anoNasc;

        return new GregorianCalendar(diaNasc, mesNasc, anoNasc);
    }

    public String toString()
    {  
        return "Essa pessoa se chama " + this.nome + " " + this.sobreNome + " e nasceu no dia " + dia +"/"+ mes + "/" + ano;
    }
}