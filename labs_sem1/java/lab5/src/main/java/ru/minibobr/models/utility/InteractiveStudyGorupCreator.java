package ru.minibobr.models.utility;


import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.FormOfEducation;
import ru.minibobr.models.Semester;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.models.utility.builders.CoordinatesBuilder;
import ru.minibobr.models.utility.builders.LocationBuilder;
import ru.minibobr.models.utility.builders.PersonBuilder;
import ru.minibobr.models.utility.builders.StudyGroupBuilder;
import ru.minibobr.utility.io.Console;
import ru.minibobr.models.Location;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Класс интерактивного ввода модели StudyGroup
 */
public class InteractiveStudyGorupCreator {
    /**
     * Запрашивает у пользователя поля и создает элемент коллекции
     * @param console консоль
     * @param scanner сканнер
     * @return элемент коллекции
     */
    public static StudyGroup create(Console console, Scanner scanner) {
        Function<String, Double> parseDouble = x -> {
            try {
                return Double.parseDouble(x);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Поле должно быть типа Double");
            }
        };

        Function<String, Float> parseFloat = x -> {
            try {
                return Float.parseFloat(x);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Поле должно быть типа Float");
            }
        };

        Function<String, Integer> parseInt = x -> {
            try {
                return Integer.parseInt(x);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Поле должно быть типа Integer");
            }
        };

        Function<String, Long> parseLong = x -> {
            try {
                return Long.parseLong(x);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Поле должно быть типа Long");
            }
        };

        Function<String, FormOfEducation> FormOfEducationValueOf = x -> {
            try {
                return FormOfEducation.valueOf(x);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Поле должно быть типа FormOfEducation");
            }
        };

        Function<String, Semester> SemesterValueOf = x -> {
            try {
                return Semester.valueOf(x);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Поле должно быть типа Semester");
            }
        };

        Function<String, LocalDate> parseLocalDate = x -> LocalDate.parse(x, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        StudyGroupBuilder studyGroupBuilder = new StudyGroupBuilder();
        studyGroupBuilder.buildId();
        input("Введите имя: ", studyGroupBuilder::buildName, String::valueOf, console, scanner);

        CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder();
        input("Введите координату X: ", coordinatesBuilder::buildX, parseInt, console, scanner);
        input("Введите координату Y: ", coordinatesBuilder::buildY, parseLong, console, scanner);
        studyGroupBuilder.buildCoordinates(coordinatesBuilder.build());

        Date date = new Date();
        studyGroupBuilder.buildCreationDate(date);

        input("Введите число учеников: ", studyGroupBuilder::buildStudentsCount, parseInt, console, scanner);

        input("Введите среднюю оценку: ", studyGroupBuilder::buildAverageMark, parseLong, console, scanner);

        input("Введите форму обучения: (Возможные варианты - %s)".formatted(FormOfEducation.getNames()), studyGroupBuilder::buildFormOfEducation, FormOfEducationValueOf, console, scanner);

        input("Введите семестр: (Возможные варианты - %s) ".formatted(Semester.getNames()), studyGroupBuilder::buildSemesterEnum, SemesterValueOf, console, scanner);

        PersonBuilder personBuilder = new PersonBuilder();
        input("Введите имя админа группы: ", personBuilder::buildName, String::valueOf, console, scanner);
        input("Введите дату рождения админа: ", personBuilder::buildBirthday, parseLocalDate, console, scanner);
        input("Введите рост админа: ", personBuilder::buildHeight, parseLong, console, scanner);
        input("Введите айди пасспорта админа: ", personBuilder::buildPassportID, String::valueOf, console, scanner);

        LocationBuilder locationBuilder = new LocationBuilder();
        input("Введите координату X локации админа: ", locationBuilder::buildX, parseLong, console, scanner);
        input("Введите координату Y локации админа: ", locationBuilder::buildY, parseDouble, console, scanner);
        input("Введите координату Z локации админа: ", locationBuilder::buildZ, parseFloat, console, scanner);
        input("Введите название локации админа: ", locationBuilder::buildName, String::valueOf, console, scanner);

        personBuilder.buildLocation(locationBuilder.build());

        studyGroupBuilder.buildGroupAdmin(personBuilder.build());

        return studyGroupBuilder.build();
    }

    /**
     * Запрашивает поле у пользователя и обрабатывает его.
     * @param message  вывод в консоль
     * @param builderMethod  метод билдера
     * @param parser  парсер переданного значения
     * @param console консоль
     * @param scanner сканнер
     * @param <T>     Класс коллекции
     */
    protected static <T> void input(String message,
                                  Consumer<T> builderMethod,
                                  Function<String, T> parser,
                                  Console console,
                                  Scanner scanner) {
        while (true) {
            try {
                console.println(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    builderMethod.accept(null);
                } else {
                    builderMethod.accept(parser.apply(input));
                }
                return;
            } catch (IllegalArgumentException | NullPointerException e) {
                console.printerr(e.getMessage());
            } catch (DateTimeParseException e) {
                console.printerr("Дата должна быть введена в формате: yyyy-MM-dd");
            }
        }
    }
}