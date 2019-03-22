package springboot.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestDTO {

    private Long id;

    private String customerName;

    private String customerAddress;

    private int sum;

    private List<ProductDescriptionDTO> productDescriptions = new ArrayList<>();
}
