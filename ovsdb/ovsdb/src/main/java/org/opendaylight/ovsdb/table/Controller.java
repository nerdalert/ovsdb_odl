package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Controller {

    private ControllerInfo controllerInfo;

    public ControllerInfo getControllerInfo() {
        return controllerInfo;
    }

    public void setNew(ControllerInfo controllerInfo) {
        this.controllerInfo = controllerInfo;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "[Controller.class  getIs_connected = " + controllerInfo
                .getIs_connected().toString() + "\n" +
                "[Controller.class  getTarget = " + controllerInfo.getTarget
                ().toString() + "\n" +
                '}';
    }
}