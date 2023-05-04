package ru.muctr.Lab2;

import java.util.Arrays;
import java.util.Comparator;

public class ResearchJournalRecordDemo {

    public static void main(String[] args) {
        ResearchJournalRecord[] journals = {
                new ResearchJournalRecord("Journal C", 3, "Editor A"),
                new ResearchJournalRecord("Journal A", 1, "Editor B"),
                new ResearchJournalRecord("Journal B", 2, "Editor C")
        };

        System.out.println("Before sorting:");
        printJournals(journals);

        Arrays.sort(journals);
        System.out.println("\nAfter sorting by Comparable:");
        printJournals(journals);

        System.out.println("\nSorted by volume number using Comparator:");
        Arrays.sort(journals, Comparator.comparingInt(ResearchJournalRecord::volumeNumber));
        printJournals(journals);

        System.out.println("\nSorted by editor name using Comparator:");
        Arrays.sort(journals, Comparator.comparing(journal -> journal.editor().getName()));
        printJournals(journals);
    }

    private static void printJournals(ResearchJournalRecord[] journals) {
        for (ResearchJournalRecord journal : journals) {
            System.out.println(journal);
        }
    }
}

