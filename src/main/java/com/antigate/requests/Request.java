package com.antigate.requests;

import com.antigate.exception.AntigateException;
import com.antigate.responses.Response;

/**
 * @author itsimoshka
 */
public interface  Request<T extends Response> {
    T execute() throws AntigateException;
}
