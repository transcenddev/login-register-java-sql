package usermanagement;

import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.TableModel;


public class AccountManagement extends javax.swing.JFrame {
   
    
    public AccountManagement() {
        initComponents();
        this.setLocationRelativeTo(null); // center the form
        
        // Populate the JTable with user data
        Show_Users_In_JTable();
      
        // Create the existing border
        Border field_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);

        // Define the padding size (e.g., 5 pixels)
        int paddingSize = 5;

        // Create a CompoundBorder to add padding to the existing border
        Border paddedBorder = BorderFactory.createCompoundBorder(
            field_border,
            BorderFactory.createEmptyBorder(paddingSize, paddingSize, paddingSize, paddingSize)
        );

        // Apply the padded border to your components
        jTextField_FirstName.setBorder(paddedBorder);
        jTextField_LastName.setBorder(paddedBorder);
        jTextField_PhoneNum.setBorder(paddedBorder);
        jDateChooser_BirthDate.setBorder(paddedBorder);
        jTextField_Country.setBorder(paddedBorder);
        jTextField_Username.setBorder(paddedBorder);
        jTextField_Email.setBorder(paddedBorder);
        jPasswordField.setBorder(paddedBorder);
       

        // Create a ButtonGroup
        ButtonGroup bg = new ButtonGroup();

        // Add the radio buttons to the ButtonGroup
        bg.add(jRadioButton_Male);
        bg.add(jRadioButton_Female);
        
        // Create two JRadioButtons for "Male" and "Female"
        JRadioButton jRadioButton_Male = new JRadioButton("Male");
        JRadioButton jRadioButton_Female = new JRadioButton("Female");
    }
    
    public Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/users_db", "root", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<User> getUsersList() 
    {
        ArrayList<User> usersList = new ArrayList<User>();
        Connection connection = getConnection();
          
        String query = "SELECT * FROM `users` ";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();  
            rs = st.executeQuery(query);
            User user;
            while(rs.next())
            {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("gender"), rs.getString("phonenum"), rs.getString("country"), rs.getString("email"), rs.getString("birthdate"));
                usersList.add(user);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
    
    
    // Display Data In JTable
    
    // Display Data In JTable
    public void Show_Users_In_JTable() 
    {
        ArrayList<User> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel) jTable_Display_Users.getModel();
        Object[] row = new Object[10];
        
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getFirstName();
            row[2] = list.get(i).getLastName();
            row[3] = list.get(i).getGender();
            row[4] = list.get(i).getPhoneNum();
            row[5] = list.get(i).getCountry();
            row[6] = list.get(i).getBirthdate();
            row[7] = list.get(i).getEmail();
            row[8] = list.get(i).getUsername();
            row[9] = list.get(i).getPassword();

            model.addRow(row);
        }
    }
    
    // Execute The SQL Query
    public void executeSQLQuery(String query, String message)
    {
        Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if(st.executeUpdate(query) == 1)
            {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable(); // Populate the JTable with user data 
                
                JOptionPane.showMessageDialog(null, "Data " +message+" Successfully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not" +message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_FirstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_LastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton_Male = new javax.swing.JRadioButton();
        jRadioButton_Female = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_PhoneNum = new javax.swing.JTextField();
        jDateChooser_BirthDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Country = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_Username = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton_InsertActionPerformed = new javax.swing.JButton();
        jButton_UpdateActionPerformed = new javax.swing.JButton();
        jButton_DeleteActionPerformed = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel5.setText("Gender");

        jRadioButton_Male.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jRadioButton_Male.setText("Male");

        jRadioButton_Female.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jRadioButton_Female.setText("Female");

        jLabel4.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel4.setText("Phone Number");

        jTextField_PhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PhoneNumActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel6.setText("Birthdate");

        jLabel7.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel7.setText("Country");

        jLabel8.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel9.setText("Username");

        jLabel10.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel10.setText("Password");

        jButton_InsertActionPerformed.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jButton_InsertActionPerformed.setText("Add");
        jButton_InsertActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformedActionPerformed(evt);
            }
        });

        jButton_UpdateActionPerformed.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jButton_UpdateActionPerformed.setText("Update");
        jButton_UpdateActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformedActionPerformed(evt);
            }
        });

        jButton_DeleteActionPerformed.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jButton_DeleteActionPerformed.setText("Delete");
        jButton_DeleteActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformedActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel11.setText("Account Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField_FirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser_BirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jTextField_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jRadioButton_Male)
                                    .addGap(85, 85, 85)
                                    .addComponent(jRadioButton_Female))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_PhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPasswordField))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton_InsertActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(jButton_UpdateActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_DeleteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser_BirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton_Male)
                            .addComponent(jRadioButton_Female))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_PhoneNum)
                    .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_Username)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_InsertActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_UpdateActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DeleteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "First Name", "Last Name", "Gender", "Phone No.", "Country", "Birth Date", "Email", "Username", "Password"
            }
        ));
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 760, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_PhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PhoneNumActionPerformed

    private void jButton_InsertActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformedActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format to match your database format
        String birthdate = dateFormat.format(jDateChooser_BirthDate.getDate());

        String gender = (jRadioButton_Male.isSelected()) ? "Male" : "Female";

        String query = "INSERT INTO `users` (`username`, `password`, `firstname`, `lastname`, `gender`, `phonenum`, `country`, `email`, `birthdate`) " +
                      "VALUES ('" + jTextField_Username.getText() + "', '" + new String(jPasswordField.getPassword()) + "', '" + jTextField_FirstName.getText() + "', '" +
                      jTextField_LastName.getText() + "', '" + gender + "', '" + jTextField_PhoneNum.getText() + "', '" + jTextField_Country.getText() + "', '" +
                      jTextField_Email.getText() + "', '" + birthdate + "')";
    }//GEN-LAST:event_jButton_InsertActionPerformedActionPerformed

    private void jButton_UpdateActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformedActionPerformed
        String gender = (jRadioButton_Male.isSelected()) ? "Male" : "Female";
        
         // Format the birthdate to match the database format (adjust the format as needed)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthdate = dateFormat.format(jDateChooser_BirthDate.getDate());

        
        String query = "UPDATE `users` SET " +
                   "`username` = '" + jTextField_Username.getText() + "', " +
                   "`password` = '" + new String(jPasswordField.getPassword()) + "', " +
                   "`firstname` = '" + jTextField_FirstName.getText() + "', " +
                   "`lastname` = '" + jTextField_LastName.getText() + "', " +
                   "`gender` = '" + gender + "', " +
                   "`phonenum` = '" + jTextField_PhoneNum.getText() + "', " +
                   "`country` = '" + jTextField_Country.getText() + "', " +
                   "`email` = '" + jTextField_Email.getText() + "', " +
                   "`birthdate` = '" + birthdate + "' " +
                   "WHERE 1";
    }//GEN-LAST:event_jButton_UpdateActionPerformedActionPerformed
    
    
    
    int genderColumnIndex = 3; // Replace with the actual index of the gender column
    int birthdateColumnIndex = 6; // Replace with the actual index of the birthdate column


    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
        // Display Selected Row in JTextFields
        int selectedRow = jTable_Display_Users.getSelectedRow();
        TableModel model = jTable_Display_Users.getModel();
   
        jTextField_Id.setText(model.getValueAt(selectedRow, 0).toString());
        jTextField_FirstName.setText(model.getValueAt(selectedRow, 1).toString());
        jTextField_LastName.setText(model.getValueAt(selectedRow, 2).toString());
        jTextField_PhoneNum.setText(model.getValueAt(selectedRow, 4).toString());
        jTextField_Country.setText(model.getValueAt(selectedRow, 5).toString());
        jTextField_Email.setText(model.getValueAt(selectedRow, 7).toString());
        jTextField_Username.setText(model.getValueAt(selectedRow, 8).toString());
        jPasswordField.setText(model.getValueAt(selectedRow, 9).toString());
        
        // Retrieve gender information from the model
        String gender = model.getValueAt(selectedRow, genderColumnIndex).toString();
        
        // Set the appropriate radio button as selected
        if ("Male".equals(gender)) {
            jRadioButton_Male.setSelected(true);
            jRadioButton_Female.setSelected(false);
        } else if ("Female".equals(gender)) {
            jRadioButton_Male.setSelected(false);
            jRadioButton_Female.setSelected(true);
        } else {
            // Handle other cases or set a default selection if needed
            jRadioButton_Male.setSelected(false);
            jRadioButton_Female.setSelected(false);
        }
        
        String birthdateString = model.getValueAt(selectedRow, birthdateColumnIndex).toString();

        // Convert the birthdateString to a Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format as needed
        Date birthdate = null;

        try {
            birthdate = dateFormat.parse(birthdateString);
        } catch (ParseException ex) {
            // Handle the parsing exception, e.g., show an error message or use a default date
            ex.printStackTrace();
        }

        jDateChooser_BirthDate.setDate(birthdate);

    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

    private void jButton_DeleteActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformedActionPerformed
        String query = "DELETE FROM `users` WHERE id = "+jTextField_Id.getText();
        executeSQLQuery(query, "Deleted");
    }//GEN-LAST:event_jButton_DeleteActionPerformedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccountManagement accountManagement = new AccountManagement();
                accountManagement.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DeleteActionPerformed;
    private javax.swing.JButton jButton_InsertActionPerformed;
    private javax.swing.JButton jButton_UpdateActionPerformed;
    private com.toedter.calendar.JDateChooser jDateChooser_BirthDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRadioButton_Female;
    private javax.swing.JRadioButton jRadioButton_Male;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTextField jTextField_Country;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_PhoneNum;
    private javax.swing.JTextField jTextField_Username;
    // End of variables declaration//GEN-END:variables

    private void setLocatiJonRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
