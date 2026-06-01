package dc.unifacef.sonoInteligenteSpring.Model;

public class WhatsApp {
    private StatusEnvio status;
    private Relatorio relatorio;

    public WhatsApp() {}

    public WhatsApp(StatusEnvio status, Relatorio relatorio) {
        this.status = status;
        this.relatorio = relatorio;
    }

    public void setStatus(StatusEnvio status) {
        this.status = status;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public StatusEnvio getStatus() {
        return this.status;
    }

    public Relatorio getRelatorio() {
        return this.relatorio;
    }

    public void enviarRelatorio(){
        System.out.println("Enviando relatório...");
    }

    public boolean isConectado(){
        return true;
    }

    public void reconectar(){
        if(!this.isConectado()){
            System.out.println("Reconectando com o WhatsApp...");
        } else {
            System.out.println("Conexão já estabelecida");
        }
    }
}
