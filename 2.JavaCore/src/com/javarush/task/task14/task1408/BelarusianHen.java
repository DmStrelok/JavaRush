package com.javarush.task.task14.task1408;

class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    String getDescription() {
        return super.getDescription().concat(" Моя страна - ").concat(Country.BELARUS).concat(". Я несу ").concat(String.valueOf(getCountOfEggsPerMonth())).concat(" яиц в месяц.");
    }
}