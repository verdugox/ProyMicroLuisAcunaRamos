package com.LAAR.AFP.Bootcamp.entities;

import io.reactivex.observers.TestObserver;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
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
    @NotBlank
    @Size(min = 0, max = 60)
    @Column(name = "firstName", nullable = false, length = 60)
    private String firstName;
    @NotBlank
    @Size(min = 0, max = 60)
    @Column(name = "lastName", nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, length = 8)
    private Integer DNI;
    @Column(name = "phone", nullable = false, length = 9)
    private Integer phone;
    @NotBlank
    @Size(min = 0, max = 100)
    @Column(nullable = false , length = 100)
    private String email;
    @NotBlank
    @Size(min = 0, max = 50)
    @Column(nullable = false, length = 50)
    private String AFP;
    @DecimalMax("10000000.00") @DecimalMin("0.0")
    @Column(nullable = false, length = 50)
    private Double amountAvailable;

}
