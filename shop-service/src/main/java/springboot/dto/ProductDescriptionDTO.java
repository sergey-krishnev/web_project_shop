package springboot.dto;

import lombok.Data;

@Data
public class ProductDescriptionDTO {

    private String serial;

    private String name;

    private String description;

    private String date;

    private boolean check;
}
