package org.patrixia.utils;

import org.patrixia.utils.tailrec.TailCall;

import java.util.Iterator;
import java.util.function.BiFunction;

import static org.patrixia.utils.tailrec.TailCalls.call;
import static org.patrixia.utils.tailrec.TailCalls.done;

public class IteratorUtils {

    private IteratorUtils() {}

    public static <T, R> R foldL(BiFunction<R,T,R> f, R seed, Iterable<T> iterable) {
        return foldLTailRec(f, seed, iterable).invoke();
    }

    private static <T,R> TailCall<R> foldLTailRec(BiFunction<R,T,R> f, R seed, Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();
        if(iterator.hasNext()) return call(() -> foldLTailRec(f, f.apply(seed, iterator.next()), iteratorToIterable(iterator)));
        else return done(seed);
    }

    private static<T> Iterable<T> iteratorToIterable(Iterator<T> iterator) {
        return () -> iterator;
    }


}
