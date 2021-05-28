package pl.lukaszmalina.mas2021.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Repair implements Serializable {

    private String description;

    private LocalDateTime receiveDateTime;

    private LocalDateTime returnDateTime;

    private BigDecimal cost;

    private static BigDecimal totalCost;

    private static int totalRepairs;

}
