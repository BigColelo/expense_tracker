package it.bigcolelo.expense_tracker.service;

import java.util.List;

import it.bigcolelo.expense_tracker.dto.IncomeDTO;
import it.bigcolelo.expense_tracker.entity.Income;

public interface IncomeService {
    
    Income postIncome(IncomeDTO incomeDTO);
    List<IncomeDTO> getAllIncomes();
    IncomeDTO getIncomeById(Long id);
    Income updateIncome(Long id, IncomeDTO incomeDTO);
    void deleteIncome(Long id);
}
