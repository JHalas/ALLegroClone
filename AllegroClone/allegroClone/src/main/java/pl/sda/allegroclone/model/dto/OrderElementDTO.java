package pl.sda.allegroclone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class OrderElementDTO {

    private Integer id;
    private Integer quantitiy;
    private String productName;
}
