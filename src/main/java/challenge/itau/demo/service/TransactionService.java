package challenge.itau.demo.service;

import challenge.itau.demo.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }
    public void clearTransactions() {
        this.transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.getDateHour().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValue)
                .summaryStatistics();
    }

    public void addTransaction(Transaction transaction) {
    }
}
