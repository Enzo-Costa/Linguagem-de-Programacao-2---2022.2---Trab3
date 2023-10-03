package lp2g05;

public class CopiaNaoDisponivelEx extends Exception
{
    public CopiaNaoDisponivelEx(String nomeDoLivro)
    {
        System.out.println("Não há cópias do livro " + nomeDoLivro + " para empréstimo.");
    }
}
