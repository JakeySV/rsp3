package org.rspeer.ui.component.menu;

import org.rspeer.environment.Environment;
import org.rspeer.ui.component.script.ScriptSelector;

import javax.swing.*;

public class BotToolBar extends JToolBar {

    private final Environment environment;

    public BotToolBar(Environment environment) {
        this.environment = environment;

        setFloatable(false);

        add(Box.createHorizontalGlue());

        ReloadButton reload = new ReloadButton();
        add(reload);

        StartButton start = new StartButton();
        add(start);

        start.addActionListener(e -> {
            if (start.getText().equals("Start")) {
                ScriptSelector selector = new ScriptSelector(environment.getBotContext().getFrame(), environment, start, reload);
                selector.display();
            } else {
                environment.getScriptController().stop();
                start.setText("Start");
            }
        });
    }

    public static class StartButton extends JButton {

        public StartButton() {
            setText("Start");
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(true);
            setFocusable(false);
        }
    }

    public static class ReloadButton extends JButton {

        public ReloadButton() {
            setText("Reload");
            setVisible(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(true);
            setFocusable(false);
        }
    }
}
