package models;

import java.util.List;

public interface Expense {
    boolean createSplit();
    List<Balance> getSplit();
}
