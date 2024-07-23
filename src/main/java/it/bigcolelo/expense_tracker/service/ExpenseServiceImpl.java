package it.bigcolelo.expense_tracker.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import it.bigcolelo.expense_tracker.dto.ExpenseDTO;
import it.bigcolelo.expense_tracker.entity.Expense;
import it.bigcolelo.expense_tracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    
    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO)
    {
        return saveOrUpdatExpense(new Expense(), expenseDTO);
    }

    private Expense saveOrUpdatExpense(Expense expense, ExpenseDTO expenseDTO)
    {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, ExpenseDTO expenseDTO)
    {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdatExpense(optionalExpense.get(), expenseDTO);
        }else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public List<Expense> getAllExpenses()
    {
        return expenseRepository.findAll()
                                .stream()
                                .sorted(Comparator.comparing(Expense::getDate)
                                .reversed())
                                .collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id)
    {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        }else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public void deleteExpense(Long id)
    {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }
}
