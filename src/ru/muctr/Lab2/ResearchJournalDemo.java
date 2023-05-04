package ru.muctr.Lab2;

import java.util.Arrays;
import java.util.Comparator;

public class ResearchJournalDemo {
    public static void main(String[] args) throws Exception {
        Editor editor1 = new Editor("John Doe");
        Editor editor2 = new Editor("Jane Smith");
        Editor editor3 = new Editor("Bob Johnson");

        ResearchJournal[] journals = {
                new ResearchJournal("Journal A", 3, editor1),
                new ResearchJournal("Journal C", 1, editor2),
                new ResearchJournal("Journal B", 2, editor3)
        };

        System.out.println("Unsorted journals:");
        printJournals(journals);

        // Sort by title using Comparable
        Arrays.sort(journals);
        System.out.println("\nSorted by title (using Comparable):");
        printJournals(journals);

        // Sort by editor name, volume number, and title using Comparator
        Comparator<ResearchJournal> editorComparator = Comparator.comparing(j -> j.getEditor().getName());
        Comparator<ResearchJournal> volumeComparator = Comparator.comparingInt(ResearchJournal::getVolumeNumber);

        Arrays.sort(journals, editorComparator);
        System.out.println("\nSorted by editor name (using Comparator):");
        printJournals(journals);

        Arrays.sort(journals, volumeComparator);
        System.out.println("\nSorted by volume number (using Comparator):");
        printJournals(journals);
    }

    private static void printJournals(ResearchJournal[] journals) {
        for (ResearchJournal journal : journals) {
            System.out.println(journal);
        }
    }
}


