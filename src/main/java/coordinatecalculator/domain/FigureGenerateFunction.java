package coordinatecalculator.domain;

@FunctionalInterface
public interface FigureGenerateFunction<T, R> {

    R generate(T t);
}
