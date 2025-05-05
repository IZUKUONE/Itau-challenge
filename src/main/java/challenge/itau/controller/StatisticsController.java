package challenge.itau.controller;

import challenge.itau.dto.CalculateStatistics;
import challenge.itau.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/statistic")
public class StatisticsController {

    private final TransactionService transactionService;
    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<CalculateStatistics> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        CalculateStatistics response = new CalculateStatistics(stats);
        return ResponseEntity.ok(response);
    }
}