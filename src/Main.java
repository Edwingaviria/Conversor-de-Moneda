import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        double cantidad;

        String[] opciones = {
                "Peso a Dólar",
                "Peso a Euro",
                "Peso a Libra Esterlina",
                "Peso a Yen Japonés",
                "Peso a Won Surcoreano",
                "Dólar a Peso",
                "Euro a Peso",
                "Libra Esterlina a Peso",
                "Yen Japonés a Peso",
                "Won Surcoreano a Peso"
        };

        while (true) {
            try {
                String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desea convertir:");
                cantidad = Double.parseDouble(cantidadStr);

                JComboBox<String> comboBox = new JComboBox<>(opciones);
                int opcion = JOptionPane.showOptionDialog(
                        null,
                        comboBox,
                        "Elije la moneda a la que deseas convertir tu dinero",

                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        opciones[0]
                );

                if (opcion == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(
                            null,
                            "¡Hasta luego!",
                            "Conversor de Divisas", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }

                double resultado = convertirDivisa(cantidad, opcion);
                JOptionPane.showMessageDialog(
                        null,
                        "Tienes: " + resultado,
                        "Conversor de Divisas", JOptionPane.INFORMATION_MESSAGE);

                int respuesta = JOptionPane.showOptionDialog(
                        null,
                        "¿Desea realizar otra conversión?",
                        "Conversor de Divisas",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null
                );

                if (respuesta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(
                            null,
                            "¡Programa Terminado!",
                            "Conversor de Divisas", JOptionPane.INFORMATION_MESSAGE);
                    break;

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "La cantidad ingresada no es válida. Por favor, ingrese un número válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static double convertirDivisa(double cantidad, int opcion) {
        return switch (opcion) {
            case 0 -> cantidad * 0.00028;
            case 1 -> cantidad * 0.00024;
            case 2 -> cantidad * 0.00021;
            case 3 -> cantidad * 0.031;
            case 4 -> cantidad * 0.33;
            case 5 -> cantidad / 0.00028;
            case 6 -> cantidad / 0.00024;
            case 7 -> cantidad / 0.00021;
            case 8 -> cantidad / 0.031;
            case 9 -> cantidad / 0.33;
            default -> 0.0;
        };
    }
}