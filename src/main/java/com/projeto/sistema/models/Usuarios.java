package com.projeto.sistema.models;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "usuarios")
public class Usuarios  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "senha", nullable = false, length = 250)
    private String senha;

    @Column(name = "observacao", nullable = false, length = 800)
    private String observacao;

}
