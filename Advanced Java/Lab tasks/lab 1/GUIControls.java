import javax.swing.*;

public class GUIControls {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI Controls Demo");
        frame.setLayout(null); // Using null layout
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 25);
        JTextField userText = new JTextField();
        userText.setBounds(150, 30, 200, 25);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 70, 100, 25);
        JPasswordField passText = new JPasswordField();
        passText.setBounds(150, 70, 200, 25);

        // Gender (Radio buttons)
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 110, 100, 25);
        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(150, 110, 80, 25);
        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(240, 110, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Hobbies (Checkboxes)
        JLabel hobbiesLabel = new JLabel("Hobbies:");
        hobbiesLabel.setBounds(50, 150, 100, 25);
        JCheckBox playingCheck = new JCheckBox("Playing");
        playingCheck.setBounds(150, 150, 80, 25);
        JCheckBox readingCheck = new JCheckBox("Reading");
        readingCheck.setBounds(240, 150, 80, 25);
        JCheckBox visitingCheck = new JCheckBox("Visiting");
        visitingCheck.setBounds(330, 150, 80, 25);

        // Country (ComboBox)
        JLabel countryLabel = new JLabel("Select Country:");
        countryLabel.setBounds(50, 190, 100, 25);
        String[] countries = {"Nepal", "India", "China", "USA"};
        JComboBox<String> countryCombo = new JComboBox<>(countries);
        countryCombo.setBounds(150, 190, 200, 25);

        // Request (TextArea)
        JLabel requestLabel = new JLabel("Request:");
        requestLabel.setBounds(50, 230, 100, 25);
        JTextArea requestText = new JTextArea();
        requestText.setBounds(150, 230, 200, 60);

        // Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 310, 100, 30);

        // Add components to frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(genderLabel);
        frame.add(maleRadio);
        frame.add(femaleRadio);
        frame.add(hobbiesLabel);
        frame.add(playingCheck);
        frame.add(readingCheck);
        frame.add(visitingCheck);
        frame.add(countryLabel);
        frame.add(countryCombo);
        frame.add(requestLabel);
        frame.add(requestText);
        frame.add(submitButton);

        frame.setVisible(true);
    }
}