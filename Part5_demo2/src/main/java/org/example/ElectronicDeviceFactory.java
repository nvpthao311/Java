package org.example;

public class ElectronicDeviceFactory {

    public static ElectronicDeviceAbstractFactory getFactory (Segment segment){
        switch (segment){
            case MID_RANGE:
                return new MidRangeDeviceFactory();
            case HIGH_END:
                return new HighendDevideFactory();
            default:
                return null;

        }
    }
}
