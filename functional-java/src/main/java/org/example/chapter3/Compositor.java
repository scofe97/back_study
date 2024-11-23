package org.example.chapter3;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Compositor {

    public static <T, R> Supplier<R> compose(Supplier<T> befroe, Function<T, R> fn) {

        Objects.requireNonNull(befroe);
        Objects.requireNonNull(fn);

        return () -> {
            T result = befroe.get();
            return fn.apply(result);
        };
    }

    public static <T, R> Consumer<T> compose(Function<T, R> fn, Consumer<R> after) {
        Objects.requireNonNull(fn);
        Objects.requireNonNull(after);

        return (T t) -> {
            R result = fn.apply(t);
            after.accept(result);
        };
    }

    public static <T> Consumer<T> acceptIf(Predicate<T> predicate, Consumer<T> consumer) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(consumer);

        return (T t) -> {
            if (!predicate.test(t)) {
                return;
            }

            consumer.accept(t);
        };
    }
}
