package fitnessback.fitnessback.entities;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;

@Data
@Entity
@Table(name="membre")
public class Membre {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="tel")
    private String tel;

    @Column(name="nom")
    private String nom;

    @Column(name="type")
    private String type;

    @Column(name="fin")
    private LocalDate FinInscription;

    @Column(name = "confirmation")
    private boolean confirmation;

    @Column(name="qrcode")
    private String qrcode;
}
