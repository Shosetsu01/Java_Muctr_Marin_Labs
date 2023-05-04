package ru.muctr.Lab7;

/**
 * Класс "Бухгалтерия"
 */
public class Accounting {
    private int income = 0;
    private final String PASSWORD = "admin";
    private static Accounting instance;

    private Accounting() {} // приватный конструктор

    /**
     * Метод для получения единственного экземпляра класса
     * @return единственный экземпляр класса Accounting
     */
    public static Accounting getInstance() {
        if (instance == null) {
            instance = new Accounting();
        }
        return instance;
    }

    /**
     * Метод распечатывает доход по паролю
     * @param psw - пароль
     */
    public void getIncome(String psw){
        if (psw.equals(PASSWORD)) {System.out.println("Your income is " + income);}
        else {
            System.out.println("Неверный пароль");
        }
    }

    /**
     * Метод считает общий доход
     * @param newOrder - сумма нового заказа
     */
    public void update(int newOrder){
        income += newOrder;
    }
}


