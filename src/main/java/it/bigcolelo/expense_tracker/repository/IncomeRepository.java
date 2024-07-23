package it.bigcolelo.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bigcolelo.expense_tracker.entity.Income;

public interface IncomeRepository  extends JpaRepository<Income, Long>{
    
}
