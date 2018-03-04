package com.javarush.task.task14.task1408;

class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    String getDescription() {
        return super.getDescription().concat(" Моя страна - ").concat(Country.MOLDOVA).concat(". Я несу ").concat(String.valueOf(getCountOfEggsPerMonth())).concat(" яиц в месяц.");
    }
}