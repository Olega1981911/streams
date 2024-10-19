package task5;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Service {

    public static void main(String[] args) {
        List<Booking> books = new ArrayList<>();
        books.add(new Booking(1L,
                LocalDate.of(2015, 5, 10),
                Status.APPROVED,
                new Client(1L, "Alexandr"),
                new Product(1L, "Учебник Java", Category.BOOK, 50.0)));
        books.add(new Booking(2L,
                LocalDate.of(2019, 3, 15),
                Status.APPROVED,
                new Client(2L, "Maxim"),
                new Product(3L, "Справочник", Category.MEDICINE, 90.0)));
        books.add(new Booking(3L,
                LocalDate.of(2017, 5, 21),
                Status.APPROVED,
                new Client(1L, "Dima"),
                new Product(1L, "Рецепты", Category.FOOD, 65.5)));
        books.add(new Booking(4L,
                LocalDate.of(2015, 11, 10),
                Status.APPROVED, new Client(1L, "Anna"),
                new Product(1L, "Журнал", Category.SPORT, 120.0)));
        books.add(new Booking(5L,
                LocalDate.of(2016, 11, 18),
                Status.APPROVED, new Client(1L, "Jannet"),
                new Product(1L, "Каталог", Category.CLOTHES, 35.0)));
        books.add(new Booking(6L,
                LocalDate.of(2018, 12, 14),
                Status.APPROVED, new Client(1L, "Vladimir"),
                new Product(1L, "Энциклопедия", Category.MEDICINE, 178.9)));
        books.add(new Booking(7L,
                LocalDate.of(2015, 2, 15),
                Status.APPROVED, new Client(1L, "Tomas"),
                new Product(1L, "Решебник", Category.BOOK, 71.2)));
        books.add(new Booking(8L,
                LocalDate.of(2015, 3, 20),
                Status.APPROVED, new Client(1L, "Amely"),
                new Product(1L, "Словарь", Category.BOOK, 89.5)));

        books.stream().filter(b -> b.getProduct().getPrice() > 50.0 && b.getProduct().getCategory() == Category.BOOK).forEach(System.out::println);
        LocalDate startDate = LocalDate.of(2015, 5, 10);
        LocalDate endDate = LocalDate.of(2019, 3, 15);
        List<Booking> bookDate = books.stream().filter(b -> !b.getBookingDate().isBefore(startDate) && !b.getBookingDate().isAfter(endDate)).toList();
        bookDate.forEach(p -> System.out.println(p.getProduct()));
        Optional<Booking> product = books.stream().filter(p -> p.getProduct().getCategory().equals(Category.MEDICINE)).min(Comparator.comparing(p -> p.getProduct().getPrice()));
        System.out.println(product.get().getProduct());
        LocalDate date = LocalDate.of(2018, 12, 14);
        books.stream().filter(b -> b.getBookingDate().equals(date)).forEach(System.out::println);
        Map<String, Optional<Booking>> maxPrice = books.stream()
                .collect(Collectors.groupingBy(p -> p.getProduct().getNameProduct(), Collectors.maxBy(Comparator.comparing(p -> p.getProduct().getPrice()))));
        System.out.println(maxPrice);
        var categoriesSports = books.stream().filter(b -> b.getProduct().getCategory().equals(Category.SPORT)).toList();
        System.out.println(categoriesSports);
        List<Booking> treeOrder = books.stream().sorted(Comparator.comparing(Booking::getBookingDate).reversed()).limit(3).toList();
        System.out.println(treeOrder);
        var allPrices = books.stream()
                .sorted(Comparator.comparing(Booking::getBookingDate))
                .filter(b -> !b.getBookingDate().isBefore(startDate) && !b.getBookingDate().isAfter(endDate))
                .flatMap(order -> order.getProduct().getPrice().describeConstable().stream())
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println(allPrices);
        var prod = books.stream().filter(b -> b.getBookingDate().equals(startDate))
                .filter(b -> b.getStatus().equals(Status.APPROVED))
                .flatMap(p -> p.getProduct().getPrice().describeConstable().stream())
                .mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println(prod);

        var book = books.stream().collect(Collectors.toMap(Booking::getBookingID,b -> Stream.of(b.getProduct()).toList().size()));
        System.out.println(book);

        var bookMap = books.stream().collect(Collectors.toMap(Booking::getNameClient,b -> Stream.of(b.getProduct()).toList()));
        System.out.println(bookMap);

        var bookOrder = books.stream().collect(Collectors.toMap(Booking::getProduct,b-> Stream.of(b.getProduct()).mapToDouble(Product::getPrice).sum()));
        System.out.println(bookOrder);
    }
}
