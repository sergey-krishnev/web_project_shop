package springboot.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class RequestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_serial")
    private ProductDescription productDescription;

    @NotNull
    private int count;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
