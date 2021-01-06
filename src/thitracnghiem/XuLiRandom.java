/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitracnghiem;

import java.util.Random;

/**
 *
 * @author vuduc
 */
public class XuLiRandom {
    private int n;

    public XuLiRandom(int n) {
        this.n = n;
    }
    public void xuLy(int[] arr)
    {
        int[] b= new int[arr.length];
        for(int i = 0 ; i<b.length;i++)
        {
            b[i]=i;
        }
        
        for(int j = n-1 ;j>=0;j--)
        {       
            if(j==0)
            {
                arr[n-1]=b[0];;
            }
            else{
                Random rd =new Random();
                int temp = rd.nextInt(j+1);
            
            arr[n-1-j]=b[temp];
                
            b[temp]=b[j];
            }      
            
        }

//        return arr;
    }
    
}
