 package org.example;

public class Main {
    public static void main(String[] args) {
        ElectronicDeviceAbstractFactory highEndFactory = ElectronicDeviceFactory.getFactory(Segment.HIGH_END);
        Laptop highendlaptop = highEndFactory.getLaptop();
        Phone highendphone = highEndFactory.getPhone();
        System.out.println(highendphone.phonePrice());
        System.out.println(highendlaptop.laptopPrice());
        System.out.println("****************************************************");

        ElectronicDeviceAbstractFactory midRangeFactory = ElectronicDeviceFactory.getFactory(Segment.MID_RANGE);
        Laptop midrangeLaptop = midRangeFactory.getLaptop();
        Phone midrangePhone = midRangeFactory.getPhone();
        System.out.println(midrangePhone.phonePrice());
        System.out.println(midrangeLaptop.laptopPrice());
        System.out.println("****************************************************");
    }
}