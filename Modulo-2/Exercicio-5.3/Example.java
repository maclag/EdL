public class Example {

    public int valor;

    public Example (int n) {
        valor = n;
    }

    public void f (int x) throws Exception {
        if (valor == 100)
            throw new ArithmeticException("Erro - Divisão por 0!");
        if (x < 0)
            throw new NumberFormatException("Erro - Valor de x negativo: "+ x);
        if (x <= valor)
            throw new NumberFormatException("Erro - Valor de x deve ser maior que " + valor);
        if (x > 10000)
            throw new Exception("Erro - Valor de x muito grande: "+ x);
        System.out.println ("x/(valor_do_usuário - 100): " + (double) x/(valor-100));
    }
}