package com.example.SpringMidtermProject.Models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CakesRequest {
    private Integer cakesid;
    private String title;
    private String CakeDescription;
    private Double Price;
    private Double Diameter;
    private Boolean isActive;
}

