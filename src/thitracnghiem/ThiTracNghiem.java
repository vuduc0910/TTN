/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitracnghiem;

import java.awt.Color;
import java.sql.*;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author vuduc
 */
public class ThiTracNghiem extends javax.swing.JFrame {

    /**
     * Creates new form ThiTracNghiem
     */
    private static final String COMMA_DELIMITER = ","; 
    private static final String NEW_LINE_SEPARATOR = "\n";
    private int viTriHienTai;
    private int soCauHoi= 25;
    private String username;
    private String mssv;
    private ArrayList<CauHoi> list = new ArrayList<>();
    public void addCauHoiList(int n)
    {   
        ArrayList<CauHoi> listTemp = new ArrayList<>();
        int i=0;
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("data/questions.csv"));
            XuLiRandom xlrd = new XuLiRandom(4);
            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                List<String> questions = new ArrayList<String>();
                questions = parseCsvLine(line);
                CauHoi a = new CauHoi();
                a.setCauHoi(questions.get(0));
                a.setDapAn(questions.get(2));
                String[] arrayCauTraLoi = questions.get(1).split("-");
                int[] vitricautraloi = new int[4];
                xlrd.xuLy(vitricautraloi);
                String[] newCauTraLoi = new String[4];
                for (int xl = 0; xl < 4 ; xl++){
                    newCauTraLoi[xl] = arrayCauTraLoi[vitricautraloi[xl]];
                }
                a.setCauTraLoi(newCauTraLoi);
                a.setVitri(++i);
                listTemp.add(a);  
                if(i>n)
                    break;
            }
            int arr[] =new int[soCauHoi];
            XuLiRandom xuLiRandom =new XuLiRandom(soCauHoi);
            xuLiRandom.xuLy(arr);
            for(int k = 0;k<arr.length;k++)
            {
                list.add(listTemp.get(arr[k]));
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }
   
    public void addListFrame(CauHoi a)//THEM CAU HOI LEN UI
    {
        jLabelSTT.setText(viTriHienTai+1+"");
        jLabelCauHoi.setText(a.getCauHoi());        
        jLabelCauTraLoiA.setText(a.getCauTraLoi()[0]);
        jLabelCauTraLoiB.setText(a.getCauTraLoi()[1]);
        jLabelCauTraLoiC.setText(a.getCauTraLoi()[2]);
        jLabelCauTraLoiD.setText(a.getCauTraLoi()[3]); 
        if(a.getLuaChon()!="")
        {
            buttonGroupDapan.clearSelection();
            
            if(jLabelCauTraLoiA.getText().equalsIgnoreCase(a.getLuaChon()))
            {
                jRadioDapanA.setSelected(true);
            }
            else if(jLabelCauTraLoiB.getText().equalsIgnoreCase(a.getLuaChon()))
            {
                jRadioDapanB.setSelected(true);
            }
            else if(jLabelCauTraLoiC.getText().equalsIgnoreCase(a.getLuaChon()))
            {
                jRadioDapanC.setSelected(true);
            }
            else if(jLabelCauTraLoiD.getText().equalsIgnoreCase(a.getLuaChon()))
            {
                jRadioDapanD.setSelected(true);
            }
        }
        else{
            buttonGroupDapan.clearSelection();
        }       
    }
    public void ResolveActionButton(CauHoi  cauHoi )
    {
        
        addListFrame(cauHoi);
//           System.out.println(cauHoi.getLuaChon());
    }
    public void addButtonIdDeThi(int n)
    {
        for(int i = 1; i <= n ; i++)
        {          
          String temp = i+"";
//          System.out.println(temp);
          JButton a = new JButton(temp);
                    
          a.setSize(60, 50); 
          int b =i-1;
          a.addActionListener( new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
//                  System.out.println(temp);
                    
                    viTriHienTai = b;
//                    System.out.println(viTriHienTai+"\t"+viTriTruoc);
//                    System.out.println(list.get(b).getLuaChon());
                    ResolveActionButton(list.get(b));
              }
          });
          jPanelCauHoi.add(a);
        }
        if(n<=50)
        {
        jPanelCauHoi.setLayout(new GridLayout(0,2));
        }
        else
        {
            jPanelCauHoi.setLayout(new GridLayout(0,5));
        }
            
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public ThiTracNghiem() {
        initComponents();
//        jPanelTime.setVisible(false);
        
        jLabelCauHoi.setText("");
        jLabelCauTraLoiA.setText("");
        jLabelCauTraLoiB.setText("");
        jLabelCauTraLoiC.setText("");
        jLabelCauTraLoiD.setText("");
        
        
    }
     public ThiTracNghiem(String username, String mssv){
        this.username = username;
        this.mssv = mssv;
        initComponents();
//        jPanelTime.setVisible(false);
        
        jLabelCauHoi.setText("");
        jLabelCauTraLoiA.setText("");
        jLabelCauTraLoiB.setText("");
        jLabelCauTraLoiC.setText("");
        jLabelCauTraLoiD.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDapan = new javax.swing.ButtonGroup();
        jPanelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelCauHoi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelSTT = new javax.swing.JLabel();
        jLabelIDCauHoi = new javax.swing.JLabel();
        jRadioDapanA = new javax.swing.JRadioButton();
        jRadioDapanB = new javax.swing.JRadioButton();
        jRadioDapanC = new javax.swing.JRadioButton();
        jRadioDapanD = new javax.swing.JRadioButton();
        jLabelCauHoi = new javax.swing.JLabel();
        jLabelCauTraLoiA = new javax.swing.JLabel();
        jLabelCauTraLoiB = new javax.swing.JLabel();
        jLabelCauTraLoiC = new javax.swing.JLabel();
        jLabelCauTraLoiD = new javax.swing.JLabel();
        jButtonPre = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonFinish = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1650, 1080));

        jPanelMain.setPreferredSize(new java.awt.Dimension(1650, 1080));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THI TRẮC NGHIỆM");

        jPanelCauHoi.setBackground(new java.awt.Color(0, 255, 102));

        javax.swing.GroupLayout jPanelCauHoiLayout = new javax.swing.GroupLayout(jPanelCauHoi);
        jPanelCauHoi.setLayout(jPanelCauHoiLayout);
        jPanelCauHoiLayout.setHorizontalGroup(
            jPanelCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
        jPanelCauHoiLayout.setVerticalGroup(
            jPanelCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Câu hỏi");

        jLabel3.setText("Câu hỏi số");

        jLabelSTT.setText("1");

        buttonGroupDapan.add(jRadioDapanA);
        jRadioDapanA.setText("A.");
        jRadioDapanA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDapanAActionPerformed(evt);
            }
        });

        buttonGroupDapan.add(jRadioDapanB);
        jRadioDapanB.setText("B.");
        jRadioDapanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDapanBActionPerformed(evt);
            }
        });

        buttonGroupDapan.add(jRadioDapanC);
        jRadioDapanC.setText("C.");
        jRadioDapanC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDapanCActionPerformed(evt);
            }
        });

        buttonGroupDapan.add(jRadioDapanD);
        jRadioDapanD.setText("D.");
        jRadioDapanD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDapanDActionPerformed(evt);
            }
        });

        jLabelCauHoi.setText("jLabel5");

        jLabelCauTraLoiA.setText("jLabel5");

        jLabelCauTraLoiB.setText("jLabelCauTraLoiB");

        jLabelCauTraLoiC.setText("jLabelCauTraLoiC");

        jLabelCauTraLoiD.setText("jLabelCauTraLoid");

        jButtonPre.setText("<< PRE ");
        jButtonPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreActionPerformed(evt);
            }
        });

        jButtonNext.setText("NEXT>>");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonFinish.setText("START");
        jButtonFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIDCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jRadioDapanA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCauTraLoiA, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jRadioDapanC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCauTraLoiC, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jRadioDapanD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCauTraLoiD, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jRadioDapanB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jLabelCauTraLoiB, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButtonPre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(jButtonFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(611, 611, 611))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabelIDCauHoi)
                        .addGap(100, 100, 100)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioDapanA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCauTraLoiA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioDapanB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCauTraLoiB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioDapanC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCauTraLoiC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioDapanD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCauTraLoiD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPre, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(399, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanelMain.getAccessibleContext().setAccessibleDescription("");
        jPanelMain.getAccessibleContext().setAccessibleParent(jPanelMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioDapanAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDapanAActionPerformed
        // TODO add your handling code here:
        CauHoi a = list.get(viTriHienTai);
        a.setLuaChon(jLabelCauTraLoiA.getText());
        list.set(viTriHienTai, a);
    }//GEN-LAST:event_jRadioDapanAActionPerformed

    private void jRadioDapanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDapanBActionPerformed
        // TODO add your handling code here:
        CauHoi a = list.get(viTriHienTai);
        a.setLuaChon(jLabelCauTraLoiB.getText());
        list.set(viTriHienTai, a);

    }//GEN-LAST:event_jRadioDapanBActionPerformed

    private void jRadioDapanCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDapanCActionPerformed
        // TODO add your handling code here:
        CauHoi a = list.get(viTriHienTai);
        a.setLuaChon(jLabelCauTraLoiC.getText());
        list.set(viTriHienTai, a);
    }//GEN-LAST:event_jRadioDapanCActionPerformed

    private void jRadioDapanDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDapanDActionPerformed
        // TODO add your handling code here:
        CauHoi a = list.get(viTriHienTai);
        a.setLuaChon(jLabelCauTraLoiD.getText());
        list.set(viTriHienTai, a);
        
    }//GEN-LAST:event_jRadioDapanDActionPerformed

    private void jButtonFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishActionPerformed
        // TODO add your handling code here:
        if(jButtonFinish.getText().equalsIgnoreCase("START"))
        {
            ThreadTime threadTime = new ThreadTime();
            threadTime.start();
            buttonGroupDapan.clearSelection();
            addCauHoiList(30);
            addListFrame(list.get(0));
            addButtonIdDeThi(soCauHoi);
            jPanelCauHoi.setVisible(true);
//            jPanelTime.setVisible(true);
            jButtonFinish.setText("FINISH");
            viTriHienTai = 0;
        }
        else{
//             xử lí điểm.
            int diem=0;
            for(CauHoi cauHoi : list)
            {
                if(cauHoi.getDapAn().equalsIgnoreCase(cauHoi.getLuaChon())&&cauHoi.getLuaChon()!="")
                {
                    diem +=1;
                }
            }
            String tk = (diem +"")+"/"+(soCauHoi+"");
            List<KQKT> listKq  = new ArrayList<>();
            listKq.add(new KQKT(this.username, this.mssv, tk));
            FileWriter fileWriter = null;
            String fileNameWrite = "data/kq.csv";
            try {
               fileWriter = new FileWriter(fileNameWrite,true);  
               for (KQKT kq : listKq) {
                fileWriter.append(kq.getUsername());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(kq.getMssv());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("'" + kq.getScore());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            }
            catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }
            }
            KQ kq = new KQ(tk);
            this.setVisible(false);
            kq.setVisible(true);
            return;
        }
    }//GEN-LAST:event_jButtonFinishActionPerformed

    private void jButtonPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreActionPerformed
        // TODO add your handling code here:
        if(viTriHienTai!=0)
        {
             viTriHienTai-=1;
             addListFrame(list.get(viTriHienTai));
        }
    }//GEN-LAST:event_jButtonPreActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        if(viTriHienTai!=soCauHoi-1)
        {
             viTriHienTai+=1;
             addListFrame(list.get(viTriHienTai));
        }
    }//GEN-LAST:event_jButtonNextActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThiTracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThiTracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThiTracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThiTracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThiTracNghiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDapan;
    private javax.swing.JButton jButtonFinish;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCauHoi;
    private javax.swing.JLabel jLabelCauTraLoiA;
    private javax.swing.JLabel jLabelCauTraLoiB;
    private javax.swing.JLabel jLabelCauTraLoiC;
    private javax.swing.JLabel jLabelCauTraLoiD;
    private javax.swing.JLabel jLabelIDCauHoi;
    private javax.swing.JLabel jLabelSTT;
    private javax.swing.JPanel jPanelCauHoi;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JRadioButton jRadioDapanA;
    private javax.swing.JRadioButton jRadioDapanB;
    private javax.swing.JRadioButton jRadioDapanC;
    private javax.swing.JRadioButton jRadioDapanD;
    // End of variables declaration//GEN-END:variables
}
