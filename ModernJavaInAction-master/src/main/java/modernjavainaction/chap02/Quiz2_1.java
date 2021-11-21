package modernjavainaction.chap02;

import java.util.Arrays;
import java.util.List;

public class Quiz2_1 {

    enum Color {
        RED,
        GREEN
    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        prettyPrintApple(inventory, new fullyDescribedApplePrettyFormatter());
        prettyPrintApple(inventory, new SimpleApplePrettyFormatter());


    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrettyFormatter applePrettyFormatter) {
        for(Apple apple: inventory) {
            String output = applePrettyFormatter.format(apple);
            System.out.println(output);
        }
    }


    public static class Apple {

        private int weight = 0;
        private Color color = Color.GREEN;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    public interface ApplePrettyFormatter {

        String format(Apple apple);
    }

    public static class SimpleApplePrettyFormatter implements ApplePrettyFormatter {

        @Override
        public String format(Apple apple) {

            return "its an " + apple.getColor() + " apple";

        }
    }

    public static class fullyDescribedApplePrettyFormatter implements ApplePrettyFormatter {

        @Override
        public String format(Apple apple) {

            return "its an apple with color:" + apple.getColor() + " and weight: " + apple.getWeight();

        }
    }
}

