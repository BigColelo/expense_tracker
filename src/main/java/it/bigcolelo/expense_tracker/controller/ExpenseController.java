package it.bigcolelo.expense_tracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bigcolelo.expense_tracker.dto.ExpenseDTO;
import it.bigcolelo.expense_tracker.entity.Expense;
import it.bigcolelo.expense_tracker.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController 
{
    
    private final ExpenseService ExpenseService;

    @PostMapping
    public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO dto)
    {
        Expense createExpense = ExpenseService.postExpense(dto);
        if(createExpense != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createExpense);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpenses()
    {
        return ResponseEntity.ok(ExpenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id)
    {
        try{
            return ResponseEntity.ok(ExpenseService.getExpenseById(id));
        }catch(EntityNotFoundException enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO dto)
    {
        try{
            return ResponseEntity.ok(ExpenseService.updateExpense(id, dto));
        }catch(EntityNotFoundException enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id)
    {
        try{
            ExpenseService.deleteExpense(id);
            return ResponseEntity.ok(null);
        }catch(EntityNotFoundException enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
