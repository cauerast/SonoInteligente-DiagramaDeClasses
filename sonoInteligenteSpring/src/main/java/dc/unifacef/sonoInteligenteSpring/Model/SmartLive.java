package dc.unifacef.sonoInteligenteSpring.Model;

public class SmartLive extends Fabricante{
    public SmartLive() {}

    public SmartLive(Long id, boolean statusConexao) {
        super(id);
    }

    @Override
    public void obterDados(){
        if(this.validarConexao()){
            System.out.println("Extraindo dados do paciente via plataforma Smart Live");
        } else {
            System.out.println("Falha ao extrair dados, verifique a conexão!");
        }
    }

}
