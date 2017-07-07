package com.winnertel.em.framework.model;

public class OperationObject {
    private String fManagedObject;
    private String fChassis;
    private String fBoard;
    private String fPort;
    private String fName;


    public OperationObject() {
    }


    public String getManagedObject() {
        return fManagedObject;
    }

    public void setManagedObject(String aManagedObject) {
        fManagedObject = aManagedObject;
    }


    public String getChassis() {
        return fChassis;
    }

    public void setChassis(String aChassis) {
        fChassis = aChassis;
    }


    public String getBoard() {
        return fBoard;
    }

    public void setBoard(String aBoard) {
        fBoard = aBoard;
    }


    public String getPort() {
        return fPort;
    }

    public void setPort(String aPort) {
        fPort = aPort;
    }


    public String getName() {
        return fName;
    }

    public void setName(String aName) {
        fName = aName;
    }


    public String toString() {
        if (fName != null) {
            return fName;
        } else {
            StringBuffer sb = new StringBuffer();
            if (fManagedObject != null) {
                sb.append(fManagedObject);
            }
            if (fChassis != null) {
                sb.append(" - ");
                sb.append(fChassis);
            }
            if (fBoard != null) {
                sb.append(" - ");
                sb.append(fBoard);
            }
            if (fPort != null) {
                sb.append(" - ");
                sb.append(fPort);
            }
            return sb.toString();
        }
    }


    public Object clone() {
        OperationObject result = new OperationObject();
        result.setManagedObject(getManagedObject());
        result.setChassis(getChassis());
        result.setBoard(getBoard());
        result.setPort(getPort());
        result.setName(getName());
        return result;
    }
}
