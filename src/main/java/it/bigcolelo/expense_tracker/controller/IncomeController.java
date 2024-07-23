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

import it.bigcolelo.expense_tracker.dto.IncomeDTO;
import it.bigcolelo.expense_tracker.entity.Income;
import it.bigcolelo.expense_tracker.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {
    
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO dto)
    {
        Income createIncome = incomeService.postIncome(dto);
        if(createIncome != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createIncome);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIncomes()
    {
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long id)
    {
        try{
            return ResponseEntity.ok(incomeService.getIncomeById(id));
        }catch(EntityNotFoundException enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO dto)
    {
        try{
            return ResponseEntity.ok(incomeService.updateIncome(id, dto));
        }catch(EntityNotFoundException enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable Long id)
    {
        try{
            incomeService.deleteIncome(id);
            return ResponseEntity.ok(null);
        }catch(EntityNotFoundException enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
