package ru.muctr.Lab2;

import java.util.Objects;

public class ResearchJournal implements Comparable<ResearchJournal> {
    private String title;
    private int volumeNumber;
    private Editor editor;

    public ResearchJournal(String title, int volumeNumber, Editor editor) throws Exception {
        setTitle(title);
        setVolumeNumber(volumeNumber);
        setEditor(editor);
    }

    public String getTitle() {
        return title;
    }

    public int getVolumeNumber() {
        return volumeNumber;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVolumeNumber(int volumeNumber) throws Exception {
        if (volumeNumber <= 0) {
            throw new Exception("Число изданных томов не может быть быть нулем или отрицательным числом.");
        } else {
            this.volumeNumber = volumeNumber;
        }
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
    return      "Журнал [" +
                " Название: " + "\"" + title + "\"" +
                ", Число изданных томов: " + volumeNumber +
                ", Редактор: " + editor + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchJournal that = (ResearchJournal) o;
        return volumeNumber == that.volumeNumber && title.equals(that.title) && editor.equals(that.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, volumeNumber, editor);
    }

    @Override
    public int compareTo(ResearchJournal o) {
        return this.title.compareTo(o.title);
    }
}
