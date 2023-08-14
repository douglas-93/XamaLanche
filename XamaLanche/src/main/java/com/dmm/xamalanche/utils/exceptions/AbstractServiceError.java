package com.dmm.xamalanche.utils.exceptions;

import org.hibernate.service.spi.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class AbstractServiceError {

    private List<ServiceErrorMessage> messages = new ArrayList();

    public AbstractServiceError() {
    }

    public AbstractServiceError addErrorMessage(String message) {
        this.messages.add(new ServiceErrorMessage(message));
        return this;
    }

    public void assertEmpty() throws ServiceException {
        if (!this.messages.isEmpty()) {
            throw new AbstractServiceException(this.createServiceException(), this.messages);

        }
    }

    public AbstractServiceException createServiceException() {
        return new AbstractServiceException(this.messages);
    }



}
