package sort;

public class Main {

    public static void main(String[] args) {
        SortPersonsList.sortingProcessor app = new SortPersonsList.sortingProcessor();
        app.processRun("dataFiles/unsorted-names-list.txt", "dataFiles/sorted-names-list.txt");
    }
}
