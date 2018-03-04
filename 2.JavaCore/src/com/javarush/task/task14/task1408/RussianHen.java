package com.javarush.task.task14.task1408;

class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 6;
    }

    @Override
    String getDescription() {
        return super.getDescription().concat(" Моя страна - ").concat(Country.RUSSIA).concat(". Я несу ").concat(String.valueOf(getCountOfEggsPerMonth())).concat(" яиц в месяц.");
    }
}