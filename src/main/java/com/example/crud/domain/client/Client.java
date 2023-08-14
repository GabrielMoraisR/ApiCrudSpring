package com.example.crud.domain.client;

import jakarta.persistence.*;
import lombok.*;

@Table(name="client")
@Entity(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String email;
    private String cpf;

    public Client(RequestClients requestClients){
        this.name = requestClients.name();
        this.email = requestClients.email();
        this.cpf = requestClients.cpf();
    }
}
