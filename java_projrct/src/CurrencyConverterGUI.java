import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {

    private JTextField amountField;
    private JComboBox<String> sourceCurrencyComboBox;
    private JComboBox<String> targetCurrencyComboBox;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 20, 80, 25);
        panel.add(amountLabel);

        amountField = new JTextField(20);
        amountField.setBounds(100, 20, 165, 25);
        panel.add(amountField);

        JLabel sourceCurrencyLabel = new JLabel("Source Currency:");
        sourceCurrencyLabel.setBounds(10, 50, 120, 25);
        panel.add(sourceCurrencyLabel);

        String[] currencies = {"USD", "EUR", "GBP"};
        sourceCurrencyComboBox = new JComboBox<>(currencies);
        sourceCurrencyComboBox.setBounds(140, 50, 80, 25);
        panel.add(sourceCurrencyComboBox);

        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
        targetCurrencyLabel.setBounds(10, 80, 120, 25);
        panel.add(targetCurrencyLabel);

        targetCurrencyComboBox = new JComboBox<>(currencies);
        targetCurrencyComboBox.setBounds(140, 80, 80, 25);
        panel.add(targetCurrencyComboBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 120, 80, 25);
        panel.add(convertButton);

        resultLabel = new JLabel("Converted Amount:");
        resultLabel.setBounds(100, 120, 200, 25);
        panel.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertAndDisplay();
            }
        });
    }

    private void convertAndDisplay() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String sourceCurrency = (String) sourceCurrencyComboBox.getSelectedItem();
            String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem();

            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

            resultLabel.setText("Converted Amount: " + convertedAmount + " " + targetCurrency);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double usdToEurRate = 0.89;
        double usdToGbpRate = 0.77;

        double eurToUsdRate = 1.12;
        double eurToGbpRate = 0.88;

        double gbpToUsdRate = 1.30;
        double gbpToEurRate = 1.14;

        double convertedAmount;

        switch (sourceCurrency) {
            case "USD" -> {
                if (targetCurrency.equals("EUR")) {
                    convertedAmount = amount * usdToEurRate;
                } else if (targetCurrency.equals("GBP")) {
                    convertedAmount = amount * usdToGbpRate;
                } else {
                    convertedAmount = amount; // Same currency
                }
            }
            case "EUR" -> {
                if (targetCurrency.equals("USD")) {
                    convertedAmount = amount * eurToUsdRate;
                } else if (targetCurrency.equals("GBP")) {
                    convertedAmount = amount * eurToGbpRate;
                } else {
                    convertedAmount = amount; // Same currency
                }
            }
            case "GBP" -> {
                if (targetCurrency.equals("USD")) {
                    convertedAmount = amount * gbpToUsdRate;
                } else if (targetCurrency.equals("EUR")) {
                    convertedAmount = amount * gbpToEurRate;
                } else {
                    convertedAmount = amount; // Same currency
                }
            }
            default -> convertedAmount = amount; // Same currency
        }

        return convertedAmount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverterGUI::new);
    }
}

