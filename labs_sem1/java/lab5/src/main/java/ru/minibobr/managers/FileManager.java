package ru.minibobr.managers;

import ru.minibobr.exceptions.PermissionDeniedException;
import ru.minibobr.utility.io.Console;

import java.io.*;

/**
 * Класс для работы с файлом
 */
public class FileManager {
    private final Console console;

    public FileManager(Console console) {
        this.console = console;
    }

    /**
     * Записать коллекцию в файл
     *
     * @param fileName имя файла
     * @param text     json
     * @throws PermissionDeniedException выбрасывается при отсутствии прав
     */
    public void write(String fileName, String text) throws PermissionDeniedException {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName))) {
            var filePath = new File(fileName);
            if (!filePath.canWrite()) throw new PermissionDeniedException("Ошибка чтения");

            char[] chars = text.toCharArray();
            outputStreamWriter.write(chars, 0, chars.length);
        } catch (IOException e) {
            console.println("Ошибка при записи файла");
        }
    }

    /**
     * Прочитать коллекцию из файла
     *
     * @param fileName имя файла
     * @return String - прочитанная коллекция из файла
     */
    public String read(String fileName) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            var filePath = new File(fileName);
            if (!filePath.exists()) throw new FileNotFoundException();
            if (!filePath.canRead()) throw new PermissionDeniedException("Ошибка чтения");
            if (!filePath.canWrite()) console.println("Нет прав на запись, вы не сможете использовать команду save");
            StringBuilder out = new StringBuilder();
            int s;
            while ((s = bufferedInputStream.read()) != -1) {
                out.append((char)s);
            }
            return out.toString();
        } catch (FileNotFoundException e) {
            console.printerr("Файл не найден. Коллекция пуста");
            return "";
        } catch (PermissionDeniedException e) {
            console.printerr(e.getMessage() + ". Коллекция пуста");
            return "";
        } catch (IOException e) {
            console.printerr("Json-файл не найден. Коллекция пуста");
            return "";
        }
    }
}
