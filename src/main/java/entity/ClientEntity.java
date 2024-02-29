package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Table(name = "client")
@Entity
public class ClientEntity {
    @Id
    @SequenceGenerator(name = "client_seq", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "client_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public ClientEntity() {
    }

    public ClientEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity client = (ClientEntity) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
