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
public class KQKT {
    private String username;
    private String mssv;
    private String score;

    public KQKT() {
    }

    public KQKT(String username, String mssv, String score) {
        this.username = username;
        this.mssv = mssv;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
}
