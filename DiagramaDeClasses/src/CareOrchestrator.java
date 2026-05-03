public class CareOrchestrator extends Fabricante{
    public CareOrchestrator() {}

    public CareOrchestrator(int ID, boolean statusConexao) {
        super(ID, statusConexao);
    }

    public void obterDados(){
        System.out.println("Extraindo dados do dispositivo CPAP via plataforma Care Orchestrator");
    }
}
