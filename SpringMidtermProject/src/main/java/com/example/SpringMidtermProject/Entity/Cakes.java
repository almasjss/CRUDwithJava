package com.example.SpringMidtermProject.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    @Entity
    @Table(name = "cake")
    @Getter
    @Setter
    @NoArgsConstructor
    public class Cakes {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String title;
        private String CakeDescription;
        private Double Price;
        private Double Diameter;
        private Boolean isActive;

        public Cakes(String title, String CakeDescription, Double Price, Double Diameter) {
            this.title = title;
            this.CakeDescription = CakeDescription;
            this.Price = Price;
            this.Diameter = Diameter;
            this.isActive = true;
        }


    }


