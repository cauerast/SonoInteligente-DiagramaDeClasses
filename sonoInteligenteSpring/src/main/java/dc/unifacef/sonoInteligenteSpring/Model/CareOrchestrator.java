package dc.unifacef.sonoInteligenteSpring.Model;

public class CareOrchestrator extends Fabricante{
    public CareOrchestrator() {}

    public CareOrchestrator(Long id, boolean statusConexao) {
        super(id);
    }

    @Override
    public void obterDados(){
        if(this.validarConexao()) {
            System.out.println("Extraindo dados do paciente via plataforma Care Orchestrator");
        } else {
            System.out.println("Falha ao extrair dados, verifique a conexão!");
        }
    }
}
