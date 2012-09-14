package com.antigate.requests;

import com.antigate.execption.AntigateException;
import com.antigate.responses.Response;

/**
 * @author itsimoshka
 */
public interface  Request<T extends Response> {
    T execute() throws AntigateException;
}
