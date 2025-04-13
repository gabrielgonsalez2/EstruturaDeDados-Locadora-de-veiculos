public class Categoria {
    private String nome;
    private int identificador;

    public Categoria(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public void incluirCategoria(Categoria cat){

    }

    public void editarCategoria(Categoria cat){

    }

    public void excluirCategoria(Categoria cat){

    }

    public void listarCategoria(Categoria cat){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome= '" + nome + '\'' +
                ", identificador= '" + identificador+ '\'' +
                '}';
    }

    @Override
    public boolean equals(Object outro) {
        //qualquer coisa é diferente de NULL
        if (outro == null) {
            return false;
        }
        //propriedade REFLEXIVA
        if (this == outro) {
            return true;
        }
        //objetos de classes diferentes nunca são iguais
        if (this.getClass() != outro.getClass()) {
            return false;
        }
        //conversão explícita para acessar os atributos do outro
        Categoria outraCategoria = (Categoria) outro;
        //verifica se todos os atributos são iguais
        return this.nome.equals(outraCategoria.nome)
                && this.identificador == outraCategoria.identificador;
    }
}
