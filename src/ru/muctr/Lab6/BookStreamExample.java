package ru.muctr.Lab6;
import java.util.*;
import java.util.stream.Collectors;

public class BookStreamExample {

    public static void main(String[] args) {
        // Создаем список книг
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Complete Reference", "Java", 2019, 4050, "English"));
        books.add(new Book(2, "Design Patterns", "Patterns", 2020, 1450, "English"));
        books.add(new Book(3, "Head First Java", "Java", 2012, 1890, "Russian"));
        books.add(new Book(4, "Effective Java", "Java", 2019, 870, "Russian"));
        books.add(new Book(5, "Data Structures and the Java Collection Framework", "Collections", 2014, 980, "English"));
        books.add(new Book(6, "Head First JavaScript", "JavaScript", 2018, 2100, "Russian"));
        books.add(new Book(7, "Spring in Action", "Spring", 2005, 2650, "Russian"));
        books.add(new Book(8, "Spring 5 Recipes: a problem-solution approach", "Spring", 2017, 4500, "English"));
        books.add(new Book(9, "Head First HTML & CSS", "HTML", 2011, 1780, "Russian"));
        books.add(new Book(10, "Pro Spring 5", "Spring", 2017, 5150, "English"));

        // 1. Сортировка книг по наименованию
        List<Book> sortedBooksByTitle = books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();

        System.out.println("Отсортированные книги по наименованию: " + sortedBooksByTitle);

        // 2. Добавление всех книг в новый HashSet
        Set<Book> bookSet = new HashSet<>(books);

        System.out.println("Все книги в новом HashSet: " + bookSet);

        // 3. Поиск книги с наименьшей ценой
        Optional<Book> cheapestBook = books.stream()
                .min(Comparator.comparing(Book::getPrice));

        System.out.println("Книга с наименьшей ценой: " + cheapestBook.orElse(null));

        // 4. Коллекция книг с ценой менее 3 тыс. руб.
        List<Book> booksWithPriceLessThan3k = books.stream()
                .filter(book -> book.getPrice() < 3000)
                .toList();

        System.out.println("Книги с ценой менее 3 тыс. руб.: " + booksWithPriceLessThan3k);

        // 5. Расчет средней цены книг на английском языке
        double averagePriceOfEnglishBooks = books.stream()
                .filter(book -> book.getLanguage().equals("English"))
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0);

        System.out.println("Средняя цена книг на английском языке: " + averagePriceOfEnglishBooks);

        // 6. Количество книг по теме «Java»
        long countOfJavaBooks = books.stream()
                .filter(book -> book.getSubject().equals("Java"))
                .count();

        System.out.println("Количество книг по теме «Java»: " + countOfJavaBooks);

        // 7. Проверка, все ли книги изданы после 2010 года.
        boolean allBooksPublishedAfter2010 = books.stream()
                .allMatch(book -> book.getYear() > 2010);

        System.out.println("Все ли книги изданы после 2010 года: " + allBooksPublishedAfter2010);

        // 8. Проверька, есть ли книги по теме «HTML».
        boolean booksOnHtmlExist = books.stream()
                .anyMatch(book -> book.getSubject().equalsIgnoreCase("HTML"));

        System.out.println("Есть ли книги по теме «HTML»: " + booksOnHtmlExist);

        // 9. Найти самую дорогую книгу, используя max().
        Optional<Book> mostExpensiveBook = books.stream()
                .max(Comparator.comparing(Book::getPrice));

        mostExpensiveBook.ifPresent(book ->
                System.out.println("Самая дорогую книгу, используя max(): " + book.getTitle() + ", price: " + book.getPrice() + " rubles"));

        // 10. Разделить все книги на 2 коллекции: на русском и на английском языке (используя коллектор partitioningBy()).
        Map<Boolean, List<Book>> booksByLanguage = books.stream()
                .collect(Collectors.partitioningBy(book -> book.getLanguage().equalsIgnoreCase("Russian")));

        List<Book> russianBooks = booksByLanguage.get(true);
        List<Book> englishBooks = booksByLanguage.get(false);

        System.out.println("Книги на русском: " + russianBooks);
        System.out.println("Книги на английском: " + englishBooks);

        // 11. Сгруппировать все книги по темам, найдите среднюю цену книг по каждой теме.
        Map<String, Double> averagePricesByTheme = books.stream()
                .collect(Collectors.groupingBy(Book::getSubject, Collectors.averagingDouble(Book::getPrice)));

        System.out.println("Все книги по темам, найдите среднюю цену книг по каждой теме: " + averagePricesByTheme);

        // 12. Сформировать строку "Книги на английском языке по теме Spring.: ...,....."
        String booksOnSpringInEnglish = books.stream()
                .filter(book -> book.getSubject().equalsIgnoreCase("Spring") && book.getLanguage().equalsIgnoreCase("English"))
                .map(Book::getTitle)
                .collect(Collectors.joining(", ", "Книги на английском языке по теме Spring: ", "."));

        System.out.println(booksOnSpringInEnglish);
    }
}