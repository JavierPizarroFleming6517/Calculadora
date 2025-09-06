import java.awt.*;
import javax.swing.*;

public class CalculadoraBases extends JFrame {
    private JTextField inputField;
    private JComboBox<String> baseCombo;
    private JLabel decimalLabel, binaryLabel, octalLabel, hexLabel;
    private JButton convertButton;

    public CalculadoraBases() {
        setTitle("Calculadora de Bases");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Número
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Número:"), gbc);
        gbc.gridx = 1;
        inputField = new JTextField(15);
        panel.add(inputField, gbc);

        //Base de entrada
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Base de entrada:"), gbc);
        gbc.gridx = 1;
        baseCombo = new JComboBox<>(new String[]{"Decimal", "Binario", "Octal", "Hexadecimal"});
        panel.add(baseCombo, gbc);

        //Botón convertir 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        convertButton = new JButton("Convertir");
        panel.add(convertButton, gbc);
        gbc.gridwidth = 1;

        //Resultados
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Decimal:"), gbc);
        gbc.gridx = 1;
        decimalLabel = new JLabel("-");
        panel.add(decimalLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Binario:"), gbc);
        gbc.gridx = 1;
        binaryLabel = new JLabel("-");
        panel.add(binaryLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Octal:"), gbc);
        gbc.gridx = 1;
        octalLabel = new JLabel("-");
        panel.add(octalLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Hexadecimal:"), gbc);
        gbc.gridx = 1;
        hexLabel = new JLabel("-");
        panel.add(hexLabel, gbc);

        add(panel);

        //pa que haga la conversion al presionar el boton
        convertButton.addActionListener(e -> convertir());

        setVisible(true);
    }

    private void convertir() {
        try {
            String input = inputField.getText().trim();
            String base = (String) baseCombo.getSelectedItem();
            int number;

            switch (base) {
                case "Decimal":
                    number = Integer.parseInt(input);
                    break;
                case "Binario":
                    number = Integer.parseInt(input, 2);
                    break;
                case "Octal":
                    number = Integer.parseInt(input, 8);
                    break;
                case "Hexadecimal":
                    number = Integer.parseInt(input, 16);
                    break;
                default:
                    number = 0;
            }

            decimalLabel.setText(String.valueOf(number));
            binaryLabel.setText(Integer.toBinaryString(number));
            octalLabel.setText(Integer.toOctalString(number));
            hexLabel.setText(Integer.toHexString(number).toUpperCase());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número inválido para la base seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
