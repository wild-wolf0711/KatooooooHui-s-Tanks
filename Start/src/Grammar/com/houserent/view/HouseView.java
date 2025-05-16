package Grammar.com.houserent.view;

import Grammar.com.houserent.domain.House;
import Grammar.com.houserent.service.HouseService;
import Grammar.com.houserent.utils.Utility;
import jdk.jshell.execution.Util;

public class HouseView {

    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);

    public void addHouse(){
        System.out.print("===============");
        System.out.print("添加房屋");
        System.out.println("===============");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态(未出租/已出租): ");
        String state = Utility.readString(3);
        House house = new House(0, name, phone, address, state, rent);
        if(houseService.add(house)){
            System.out.print("===============");
            System.out.print("添加房屋成功");
            System.out.println("===============");
        }else{
            System.out.print("===============");
            System.out.print("添加房屋失败");
            System.out.println("===============");
        }
    }

    public void findHouse(){
        System.out.print("===============");
        System.out.print("查找房屋");
        System.out.println("===============");
        System.out.println("请输入你想要查找的房屋编号");
        int houseId = Utility.readInt();
        if(houseService.find(houseId)){
            System.out.print("===============");
            System.out.print("查找房屋成功");
            System.out.println("===============");
        }else{
            System.out.print("===============");
            System.out.print("查找房屋失败,已退出");
            System.out.println("===============");
        }
    }

    public void deleteHouse(){
        System.out.print("===============");
        System.out.print("删除房屋");
        System.out.println("===============");
        System.out.println("请选择待删除房屋编号(-1退出)");
        int houseId = Utility.readInt();
        if(houseId == -1)
            return;
        System.out.println("确认是否删除(Y/N)");
        char op = Utility.readChar();
        if(op == 'N' || op == 'n')
            return;
        if(op != 'Y' && op != 'y'){
            System.out.print("===============");
            System.out.print("输入错误，已退出");
            System.out.println("===============");
        }
        if(houseService.delete(houseId)){
            System.out.print("===============");
            System.out.print("删除房屋成功");
            System.out.println("===============");
        }else{
            System.out.print("===============");
            System.out.print("删除房屋失败");
            System.out.println("===============");
        }
    }

    public void listHouses(){
        System.out.print("===============");
        System.out.print("房屋列表");
        System.out.println("===============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址" +
                "\t\t月租\t\t状态(未出租/已出租)");
        House[] house = houseService.list();
        for(int i = 0;i < house.length;i++){
            if(house[i] == null)
                break;
            System.out.println(house[i]);
        }
        System.out.print("===============");
        System.out.print("房屋列表显示完毕");
        System.out.println("===============");
    }

    public void exitHouse(){
        char c = Utility.readConfirmSelection();
        if(c == 'y' || c == 'Y')
            loop = false;
    }

    public void modifyHouse(){
        System.out.print("===============");
        System.out.print("修改房屋信息");
        System.out.println("===============");
        System.out.println("请输入你想要修改的房屋编号");
        int houseId = Utility.readInt();
        if(houseService.modify(houseId)){
            System.out.print("===============");
            System.out.print("修改房屋信息成功");
            System.out.println("===============");
        }else{
            System.out.print("===============");
            System.out.print("修改房屋信息失败");
            System.out.println("===============");
        }
    }

    public void mainMenu(){
        do{
            System.out.println("输入任意语句以开始/继续");
            String temp = Utility.readString(999);
            System.out.print("===============");
            System.out.print("房屋出租系统菜单");
            System.out.println("===============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出");
            System.out.println("请输入你的选择(1-6)");
            key = Utility.readChar();
            switch (key){
                case '1' :
                    addHouse();
                    break;
                case '2' :
                    findHouse();
                    break;
                case '3' :
                    deleteHouse();
                    break;
                case '4' :
                    modifyHouse();
                    break;
                case '5' :
                    listHouses();
                    break;
                case '6' :
                    exitHouse();
                    break;
                default:
                    System.out.println("你输入数字的有误");
            }

        }while(loop);
    }
}
