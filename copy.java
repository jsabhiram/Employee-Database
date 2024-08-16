import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;

public class copy extends JFrame {
    private JButton insertButton, updateButton, displayButton, stopButton, startButton, searchButton, controlButton, helpButton, veButton, clearButton;
    private JTextArea logTextArea, displayTextArea;
    private Color discordBlurple = new Color(123,50,250);
    private Color discordWhite = new Color(220, 221, 222);
    private Color hoverColor = new Color(105, 46, 206);

    public copy() {
        //start select
        setTitle("DBMS Interface");
        setSize(800, 700);
        ImageIcon image = new ImageIcon("Frame 1.png");
        setIconImage(image.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setExtendedState(MAXIMIZED_BOTH);

        // Create buttons with Discord dark theme styling
        clearButton = createButton("Clear");
        veButton = createButton("DATABASE MANAGER  Version 3.6.2");
        veButton.setFont(veButton.getFont().deriveFont(Font.PLAIN, 10)); // Set thin font style
        controlButton = createButton("Control Panel --->");
        helpButton = createButton("Help & Support");
        helpButton.setFont(helpButton.getFont().deriveFont(Font.PLAIN, 10)); 
        insertButton = createButton("Insert");
        updateButton = createButton("Update");
        displayButton = createButton("Display");
        stopButton = createButton("Stop");
        startButton = createButton("Start");
        searchButton = createButton("Search");

       
        logTextArea = createTextArea(5, 30, "Log Area");

       
        displayTextArea = createTextArea(10, 60, "Display Area");

        // Layout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        buttonPanel.setBackground(discordBlurple);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20); // Add some padding
        buttonPanel.add(new LogoPanel(), gbc);

        gbc.gridy++;
        gbc.weightx = 1.0; // Increase the width of the button panel
        gbc.insets = new Insets(20, 20, 0, 20); // Adjust insets to add gap between buttons
        buttonPanel.add(controlButton, gbc);

        gbc.gridy++;
        buttonPanel.add(startButton, gbc);

        gbc.gridy++;
        buttonPanel.add(insertButton, gbc);

        gbc.gridy++;
        buttonPanel.add(updateButton, gbc);

        gbc.gridy++;
        buttonPanel.add(clearButton, gbc);

        gbc.gridy++;
        buttonPanel.add(displayButton, gbc);

        gbc.gridy++;
        buttonPanel.add(searchButton, gbc);
 	
 	

        gbc.gridy++;
        buttonPanel.add(stopButton, gbc);
	
        gbc.gridy++;
        buttonPanel.add(helpButton, gbc);

        gbc.gridy++;
        buttonPanel.add(veButton, gbc);

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(Color.BLACK);
        displayPanel.add(displayTextArea, BorderLayout.CENTER);

        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.setBackground(Color.BLACK);
        logPanel.add(logTextArea, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.BLACK);
        rightPanel.add(displayPanel, BorderLayout.CENTER);
        rightPanel.add(logPanel, BorderLayout.SOUTH);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        contentPane.add(buttonPanel, BorderLayout.WEST);
        contentPane.add(rightPanel, BorderLayout.CENTER);
    }
//this not the code :)
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(discordBlurple);
        button.setForeground(discordWhite);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Adjust padding
        button.setPreferredSize(new Dimension(100, 40)); // Adjust preferred size
	//Give effects to the button when cursor is clicked or hovered
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(discordBlurple);
            }

            public void mousePressed(MouseEvent e) {
                button.setBackground(hoverColor);
                button.setForeground(discordBlurple);
            }

            public void mouseReleased(MouseEvent e) {
                button.setBackground(discordBlurple);
                button.setForeground(discordWhite);
            }
        });

        return button;
    }

    private JTextArea createTextArea(int rows, int columns, String title) {
        JTextArea textArea = new JTextArea(rows, columns);
        textArea.setBackground(new Color(47, 49, 54));
        textArea.setForeground(discordBlurple);
        TitledBorder border = BorderFactory.createTitledBorder(title);
        border.setTitleColor(discordWhite);
        border.setTitleJustification(TitledBorder.CENTER);
        textArea.setBorder(border);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setBackground(new Color(54, 57, 63));
        return textArea;
    }
//select end
//good night oh noo dont go wait for 5 min 
class LogoPanel extends JPanel {
    public LogoPanel() {
        setPreferredSize(new Dimension(350, 200));  
        setBackground(discordBlurple); 
        setBorder(new EmptyBorder(10, 10, 10, 10)); 

        // Load the image
        ImageIcon logoIcon = new ImageIcon("Frame 1.png"); 
        

        Image img = logoIcon.getImage();
        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaledImg);

        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel);
    }
}    //
    // Methods to interact with the database
    // Example methods:
    /*
    
    private void insertData() {
        // Implement insertion logic here
    }

    private void updateData() {
        // Implement update logic here
    }

    private void displayData() {
        // Implement display logic here
    }
    */
//up




//new method
/* 
private void createInputBox(String action) {
    JFrame frame = new JFrame(action + " Input"); // Dialog box title
    JPanel panel = new JPanel();
    JLabel label = new JLabel(action + " Data:");
    JTextField textField = new JTextField(20); // Text field for input
    panel.add(label);
    panel.add(textField);
    JButton confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String inputData = textField.getText(); // Get input data
            logTextArea.append(action + " data: " + inputData + "\n"); // Log input data
            frame.dispose(); // Close the dialog box
        }
    });
    panel.add(confirmButton);
    frame.add(panel);
    frame.setSize(300, 150);
    frame.setVisible(true);
}*/
//calculate time
    
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                copy frame = new copy();
                frame.setVisible(true);
            }
        });
    }
}
