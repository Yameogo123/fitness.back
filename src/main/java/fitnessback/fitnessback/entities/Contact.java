package fitnessback.fitnessback.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="contact")
public class Contact {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="tel")
    private String message;

    @Column(name="nom")
    private String nom;

    @Column(name="type")
    private String mail;

    @Column(name="object")
    private String object;
}
