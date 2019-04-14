import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorForm {
    public void testClick(String button) throws Exception {
        switch (button) {
            case "+": addButton.doClick(); break;
            case "-": subButton.doClick(); break;
            case "*": multiplyButton.doClick(); break;
            case "/": divideButton.doClick(); break;
            case ".": digitButton.doClick(); break;
            case "=": equalButton.doClick(); break;
            case "±": signButton.doClick(); break;
            case "CE": ceButton.doClick(); break;
            case "CLEAR": clearButton.doClick(); break;
            case "0": a0Button.doClick(); break;
            case "1": a1Button.doClick(); break;
            case "2": a2Button.doClick(); break;
            case "3": a3Button.doClick(); break;
            case "4": a4Button.doClick(); break;
            case "5": a5Button.doClick(); break;
            case "6": a6Button.doClick(); break;
            case "7": a7Button.doClick(); break;
            case "8": a8Button.doClick(); break;
            case "9": a9Button.doClick(); break;
            default:
                throw new Exception("Error! No button " + button);
        }
    }
    public double getResult() {
        return result;
    }
    public void showWindow() {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(this.calculatorView); // frame.setContentPane(this.CalcPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton addButton;
    private JButton ceButton;
    private JButton clearButton;
    private JButton digitButton;
    private JButton divideButton;
    private JButton equalButton;
    private JButton multiplyButton;
    private JButton signButton;
    private JButton subButton;
    private JPanel calculatorView;
    private JTextField displayField;

    private boolean isDigitEnterMode = false;
    private String displayString = "";
    private double result = 0;

    enum CalcOP {NONE, ADD, SUB, MULTIPLY, DIVIDE};
    private CalcOP lastOP = CalcOP.NONE;

    private void evalLastOP(CalcOP currOP) {
        double value = Double.parseDouble(displayField.getText());
        // Note that we evaluate last Operator, not current
        switch (lastOP) {
            case ADD:
                result += value;
                break;
            case SUB:
                result -= value;
                break;
            case DIVIDE:
                result /= value;
                break;
            case MULTIPLY:
                result *= value;
                break;
            default: // First value
                result = value;
                break;
        }
        displayField.setText(Double.toString(result));
        isDigitEnterMode = false;
        lastOP = currOP;
    }
    private void enterDigit(String digit) {
        if (!isDigitEnterMode) {
            if (digit == ".")
                displayString = "0.";
            else
                displayString = digit;
            isDigitEnterMode = true;
        }
        else {
            // Only floating-point number can start with 0
            if (displayString == "0" && digit != ".")
                return;
            displayString += digit;
        }
        displayField.setText(displayString);
    }
    private void clearAll() {
        isDigitEnterMode = false;
        CalcOP lastOP = CalcOP.NONE;
        displayString = "";
        result = 0;
        displayField.setText(displayString);
    }
    public CalculatorForm() {
        equalButton.addActionListener(new ActionListener() {
            @Override
            // calculate the result
            // show text
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.NONE);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.ADD);
            }
        });
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.SUB);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.MULTIPLY);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.DIVIDE);
            }
        });
        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }); 
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });

        digitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit(".");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("4");
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("1");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("7");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("0");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("2");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("5");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("8");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("3");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("6");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("9");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("CalculatorForm");
        frame.setContentPane(new CalculatorForm().calculatorView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
