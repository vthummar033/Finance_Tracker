package com.fullStack.expenseTracker.dataSeeders;

import com.fullStack.expenseTracker.enums.ETransactionType;
import com.fullStack.expenseTracker.models.Category;
import com.fullStack.expenseTracker.models.TransactionType;
import com.fullStack.expenseTracker.repository.CategoryRepository;
import com.fullStack.expenseTracker.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CategoryDataSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @EventListener
    @Transactional
    public void LoadCategories(ContextRefreshedEvent event) {

        TransactionType expenseType = transactionTypeRepository.findByTransactionTypeName(ETransactionType.TYPE_EXPENSE);
        TransactionType incomeType = transactionTypeRepository.findByTransactionTypeName(ETransactionType.TYPE_INCOME);

        if (expenseType != null) {
            seedCategory("Food", expenseType);
            seedCategory("Transport", expenseType);
            seedCategory("Shopping", expenseType);
            seedCategory("Entertainment", expenseType);
        }

        if (incomeType != null) {
            seedCategory("Salary", incomeType);
            seedCategory("Gift", incomeType);
            seedCategory("Other Income", incomeType);
        }
    }

    private void seedCategory(String name, TransactionType type) {
        if (!categoryRepository.existsByCategoryNameAndTransactionType(name, type)) {
            categoryRepository.save(new Category(name, type, true));
        }
    }
}
