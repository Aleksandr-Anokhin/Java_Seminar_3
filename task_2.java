/* 2. Пусть дан произвольный список целых чисел, удалить из него четные числа */

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class task_2 {
    public static List<Integer> getRandomList() {
        Random random = new Random();
        int size = 15;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list.toString());
        return list;
    }

    public static List<Integer> deletEven(List<Integer> list) {

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }

        }
        System.out.println(list.toString());
        return list;
    }

    public static void main(String[] args) {
        deletEven(getRandomList());
    }
}
