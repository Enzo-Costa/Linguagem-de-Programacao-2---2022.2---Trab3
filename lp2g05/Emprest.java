package lp2g05;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Emprest 
{
    private GregorianCalendar dataEmprest;
    private GregorianCalendar dataDevolucao;
    private String codLivro;

    public Emprest(GregorianCalendar dataEmp,GregorianCalendar dataDevol,String codLivr)
    {
        setDataEmprest(dataEmp);
        setDataDevolucao(dataDevol);
        this.codLivro = codLivr;
    }

    private void setDataEmprest(GregorianCalendar dataEmp)
    {
        this.dataEmprest = dataEmp;
    }

    private void setDataDevolucao(GregorianCalendar dataDev)
    {
        this.dataDevolucao = dataDev;
    }

    public String toString()
    {
        return "\nO livro de código " + this.codLivro +" foi emprestado na data " + dataEmprest.get(Calendar.DAY_OF_MONTH) + "/" + dataEmprest.get(Calendar.MONTH) + "/" + dataEmprest.get(Calendar.YEAR) + " e devolvido na data " + dataDevolucao.get(Calendar.DAY_OF_MONTH) + "/" + dataDevolucao.get(Calendar.MONTH) + "/" + dataDevolucao.get(Calendar.YEAR) + ".";
    }
}
