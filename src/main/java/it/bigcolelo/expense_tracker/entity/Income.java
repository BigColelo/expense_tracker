package it.bigcolelo.expense_tracker.entity;

import java.time.LocalDate;

import it.bigcolelo.expense_tracker.dto.IncomeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Double amount;

    public IncomeDTO getIncomeDTO()
    {
        IncomeDTO incomeDTO = new IncomeDTO();

        incomeDTO.setId(Id);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setCategory(category);
        incomeDTO.setDescription(description);
        incomeDTO.setDate(date);

        return incomeDTO;
    }
}
