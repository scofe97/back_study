package org.example.chapter11;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Thunk<T> implements Supplier<T> {

    private static class Holder<T> implements Supplier<T> {
        private final T value;
        Holder(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return this.value;
        }
    }

    private Supplier<T> holder;

    private T result;

    public Thunk(Supplier<T> expression) {
        this.holder = () -> evaluate(expression);
    }

    //
    private synchronized T evaluate(Supplier<T> expression) {
        if (Holder.class.isInstance(this.holder) == false) {
            var evaluated = expression.get();
            this.holder = new Holder<>(evaluated);
        }

        return this.holder.get();
    }

    @Override
    public T get() {
        return this.holder.get();
    }

    public static <T> Thunk<T> of(Supplier<T> expression) {
        if(expression instanceof Thunk<T>) {
            return (Thunk<T>) expression;
        }

        return new Thunk<T>(expression);
    }

    public static <T> Thunk<T> of(T value) {
        return new Thunk<T>(() -> value);
    }

    public <R> Thunk<R> map(Function<T, ? extends R> mapper) {
        return Thunk.of(() -> mapper.apply(get()));
    }

    public void accept(Consumer<T> consumer) {
        consumer.accept(get());
    }
}
