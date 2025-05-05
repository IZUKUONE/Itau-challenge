package challenge.itau.controller;

import challenge.itau.dto.TransactionDto;
import challenge.itau.model.Transaction;
import challenge.itau.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;
    private Transaction request;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionDto transaction) {
        if(request.getDateHour().isAfter(OffsetDateTime.now()) || request.getValue() <= 0){
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(request.getValue(), request.getDateHour));

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(@RequestBody TransactionDto transaction) {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();

    }
}
