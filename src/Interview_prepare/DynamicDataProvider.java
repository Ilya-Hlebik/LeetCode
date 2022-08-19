package Interview_prepare;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DynamicDataProvider {
    public double multiply(double v1, double v2) {
        return v1 * v2;
    }

    public static void main(String[] args) {
        DynamicDataProvider dynamicDataProvider = new DynamicDataProvider();
        List<Pair<Double, Double>> pairs = dynamicDataProvider.dataProvider(100, Type.NEGATIVE);
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(dynamicDataProvider.multiply(pairs.get(i).getKey(), pairs.get(i).getValue()));
        }

    }

    public List<Pair<Double, Double>> dataProvider(int countOfData, Type type) {
        double maxBeforeException = Math.sqrt(Double.MAX_VALUE);
        Random random = new Random();
        List<Pair<Double, Double>> result = new ArrayList<>();
        double min = 0.0;
        double max;
        if (type.equals(Type.POSITIVE)) {
            max = maxBeforeException;
        } else if (type.equals(Type.NEGATIVE)) {
            min = Math.sqrt(Double.MIN_VALUE);
            max = 0;
        } else {
            min = Double.MIN_VALUE;
            max = Double.MAX_VALUE;
        }
        for (int i = 0; i < countOfData; i++) {
            double positiveNumber1 = min + (max - min) * random.nextDouble();
            double positiveNumber2 = min + (max - min) * random.nextDouble();
            result.add(Pair.of(positiveNumber1, positiveNumber2));
        }
        return result;
    }

    enum Type {
        POSITIVE, NEGATIVE, EXCEPTION
    }

}
