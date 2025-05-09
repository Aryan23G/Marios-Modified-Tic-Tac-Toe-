// Aryan Guptas Modified Tic Tac Toe Game
// The Theme is the Mario Universe
// Get 3 in a row of a character and keep flipping to win!
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class ItalianPlumber extends JFrame implements ActionListener {

    Clip soundFile;
    // For screens
    JPanel p_card;
    JPanel card1, card2, card3, card4;
    CardLayout cdLayout = new CardLayout();

    // Game screen
    JLabel turnPic, playerturn;
    JButton a, b, c, d, ee, f, g, h, i;
    int board[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    int winner = 0;
    char turn = 'x';
    String n1 = "";
    String n2 = "";
    JTextField choice, name, first;

    // Formatting
    Color backgroundColour = new Color(250, 218, 94);
    Color buttonColour = new Color(246, 248, 210);
    Color buttonText = new Color(58, 75, 99);
    Color titleColour = Color.white;
    Font titleFont = new Font("Segoe UI Black", Font.PLAIN, 30);
    Font promptFont = new Font("Segoe UI Black", Font.PLAIN, 15);
    Dimension boardSquare = new Dimension(96, 96);

    public ItalianPlumber() {
        // Initialize JFrame
        setTitle("Tic Tac Toe");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        p_card = new JPanel();
        p_card.setLayout(cdLayout);

        // Screens
        opening();
        instructions();
        settings();
        gameScreen();

        add(p_card, BorderLayout.CENTER);

        // Load and play sound
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("MarioOverworldMusic.snd").getAbsoluteFile());
            soundFile = AudioSystem.getClip();
            soundFile.open(audioInputStream);
            soundFile.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println("Error loading sound: " + e.getMessage());
        }

        setVisible(true);
    }

    public void opening() {
        // Opening
        card1 = new JPanel();
        card1.setBackground(backgroundColour);
        JLabel title = new JLabel(createImageIcon("title.png"));
        JLabel back = new JLabel(createImageIcon("startback1.png"));
        JButton next = new JButton("Begin Game");
        next.setPreferredSize(new Dimension(300, 50));
        next.setActionCommand("2");
        next.addActionListener(this);
        next.setBackground(buttonColour);
        next.setForeground(buttonText);
        card1.add(title);
        card1.add(back);
        card1.add(next);
        p_card.add("1", card1);
    }

    public void instructions() {
        // Instructions
        card2 = new JPanel();
        card2.setBackground(backgroundColour);
        JLabel title = new JLabel(createImageIcon("Instructions.png"));
        title.setFont(titleFont);
        title.setForeground(titleColour);
        JPanel p = new JPanel();
        JButton settings = new JButton("Settings");
        settings.setActionCommand("3");
        settings.addActionListener(this);
        settings.setPreferredSize(new Dimension(150, 50));
        settings.setBackground(buttonColour);
        settings.setForeground(buttonText);
        JButton gameScreen = new JButton("Game");
        gameScreen.setActionCommand("4");
        gameScreen.addActionListener(this);
        gameScreen.setPreferredSize(new Dimension(150, 50));
        gameScreen.setBackground(buttonColour);
        gameScreen.setForeground(buttonText);

        card2.add(title);
        p.add(settings);
        p.add(gameScreen);
        card2.add(p);
        p_card.add("2", card2);
    }

    public void settings() {
        // Settings
        card3 = new JPanel();
        card3.setBackground(backgroundColour);
        JLabel title = new JLabel("Choose your settings:");
        title.setFont(titleFont);
        title.setForeground(titleColour);

        JPanel p = new JPanel();
        JLabel gif = new JLabel(createImageIcon("settings.gif"));
        JLabel namePmt = new JLabel("Player 1:");
        namePmt.setFont(promptFont);
        name = new JTextField(10);
        name.setFont(promptFont);

        JPanel p2 = new JPanel();
        JLabel choicePmt = new JLabel("Player 2");
        choicePmt.setFont(promptFont);
        choice = new JTextField(10);
        choice.setFont(promptFont);

        JButton entrance = new JButton("To the game");
        entrance.setActionCommand("4");
        entrance.addActionListener(this);
        entrance.setPreferredSize(new Dimension(300, 50));
        entrance.setBackground(buttonColour);
        entrance.setForeground(buttonText);

        card3.add(title);
        card3.add(gif);
        p.add(namePmt);
        p.add(name);
        p2.add(choicePmt);
        p2.add(choice);

        card3.add(p);
        card3.add(p2);
        card3.add(entrance);
        p_card.add("3", card3);
    }

    public void gameScreen() {
        // GameScreen
        card4 = new JPanel();
        card4.setBackground(backgroundColour);
        JLabel title = new JLabel(createImageIcon("title2.png"));
        title.setFont(titleFont);
        title.setForeground(titleColour);

        JPanel p = new JPanel();
        JLabel curturn = new JLabel("Current Turn:");
        curturn.setFont(promptFont);
        curturn.setForeground(titleColour);

        playerturn = new JLabel("Player 1 Name");
        playerturn.setFont(promptFont);
        playerturn.setForeground(titleColour);

        turnPic = new JLabel(createImageIcon("bowser.png"));
        p.add(curturn);
        p.add(turnPic);
        p.add(playerturn);

        // Game Board
        JPanel p2 = new JPanel(new GridLayout(3, 3));
        p2.setBackground(backgroundColour);
        a = new JButton(createImageIcon("b.png"));
        a.setActionCommand("a");
        a.setBackground(backgroundColour);
        a.setPreferredSize(boardSquare);
        a.addActionListener(this);
        p2.add(a);
        b = new JButton(createImageIcon("b.png"));
        b.setActionCommand("b");
        b.setBackground(backgroundColour);
        b.setPreferredSize(boardSquare);
        b.addActionListener(this);
        p2.add(b);
        c = new JButton(createImageIcon("b.png"));
        c.setActionCommand("c");
        c.setBackground(backgroundColour);
        c.setPreferredSize(boardSquare);
        c.addActionListener(this);
        p2.add(c);
        d = new JButton(createImageIcon("b.png"));
        d.setActionCommand("d");
        d.setBackground(backgroundColour);
        d.setPreferredSize(boardSquare);
        d.addActionListener(this);
        p2.add(d);
        ee = new JButton(createImageIcon("b.png"));
        ee.setActionCommand("ee");
        ee.setBackground(backgroundColour);
        ee.setPreferredSize(boardSquare);
        ee.addActionListener(this);
        p2.add(ee);
        f = new JButton(createImageIcon("b.png"));
        f.setActionCommand("f");
        f.setBackground(backgroundColour);
        f.setPreferredSize(boardSquare);
        f.addActionListener(this);
        p2.add(f);
        g = new JButton(createImageIcon("b.png"));
        g.setActionCommand("g");
        g.setBackground(backgroundColour);
        g.setPreferredSize(boardSquare);
        g.addActionListener(this);
        p2.add(g);
        h = new JButton(createImageIcon("b.png"));
        h.setActionCommand("h");
        h.setBackground(backgroundColour);
        h.setPreferredSize(boardSquare);
        h.addActionListener(this);
        p2.add(h);
        i = new JButton(createImageIcon("b.png"));
        i.setActionCommand("i");
        i.setBackground(backgroundColour);
        i.setPreferredSize(boardSquare);
        i.addActionListener(this);
        p2.add(i);

        // Buttons
        JPanel p3 = new JPanel();
        JButton reset = new JButton("Again");
        reset.addActionListener(this);
        reset.setActionCommand("reset");
        reset.setPreferredSize(new Dimension(100, 30));
        reset.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        reset.setBackground(buttonColour);
        reset.setForeground(buttonText);
        p3.add(reset);
        JButton instruct = new JButton("Instructions");
        instruct.addActionListener(this);
        instruct.setActionCommand("instruct");
        instruct.setPreferredSize(new Dimension(120, 30));
        instruct.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        instruct.setBackground(buttonColour);
        instruct.setForeground(buttonText);
        p3.add(instruct);
        JButton settings = new JButton("Settings");
        settings.addActionListener(this);
        settings.setActionCommand("Settings");
        settings.setPreferredSize(new Dimension(100, 30));
        settings.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        settings.setBackground(buttonColour);
        settings.setForeground(buttonText);
        p3.add(settings);

        card4.add(title);
        card4.add(p);
        card4.add(p2);
        card4.add(p3);
        p_card.add("4", card4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "2":
                cdLayout.show(p_card, "2");
                break;
            case "3":
                cdLayout.show(p_card, "3");
                break;
            case "4":
                n1 = name.getText();
                playerturn.setText(n1);
                cdLayout.show(p_card, "4");
                break;
            case "reset":
                resetGame();
                break;
            case "settings":
                cdLayout.show(p_card, "3");
                break;
            case "instruct":
                cdLayout.show(p_card, "2");
                break;
            default:
                if (command.equals("a"))
                    upDateSquare(0, 0, a);
                else if (command.equals("b"))
                    upDateSquare(0, 1, b);
                else if (command.equals("c"))
                    upDateSquare(0, 2, c);
                else if (command.equals("d"))
                    upDateSquare(1, 0, d);
                else if (command.equals("ee"))
                    upDateSquare(1, 1, ee);
                else if (command.equals("f"))
                    upDateSquare(1, 2, f);
                else if (command.equals("g"))
                    upDateSquare(2, 0, g);
                else if (command.equals("h"))
                    upDateSquare(2, 1, h);
                else if (command.equals("i"))
                    upDateSquare(2, 2, i);
                win();
        }
    }

    private void resetGame() {
        // Reset the game board and other variables
        board = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        turn = 'x';
        winner = 0;
        // Reset button icons and other UI elements as needed
        a.setIcon(createImageIcon("b.png"));
        b.setIcon(createImageIcon("b.png"));
        c.setIcon(createImageIcon("b.png"));
        d.setIcon(createImageIcon("b.png"));
        ee.setIcon(createImageIcon("b.png"));
        f.setIcon(createImageIcon("b.png"));
        g.setIcon(createImageIcon("b.png"));
        h.setIcon(createImageIcon("b.png"));
        i.setIcon(createImageIcon("b.png"));
    }

    public void upDateSquare(int x, int y, JButton square) {
        int m = (int) (Math.random() * 6);

        board[x][y] = m;
        if (m == 1)
            square.setIcon(createImageIcon("Luigi.png"));
        else if (m == 2)
            square.setIcon(createImageIcon("Peach.png"));
        else if (m == 3)
            square.setIcon(createImageIcon("Yoshi.png"));
        else if (m == 4)
            square.setIcon(createImageIcon("Goomba.png"));
        else if (m == 5)
            square.setIcon(createImageIcon("bullet.png"));
        else
            square.setIcon(createImageIcon("DKong.png"));
        flipTurn();
    }

    public void flipTurn() {
        n1 = name.getText();
        n2 = choice.getText();
        if (turn == 'x') {
            turn = 'o';
            turnPic.setIcon(createImageIcon("mario.png"));
            playerturn.setText(n2);
        } else {
            turn = 'x';
            turnPic.setIcon(createImageIcon("bowser.png"));
            playerturn.setText(n1);
        }
    }

    public void win() {
        winner = 0;
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != 0)
            winner = board[0][0];
        else if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != 0)
            winner = board[1][0];
        else if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != 0)
            winner = board[2][0];
        else if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != 0)
            winner = board[0][0];
        else if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != 0)
            winner = board[0][1];
        else if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != 0)
            winner = board[0][2];
        else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != 0)
            winner = board[0][0];
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != 0)
            winner = board[0][2];

        if (winner == 99) {
            JOptionPane.showMessageDialog(null, "Tie", "Winner", JOptionPane.INFORMATION_MESSAGE);
        } else if (winner != 0 && turn == 'x') {
            JOptionPane.showMessageDialog(null, "Mario Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        } else if (winner != 0 && turn == 'o') {
            JOptionPane.showMessageDialog(null, "Bowser Wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ItalianPlumber.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        new ItalianPlumber();
    }
}