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
public class BoCauHoi {
    private String cauHoi;
    private String[] cauTraLoi;
    private String dapAn;

    public BoCauHoi(String cauHoi, String[] cauTraLoi, String dapAn) {
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
        this.dapAn = dapAn;
    }

    public BoCauHoi() {
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
    
    
}
