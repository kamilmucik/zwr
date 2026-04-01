package pl.estrix.frontend.jsf;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private ExceptionHandler wrapped;


    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterator iterator = getUnhandledExceptionQueuedEvents().iterator();

        while (iterator.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) iterator.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)event.getSource();

            Throwable throwable = context.getException();

            FacesContext fc = FacesContext.getCurrentInstance();

            try {
                Flash flash = fc.getExternalContext().getFlash();
                flash.put("errorDetails", throwable.getMessage());
                if (!fc.getExternalContext().isResponseCommitted()) {
                    NavigationHandler navigationHandler = fc.getApplication().getNavigationHandler();
                    navigationHandler.handleNavigation(fc, null, "/secured/error.html?faces-redirect=true");
                }

                fc.renderResponse();
            } finally {
                iterator.remove();
            }
        }

        // Let the parent handle the rest
        getWrapped().handle();
    }
}
