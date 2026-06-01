package dc.unifacef.sonoInteligenteSpring.Model;

public abstract class Fabricante{
    protected Long id;
    protected boolean statusConexao;

    public Fabricante() {}

    public Fabricante(Long id) {
        this.id = id;
        this.statusConexao = validarConexao();
    }

    public void obterDados(){
        System.out.println("Extraindo dados...");
    };

    public void setID(Long id) {
        this.id = id;
    }

    public void setStatusConexao(boolean statusConexao) {
        this.statusConexao = statusConexao;
    }

    public Long getId() {
        return this.id;
    }

    public boolean isStatusConexao() {
        return this.statusConexao;
    }

    public boolean validarConexao(){
        return true;
    }
}