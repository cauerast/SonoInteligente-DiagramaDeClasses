package dc.unifacef.sonoInteligenteSpring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "careorchestrator")
@DiscriminatorValue("careorchestrator")
public class CareOrchestrator extends Fabricante{

    public CareOrchestrator() {}
}
