package lp2g05;

public class UsuarioNaoCadastradoEx extends Exception
{
    public UsuarioNaoCadastradoEx()
    {
        System.out.println("O usuário desejado não está cadastrado.");
    }
}
