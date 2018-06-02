package ru.job4j;

import java.util.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 01.06.2018
 * @version 1
 */
public class DepartmentSort {

    /**
     * Восстановление департаментов.
     * @param departments исходный массив департаментов.
     * @return восстановленные департаменты.
     */
    private List<String> recover(List<String> departments) {
        List<String> depart = new ArrayList<>(departments);
        for (String dep : departments) {
            List<Integer> position = new ArrayList<>();
            for (int i = 0; i < dep.length(); i++) {
                if (dep.charAt(i) == '\\') {
                    position.add(i);
                }
            }
            for (Integer pos : position) {
                char[] departmentAsChar = dep.toCharArray();
                String code = new String(departmentAsChar, 0, pos);
                depart.add(code);
            }
        }
        return depart;
    }

    /**
     * Отсортировать департаменты по возрастанию.
     * @param departments исходный массив департаментов.
     * @return отсортированный массив департаментов.
     */
    public List<String> sortAscending(List<String> departments) {
        Set<String> sortedSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        sortedSet.addAll(recover(departments));
        List<String> result = new ArrayList<>(sortedSet);
        return result;
    }

    /**
     * Отсортировать департаменты по убыванию.
     * @param departments исходный массив департаментов.
     * @return отсортированный массив департаментов.
     */
    public List<String> sortDescending(List<String> departments) {
        Set<String> sortedSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int minimal = Math.min(o1.length(), o2.length());
                for (int index = 0; index < minimal; index++) {
                    Character leftChar = o1.charAt(index);
                    Character rightChar = o2.charAt(index);
                    if (rightChar.compareTo(leftChar) != 0) {
                        return rightChar - leftChar;
                    }
                }
                return o1.length() - o2.length();
            }
        });
        sortedSet.addAll(recover(departments));
        List<String> result = new ArrayList<>(sortedSet);
        return result;
    }
}
