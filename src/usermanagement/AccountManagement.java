package usermanagement;

import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
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
//       
        Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if (st.executeUpdate(query) == 1) {
                DefaultTableModel model = (DefaultTableModel) jTable_Display_Users.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable();
                JOptionPane.showMessageDialog(null, "Data " + message + " Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
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
        jLabel12_CloseButton = new javax.swing.JLabel();
        jLabel13Min = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel1.setText("ID Number");

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

        jLabel11.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
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
                .addGap(36, 36, 36)
                .addComponent(jLabel11)
                .addGap(39, 39, 39)
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
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_InsertActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_UpdateActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DeleteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

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

        jLabel12_CloseButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel12_CloseButton.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12_CloseButton.setText("X");

        jLabel13Min.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel13Min.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13Min.setText("—");
        jLabel13Min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13Min)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12_CloseButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12_CloseButton)
                    .addComponent(jLabel13Min))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_PhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PhoneNumActionPerformed
//
    private void jButton_InsertActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformedActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format to match your database format
            String birthdate = dateFormat.format(jDateChooser_BirthDate.getDate());

            String gender = (jRadioButton_Male.isSelected()) ? "Male" : "Female";

            String query = "INSERT INTO `users` (`username`, `password`, `firstname`, `lastname`, `gender`, `phonenum`, `country`, `email`, `birthdate`) " +  
                   "VALUES ('" + jTextField_Username.getText() + "', '" + new String(jPasswordField.getPassword()) + "', '" + jTextField_FirstName.getText() + "', '" +  
                   jTextField_LastName.getText() + "', '" + gender + "', '" + jTextField_PhoneNum.getText() + "', '" + jTextField_Country.getText() + "', '" +  
                   jTextField_Email.getText() + "', '" + birthdate + "')"; 

            try (Connection conn = getConnection();
                 Statement stmt = conn.createStatement()) {

                stmt.executeUpdate(query);
                System.out.println("Insertion successful");
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }
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
                   "WHERE `id` = " + jTextField_Id.getText();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(query);
            System.out.println("Update successful");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformedActionPerformed
    
    
    
    int genderColumnIndex = 3; // Replace with the actual index of the gender column
    int birthdateColumnIndex = 6; // Replace with the actual index of the birthdate column


    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked

        // Display Selected Row in JTextFields
        int selectedRow = jTable_Display_Users.getSelectedRow();
        TableModel model = jTable_Display_Users.getModel();

        // Retrieve the values from the model and handle null values
        Object idObject = model.getValueAt(selectedRow, 0);
        Object firstNameObject = model.getValueAt(selectedRow, 1);
        Object lastNameObject = model.getValueAt(selectedRow, 2);
        Object phoneNumObject = model.getValueAt(selectedRow, 4);
        Object countryObject = model.getValueAt(selectedRow, 5);
        Object emailObject = model.getValueAt(selectedRow, 7);
        Object usernameObject = model.getValueAt(selectedRow, 8);
        Object passwordObject = model.getValueAt(selectedRow, 9);

        String id = (idObject != null) ? idObject.toString() : "";
        String firstName = (firstNameObject != null) ? firstNameObject.toString() : "";
        String lastName = (lastNameObject != null) ? lastNameObject.toString() : "";
        String phoneNum = (phoneNumObject != null) ? phoneNumObject.toString() : "";
        String country = (countryObject != null) ? countryObject.toString() : "";
        String email = (emailObject != null) ? emailObject.toString() : "";
        String username = (usernameObject != null) ? usernameObject.toString() : "";
        String password = (passwordObject != null) ? passwordObject.toString() : "";

        // Set the text fields with the retrieved values
        jTextField_Id.setText(id);
        jTextField_FirstName.setText(firstName);
        jTextField_LastName.setText(lastName);
        jTextField_PhoneNum.setText(phoneNum);
        jTextField_Country.setText(country);
        jTextField_Email.setText(email);
        jTextField_Username.setText(username);
        jPasswordField.setText(password);

        // Retrieve gender information from the model
        Object genderObject = model.getValueAt(selectedRow, genderColumnIndex);
        String gender = (genderObject != null) ? genderObject.toString() : "";

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

        // Retrieve birthdate information from the model
        Object birthdateObject = model.getValueAt(selectedRow, birthdateColumnIndex);
        String birthdateString = (birthdateObject != null) ? birthdateObject.toString() : "";

        // Convert the birthdateString to a Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format as needed
        Date birthdate = null;

        try {
            if (!birthdateString.isEmpty()) {
                birthdate = dateFormat.parse(birthdateString);
            }
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

    private void jLabel13MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MinMouseClicked
            // Check for a mouse click event (e.g., a left mouse button click)
        if (evt.getButton() == MouseEvent.BUTTON1) {
            // Minimize the JFrame
            setExtendedState(JFrame.ICONIFIED);
        }
    }//GEN-LAST:event_jLabel13MinMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel3MouseClicked

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
    private javax.swing.JLabel jLabel12_CloseButton;
    private javax.swing.JLabel jLabel13Min;
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
