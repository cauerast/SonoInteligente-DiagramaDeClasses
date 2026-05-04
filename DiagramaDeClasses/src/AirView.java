public class AirView extends Fabricante{
    public AirView() {}

    public AirView(int ID, boolean statusConexao) {
        super(ID);
    }

    @Override
    public void obterDados(){
        if(this.validarConexao()){
            System.out.println("Extraindo dados do paciente via plataforma AirView");
        } else {
            System.out.println("Falha ao extrair dados, verifique a conexão!");
        }
    }

    @Override
    public String toString() {
        return "AirView {" +
                super.toString() +
                "\n}";
    }
}
