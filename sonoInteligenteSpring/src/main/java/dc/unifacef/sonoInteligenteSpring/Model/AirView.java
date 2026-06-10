package dc.unifacef.sonoInteligenteSpring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class AirView extends Fabricante {

}
