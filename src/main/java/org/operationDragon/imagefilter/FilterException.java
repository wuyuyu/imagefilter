package org.operationDragon.imagefilter;

import java.io.IOException;

/**
 * Class that manages and centralizes exceptions
 */
public class FilterException extends Exception {

    public FilterException(String message) {
        super(message);
    }

    public FilterException(String message, Throwable cause) {
        super(message, cause);
    }
}
