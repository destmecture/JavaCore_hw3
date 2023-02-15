import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();     //Создание и наполнение листов для последующей проверки
        integers.add(-1);
        integers.add(5);
        integers.add(0);
        integers.add(7);

        List<String> strings = new ArrayList<>();
        strings.add("Ivan");
        strings.add("Masha");

        List<Double> doubles = new ArrayList<>();
        doubles.add(100.578);    //ожидаем 101
        doubles.add(100.478);    //ожидаем 100

        //region task 1
        System.out.println("Task 1");
        System.out.println("Anonymous class");

        Predicate<Integer> moreThanZero = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        for (Integer i : integers) {                             //Проверка листа интов с помощью анонимных классов
            System.out.println(moreThanZero.test(i));
        }

        System.out.println("Lambda expression");
        Predicate<Integer> predicate = integer -> integer > 0;
        for (Integer i : integers) {                             //Проверка листа интов с помощью лямбды
            System.out.println(predicate.test(i));
        }
        //endregion
        //region task 2
        System.out.println("Task 2");
        System.out.println("Anonymous class");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет "+s+" !");
            }
        };
        for (String a : strings) {
            consumer.accept(a);
        }

        System.out.println("Lambda expression");
        Consumer<String> consumer2 = s -> System.out.println("Привет " + s + " !");

        for (String a : strings) {
            consumer2.accept(a);
        }
        //endregion
        //region task 3
        System.out.println("Task 3");
        System.out.println("Anonymous class");
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        for (Double a : doubles) {
            System.out.println(function.apply(a));

        }

        System.out.println("Lambda expression");
        Function<Double, Long> function2 = Math::round;
        for (Double a : doubles) {
            System.out.println(function2.apply(a));
        }

        //endregion
        //region task 4
        System.out.println("Task 4");
        System.out.println("Anonymous class");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(supplier.get());

        System.out.println("Lambda expression");
        Supplier<Integer> supplier2 = () -> (int) (Math.random()*100);
        System.out.println(supplier2.get());

        //endregion


    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}
