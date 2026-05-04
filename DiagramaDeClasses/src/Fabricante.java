public abstract class Fabricante{
    protected int ID;
    protected boolean statusConexao;

    public Fabricante() {}

    public Fabricante(int ID) {
        this.ID = ID;
        this.statusConexao = validarConexao();
    }

    abstract public void obterDados();

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStatusConexao(boolean statusConexao) {
        this.statusConexao = statusConexao;
    }

    public int getID() {
        return this.ID;
    }

    public boolean isStatusConexao() {
        return this.statusConexao;
    }

    @Override
    public String toString() {
        return "\nID: " + this.ID +
                "\nStatus de Conexão: " + this.statusConexao +
                "\n}";
    }

    public boolean validarConexao(){
        return true;
    }
}