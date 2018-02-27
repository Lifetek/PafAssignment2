package controller;

import services.LoanService;
import services.TitleService;

/**
 * Created by fatih on 3-2-2018.
 */

//de main geeft aan welke controller welke service gebruikt
public class Main {
    public static void main(String[] args) {
        new TitleController(new TitleService());
        new LoanController(new LoanService());
    }
}
