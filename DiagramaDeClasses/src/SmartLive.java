public class SmartLive extends Fabricante{
    public SmartLive() {}

    public SmartLive(int ID, boolean statusConexao) {
        super(ID);
    }

    public void obterDados(){
        if(this.validarConexao()){
            System.out.println("Extraindo dados do paciente via plataforma Smart Live");
        } else {
            System.out.println("Falha ao extrair dados, verifique a conexão!");
        }
    }

    @Override
    public String toString() {
        return "SmartLive {" +
                super.toString() +
                "\n}";
    }
}
