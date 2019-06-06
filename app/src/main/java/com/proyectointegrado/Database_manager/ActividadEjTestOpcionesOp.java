package com.proyectointegrado.Database_manager;

public class ActividadEjTestOpcionesOp {

    private String opActividadEjTestOpcionesOp, aciertoActividadEjTestOpcionesOp;
    private int indiceopActividadEjTestOpcionesOp;

    public ActividadEjTestOpcionesOp()
    {

    }

    public ActividadEjTestOpcionesOp(String opActividadEjTestOpcionesOp, String aciertoActividadEjTestOpcionesOp, int indiceopActividadEjTestOpcionesOp) {
        this.opActividadEjTestOpcionesOp = opActividadEjTestOpcionesOp;
        this.aciertoActividadEjTestOpcionesOp = aciertoActividadEjTestOpcionesOp;
        this.indiceopActividadEjTestOpcionesOp = indiceopActividadEjTestOpcionesOp;
    }

    public String getOpActividadEjTestOpcionesOp() {
        return opActividadEjTestOpcionesOp;
    }

    public void setOpActividadEjTestOpcionesOp(String opActividadEjTestOpcionesOp) {
        this.opActividadEjTestOpcionesOp = opActividadEjTestOpcionesOp;
    }

    public String getAciertoActividadEjTestOpcionesOp() {
        return aciertoActividadEjTestOpcionesOp;
    }

    public void setAciertoActividadEjTestOpcionesOp(String aciertoActividadEjTestOpcionesOp) {
        this.aciertoActividadEjTestOpcionesOp = aciertoActividadEjTestOpcionesOp;
    }

    public int getIndiceopActividadEjTestOpcionesOp() {
        return indiceopActividadEjTestOpcionesOp;
    }

    public void setIndiceopActividadEjTestOpcionesOp(int indiceopActividadEjTestOpcionesOp) {
        this.indiceopActividadEjTestOpcionesOp = indiceopActividadEjTestOpcionesOp;
    }

    @Override
    public String toString() {
        return "ActividadEjTestOpcionesOp{" +
                "opActividadEjTestOpcionesOp='" + opActividadEjTestOpcionesOp + '\'' +
                ", aciertoActividadEjTestOpcionesOp='" + aciertoActividadEjTestOpcionesOp + '\'' +
                ", indiceopActividadEjTestOpcionesOp=" + indiceopActividadEjTestOpcionesOp +
                '}';
    }
}
