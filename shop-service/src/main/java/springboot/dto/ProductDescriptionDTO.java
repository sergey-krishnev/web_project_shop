package springboot.dto;

import lombok.Data;

@Data
public class ProductDescriptionDTO {

    private Long id;

    private String name;

    private String description;

    private String date;

    private boolean selected;
}
