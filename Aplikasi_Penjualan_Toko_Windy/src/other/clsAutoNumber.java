/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package other;

/**
 *
 * @author praktek
 */
public class clsAutoNumber {
    public String getNol(int pJml){
        String vJmlNol =" ";
        for(int i =0;i<pJml;i++){
            vJmlNol+="0";
        }
        return vJmlNol;
    }
    public String getDefaultNumber (String pId){
        String vKd = "";
        int vLebar = 0;
        vLebar = pId.length();
        int vNumber= 0;
        vNumber=Integer.parseInt(pId) +1;
        int vLebarNumber =0;
        vLebarNumber= Integer.toString(vNumber).length();
        
        vKd = getNol(vLebar-vLebarNumber) + Integer.toString(vNumber);
        return vKd;
        }
}