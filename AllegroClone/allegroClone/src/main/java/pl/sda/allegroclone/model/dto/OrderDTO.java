package pl.sda.allegroclone.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {

    private Integer id;
    private String data;
    private String status;
}
