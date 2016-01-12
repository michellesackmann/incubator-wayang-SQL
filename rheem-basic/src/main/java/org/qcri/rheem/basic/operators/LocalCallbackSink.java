package org.qcri.rheem.basic.operators;

import org.qcri.rheem.core.plan.UnarySink;
import org.qcri.rheem.core.types.DataSet;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * This sink executes a callback on each received data unit into a Java {@link Collection}.
 */
public class LocalCallbackSink<T> extends UnarySink<T> {

    protected final Consumer<T> callback;

    public static <T> LocalCallbackSink<T> createCollectingSink(Collection<T> collector, DataSet type) {
        return new LocalCallbackSink<>(dataUnit -> collector.add(dataUnit), type);
    }


    /**
     * Creates a new instance.
     *
     * @param callback callback that is executed locally for each incoming data unit
     * @param type     type of the incoming elements
     */
    public LocalCallbackSink(Consumer<T> callback, DataSet type) {
        super(type, null);
        this.callback = callback;
    }

    public Consumer<T> getCallback() {
        return callback;
    }

}
