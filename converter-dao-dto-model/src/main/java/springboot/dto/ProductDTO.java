package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String date;

    private byte[] image;

    private boolean selected;

}
