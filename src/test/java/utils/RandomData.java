package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomData {

    public static Faker faker = new Faker();
    public static Faker fakerRu = new Faker(new Locale("ru"));

    public static String getIncorrectEnglishKeyboardText() {
        return faker.options().option(
                "yfcnjkmyst buhs",    // настольные игры
                "rfhnjxyst buhs",     // карточные игры
                "if[vfns",            // шахматы
                "ujkjdjkjvrf",        // головоломка
                "gfpk",               // пазл
                "aen,jkrf",           // футболка
                "[elb",               // худи
                "l;bycs",             // джинсы
                "rhjccjdrb",          // кроссовки
                "rehnrf",             // куртка
                "gkfnmt",             // платье
                "yfeiybrb",           // наушники
                "cvfhnajy",           // смартфон
                "yjen,er",            // ноутбук
                "gfe'h,fyr",          // пауэрбанк
                "bluetooth rjkjyrf",  // bluetooth колонка
                "gjcntkmyjt ,tkm`",   // постельное бельё
                "gjleirf",            // подушка
                "jltzkj",             // одеяло
                "rfcnh.kz",           // кастрюля
                "crjdjhjlf"           // сковорода
        );
    }

    public static String getSomeText() {
        return faker.funnyName().name();
    }
}
