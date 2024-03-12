import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {

    private JTextField amountField;
    private JComboBox<String> sourceCurrencyComboBox;
    private JComboBox<String> targetCurrencyComboBox;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(550, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.black);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        //panel.setForeground(Color.white);
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);


        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 80, 25);
        panel.add(amountLabel);
        amountLabel.setForeground(Color.white);
        amountLabel.setHorizontalAlignment(JLabel.CENTER);
        amountLabel.setVerticalAlignment(JLabel.CENTER);

        amountField = new JTextField(20);
        amountField.setBounds(150, 20, 200, 25);
        panel.add(amountField);
        amountField.setHorizontalAlignment(JTextField.CENTER);


        JLabel sourceCurrencyLabel = new JLabel("Source Currency:");
        sourceCurrencyLabel.setBounds(20, 50, 120, 25);
        panel.add(sourceCurrencyLabel);
        sourceCurrencyLabel.setForeground(Color.white);
        sourceCurrencyLabel.setHorizontalAlignment(JLabel.CENTER);
        sourceCurrencyLabel.setVerticalAlignment(JLabel.CENTER);

        String[] currencies = {" ","United States Dollar(USD)", "Euro(EUR)", "Pound sterling(GBP)","Indian Rupee(INR)","Japanese Yen(JPY)","United Arab Emirates Dirham(Dir) ","Thai Baht (THB)","Chinese Yuan"};
        sourceCurrencyComboBox = new JComboBox<>(currencies);
        sourceCurrencyComboBox.setBounds(150, 50, 200, 25);
        panel.add(sourceCurrencyComboBox);
        sourceCurrencyComboBox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);

        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
        targetCurrencyLabel.setBounds(20, 80, 120, 25);
        panel.add(targetCurrencyLabel);
        targetCurrencyLabel.setForeground(Color.white);
        targetCurrencyLabel.setVerticalAlignment(JLabel.CENTER);
        targetCurrencyLabel.setHorizontalAlignment(JLabel.CENTER);

        targetCurrencyComboBox = new JComboBox<>(currencies);
        targetCurrencyComboBox.setBounds(150, 80, 200, 25);
        panel.add(targetCurrencyComboBox);
        //targetCurrencyComboBox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 80, 25);
        panel.add(convertButton);
        convertButton.setAlignmentX(JButton.CENTER);

        resultLabel = new JLabel("Converted Amount:");
        resultLabel.setBounds(110, 120, 400, 25);
        panel.add(resultLabel);
        resultLabel.setForeground(Color.white);
        resultLabel.setVerticalAlignment(JLabel.CENTER);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

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
        double usdToEurRate = 0.93;
        double usdToGbpRate = 0.77;
        double usdToInrRate = 83.01;
        double usdToJpyRate = 149.94;
        double usdTodirhamRate = 3.67;
        double usdToThaiBhatRate = 36.09;
        double usdToYuanRate = 7.12;


        double eurToUsdRate = 1.12;
        double eurToGbpRate = 0.88;
        double eurToInrRate = 89.39;
        double eurToJpyRate = 161.45;
        double eurTodirhamRate = 3.95;
        double eurToThaiBhatRate = 38.83;
        double eurToYuanRate  = 7.66;


        double gbpToUsdRate = 1.30;
        double gbpToEurRate = 1.14;
        double gbpToInrRate = 104.57;
        double gbpToJpyRate = 188.90;
        double gbpTodirhamRate = 4.62;
        double gbpToThaiBhatRate = 45.40;
        double gbpToYuanRate = 8.96;

        double inrToUsdRate = 0.012;
        double inrToEurRate = 0.011;
        double inrToGbpRate = 0.0096;
        double inrToJpyRate = 1.81;
        double inrTodirhamRate = 0.044;
        double inrToThaiBhatRate = 0.43;
        double inrToYuanRate = 0.086;

        double jpyToUsdRate = 0.0067;
        double jpyToEurRate = 0.0062;
        double jpyToInrRate = 0.55;
        double jpyToGbpRate = 0.0053;
        double jpyTodirhamRate = 0.024;
        double jpyToThaiBhatRate = 0.24;
        double jpyToYuanRate = 0.047;

        double dirhamToUsdRate = 0.27;
        double dirhamToEurRate = 0.25;
        double dirhamToInrRate = 22.60;
        double dirhamToGbpRate = 0.22;
        double dirhamToJypRate = 40.92;
        double dirhamToThaiBhatRate = 9.82;
        double dirhamToYuanRate = 1.94;

        double ThaiBhatToUsdRate =0.028;
        double ThaiBhatToJypRate = 4.16;
        double ThaiBhatToeurRate = 0.026;
        double ThaiBhatTodirhamRate = 0.10;
        double ThaiBhatToinrRate = 2.30;
        double ThaiBhatTogbpRate = 0.022;
        double ThaiBhatToYuanRate = 0.20;

        double YuanToUsdRate = 0.14;
        double YuanToEurRate = 0.13;
        double YuanToGbpRate = 0.11;
        double YuanToInrRate = 11.66;
        double YuanToJypRate = 21.11;
        double YuanToThaiBahtRate = 5.07;
        double YuanToDirhamRate = 0.52;



        double convertedAmount;

        if (sourceCurrency.equals("United States Dollar(USD)")) {
            if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * usdToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * usdToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * usdToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * usdToJpyRate;
            } else if (targetCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
                convertedAmount = amount * usdTodirhamRate;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * usdToThaiBhatRate;

            }else if (targetCurrency.equals("Chinese Yuan")) {
                convertedAmount = amount * usdToYuanRate;
            } else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Euro(EUR)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * eurToUsdRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * eurToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * eurToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * eurToJpyRate;
            }else if (targetCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
                convertedAmount = amount * eurTodirhamRate;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * eurToThaiBhatRate;
            }else if (targetCurrency.equals("Chinese Yuan")) {
                convertedAmount = amount * eurToYuanRate;
            }
            else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Pound sterling(GBP)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * gbpToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * gbpToEurRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * gbpToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * gbpToJpyRate;
            }else if (targetCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
                convertedAmount = amount * gbpTodirhamRate;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * gbpToThaiBhatRate;
            }else if (targetCurrency.equals("Chinese Yuan")) {
                convertedAmount = amount * gbpToYuanRate;
            }else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Indian Rupee(INR)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * inrToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * inrToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * inrToGbpRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * inrToJpyRate;
            }else if (targetCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
                convertedAmount = amount * inrTodirhamRate;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * inrToThaiBhatRate;
            }else if (targetCurrency.equals("Chinese Yuan")) {
                convertedAmount = amount * inrToYuanRate;
            }
            else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Japanese Yen(JPY)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * jpyToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * jpyToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * jpyToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * jpyToInrRate;
            }else if (targetCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
                convertedAmount = amount * jpyTodirhamRate;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * jpyToThaiBhatRate;
            }else if (targetCurrency.equals("Chinese Yuan")) {
                convertedAmount = amount * jpyToYuanRate;
            }
            else {
                convertedAmount = amount; // Same currency
            }
        }  else if (sourceCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
              convertedAmount = amount * dirhamToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
              convertedAmount = amount * dirhamToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
              convertedAmount = amount * dirhamToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
              convertedAmount = amount * dirhamToInrRate;
           }else if (targetCurrency.equals("Japanese Yen(JPY)")) {
             convertedAmount = amount * dirhamToJypRate ;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * dirhamToThaiBhatRate;
            }else if (targetCurrency.equals("Chinese Yuan")) {
                convertedAmount = amount * dirhamToYuanRate;
            }
            else {
                convertedAmount = amount; // Same currency
            }
         } else if (sourceCurrency.equals("Thai Baht (THB)")) {
                if (targetCurrency.equals("United States Dollar(USD)")) {
                    convertedAmount = amount * ThaiBhatToUsdRate;
                } else if (targetCurrency.equals("Euro(EUR)")) {
                    convertedAmount = amount * ThaiBhatToeurRate;
                } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                    convertedAmount = amount * ThaiBhatTogbpRate;
                } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                    convertedAmount = amount * ThaiBhatToinrRate;
                }else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                    convertedAmount = amount * ThaiBhatToJypRate ;
                }else if (targetCurrency.equals("Chinese Yuan")) {
                    convertedAmount = amount * ThaiBhatToYuanRate;
                } else {
                    convertedAmount = amount; // Same currency
                }
         } else if (sourceCurrency.equals("Chinese Yuan")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * YuanToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * YuanToEurRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * YuanToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * YuanToJypRate;
            } else if (targetCurrency.equals("United Arab Emirates Dirham(Dir) ")) {
                convertedAmount = amount * YuanToDirhamRate;
            } else if (targetCurrency.equals("Thai Baht (THB)")) {
                convertedAmount = amount * YuanToThaiBahtRate;
            } else {
                convertedAmount = amount; // Same currency
            }
        }else {
        convertedAmount = amount; // Same currency
    }
        return convertedAmount;
    }

     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverterGUI());
    }
}
