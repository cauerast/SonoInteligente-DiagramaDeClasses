package dc.unifacef.sonoInteligenteSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "whatsapps")
public class WhatsApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusEnvio status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatorio_id")
    @JsonIgnore
    private Relatorio relatorio;

    public WhatsApp() {}

    public WhatsApp(StatusEnvio status, Relatorio relatorio) {
        this.status = status;
        this.relatorio = relatorio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(StatusEnvio status) {
        this.status = status;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public Long getId() {
        return this.id;
    }

    public StatusEnvio getStatus() {
        return this.status;
    }

    public Relatorio getRelatorio() {
        return this.relatorio;
    }

    public void enviarRelatorio() {
        System.out.println("Enviando relatório...");
    }

    public boolean isConectado() {
        return true;
    }

    public void reconectar() {
        if (!this.isConectado()) {
            System.out.println("Reconectando com o WhatsApp...");
        } else {
            System.out.println("Conexão já estabelecida");
        }
    }
}