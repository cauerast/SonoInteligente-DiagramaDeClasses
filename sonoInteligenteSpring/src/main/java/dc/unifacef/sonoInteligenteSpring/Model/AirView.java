package dc.unifacef.sonoInteligenteSpring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "airview")
@DiscriminatorValue("airview")
public class AirView extends Fabricante{

    public AirView() {}
}
