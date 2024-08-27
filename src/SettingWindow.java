import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Настройка поля, выбор режима игры
public class SettingWindow extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 350;

    private JSlider sliderS, sliderW;
    private JRadioButton humamButton, aiButton;
    JButton btnStart;
    SettingWindow(GameWindow gameWindow){
        btnStart = new JButton("Start new game");
        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        setLocationRelativeTo(gameWindow);
        setSize(WIDTH,HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                int mode = aiButton.isSelected() ? 1 : 0;
                gameWindow.startNewGame(mode, sliderS.getValue(),sliderS.getValue(),sliderW.getValue());
            }
        });
        mainPanel.add(getModePanel());
        mainPanel.add(getFieldSize());
        mainPanel.add(getWinLength());

        add(mainPanel);
        add(btnStart,BorderLayout.SOUTH);
    }

    private JPanel getModePanel() {
        JPanel modePanel = new JPanel(new GridLayout(3, 1));

        JLabel textTitle = new JLabel("Select game mode");
        aiButton = new JRadioButton("Human vs Ai");
        humamButton = new JRadioButton("Human vs Human");

        aiButton.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(aiButton);
        group.add(humamButton);

        modePanel.add(textTitle);
        modePanel.add(aiButton);
        modePanel.add(humamButton);

        return modePanel;
    }

    private JPanel getFieldSize() {
        String textTitle = "Field size: ";

        JPanel modePanel = new JPanel(new GridLayout(3, 1));

        JLabel textTitle1 = new JLabel("Select field size");

        sliderS = new JSlider(3,10,3);

        JLabel textTitle2 = new JLabel(textTitle + sliderS.getValue());

        sliderS.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textTitle2.setText(textTitle + sliderS.getValue());
            }
        });

        modePanel.add(textTitle1);
        modePanel.add(textTitle2);
        modePanel.add(sliderS);

        return modePanel;
    }

    private JPanel getWinLength() {
        String textTitle = "Length: ";

        JPanel modePanel = new JPanel(new GridLayout(3, 1));

        JLabel textTitle1 = new JLabel("Select length for win");

        sliderW = new JSlider(3,10,3);

        JLabel textTitle2 = new JLabel(textTitle + sliderW.getValue());

        sliderW.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textTitle2.setText(textTitle + sliderW.getValue());
            }
        });

        modePanel.add(textTitle1);
        modePanel.add(textTitle2);
        modePanel.add(sliderW);

        return modePanel;
    }








}