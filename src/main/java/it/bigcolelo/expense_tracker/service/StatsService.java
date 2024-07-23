package it.bigcolelo.expense_tracker.service;

import it.bigcolelo.expense_tracker.dto.GraphDTO;
import it.bigcolelo.expense_tracker.dto.StatsDTO;

public interface StatsService {
    
    GraphDTO getChartData();
    StatsDTO getStats();
}
