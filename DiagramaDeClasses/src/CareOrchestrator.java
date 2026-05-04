public class CareOrchestrator extends Fabricante{
    public CareOrchestrator() {}

    public CareOrchestrator(int ID, boolean statusConexao) {
        super(ID);
    }

    @Override
    public void obterDados(){
        if(this.validarConexao()) {
            System.out.println("Extraindo dados do paciente via plataforma Care Orchestrator");
        } else {
            System.out.println("Falha ao extrair dados, verifique a conexão!");
        }
    }

    @Override
    public String toString() {
        return "Care Orchestrator {" +
                super.toString() +
                "\n}";
    }
}
