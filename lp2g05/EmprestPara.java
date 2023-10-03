package lp2g05;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class EmprestPara implements Serializable
{
    private GregorianCalendar dataEmp;
    private GregorianCalendar dataDev;
    private int codUser;
    
    public EmprestPara(GregorianCalendar dataEmprest,GregorianCalendar dataDev,int codUsr)
    {
        setDataEmp(dataEmprest);
        setDataDev(dataDev);
        setCodUser(codUsr);
    }

    private void setDataEmp(GregorianCalendar datEmp)
    {
        this.dataEmp = datEmp;
    }

    private void setDataDev(GregorianCalendar datDev)
    {
        this.dataDev = datDev;
    }

    private void setCodUser(int cod)
    {
        this.codUser = cod;
    }

    public GregorianCalendar getDataEmprest()
    {
        return this.dataEmp;
    }

    public GregorianCalendar getDataDevolucao()
    {
        return this.dataDev;
    }

    public int getCodUser()
    {
        return this.codUser;
    }

}
