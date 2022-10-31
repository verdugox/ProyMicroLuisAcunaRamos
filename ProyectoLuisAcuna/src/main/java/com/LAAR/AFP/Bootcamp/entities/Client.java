package com.LAAR.AFP.Bootcamp.entities;

import io.reactivex.observers.TestObserver;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client implements Serializable{

    private static final long serialVersionUID = 4080729130530523253L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Long idClient;
    @Column(name = "firstName", nullable = false, length = 60)
    private String firstName;
    @Column(name = "lastName", nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, length = 8)
    private Integer DNI;
    @Column(name = "phone", nullable = false, length = 9)
    private Integer phone;
    @Column(nullable = false , length = 100)
    private String email;
    @Column(nullable = false, length = 50)
    private String AFP;
    @Column(nullable = false, length = 50)
    private Double amountAvailable;

}
