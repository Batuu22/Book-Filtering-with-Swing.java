import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class Demo extends javax.swing.JFrame {
    DefaultTableModel model;
    
   
    public Demo() {
        initComponents();
        model = (DefaultTableModel)tblBooks.getModel();
        
        try {
            
            ArrayList<Books> books = getBooks();
            
            for(Books book2 : books){
                
                Object[] row = {book2.getID(),book2.getBookName(),book2.getPublisher(),
                book2.getPageNumber(),book2.getAuthor()};
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
           
        }
        
    }
    
    public ArrayList<Books> getBooks() throws SQLException {
        
        Connection connection = null ;
        
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultset ;
        
        ArrayList<Books> books = null;
        
        try {
            
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("select * from books");
            
            books = new ArrayList<Books>();
            
            while(resultset.next()){
                
                books.add(new Books(resultset.getInt("ID"),
                        resultset.getString("KitapAdi"),
                resultset.getString("KitapYayınevi"),
                resultset.getInt("SayfaSayisi"),
                resultset.getString("Yazar")));
                
                
            }
            
        }catch(SQLException e){
            
            helper.showErrorMessage(e);
            
        }finally{
            
            connection.close();
            statement.close();
            
        }
        
        return books;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        txtfieldSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBooks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Publisher", "Page Number", "Author"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBooks);
        if (tblBooks.getColumnModel().getColumnCount() > 0) {
            tblBooks.getColumnModel().getColumn(0).setResizable(false);
            tblBooks.getColumnModel().getColumn(1).setResizable(false);
            tblBooks.getColumnModel().getColumn(2).setResizable(false);
            tblBooks.getColumnModel().getColumn(3).setResizable(false);
            tblBooks.getColumnModel().getColumn(4).setResizable(false);
        }

        txtfieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtfieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfieldSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearch.setText("Search :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>                        

    private void txtfieldSearchKeyReleased(java.awt.event.KeyEvent evt) {                                           
        
        String SearchKey = txtfieldSearch.getText();
        
        TableRowSorter<DefaultTableModel> tableRowSorter = 
                new TableRowSorter<DefaultTableModel>(model);
        
        tblBooks.setRowSorter(tableRowSorter);
        
        tableRowSorter.setRowFilter(RowFilter.regexFilter(SearchKey));
        
    }                                          

    
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txtfieldSearch;
    // End of variables declaration                   
}
