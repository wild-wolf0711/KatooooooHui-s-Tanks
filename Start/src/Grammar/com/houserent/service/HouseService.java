package Grammar.com.houserent.service;

import Grammar.com.houserent.domain.House;
import Grammar.com.houserent.utils.Utility;

public class HouseService {
    private House[] houses;
    private int houseSize;
    private int houseCnt = 0;
    private int idCounter = 0;

    public HouseService(int size) {
        houseSize = size;
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        if (houseCnt == houseSize) {
            System.out.println("数组已满,不能再添加了");
            return false;
        }
        houses[houseCnt++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean delete(int houseId) {
        int index = -1;
        for(int i = 0;i < houseCnt;i++){
            if(houses[i].getId() == houseId) {
                index = i;
                break;
            }
        }
        if(index == -1)
            return false;
        for(int i = index;i < houseCnt - 1;i++){
            houses[i] = houses[i + 1];
        }
        houses[--houseCnt] = null;
        return true;
    }

    public boolean find(int houseId){
        int index = -1;
        for(int i = 0;i < houseCnt;i++){
            if(houses[i].getId() == houseId) {
                index = i;
                break;
            }
        }
        if(index == -1)
            return false;
        System.out.println("编号\t\t房主\t\t电话\t\t地址" +
                "\t\t月租\t\t状态(未出租/已出租)");
        System.out.println(houses[index]);
        return true;
    }

    public boolean modify(int houseId){
        int index = -1;
        for(int i = 0;i < houseCnt;i++){
            if(houses[i].getId() == houseId) {
                index = i;
                break;
            }
        }
        if(index == -1)
            return false;
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        houses[index].setName(name);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        houses[index].setPhone(phone);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        houses[index].setAddress(address);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        houses[index].setRent(rent);
        System.out.print("状态(未出租/已出租): ");
        String state = Utility.readString(3);
        houses[index].setState(state);
        return true;
    }
}
