package lp2g05;

public class NenhumaCopiaEmprestadaEx extends Exception
{
    public NenhumaCopiaEmprestadaEx(String nomeDoLivro)
    {
        System.out.println("Não há cópias do livro " + nomeDoLivro + " emprestadas atualmente.");
    }
}
