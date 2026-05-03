public class AirView extends Fabricante{
    public AirView() {}

    public AirView(int ID, boolean statusConexao) {
        super(ID, statusConexao);
    }

    public void obterDados(){
        System.out.println("Extraindo dados do dispositivo CPAP via plataforma AirView");
    }

}
