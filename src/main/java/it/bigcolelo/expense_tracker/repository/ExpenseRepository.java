package it.bigcolelo.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bigcolelo.expense_tracker.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    
}
