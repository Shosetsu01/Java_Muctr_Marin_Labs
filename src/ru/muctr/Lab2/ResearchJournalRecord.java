package ru.muctr.Lab2;

import java.util.Objects;

public record ResearchJournalRecord(String title, int volumeNumber, Editor editor) implements Comparable<ResearchJournalRecord>  {
    //  Первый конструктор - канонический, он проверяет, что число изданных томов положительное целое число.
    public ResearchJournalRecord {
        if (volumeNumber <= 0) {
            throw new IllegalArgumentException("Volume должен быть положительным целым числом");
        }
        Objects.requireNonNull(title, "Title не может быть null");
        Objects.requireNonNull(editor, "Editor не может быть null");
    }

    //     Второй конструктор - не канонический, он принимает в качестве третьего параметра строку с именем редактора,
    //     создает объект класса Editor и передает его в качестве третьего параметра каноническому конструктору.
    public ResearchJournalRecord(String title, int volumeNumber, String editorName) {
        this(title, volumeNumber, new Editor(editorName));
    }

    @Override
    public int compareTo(ResearchJournalRecord other) {
        return this.title.compareTo(other.title);
    }
}
