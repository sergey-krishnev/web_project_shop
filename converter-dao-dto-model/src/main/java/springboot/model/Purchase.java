package springboot.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String customerName;

    @NotNull
    private String customerAddress;

    @NotNull
    private int sum;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "purchase_details", joinColumns = { @JoinColumn(name = "purchase_id")},
    inverseJoinColumns = { @JoinColumn(name = "product_id")})
    private List<Product> product = new ArrayList<>();
}
