public class SmartLive extends Fabricante{
    public SmartLive() {}

    public SmartLive(int ID, boolean statusConexao) {
        super(ID, statusConexao);
    }

    public void obterDados(){
        System.out.println("Extraindo dados do dispositivo CPAP via plataforma Smart Live");
    }
}
