package lp2g05;

public class LivroNaoCadastradoEx extends Exception
{
    public LivroNaoCadastradoEx()
    {
        System.out.println("O livro desejado não está cadastrado.");
    }
}
