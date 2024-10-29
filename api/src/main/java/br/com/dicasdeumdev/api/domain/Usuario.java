package br.com.dicasdeumdev.api.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

  @Id
  @Column(name = "id_usuario")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nome_usuario")
  private String nome;

  @Column(unique = true, name = "email_usuario")
  private String email;

  @Column(name = "password_usuario")
  private String password;

  @Column(unique = true, name = "codigo_registro")
  private String codigoRegistro;
}
