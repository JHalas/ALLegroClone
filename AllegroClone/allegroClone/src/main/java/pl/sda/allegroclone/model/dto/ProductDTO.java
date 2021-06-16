package pl.sda.allegroclone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    private Integer id;
    private String name;
    private Integer price;

}
