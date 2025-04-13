package org.example;

public class HighendDevideFactory extends ElectronicDeviceAbstractFactory{
    @Override
    Phone getPhone() {
        return new HighendPhone();
    }

    @Override
    Laptop getLaptop() {
        return new HighendLaptop();
    }
}
