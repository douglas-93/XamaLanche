package com.dmm.xamalanche.utils.exceptions;

import java.util.Iterator;
import java.util.List;

public class AbstractServiceException extends RuntimeException {

    private List<ServiceErrorMessage> messages;

    public AbstractServiceException(Throwable throwable, List<ServiceErrorMessage> messages) {
        super(throwable);
        this.messages = messages;
    }

    public AbstractServiceException(List<ServiceErrorMessage> messages) {
        this.messages = messages;
    }
    public String toString() {
        StringBuffer buff = new StringBuffer();
        if (this.messages != null && this.messages.size() > 0) {
            int count = 0;
            Iterator iteratorMensagem = this.messages.iterator();

            while(iteratorMensagem.hasNext()) {
                ServiceErrorMessage msg = (ServiceErrorMessage)iteratorMensagem.next();


                if (msg.getMessage() != null) {
                    buff.append(msg.getMessage());
                }

                if (count++ < this.messages.size() - 1) {
                    buff.append("\n ");
                }
            }

            return buff.toString();
        } else {
            return this.getMessage();
        }
    }

}
