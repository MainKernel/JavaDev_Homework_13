package entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ticket_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "create_at")
    private OffsetDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "from_planet")
    private PlanetEntity fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet")
    private PlanetEntity toPlanet;

    public TicketEntity(OffsetDateTime createAt, ClientEntity client,
                        PlanetEntity fromPlanet, PlanetEntity toPlanet) {

        this.createAt = createAt;
        this.client = client;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
    }

    public TicketEntity() {

    }

    public Long getId() {
        return id;
    }

    public OffsetDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(OffsetDateTime createAt) {
        this.createAt = createAt;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public PlanetEntity getFromPlanet() {
        return fromPlanet;
    }

    public void setFromPlanet(PlanetEntity fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public PlanetEntity getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(PlanetEntity toPlanet) {
        this.toPlanet = toPlanet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createAt, that.createAt) && Objects.equals(client, that.client) && Objects.equals(fromPlanet, that.fromPlanet) && Objects.equals(toPlanet, that.toPlanet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createAt, client, fromPlanet, toPlanet);
    }
}
