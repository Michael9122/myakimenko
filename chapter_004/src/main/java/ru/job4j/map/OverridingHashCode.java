package ru.job4j.map;

import java.util.Arrays;

/**
 * Хорошая хэш-функция должна стремиться генерировать различные хэш-коды для не равных объектов.
 * В идеале хэш-функция должна равномерно распределять любое возможное множество неравных экземпляров класса по всем возможным значениям хэш-кода.
 * В effective java приведены некоторые правила для этого достижения:
 *
 * 1. Присвоение переменной result ненулевое число, например 17.
 *
 * 2. Для каждого значимого поля f выполнить вычисление хэш-кода:
 *
 *     2.1 Если поле имеет тип boolean, вычислить (f ? 0 : 1).
 *
 *     2.2 Если поле имеет тип byte, char, short, int вычислить (int)f.
 *
 *     2.3 Если поле имеет тип long, вычислить (int)(f-(f >>> 32)).
 *
 *     2.4 Если поле имеет тип float, вычислить Float.floatToIntBits(f).
 *
 *     2.5 Если - тип double, вычислите Double. doubleToLongBits(f), а затем преобразуйте полученное значение, как указано в п. 2.3.
 *
 *     2.6 Если поле является массивом, обрабатываете его так, как если бы каждый
 *         его элемент был отдельным полем. Иными словами, вычислите хэш-код для
 *         каждого значимого элемента, а затем объедините полученные значения так, как описано в п. 3.
 *
 *     2.7 Если поле является ссылкой на объект, а метод equals
 *         данного класса сравнивает это поле, рекурсивно вызывая другие методы equals,
 *         так же рекурсивно вызывайте для этого поля метод hashCode.
 *
 * 3) Скомбинировать result и полученный hashCode с: result =37 * result + c.
 *
 * 4) Вернуть result.
 */
public class OverridingHashCode {
    String name;
    long id;
    int age;
    float weight;
    boolean isMember;
    double credits;
    String[] interests;

    public OverridingHashCode(String name, long id, int age, float weight, boolean isMember, double credits, String[] interests) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.isMember = isMember;
        this.credits = credits;
        this.interests = interests;
    }

    @Override
    public int hashCode() {
        int result = 17;

        // Вычесление hashCode для переменной типа String.
        result = 31 * result + name.hashCode();

        // Вычесление hashCode для переменной типа long.
        result = 31 * result + (int) (id ^ (id >>> 32));

        // Вычесление hashCode для переменной типа int.
        result = 31 * result + age;

        // Вычесление hashCode для переменной типа float.
        result = 31 * result + Float.floatToIntBits(weight);

        // Вычесление hashCode для переменной типа boolean.
        result = 31 * result + (isMember ? 1 : 0);

        // Вычесление hashCode для переменной типа double.
        long creditsLong = Double.doubleToLongBits(credits);
        result = 31 * result + (int) (creditsLong ^ (creditsLong >>> 32));

        // Вычесление hashCode для массива.
        result = 31 * result + Arrays.hashCode(interests);

        // Возвращаем полученный результат.
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OverridingHashCode)) {
            return false;
        }

        OverridingHashCode p = (OverridingHashCode) obj;
        return this.id == p.id
                && this.name.equals(p.name)
                && this.age == p.age
                && this.weight == p.weight
                && this.isMember == p.isMember
                && this.credits == p.credits
                && Arrays.equals(this.interests, p.interests);
    }
}
