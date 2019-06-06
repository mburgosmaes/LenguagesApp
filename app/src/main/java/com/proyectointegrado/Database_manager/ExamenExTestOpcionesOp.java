package com.proyectointegrado.Database_manager;

public class ExamenExTestOpcionesOp {
    private String opExamenExTestOpcionesOp, aciertoExamenExTestOpcionesOp;

    public ExamenExTestOpcionesOp()
    {

    }
    public ExamenExTestOpcionesOp(String opExamenExTestOpcionesOp, String aciertoExamenExTestOpcionesOp) {
        this.opExamenExTestOpcionesOp = opExamenExTestOpcionesOp;
        this.aciertoExamenExTestOpcionesOp = aciertoExamenExTestOpcionesOp;
    }

    public String getOpExamenExTestOpcionesOp() {
        return opExamenExTestOpcionesOp;
    }

    public void setOpExamenExTestOpcionesOp(String opExamenExTestOpcionesOp) {
        this.opExamenExTestOpcionesOp = opExamenExTestOpcionesOp;
    }

    public String getAciertoExamenExTestOpcionesOp() {
        return aciertoExamenExTestOpcionesOp;
    }

    public void setAciertoExamenExTestOpcionesOp(String aciertoExamenExTestOpcionesOp) {
        this.aciertoExamenExTestOpcionesOp = aciertoExamenExTestOpcionesOp;
    }

    @Override
    public String toString() {
        return "ExamenExTestOpcionesOp{" +
                "opExamenExTestOpcionesOp='" + opExamenExTestOpcionesOp + '\'' +
                ", aciertoExamenExTestOpcionesOp='" + aciertoExamenExTestOpcionesOp + '\'' +
                '}';
    }
}
