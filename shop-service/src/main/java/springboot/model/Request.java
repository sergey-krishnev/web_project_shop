package springboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String customerName;

    @NotNull
    private String customerAddress;

    @NotNull
    private int sum;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "request_details", joinColumns = { @JoinColumn(name = "request_id")},
    inverseJoinColumns = { @JoinColumn(name = "product_serial")})
    private List<ProductDescription> productDescriptions = new ArrayList<>();
}
