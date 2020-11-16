package com.g10.prs.ui;

import com.g10.prs.PetRescueSaga;
import com.g10.prs.core.printer.Out;
import com.g10.prs.level.Level;

import java.util.Scanner;

public class MainMenu extends Menu {
    public MainMenu() {
        super("Menu principal", false, new String[] {"Jouer", "Changer de nom"});
    }

    public Integer use() {
        Out.println("--------------------------------------------------------------------------------");
        Out.clear();

        Out.println("   _____     _     _____                              _____                   ");
        Out.println("  |  __ \\   | |   |  __ \\                            / ____|                  ");
        Out.println("  | |__) |__| |_  | |__) |___  ___  ___ _   _  ___  | (___   __ _  __ _  __ _ ");
        Out.println("  |  ___/ _ \\ __| |  _  // _ \\/ __|/ __| | | |/ _ \\  \\___ \\ / _` |/ _` |/ _` |");
        Out.println("  | |  |  __/ |_  | | \\ \\  __/\\__ \\ (__| |_| |  __/  ____) | (_| | (_| | (_| |");
        Out.println("  |_|   \\___|\\__| |_|  \\_\\___||___/\\___|\\__,_|\\___| |_____/ \\__,_|\\__, |\\__,_|");
        Out.println("                                                                   __/ |      ");
        Out.println("                                                                  |___/       ");
        Out.println();

        int result = super.use(true);

        if (result == 1) {
            LevelSelectionMenu selectionMenu = new LevelSelectionMenu();
            PetRescueSaga.setNextMenu(selectionMenu);
        } else if (result == 2) {
            String name = PetRescueSaga.showPopup("Changer de nom", "Veuillez entrez votre nouveau nom: ", PopupType.ReturnString);
            PetRescueSaga.player.setName(name);
        }

        return result;
    }
}
