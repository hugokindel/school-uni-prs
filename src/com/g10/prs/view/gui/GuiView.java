package com.g10.prs.view.gui;

import com.g10.prs.common.Resources;
import com.g10.prs.view.Menu;
import com.g10.prs.view.View;

import javax.sound.sampled.Clip;

/** Gui view class */
public class GuiView extends View {
    public enum Style {
        Default,
        Stylized
    }

    /** window of the game */
    private Window window;

    private Style style;

    private boolean musicState;

    private Clip music;

    /** class constructor */
    public GuiView() {
        super(new MainMenu());
        this.style = Style.Stylized;
        musicState = true;
        music = Resources.getSound("theme.wav");
        music.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /** show the window */
    @Override
    public void run() {
        window = new Window();

        window.setLocationRelativeTo(null);
        currentMenu.draw();
        window.setVisible(true);
    }

    /** @return the window */
    public Window getWindow() {
        return window;
    }

    /** change the current menu */
    @Override
    public void changeMenu(Menu menu, boolean addCurrentToBacklog) {
        window.getContentPane().removeAll();

        super.changeMenu(menu, addCurrentToBacklog);

        currentMenu.draw();
        window.validate();
    }

    /** go to the previous menu */
    @Override
    public void goBack() {
        changeMenu(menuBacklog.pop(), false);
    }

    /** reload the current menu */
    public void reload() {
        changeMenu(currentMenu, false);
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
        reload();
    }

    public void setMusicState(boolean state) {
        musicState = state;

        if (!musicState) {
            music.stop();
        } else {
            music.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public boolean getMusicState() {
        return musicState;
    }
}
