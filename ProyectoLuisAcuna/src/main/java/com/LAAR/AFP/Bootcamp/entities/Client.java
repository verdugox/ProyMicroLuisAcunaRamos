package com.LAAR.AFP.Bootcamp.entities;

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
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "firstName", nullable = false, length = 60)
    private String firstName;
    @Column(name = "lastName", nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, length = 8)
    private String DNI;
    @Column(name = "phone", nullable = false, length = 9)
    private String phone;
    @Column(nullable = false , length = 100)
    private String email;
    @Column(nullable = false, length = 50)
    private String AFP;


}
