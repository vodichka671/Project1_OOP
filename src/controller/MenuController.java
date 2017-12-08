package controller;


import service.CoffeeComparator;
import service.constatnts.MainMenu;
import service.MenuMessages;
import model.Van;

import java.util.Collections;
import java.util.Scanner;

import static service.Find.find;
import static controller.Controller.generateUnit;
import static service.Validation.inputDoubleValue;
import static service.Validation.inputForMainMenu;
import static view.Show.show;
import static view.Show.showCoffee;

public class MenuController implements MenuMessages,MainMenu {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        Van van = new Van(inputDoubleValue(sc,TYPE_MAX_AMOUT_MONEY));
    while (true) {
        show(SPACE + van.maxWeight);
        show(FREE + van.maxCost);
        switch (inputForMainMenu(sc, MAIN_MENU)) {
            case ADD_COFFEE:
                van.add(generateUnit(sc));
                break;
            case FIND:
                showCoffee(find(sc, van));
                break;
            case SORT:
                Collections.sort(van.getMerchandise(),new CoffeeComparator());
                showCoffee(van.getMerchandise());
                break;
            case CARRIER:
                showCoffee(van.getMerchandise());
                break;
            case EXIT:
                return;
            }
        }
    }
}
