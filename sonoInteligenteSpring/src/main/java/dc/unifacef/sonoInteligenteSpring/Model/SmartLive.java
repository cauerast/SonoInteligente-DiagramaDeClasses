package dc.unifacef.sonoInteligenteSpring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "smartlive")
@DiscriminatorValue("smartlive")
public class SmartLive extends Fabricante{

    public SmartLive() {}
}
