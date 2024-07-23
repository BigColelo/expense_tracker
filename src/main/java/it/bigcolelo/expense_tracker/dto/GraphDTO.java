package it.bigcolelo.expense_tracker.dto;

import java.util.List;

import it.bigcolelo.expense_tracker.entity.Expense;
import it.bigcolelo.expense_tracker.entity.Income;
import lombok.Data;

@Data
public class GraphDTO {
    
    private List<Expense> expenseList;
    private List<Income> incomeList;
}
