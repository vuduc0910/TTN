/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitracnghiem;

/**
 *
 * @author vuduc
 */
public class CauHoi {
    private String cauHoi;
    private String[] cauTraLoi;
    private String dapAn;
    private String luaChon;
    private int vitri;

    public CauHoi() {
        vitri=0;
        luaChon = "";
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String[] getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String[] cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }
    
}
