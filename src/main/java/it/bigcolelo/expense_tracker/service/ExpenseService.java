package it.bigcolelo.expense_tracker.service;

import java.util.List;

import it.bigcolelo.expense_tracker.dto.ExpenseDTO;
import it.bigcolelo.expense_tracker.entity.Expense;

public interface ExpenseService {
    
    Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
}
