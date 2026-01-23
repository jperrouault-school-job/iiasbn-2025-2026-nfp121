package fr.formation;

public class Calculatrice {
    public int additionner(int a, int b) {
        return a + b;
    }

    public int additionner(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }

        String[] values = value.split("[,;\\n]+");
        int total = 0;

        for (String val : values) {
            int valInt = Integer.parseInt(val);

            if (valInt < 0) {
                throw new NegativeNotAllowedException();
            }

            total += valInt;
        }

        return total;
    }
}
