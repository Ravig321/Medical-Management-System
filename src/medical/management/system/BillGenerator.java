/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package medical.management.system;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ravi Kant Gupta
 */
public class BillGenerator extends javax.swing.JFrame {

    JFrame jf;
    private Connection conn;
    int rate;
    int flag = 0;
    private int total = 0;
    private static ArrayList<String> al;
    private static String[] arr;
//    private PrintFrame printFrame;

    public BillGenerator() {
        super("Bill Generator");
        setVisible(true);
        getMedicines();
        arr = new String[al.size()];
        arr = al.toArray(arr);
        getContentPane().setBackground(Color.WHITE);
        initComponents();

        Add_Medicine_Row1.setVisible(false);
        Add_Medicine_Row2.setVisible(false);
        Add_Medicine_Row3.setVisible(false);
        Add_Medicine_Row4.setVisible(false);
        Add_Medicine_Row5.setVisible(false);
        Footer.setVisible(false);
        Buttons_Row6.setVisible(false);
        jf = this;
    }

    public void getMedicines() {
        al = new ArrayList<String>();
        try {
            conn = new GetConnection().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT  name FROM medicines");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al.add(rs.getString("name"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getRate(JComboBox b, JTextField t) {
        String name = (String) b.getSelectedItem();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM medicines WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            rate = rs.getInt("price");
            t.setText(rate + "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getTotal(JTextField q, JTextField t) {
        int quantity = 0;
        try {
            quantity = Integer.parseInt(q.getText());

        } catch (Exception ex) {
            System.out.println("invalid Quantity");

        }
        if (quantity > 0) {
            t.setText(quantity * rate + "");
            setPayable(t);
            Buttons_Row6.setVisible(true);
        }

    }

    public void setPayable(JTextField t) {
        int t1 = Integer.parseInt(t.getText());
        total = total + t1;

    }

    
    public void GenerateBill(){
        flag =1;
        int sum=0;
        JTextField [] jarr = new JTextField[6];
        JComboBox [] name = new JComboBox[6];
        JTextField[] quantity = new JTextField[6];
        
        ArrayList Medicine_Name = new ArrayList();
        ArrayList Total_Amount = new ArrayList();
        
        jarr[0]= Total_Field;
        jarr[1]=Total_Field1;
        jarr[2]=Total_Field2;
        jarr[3]=Total_Field3;
        jarr[4]=Total_Field4;
        jarr[5]=Total_Field5;
        
        
        name[0]=Select_Medicine;
        name[1]=Select_Medicine1;
        name[2]=Select_Medicine2;
        name[3]=Select_Medicine3;
        name[4]=Select_Medicine4;
        name[5]=Select_Medicine5;
        
        
        quantity[0]=Quantity_field;
        quantity[1]=Quantity_field1;
        quantity[2]=Quantity_field2;
        quantity[3]=Quantity_field3;
        quantity[4]=Quantity_field4;
        quantity[5]=Quantity_field5;
        
        
        for(int i=0; i<6; i++){
            try{
                sum= sum+Integer.parseInt(jarr[i].getText());
                Medicine_Name.add(name[i].getSelectedItem());
                Total_Amount.add(jarr[i].getText());
                
                updateDatabase(name[i],quantity[i]);
                
            }   catch(Exception ex){
                System.out.println(ex);
            }
        
        }
            Payable.setText(sum+ "");
    }
    
    
     public void updateDatabase(JComboBox name , JTextField quantity) throws SQLException
     {
            
         String m_name = (String)name.getSelectedItem();
         int m_quantity = Integer.parseInt(quantity.getText());
         PreparedStatement ps = conn.prepareStatement("UPDATE medicines SET quantity = quantity-? WHERE name = ?");
         ps.setInt(1, m_quantity);
         ps.setString(2, m_name);
         ps.executeUpdate();
    }
    
   
    

    public void reset() {
        jf.dispose();
        new BillGenerator();
        JOptionPane.showMessageDialog(jf, "Reset Successful");
    }

    public boolean checkQuantity(JTextField q) {
        if (q.getText().equals("") != true) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Enter Quantity");
            return false;
        }
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Add_Medicine_Row = new javax.swing.JPanel();
        Medicine_name = new javax.swing.JLabel();
        Select_Medicine = new javax.swing.JComboBox<>(arr);
        Quantity = new javax.swing.JLabel();
        Quantity_field = new javax.swing.JTextField();
        Rate_Label = new javax.swing.JLabel();
        Rate_Field = new javax.swing.JTextField();
        Total_Label = new javax.swing.JLabel();
        Total_Field = new javax.swing.JTextField();
        Add_Button = new javax.swing.JButton();
        Add_Medicine_Row1 = new javax.swing.JPanel();
        Medicine_name1 = new javax.swing.JLabel();
        Select_Medicine1 = new javax.swing.JComboBox<>(arr);
        Quantity1 = new javax.swing.JLabel();
        Quantity_field1 = new javax.swing.JTextField();
        Rate_Label1 = new javax.swing.JLabel();
        Rate_Field1 = new javax.swing.JTextField();
        Total_Label1 = new javax.swing.JLabel();
        Total_Field1 = new javax.swing.JTextField();
        Add_Button1 = new javax.swing.JButton();
        Add_Medicine_Row2 = new javax.swing.JPanel();
        Medicine_name2 = new javax.swing.JLabel();
        Select_Medicine2 = new javax.swing.JComboBox<>(arr);
        Quantity2 = new javax.swing.JLabel();
        Quantity_field2 = new javax.swing.JTextField();
        Rate_Label2 = new javax.swing.JLabel();
        Rate_Field2 = new javax.swing.JTextField();
        Total_Label2 = new javax.swing.JLabel();
        Total_Field2 = new javax.swing.JTextField();
        Add_Button2 = new javax.swing.JButton();
        Add_Medicine_Row3 = new javax.swing.JPanel();
        Medicine_name3 = new javax.swing.JLabel();
        Select_Medicine3 = new javax.swing.JComboBox<>(arr);
        Quantity3 = new javax.swing.JLabel();
        Quantity_field3 = new javax.swing.JTextField();
        Rate_Label3 = new javax.swing.JLabel();
        Rate_Field3 = new javax.swing.JTextField();
        Total_Label3 = new javax.swing.JLabel();
        Total_Field3 = new javax.swing.JTextField();
        Add_Button3 = new javax.swing.JButton();
        Add_Medicine_Row4 = new javax.swing.JPanel();
        Medicine_name4 = new javax.swing.JLabel();
        Select_Medicine4 = new javax.swing.JComboBox<>(arr);
        Quantity4 = new javax.swing.JLabel();
        Quantity_field4 = new javax.swing.JTextField();
        Rate_Label4 = new javax.swing.JLabel();
        Rate_Field4 = new javax.swing.JTextField();
        Total_Label4 = new javax.swing.JLabel();
        Total_Field4 = new javax.swing.JTextField();
        Add_Button4 = new javax.swing.JButton();
        Add_Medicine_Row5 = new javax.swing.JPanel();
        Medicine_name5 = new javax.swing.JLabel();
        Select_Medicine5 = new javax.swing.JComboBox<>(arr);
        Quantity5 = new javax.swing.JLabel();
        Quantity_field5 = new javax.swing.JTextField();
        Rate_Label5 = new javax.swing.JLabel();
        Rate_Field5 = new javax.swing.JTextField();
        Total_Label5 = new javax.swing.JLabel();
        Total_Field5 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Buttons_Row6 = new javax.swing.JPanel();
        Generate_Bill = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Total_Label6 = new javax.swing.JLabel();
        Payable = new javax.swing.JTextField();
        Footer = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Medical Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medicine Detail", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Sitka Text", 0, 18))); // NOI18N

        Medicine_name.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name.setText("Medicine Name :");

        Select_Medicine.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Select_Medicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_MedicineActionPerformed(evt);
            }
        });

        Quantity.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Quantity.setText("Quantity :");

        Quantity_field.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_fieldActionPerformed(evt);
            }
        });

        Rate_Label.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label.setText("Rate :");

        Rate_Field.setEditable(false);
        Rate_Field.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_FieldActionPerformed(evt);
            }
        });

        Total_Label.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label.setText("Total");

        Total_Field.setEditable(false);
        Total_Field.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Total_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_FieldActionPerformed(evt);
            }
        });

        Add_Button.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Add_Button.setText("Add More");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Add_Medicine_RowLayout = new javax.swing.GroupLayout(Add_Medicine_Row);
        Add_Medicine_Row.setLayout(Add_Medicine_RowLayout);
        Add_Medicine_RowLayout.setHorizontalGroup(
            Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_RowLayout.createSequentialGroup()
                .addComponent(Medicine_name, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Select_Medicine, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Quantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Rate_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rate_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Total_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        Add_Medicine_RowLayout.setVerticalGroup(
            Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_RowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_RowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name)
                    .addComponent(Select_Medicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity)
                    .addComponent(Quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rate_Label)
                    .addComponent(Rate_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label)
                    .addComponent(Total_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Medicine_name1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name1.setText("Medicine Name :");

        Select_Medicine1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Select_Medicine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_Medicine1ActionPerformed(evt);
            }
        });

        Quantity1.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Quantity1.setText("Quantity :");

        Quantity_field1.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_field1ActionPerformed(evt);
            }
        });

        Rate_Label1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label1.setText("Rate :");

        Rate_Field1.setEditable(false);
        Rate_Field1.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_Field1ActionPerformed(evt);
            }
        });

        Total_Label1.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label1.setText("Total");

        Total_Field1.setEditable(false);
        Total_Field1.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N

        Add_Button1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Add_Button1.setText("Add More");
        Add_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Add_Medicine_Row1Layout = new javax.swing.GroupLayout(Add_Medicine_Row1);
        Add_Medicine_Row1.setLayout(Add_Medicine_Row1Layout);
        Add_Medicine_Row1Layout.setHorizontalGroup(
            Add_Medicine_Row1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row1Layout.createSequentialGroup()
                .addComponent(Medicine_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Select_Medicine1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Quantity1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quantity_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Rate_Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rate_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Total_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Add_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        Add_Medicine_Row1Layout.setVerticalGroup(
            Add_Medicine_Row1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_Row1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name1)
                    .addComponent(Select_Medicine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity1)
                    .addComponent(Quantity_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rate_Label1)
                    .addComponent(Rate_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label1)
                    .addComponent(Total_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Button1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Medicine_name2.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name2.setText("Medicine Name :");

        Select_Medicine2.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Select_Medicine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_Medicine2ActionPerformed(evt);
            }
        });

        Quantity2.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Quantity2.setText("Quantity :");

        Quantity_field2.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_field2ActionPerformed(evt);
            }
        });

        Rate_Label2.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label2.setText("Rate :");

        Rate_Field2.setEditable(false);
        Rate_Field2.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_Field2ActionPerformed(evt);
            }
        });

        Total_Label2.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label2.setText("Total");

        Total_Field2.setEditable(false);
        Total_Field2.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N

        Add_Button2.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Add_Button2.setText("Add More");
        Add_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Add_Medicine_Row2Layout = new javax.swing.GroupLayout(Add_Medicine_Row2);
        Add_Medicine_Row2.setLayout(Add_Medicine_Row2Layout);
        Add_Medicine_Row2Layout.setHorizontalGroup(
            Add_Medicine_Row2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row2Layout.createSequentialGroup()
                .addComponent(Medicine_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Select_Medicine2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Quantity2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quantity_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Rate_Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rate_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Total_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Add_Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        Add_Medicine_Row2Layout.setVerticalGroup(
            Add_Medicine_Row2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_Row2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name2)
                    .addComponent(Select_Medicine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity2)
                    .addComponent(Quantity_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rate_Label2)
                    .addComponent(Rate_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label2)
                    .addComponent(Total_Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Button2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Medicine_name3.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name3.setText("Medicine Name :");

        Select_Medicine3.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Select_Medicine3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_Medicine3ActionPerformed(evt);
            }
        });

        Quantity3.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Quantity3.setText("Quantity :");

        Quantity_field3.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_field3ActionPerformed(evt);
            }
        });

        Rate_Label3.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label3.setText("Rate :");

        Rate_Field3.setEditable(false);
        Rate_Field3.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_Field3ActionPerformed(evt);
            }
        });

        Total_Label3.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label3.setText("Total");

        Total_Field3.setEditable(false);
        Total_Field3.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N

        Add_Button3.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Add_Button3.setText("Add More");
        Add_Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Add_Medicine_Row3Layout = new javax.swing.GroupLayout(Add_Medicine_Row3);
        Add_Medicine_Row3.setLayout(Add_Medicine_Row3Layout);
        Add_Medicine_Row3Layout.setHorizontalGroup(
            Add_Medicine_Row3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row3Layout.createSequentialGroup()
                .addComponent(Medicine_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Select_Medicine3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Quantity3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quantity_field3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Rate_Label3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rate_Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Total_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total_Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Add_Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        Add_Medicine_Row3Layout.setVerticalGroup(
            Add_Medicine_Row3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_Row3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name3)
                    .addComponent(Select_Medicine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity3)
                    .addComponent(Quantity_field3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rate_Label3)
                    .addComponent(Rate_Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label3)
                    .addComponent(Total_Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Button3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Medicine_name4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name4.setText("Medicine Name :");

        Select_Medicine4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Select_Medicine4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_Medicine4ActionPerformed(evt);
            }
        });

        Quantity4.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Quantity4.setText("Quantity :");

        Quantity_field4.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_field4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_field4ActionPerformed(evt);
            }
        });

        Rate_Label4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label4.setText("Rate :");

        Rate_Field4.setEditable(false);
        Rate_Field4.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_Field4ActionPerformed(evt);
            }
        });

        Total_Label4.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label4.setText("Total");

        Total_Field4.setEditable(false);
        Total_Field4.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N

        Add_Button4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Add_Button4.setText("Add More");
        Add_Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Button4ActionPerformed(evt);
            }
        });

        Medicine_name5.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Medicine_name5.setText("Medicine Name :");

        Select_Medicine5.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Select_Medicine5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_Medicine5ActionPerformed(evt);
            }
        });

        Quantity5.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Quantity5.setText("Quantity :");

        Quantity_field5.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Quantity_field5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_field5ActionPerformed(evt);
            }
        });

        Rate_Label5.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Rate_Label5.setText("Rate :");

        Rate_Field5.setEditable(false);
        Rate_Field5.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Rate_Field5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_Field5ActionPerformed(evt);
            }
        });

        Total_Label5.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label5.setText("Total");

        Total_Field5.setEditable(false);
        Total_Field5.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N

        javax.swing.GroupLayout Add_Medicine_Row5Layout = new javax.swing.GroupLayout(Add_Medicine_Row5);
        Add_Medicine_Row5.setLayout(Add_Medicine_Row5Layout);
        Add_Medicine_Row5Layout.setHorizontalGroup(
            Add_Medicine_Row5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row5Layout.createSequentialGroup()
                .addComponent(Medicine_name5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Select_Medicine5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Quantity5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quantity_field5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Rate_Label5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rate_Field5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Total_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total_Field5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        Add_Medicine_Row5Layout.setVerticalGroup(
            Add_Medicine_Row5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_Row5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name5)
                    .addComponent(Select_Medicine5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity5)
                    .addComponent(Quantity_field5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rate_Label5)
                    .addComponent(Rate_Field5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label5)
                    .addComponent(Total_Field5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Add_Medicine_Row4Layout = new javax.swing.GroupLayout(Add_Medicine_Row4);
        Add_Medicine_Row4.setLayout(Add_Medicine_Row4Layout);
        Add_Medicine_Row4Layout.setHorizontalGroup(
            Add_Medicine_Row4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Add_Medicine_Row4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Add_Medicine_Row4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Add_Medicine_Row4Layout.createSequentialGroup()
                        .addComponent(Medicine_name4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Select_Medicine4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Quantity4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quantity_field4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Rate_Label4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rate_Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Total_Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Total_Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Add_Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Add_Medicine_Row5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        Add_Medicine_Row4Layout.setVerticalGroup(
            Add_Medicine_Row4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Medicine_Row4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Medicine_Row4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medicine_name4)
                    .addComponent(Select_Medicine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity4)
                    .addComponent(Quantity_field4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rate_Label4)
                    .addComponent(Rate_Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total_Label4)
                    .addComponent(Total_Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Button4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_Medicine_Row5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Generate_Bill.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Generate_Bill.setText("Generate Bill");
        Generate_Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_BillActionPerformed(evt);
            }
        });

        Reset.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Total_Label6.setFont(new java.awt.Font("Sitka Display", 0, 15)); // NOI18N
        Total_Label6.setText("Payable Amount :");

        Payable.setEditable(false);
        Payable.setFont(new java.awt.Font("Sitka Display", 0, 17)); // NOI18N
        Payable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Buttons_Row6Layout = new javax.swing.GroupLayout(Buttons_Row6);
        Buttons_Row6.setLayout(Buttons_Row6Layout);
        Buttons_Row6Layout.setHorizontalGroup(
            Buttons_Row6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Buttons_Row6Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(Generate_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(Total_Label6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Payable, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        Buttons_Row6Layout.setVerticalGroup(
            Buttons_Row6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Buttons_Row6Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(Buttons_Row6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Generate_Bill)
                    .addComponent(Reset)
                    .addComponent(Total_Label6)
                    .addComponent(Payable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Footer.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Footer.setText("Developed with ❤ by Ravi Kant Gupta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Buttons_Row6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Footer, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_Medicine_Row1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Medicine_Row2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Medicine_Row3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Medicine_Row4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Medicine_Row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Add_Medicine_Row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_Medicine_Row1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_Medicine_Row2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_Medicine_Row3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_Medicine_Row4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buttons_Row6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Footer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        jMenu1.setText("Operations");
        jMenu1.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem4.setText("Generate Bill");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem2.setText("Check Stock");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem3.setText("Add Medicines");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("More");
        jMenu4.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem5.setText("Log Out");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Sitka Display", 0, 16)); // NOI18N
        jMenuItem6.setText("Exit");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       new Stocks();
       this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Add_Medicines();
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       new BillGenerator();
       this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void PayableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PayableActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_ResetActionPerformed

    private void Generate_BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generate_BillActionPerformed
        // TODO add your handling code here:
        GenerateBill();
    }//GEN-LAST:event_Generate_BillActionPerformed

    private void Rate_Field5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_Field5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_Field5ActionPerformed

    private void Quantity_field5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_field5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_field5ActionPerformed

    private void Select_Medicine5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_Medicine5ActionPerformed
        // TODO add your handling code here:
        getRate(Select_Medicine5, Rate_Field5);
    }//GEN-LAST:event_Select_Medicine5ActionPerformed

    private void Add_Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Button4ActionPerformed
        boolean c = checkQuantity(Quantity_field4);
        if(c==true){
            getTotal(Quantity_field2, Total_Field2);
            Add_Medicine_Row5.setVisible(true);
        }
    }//GEN-LAST:event_Add_Button4ActionPerformed

    private void Rate_Field4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_Field4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_Field4ActionPerformed

    private void Quantity_field4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_field4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_field4ActionPerformed

    private void Select_Medicine4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_Medicine4ActionPerformed
        // TODO add your handling code here:
        getRate(Select_Medicine4, Rate_Field4);
    }//GEN-LAST:event_Select_Medicine4ActionPerformed

    private void Add_Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Button3ActionPerformed
        boolean c = checkQuantity(Quantity_field3);
        if(c==true){
            getTotal(Quantity_field2, Total_Field2);
            Add_Medicine_Row4.setVisible(true);
        }
    }//GEN-LAST:event_Add_Button3ActionPerformed

    private void Rate_Field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_Field3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_Field3ActionPerformed

    private void Quantity_field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_field3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_field3ActionPerformed

    private void Select_Medicine3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_Medicine3ActionPerformed
        // TODO add your handling code here:
        getRate(Select_Medicine3, Rate_Field3);
    }//GEN-LAST:event_Select_Medicine3ActionPerformed

    private void Add_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Button2ActionPerformed

        boolean c = checkQuantity(Quantity_field2);
        if(c==true){
            getTotal(Quantity_field2, Total_Field2);
            Add_Medicine_Row3.setVisible(true);
        }
    }//GEN-LAST:event_Add_Button2ActionPerformed

    private void Rate_Field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_Field2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_Field2ActionPerformed

    private void Quantity_field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_field2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_field2ActionPerformed

    private void Select_Medicine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_Medicine2ActionPerformed
        // TODO add your handling code here:
        getRate(Select_Medicine2, Rate_Field2);
    }//GEN-LAST:event_Select_Medicine2ActionPerformed

    private void Add_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Button1ActionPerformed

        boolean c = checkQuantity(Quantity_field1);
        if (c == true) {
            getTotal(Quantity_field1, Total_Field1);
            Add_Medicine_Row2.setVisible(true);
            Footer.setVisible(true);
        }
    }//GEN-LAST:event_Add_Button1ActionPerformed

    private void Rate_Field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_Field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_Field1ActionPerformed

    private void Quantity_field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_field1ActionPerformed

    private void Select_Medicine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_Medicine1ActionPerformed
        getRate(Select_Medicine1, Rate_Field1);
    }//GEN-LAST:event_Select_Medicine1ActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed

        boolean c = checkQuantity(Quantity_field);
        if (c == true) {

            getTotal(Quantity_field, Total_Field);
            Add_Medicine_Row1.setVisible(true);
        }
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Total_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_FieldActionPerformed

    private void Rate_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rate_FieldActionPerformed

    private void Quantity_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_fieldActionPerformed

    }//GEN-LAST:event_Quantity_fieldActionPerformed

    private void Select_MedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_MedicineActionPerformed
        // TODO add your handling code here:
        getRate(Select_Medicine, Rate_Field);
    }//GEN-LAST:event_Select_MedicineActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new Login();
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Button;
    private javax.swing.JButton Add_Button1;
    private javax.swing.JButton Add_Button2;
    private javax.swing.JButton Add_Button3;
    private javax.swing.JButton Add_Button4;
    private javax.swing.JPanel Add_Medicine_Row;
    private javax.swing.JPanel Add_Medicine_Row1;
    private javax.swing.JPanel Add_Medicine_Row2;
    private javax.swing.JPanel Add_Medicine_Row3;
    private javax.swing.JPanel Add_Medicine_Row4;
    private javax.swing.JPanel Add_Medicine_Row5;
    private javax.swing.JPanel Buttons_Row6;
    private javax.swing.JLabel Footer;
    private javax.swing.JButton Generate_Bill;
    private javax.swing.JLabel Medicine_name;
    private javax.swing.JLabel Medicine_name1;
    private javax.swing.JLabel Medicine_name2;
    private javax.swing.JLabel Medicine_name3;
    private javax.swing.JLabel Medicine_name4;
    private javax.swing.JLabel Medicine_name5;
    private javax.swing.JTextField Payable;
    private javax.swing.JLabel Quantity;
    private javax.swing.JLabel Quantity1;
    private javax.swing.JLabel Quantity2;
    private javax.swing.JLabel Quantity3;
    private javax.swing.JLabel Quantity4;
    private javax.swing.JLabel Quantity5;
    private javax.swing.JTextField Quantity_field;
    private javax.swing.JTextField Quantity_field1;
    private javax.swing.JTextField Quantity_field2;
    private javax.swing.JTextField Quantity_field3;
    private javax.swing.JTextField Quantity_field4;
    private javax.swing.JTextField Quantity_field5;
    private javax.swing.JTextField Rate_Field;
    private javax.swing.JTextField Rate_Field1;
    private javax.swing.JTextField Rate_Field2;
    private javax.swing.JTextField Rate_Field3;
    private javax.swing.JTextField Rate_Field4;
    private javax.swing.JTextField Rate_Field5;
    private javax.swing.JLabel Rate_Label;
    private javax.swing.JLabel Rate_Label1;
    private javax.swing.JLabel Rate_Label2;
    private javax.swing.JLabel Rate_Label3;
    private javax.swing.JLabel Rate_Label4;
    private javax.swing.JLabel Rate_Label5;
    private javax.swing.JButton Reset;
    private javax.swing.JComboBox<String> Select_Medicine;
    private javax.swing.JComboBox<String> Select_Medicine1;
    private javax.swing.JComboBox<String> Select_Medicine2;
    private javax.swing.JComboBox<String> Select_Medicine3;
    private javax.swing.JComboBox<String> Select_Medicine4;
    private javax.swing.JComboBox<String> Select_Medicine5;
    private javax.swing.JTextField Total_Field;
    private javax.swing.JTextField Total_Field1;
    private javax.swing.JTextField Total_Field2;
    private javax.swing.JTextField Total_Field3;
    private javax.swing.JTextField Total_Field4;
    private javax.swing.JTextField Total_Field5;
    private javax.swing.JLabel Total_Label;
    private javax.swing.JLabel Total_Label1;
    private javax.swing.JLabel Total_Label2;
    private javax.swing.JLabel Total_Label3;
    private javax.swing.JLabel Total_Label4;
    private javax.swing.JLabel Total_Label5;
    private javax.swing.JLabel Total_Label6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
