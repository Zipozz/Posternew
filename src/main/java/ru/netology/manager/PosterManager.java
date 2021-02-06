package ru.netology.manager;
import ru.netology.domain.Movie;

public class PosterManager {
    private Movie[] items = new Movie[0];
    private int limitMovies = 10;

    public PosterManager() {
    }

    public void add(Movie item) {
        // добавляем фильм в ленту
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getAll() {
        //Movie[] result = new Movie[items.length];
        Movie[] result = new Movie[Math.min(items.length, limitMovies)];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public PosterManager(int numberOfMovies) {
        if (numberOfMovies < 0) {
            return;

        }
        this.limitMovies = numberOfMovies;
    }
}