package com.example.myapplication.Helper;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);

    }
    public void insertFood(PopularDomain item){
        ArrayList<PopularDomain> listPop=getListCart();
        boolean exitAlready=false;
        int n = 0;
        for (int i = 0; i < ListPop.size(); i++) {
            if (listPop.get(i).getTitle().equals(item.getTitle())){
                exitAlready=true;
                n=i;
                break;
            }
        }
        if (exitAlready){
            listPop.get(n).setNumberinCart(item.getNumberinCart());
        }
        else {
            listPop.add(item);
        }
        tinyDB.putListObject("CartList",listPop);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDomain> getListCart() {
        return tinyDB.getListObject("CartList");

    }

    public void minusNumberItem(ArrayList<PopularDomain>listItem,int position, ChangeNumberItemListner changeNumberItemListner){
        if (listItem.get(position).getNumberinCart()==1){
            listItem.remove(position);
        }else {
            listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart()-1);
        }

        tinyDB.putListObject("Cartlist", listItem);
        changeNumberItemListner.change();
    }

    public void plusNumberItem(ArrayList<PopularDomain>listItem,int position, ChangeNumberItemListner changeNumberItemListner){
        listItem.get(position).setNumberincart(listItem.get(position).getNumberinCart()+1);
        tinyDB.putListObject("Cartlist", listItem);
        changeNumberItemListner.change();

    }

    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem=getListCart();
        double fee = 0;
        for (int i = 0; i < listItem.size(); i++) {
            fee=fee+(listItem.get(i).getPrice()*listItem.get(i).getNumberinCart());

        }
        return fee;
    }


}
