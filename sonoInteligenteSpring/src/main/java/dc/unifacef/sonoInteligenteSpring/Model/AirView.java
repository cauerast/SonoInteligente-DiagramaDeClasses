package dc.unifacef.sonoInteligenteSpring.Model;

public class AirView extends Fabricante{
    public AirView() {}

    public AirView(Long id, boolean statusConexao) {
        super(id);
    }

    @Override
    public void obterDados(){
        if(this.validarConexao()){
            System.out.println("Extraindo dados do paciente via plataforma AirView");
        } else {
            System.out.println("Falha ao extrair dados, verifique a conexão!");
        }
    }
}
